package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.fs.ObjectDefinition;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.map.MapObj;
import io.nozemi.runescape.net.packets.annotations.MessageListener;
import io.nozemi.runescape.net.packets.models.object.*;
import org.springframework.stereotype.Component;

@Component
public class ObjectActionMessageHandler {

    @MessageListener
    public void onObjectAction1(ObjectAction1 action) {
        handleObjectAction(action);
    }

    @MessageListener
    public void onObjectAction2(ObjectAction2 action) {
        handleObjectAction(action);
    }

    private void handleObjectAction(ObjectAction action) {
        Player player = action.getPlayer();

        MapObj obj = player.world().objById(action.getId(), action.getX(), action.getZ(), player.tile().level);

        if (obj == null)
            return;

        MapObj original = player.world().objByType(obj.type(), action.getX(), action.getZ(), player.tile().level);
        if (original == null || original.id() != obj.id())
            return;

        MapObj over = new MapObj(new Tile(action.getX(), action.getZ(), player.tile().level), original.id(), original.type(), obj.rot()).cloneattribs(original);

        if (player.attribOr(AttributeKey.DEBUG, false)) {
            ObjectDefinition objdef = player.world().definitions().get(ObjectDefinition.class, action.getId());
            player.message("Click:%d id=%d at %d,%d,%d rot:%d vb:%d, v:%d lx=%d lz=%d", 1, action.getId(), action.getX(), action.getZ(), over.tile().level, over.rot(), objdef.varbit, objdef.varp, action.getX() & 63, action.getZ() & 63);
        }

        if (!player.locked() && !player.dead()) {
            player.stopActions(true);
            player.putattrib(AttributeKey.ORIGINAL_INTERACTION_OBJECT, original);
            player.putattrib(AttributeKey.INTERACTION_OBJECT, over);
            player.putattrib(AttributeKey.INTERACTION_OPTION, 1);
            player.walkToThen(obj, obj.tile(), () -> {
                player.stopActions(true);
                player.faceObj(obj);
                if(player.attribOr(AttributeKey.DEBUG, false)) {
                    player.message("Arrived!");
                }
            });
        }
    }
}
