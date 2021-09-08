package net.dodian.runescape.net.packets.models.dialogue;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;

public class DialogueOption extends GamePacket {

    private int hash;

    @Override
    public DialogueOption decode(RSBuffer buffer) {
        hash = buffer.readInt();
        return this;
    }

    @Override
    public DialogueOption newInstance() {
        return new DialogueOption();
    }
}
