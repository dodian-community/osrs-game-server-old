package io.nozemi.runescape.net.packets.models;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.annotations.Opcodes;

import static io.nozemi.runescape.net.packets.PacketConstants.LOOKS_SET;

@Opcodes(LOOKS_SET)
public class SetLooks extends GamePacket {

    private final int[] looks = new int[7];
    private final int[] colors = new int[5];
    private boolean female;
    
    @Override
    public SetLooks decode(RSBuffer buffer) {
        female = buffer.readByte() == 1;
        for (int i = 0; i < 7; i++) {
            looks[i] = buffer.readUByte();
            if (looks[i] < 0)
                looks[i] = 0;
        }
        for (int i = 0; i < 5; i++) {
            colors[i] = buffer.readUByte();
        }
        return this;
    }

    @Override
    public GamePacket newInstance() {
        return new SetLooks();
    }
}