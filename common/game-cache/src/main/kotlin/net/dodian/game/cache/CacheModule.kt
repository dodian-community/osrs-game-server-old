package net.dodian.game.cache

import io.guthix.js5.Js5Cache
import io.guthix.js5.container.disk.Js5DiskStore
import net.dodian.game.config.GameConfig
import net.dodian.game.core.ServerModule
import java.nio.file.Files

class CacheModule constructor(
    private val gameConfig: GameConfig
) : ServerModule<GameCache> {

    override fun get(): GameCache {
        val path = gameConfig.cachePath.resolve(PACKED_FOLDER)
        if (!Files.isDirectory(path)) {
            error("Cache directory does not exist: ${path.toAbsolutePath()}")
        }
        val diskStore = Js5DiskStore.open(path)
        val cache = Js5Cache(diskStore)
        return GameCache(path, diskStore, cache)
    }

    companion object {
        private const val PACKED_FOLDER = "packed"
    }
}