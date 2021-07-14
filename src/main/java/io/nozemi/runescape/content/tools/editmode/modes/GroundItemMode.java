package io.nozemi.runescape.content.tools.editmode.modes;

public abstract class GroundItemMode implements EditorMode {
    protected int itemId;
    protected int respawnTime;

    public int getItemId() {
        return itemId;
    }

    public int getRespawnTime() {
        return respawnTime;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setRespawnTime(int respawnTime) {
        this.respawnTime = respawnTime;
    }
}
