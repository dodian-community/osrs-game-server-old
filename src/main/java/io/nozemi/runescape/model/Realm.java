package io.nozemi.runescape.model;

public enum Realm {
    ECO,
    PVP,
    DODIAN;

    public boolean isEco() {
        return this == ECO;
    }

    public boolean isPvP() {
        return this == PVP;
    }

    public boolean isDodian() {
        return this == DODIAN;
    }
}
