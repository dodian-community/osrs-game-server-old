package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.content.interfaces.Equipment;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.Privilege;
import io.nozemi.runescape.model.item.Item;
import io.nozemi.runescape.net.packets.annotations.MessageListener;
import io.nozemi.runescape.net.packets.models.item.ItemAction2;
import io.nozemi.runescape.net.packets.models.item.ItemDragAction;
import org.springframework.stereotype.Component;

@Component
public class ItemMessageHandler {

    @MessageListener
    public void onItemDrag(ItemDragAction action) {
        Player player = action.getPlayer();
        if (player.privilege().eligibleTo(Privilege.ADMIN) && player.<Boolean>attribOr(AttributeKey.DEBUG, false))
            player.message("Drag: from=%d to=%d inter=%d child=%d insert=%b", action.getFrom(), action.getTo(), action.getPackedInteger() >> 16, action.getPackedInteger() & 0xFFFF, action.isInsert());

        int inter = action.getPackedInteger() >> 16;
        if (inter == 149 && action.getTo() >= 0 && action.getFrom() >= 0 && action.getTo() < 28 && action.getFrom() < 28) {
            Item old = player.inventory().get(action.getTo());
            player.inventory().set(action.getTo(), player.inventory().get(action.getFrom()));
            player.inventory().set(action.getFrom(), old);
            player.interfaces().close(162, 550); // Close chatbox
        }
    }

    @MessageListener
    public void onItemAction2(ItemAction2 action) {
        Player player = action.getPlayer();

        int item = action.getItem();
        int slot = action.getSlot();

        if (item == 0xFFFF)
            item = -1;
        if (slot == 0xFFFF)
            item = -1;

        if (player.privilege().eligibleTo(Privilege.ADMIN) && player.<Boolean>attribOr(AttributeKey.DEBUG, false))
            player.message("Item option %d on [%d:%d], item: %d, slot: %d", 1 + 1, action.getHash() >> 16, action.getHash() & 0xFFFF, item, slot);

        if (slot < 0 || slot > 27) return;

        if (player.locked() || player.dead() || !player.inventory().hasAt(slot))
            return;

        Item used = player.inventory().get(slot);
        if (used != null && used.getId() == item) {
            player.putattrib(AttributeKey.FROM_ITEM, item);
            Equipment.equip(player, slot, used, true);

            //player.world().server().scriptRepository().triggerItemOption2(player, item, slot); // Currently just hunter box trap laying.
        }
    }
}
