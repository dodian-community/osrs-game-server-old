package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.Opcodes;
import org.springframework.stereotype.Component;

import static io.nozemi.runescape.net.packets.PacketConstants.PING_PACKET;

@Component
@Opcodes(PING_PACKET)
public class PingPacket extends GamePacket {

    @Override
    public PingPacket createFrom(RSBuffer packet) {
        return this;
    }
}
