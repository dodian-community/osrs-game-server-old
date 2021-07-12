package io.nozemi.runescape.net.packets.handlers.impl;

import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.packets.handlers.PacketHandler;
import io.nozemi.runescape.net.packets.handlers.PacketListener;
import io.nozemi.runescape.net.packets.impl.PingPacket;
import io.nozemi.runescape.net.packets.impl.PingServer;
import org.springframework.stereotype.Component;

@Component
public class PingPacketHandler extends PacketListener {

    @PacketHandler
    public void onPingPlayer(PingPacket packet, Player player) {
        player.lastPing(System.currentTimeMillis());
    }

    @PacketHandler
    public void onPingServer(PingServer packet, Player player) {

    }
}
