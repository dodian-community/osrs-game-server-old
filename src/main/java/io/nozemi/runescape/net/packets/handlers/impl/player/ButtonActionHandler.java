package io.nozemi.runescape.net.packets.handlers.impl.player;

import io.nozemi.runescape.handlers.impl.ButtonHandler;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.Privilege;
import io.nozemi.runescape.net.packets.handlers.PacketHandler;
import io.nozemi.runescape.net.packets.handlers.PacketListener;
import io.nozemi.runescape.net.packets.impl.ButtonAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ButtonActionHandler extends PacketListener {

    private final ButtonHandler buttonHandler;

    @Autowired
    public ButtonActionHandler(ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;
    }

    @PacketHandler
    public void onButtonClick(ButtonAction action, Player player) {
        if (player.privilege().eligibleTo(Privilege.ADMIN) && player.<Boolean>attribOr(AttributeKey.DEBUG, false))
            player.message("Button option %d on [%d:%d], item: %d, slot: %d", action.getOption() + 1, action.getHash() >> 16, action.getHash() & 0xFFFF, action.getItem(), action.getSlot());

        if (player.dead()) {
            return;
        }

        if (player.interfaces().visible(action.getHash() >> 16)) {
            if (action.getHash() >> 16 != 382) {
                player.putattrib(AttributeKey.INTERACTION_OPTION, action.getOption() + 1);
                int parentId = action.getHash() >> 16;
                int childId = action.getHash() & 0xFFFF;
                buttonHandler.handleButton(player, parentId, childId, action.getOption() + 1, action.getItem());
            }
        }
    }
}
