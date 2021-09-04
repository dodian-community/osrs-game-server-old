package io.nozemi.runescape.net.packets.models.dialogue;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.annotations.Opcodes;

import static io.nozemi.runescape.net.packets.PacketConstants.INPUT_INTEGER;

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
