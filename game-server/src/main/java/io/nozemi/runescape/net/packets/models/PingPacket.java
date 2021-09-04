package io.nozemi.runescape.net.packets.models;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.annotations.Opcodes;

import static io.nozemi.runescape.net.packets.PacketConstants.PING_PACKET;

@Opcodes(PING_PACKET)
public class PingPacket extends GamePacket {

    @Override
    public PingPacket decode(RSBuffer buffer) {
        return this;
    }

    @Override
    public GamePacket newInstance() {
        return new PingPacket();
    }
}