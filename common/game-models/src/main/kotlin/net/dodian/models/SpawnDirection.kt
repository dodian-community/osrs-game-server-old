package net.dodian.models

import java.util.*

enum class SpawnDirection(val id: Int) {
    NORTH_WEST(0),
    NORTH(1),
    NORTH_EAST(2),
    WEST(3),
    EAST(4),
    SOUTH_WEST(5),
    SOUTH(6),
    SOUTH_EAST(7);

    companion object {
        fun getById(id: Int): SpawnDirection {
            return Arrays.stream(values())
                .filter { direction: SpawnDirection -> direction.id == id }
                .findFirst().orElse(SOUTH)
        }
    }
}