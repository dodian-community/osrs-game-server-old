package net.dodian.runescape.util;

import java.util.Arrays;

public enum SpawnDirection {
    NORTH_WEST(0),
    NORTH(1),
    NORTH_EAST(2),
    WEST(3),
    EAST(4),
    SOUTH_WEST(5),
    SOUTH(6),
    SOUTH_EAST(7);

    private final int id;

    SpawnDirection(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static SpawnDirection getById(int id) {
        return Arrays.stream(SpawnDirection.values())
                .filter(direction -> direction.getId() == id)
                .findFirst().orElse(SOUTH);
    }
}