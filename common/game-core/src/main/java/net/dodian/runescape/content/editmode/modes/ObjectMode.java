package net.dodian.runescape.content.editmode.modes;

public abstract class ObjectMode implements EditorMode {
    protected int objectId;

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }
}
