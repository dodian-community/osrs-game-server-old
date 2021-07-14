package io.nozemi.runescape.net.packets.models;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;

public class PingServer extends GamePacket {

    @Override
    public GamePacket decode(RSBuffer buffer) {
        return null;
    }

    @Override
    public GamePacket clone() {
        return new PingServer();
    }
}