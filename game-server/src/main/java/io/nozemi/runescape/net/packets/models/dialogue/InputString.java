package io.nozemi.runescape.net.packets.models.dialogue;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.annotations.Opcodes;

import static io.nozemi.runescape.net.packets.PacketConstants.INPUT_STRING;

@Opcodes(INPUT_STRING)
public class InputString extends GamePacket {

    private String value;

    @Override
    public InputString decode(RSBuffer buffer) {
        value = buffer.readString();
        return this;
    }

    @Override
    public InputString newInstance() {
        return new InputString();
    }

    public String getValue() {
        return value;
    }
}
