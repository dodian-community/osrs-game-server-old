package net.dodian.runescape.net.packets.models.dialogue;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.INPUT_INTEGER;

@Opcodes(INPUT_INTEGER)
public class InputInteger extends GamePacket {

    private int value;

    @Override
    public InputInteger decode(RSBuffer buffer) {
        this.value = buffer.readInt();
        return this;
    }

    @Override
    public InputInteger newInstance() {
        return new InputInteger();
    }

    public int getValue() {
        return value;
    }
}
