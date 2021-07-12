package io.nozemi.runescape.net.packets.handlers.impl;

import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.entity.PathQueue;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.Privilege;
import io.nozemi.runescape.net.packets.handlers.PacketHandler;
import io.nozemi.runescape.net.packets.handlers.PacketListener;
import io.nozemi.runescape.net.packets.impl.WalkMap;
import org.springframework.stereotype.Component;

@Component
public class PublicWalkActionHandler extends PacketListener {

    @PacketHandler
    public void onWalk(WalkMap packet, Player player) {
        if (packet.getMode() == 2 && player.privilege().eligibleTo(Privilege.ADMIN)) {
            player.teleport(packet.getZ(), packet.getZ(), player.tile().level);
            player.interfaces().closeMain();
            player.stopActions(true);
            return;
        }

        if (!player.locked() && !player.dead()) {
            double energy = player.attribOr(AttributeKey.RUN_ENERGY, 0.0);
            if (packet.getMode() == 1 && energy <= 1) {
                packet.setMode(0);
            }
            if (player.looks().trans() == 3008) {
                player.walkTo(packet.getX(), packet.getZ(), PathQueue.StepType.FORCED_WALK, true);
            } else {
                player.walkTo(packet.getX(), packet.getZ(), packet.getMode() == 1 ? PathQueue.StepType.FORCED_RUN : PathQueue.StepType.REGULAR, true);
            }
        }
    }
}
