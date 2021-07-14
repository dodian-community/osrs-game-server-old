package io.nozemi.runescape.net.packets.models;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.annotations.Opcodes;

import static io.nozemi.runescape.net.packets.PacketConstants.MAIN_INTERFACE_CLOSE;

@Opcodes(MAIN_INTERFACE_CLOSE)
public class CloseMainInterface extends GamePacket {

    @Override
    public CloseMainInterface decode(RSBuffer buffer) {
        return this;
    }

    @Override
    public GamePacket clone() {
        return new CloseMainInterface();
    }
}