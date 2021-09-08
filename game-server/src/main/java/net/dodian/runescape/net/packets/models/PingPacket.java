package net.dodian.runescape.net.packets.models;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.PING_PACKET;

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