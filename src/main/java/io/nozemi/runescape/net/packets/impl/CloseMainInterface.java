package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.Opcodes;
import org.springframework.stereotype.Component;

import static io.nozemi.runescape.net.packets.PacketConstants.MAIN_INTERFACE_CLOSE;

@Component
@Opcodes(MAIN_INTERFACE_CLOSE)
public class CloseMainInterface extends GamePacket {

    @Override
    public CloseMainInterface createFrom(RSBuffer packet) {
        return this;
    }
}
