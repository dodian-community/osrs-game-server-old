package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.Opcodes;
import org.springframework.stereotype.Component;

@Component
@Opcodes({63, 11, 20, 9, 78, 96, 25, 91, 22, 45})
public class ButtonAction extends GamePacket {

    public static final int[] OPCODES = {63, 11, 20, 9, 78, 96, 25, 91, 22, 45};

    private int option;
    private int hash;
    private int item;
    private int slot;

    @Override
    public ButtonAction createFrom(RSBuffer packet) {
        this.hash = packet.readInt();
        this.slot = packet.readUShort();
        this.item = packet.readUShort();

        if (item == 0xFFFF)
            item = -1;
        if (slot == 0xFFFF)
            slot = -1;

        for (int i = 0; i < OPCODES.length; i++)
            if (OPCODES[i] == opcode)
                option = i;

        return this;
    }

    public int getOption() {
        return option;
    }

    public int getHash() {
        return hash;
    }

    public int getItem() {
        return item;
    }

    public int getSlot() {
        return slot;
    }
}
