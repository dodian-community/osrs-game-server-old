package io.nozemi.runescape.net.packets.models.dialogue;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;

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
