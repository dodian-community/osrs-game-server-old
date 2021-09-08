package net.dodian.runescape.net.packets.models.dialogue;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.INPUT_STRING;

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
