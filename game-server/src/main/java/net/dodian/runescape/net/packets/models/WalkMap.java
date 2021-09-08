package net.dodian.runescape.net.packets.models;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.WALK_BY_CLICKING;
import static net.dodian.runescape.net.packets.PacketConstants.WALK_BY_MINIMAP;

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