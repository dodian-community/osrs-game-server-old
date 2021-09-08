package net.dodian.runescape.net.packets.models;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;

public class PingServer extends GamePacket {

    @Override
    public GamePacket decode(RSBuffer buffer) {
        return null;
    }

    @Override
    public GamePacket newInstance() {
        return new PingServer();
    }
}