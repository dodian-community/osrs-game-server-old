package io.nozemi.runescape.model;

public enum Realm {
    ECO(1),
    PVP(2),
    DODIAN(3);

    private final int id;

    Realm(int id) {
        this.id = id;
    }

    public boolean isEco() {
        return this == ECO;
    }

    public boolean isPvP() {
        return this == PVP;
    }

    public boolean isDodian() {
        return this == DODIAN;
    }

    public int id() {
        return this.id;
    }
}
