package io.nozemi.runescape.net.packets.models;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.annotations.Opcodes;

import static io.nozemi.runescape.net.packets.PacketConstants.WALK_BY_CLICKING;
import static io.nozemi.runescape.net.packets.PacketConstants.WALK_BY_MINIMAP;

@Opcodes({WALK_BY_CLICKING, WALK_BY_MINIMAP})
public class WalkMap extends GamePacket {

    private int x;
    private int z;
    private int mode;

    @Override
    public WalkMap decode(RSBuffer buffer) {
        this.x = buffer.readUShort();
        this.mode = buffer.readByteN();
        this.z = buffer.readULEShort();
        return this;
    }

    @Override
    public WalkMap newInstance() {
        return new WalkMap();
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

    public void setMode(int mode) {
        this.mode = mode;
    }
}