package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.Opcodes;
import org.springframework.stereotype.Component;

import static io.nozemi.runescape.net.packets.PacketConstants.LOOKS_SET;

@Component
@Opcodes(LOOKS_SET)
public class SetLooks extends GamePacket {

    private final int[] looks = new int[7];
    private final int[] colors = new int[5];
    private boolean female;

    @Override
    public SetLooks createFrom(RSBuffer packet) {
        female = packet.readByte() == 1;
        for (int i = 0; i < 7; i++) {
            looks[i] = packet.readUByte();
            if (looks[i] < 0)
                looks[i] = 0;
        }
        for (int i = 0; i < 5; i++) {
            colors[i] = packet.readUByte();
        }
        return this;
    }

    public int[] getLooks() {
        return looks;
    }

    public int[] getColors() {
        return colors;
    }

    public boolean isFemale() {
        return female;
    }
}
