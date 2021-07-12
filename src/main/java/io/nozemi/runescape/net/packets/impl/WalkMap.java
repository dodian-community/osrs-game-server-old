package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.Opcodes;
import org.springframework.stereotype.Component;

import static io.nozemi.runescape.net.packets.PacketConstants.WALK_BY_CLICKING;
import static io.nozemi.runescape.net.packets.PacketConstants.WALK_BY_MINIMAP;

@Component
@Opcodes({WALK_BY_CLICKING, WALK_BY_MINIMAP})
public class WalkMap extends GamePacket {
    private int x;
    private int z;
    private int mode;

    @Override
    public WalkMap createFrom(RSBuffer packet) {
        x = packet.readUShort();
        mode = packet.readByteN();
        z = packet.readULEShort();
        return this;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }
}
