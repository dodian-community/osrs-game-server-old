package net.dodian.runescape.net.packets.models.object;

import net.dodian.runescape.net.packets.GamePacket;

public abstract class ObjectAction extends GamePacket {
    protected int id;
    protected int x;
    protected int z;
    protected boolean run;

    public int getId() {
        return id;
    }

    public int getZ() {
        return z;
    }

    public int getX() {
        return x;
    }

    public boolean isRun() {
        return run;
    }
}
