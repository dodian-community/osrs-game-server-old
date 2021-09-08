package net.dodian.runescape.net.packets.models;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.MAIN_INTERFACE_CLOSE;

@Opcodes(MAIN_INTERFACE_CLOSE)
public class CloseMainInterface extends GamePacket {

    @Override
    public CloseMainInterface decode(RSBuffer buffer) {
        return this;
    }

    @Override
    public GamePacket newInstance() {
        return new CloseMainInterface();
    }
}