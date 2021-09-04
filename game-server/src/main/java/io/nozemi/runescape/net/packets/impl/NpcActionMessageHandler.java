package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.content.combat.PlayerCombat;
import io.nozemi.runescape.events.ScriptRepository;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.packets.annotations.MessageListener;
import io.nozemi.runescape.net.packets.models.npc.NpcAction1;
import io.nozemi.runescape.net.packets.models.npc.NpcAction2;
import io.nozemi.runescape.net.packets.models.npc.NpcAttack;
import io.nozemi.runescape.util.Tuple;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.ref.WeakReference;

@Component
public class NpcActionMessageHandler {

    private static final Logger logger = LogManager.getLogger(NpcActionMessageHandler.class);

    private static final int OPTION_ITEM_ON_NPC = -1;

    private final ScriptRepository repository;

    @Autowired
    public NpcActionMessageHandler(ScriptRepository repository) {
        this.repository = repository;
    }

    @MessageListener
    public void onAttackNpc(NpcAttack attack) {
        Player player = attack.getPlayer();
        Npc other = player.world().npcs().get(attack.getIndex());

        if(other == null) {
            player.debug("NPC index=%d is null.", attack.getIndex());
        } else {
            logger.info("Attempted to attack NPC by ID: {}.", other.id());

            if (player.attribOr(AttributeKey.DEBUG, false))
                player.debug("Npc id=%d index=%d  dead: %s %s can-attack=%s", other.id(), attack.getIndex(), other.dead() ? "Y" : "N", player.dead() ? "Y" : "N",
                        player.attribOr(AttributeKey.DEBUG, false) ? PlayerCombat.canAttack(player, other) : "?");

            if (!player.locked() && !player.dead()) {
                player.stopActions(true);
                player.face(other);

                if (!other.dead()) {
                    if (other.combatInfo() == null) {
                        player.message("Without combat attributes this monster is unattackable.");
                        return;
                    }

                    // See if it's exclusively owned
                    Tuple<Integer, Player> ownerLink = other.attribOr(AttributeKey.OWNING_PLAYER, new Tuple(-1, null));
                    if (ownerLink.first() != null && ownerLink.first() >= 0 && ownerLink.first() != player.id()) {
                        player.message("They don't seem interested in fighting you.");
                        return;
                    }

                    player.putattrib(AttributeKey.TARGET, new WeakReference<Entity>(other));
                    //player.world().server().scriptExecutor().executeLater(player, PlayerCombat.script);
                    player.prepareAttack();
                }
            }
        }
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
