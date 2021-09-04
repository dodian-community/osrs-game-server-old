package io.nozemi.runescape.content.tools.editmode.modes;

public abstract class ObjectMode implements EditorMode {
    protected int objectId;

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }
}
