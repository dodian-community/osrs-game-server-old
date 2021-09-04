package io.nozemi.runescape.net.packets.models.item;

import io.nozemi.runescape.net.packets.GamePacket;

public abstract class ItemAction extends GamePacket {
    protected int slot;
    protected int item;
    protected int hash;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }
}
