package io.nozemi.runescape.task

import io.nozemi.runescape.model.World
import io.nozemi.skript.Script

interface GameTask {
    /**
     * Executes the [GameTask] logic.
     */
    fun execute(world: World, service: Script)
}