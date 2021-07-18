package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.events.ScriptRepository;
import io.nozemi.runescape.fs.ObjectDefinition;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.map.MapObj;
import io.nozemi.runescape.net.packets.annotations.MessageListener;
import io.nozemi.runescape.net.packets.models.object.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectActionMessageHandler {

    private static final Logger logger = LogManager.getLogger(ObjectActionMessageHandler.class);

    private final ScriptRepository repository;

    @Autowired
    public ObjectActionMessageHandler(ScriptRepository repository) {
        this.repository = repository;
    }

    @MessageListener
    public void onObjectAction1(ObjectAction1 action) {
        handleObjectAction(action, 1);
    }

    @MessageListener
    public void onObjectAction2(ObjectAction2 action) {
        handleObjectAction(action, 2);
    }

    private void handleObjectAction(ObjectAction action, int option) {
        logger.info("Interacting with object id: {}.", action.getId());

        Player player = action.getPlayer();
        MapObj object = player.world().objById(action.getId(), action.getX(), action.getZ(), player.tile().level);

        if (object == null) {
            return;
        }

        MapObj original = player.world().objByType(object.type(), action.getX(), action.getZ(), player.tile().level);
        if(original == null || original.id() != object.id()) {
            return;
        }

        MapObj over = new MapObj(new Tile(action.getX(), action.getZ(), player.tile().level), original.id(), original.type(), object.rot()).cloneattribs(original);

        if(player.attribOr(AttributeKey.DEBUG, false)) {

        }

        if(!player.locked() && !player.dead()) {
            player.stopActions(true);
            player.putattrib(AttributeKey.ORIGINAL_INTERACTION_OBJECT, original);
            player.putattrib(AttributeKey.INTERACTION_OBJECT, over);
            player.putattrib(AttributeKey.INTERACTION_OPTION, option);
            player.walkToThen(over, () -> {
                if(!repository.triggerObject(player, over, option)) {
                    player.message("Nothing interesting happens.");
                }
            });
        }
    }
}
