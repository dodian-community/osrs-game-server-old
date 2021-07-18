package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.content.npcs.Bankers;
import io.nozemi.runescape.events.Script;
import io.nozemi.runescape.events.ScriptExecutor;
import io.nozemi.runescape.events.ScriptRepository;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.PathQueue;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.map.steroids.RangeStepSupplier;
import io.nozemi.runescape.net.packets.annotations.MessageListener;
import io.nozemi.runescape.net.packets.models.npc.NpcAction1;
import io.nozemi.runescape.net.packets.models.npc.NpcAction2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.ref.WeakReference;

@Component
public class NpcActionMessageHandler {

    private static final int OPTION_ITEM_ON_NPC = -1;

    private final ScriptRepository repository;

    @Autowired
    public NpcActionMessageHandler(ScriptRepository repository) {
        this.repository = repository;
    }

    @MessageListener
    public void onNpcAction1(NpcAction1 action) {
        Player player = action.getPlayer();
        Npc other = player.world().npcs().get(action.getIndex());
        if(!player.locked() && !player.dead()) {
            player.stopActions(true);
            player.face(other);

            if(!other.dead()) {
                player.putattrib(AttributeKey.TARGET, new WeakReference<Entity>(other));
                player.putattrib(AttributeKey.INTERACTION_OPTION, 1);
                player.walkToThen(other, other.tile(), () -> repository.triggerNpcAction1(player, other));
            }
        }
    }

    @MessageListener
    public void onNpcAction2(NpcAction2 action) {
        Player player = action.getPlayer();
        Npc other = player.world().npcs().get(action.getIndex());
        if(!player.locked() && !player.dead()) {
            player.stopActions(true);
            player.face(other);

            if(!other.dead()) {
                player.putattrib(AttributeKey.TARGET, new WeakReference<Entity>(other));
                player.putattrib(AttributeKey.INTERACTION_OPTION, 2);
                player.walkToThen(other, other.tile(), () -> repository.triggerNpcAction2(player, other));
            }
        }
    }
}
