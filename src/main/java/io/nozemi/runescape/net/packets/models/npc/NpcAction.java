package io.nozemi.runescape.net.packets.models.npc;

import io.nozemi.runescape.net.packets.GamePacket;

public abstract class NpcAction extends GamePacket {
    protected boolean run;
    protected int index;

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
