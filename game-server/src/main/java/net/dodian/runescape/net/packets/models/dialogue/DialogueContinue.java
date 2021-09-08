package net.dodian.runescape.net.packets.models.dialogue;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.CONTINUE_DIALOGUE;

@Opcodes(CONTINUE_DIALOGUE)
public class DialogueContinue extends GamePacket {

    private int hash;
    private int slot;

    @Override
    public DialogueContinue decode(RSBuffer buffer) {
        hash = buffer.readLEInt();
        slot = buffer.readUShortA();
        return this;
    }

    @Override
    public DialogueContinue newInstance() {
        return new DialogueContinue();
    }

    public int getHash() {
        return hash;
    }

    public int getSlot() {
        return slot;
    }
}
