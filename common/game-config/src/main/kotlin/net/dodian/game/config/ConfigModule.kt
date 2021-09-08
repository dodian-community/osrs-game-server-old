package net.dodian.game.config

import com.fasterxml.jackson.databind.ObjectMapper
import net.dodian.game.core.GameEnv
import net.dodian.game.core.ServerModule
import org.springframework.beans.factory.annotation.Autowired
import java.nio.file.Path

class GameConfigProvider @Autowired constructor(
    private val mapper: ObjectMapper
) : ServerModule<GameConfig> {

    override fun get(): GameConfig {
        val config = ConfigMap(mapper).load(CONFIG_PATH)
        val name: String = config["server-name"] ?: DEFAULT_SERVER_NAME
        val dataPath: Path = config.dataPath("data-path")
        val pluginPath: Path = config.pluginPath("plugin-path")
        val port: Int = config["port"] ?: DEFAULT_PORT
        val home: List<Int> = config["home"] ?: DEFAULT_HOME
        val envString: String = config["env"] ?: DEFAULT_ENV.toString()

        val revision: Number = config["revision"] ?: error("Game config revision required.")
        val majorRevision: Int
        val minorRevision: Int

        if (revision is Double) {
            val split = revision.toString().split(".")
            if (split.size == 1) {
                majorRevision = revision.toInt()
                minorRevision = DEFAULT_MINOR_REVISION
            } else {
                majorRevision = split[0].toInt()
                minorRevision = split[1].toInt()
            }
        } else {
            majorRevision = revision as Int
            minorRevision = DEFAULT_MINOR_REVISION
        }

        val env = when {
            envString.contains(TESTING_ENV_IDENTIFIER) -> GameEnv.Testing
            envString.contains(DEVELOPMENT_ENV_IDENTIFIER) -> GameEnv.Development
            envString.contains(PRODUCTION_ENV_IDENTIFIER) -> GameEnv.Production
            else -> DEFAULT_ENV
        }

        return GameConfig(
            name = name,
            majorRevision = majorRevision,
            minorRevision = minorRevision,
            port = port,
            dataPath = dataPath,
            pluginPath = pluginPath,
            //home = home.coordinates(),
            env = env
        )
    }

    private fun ConfigMap.dataPath(key: String): Path {
        val path: String = this[key] ?: return DEFAULT_DATA_PATH
        return Path.of(path)
    }

    private fun ConfigMap.pluginPath(key: String): Path {
        val path: String = this[key] ?: return DEFAULT_PLUGIN_PATH
        return Path.of(path)
    }

    //private fun List<Int>.coordinates() = when (size) {
    //    2 -> Coordinates(this[0], this[1])
    //    3 -> Coordinates(this[0], this[1], this[2])
    //    else -> error("Invalid array size for coordinates: $this")
    //}

    companion object {

        private val CONFIG_PATH = Path.of(".", "config.yml")
        private val DEFAULT_DATA_PATH = Path.of(".", "data")
        private val DEFAULT_PLUGIN_PATH = Path.of(".", "plugins")
        private const val DEFAULT_SERVER_NAME = "RS Mod"
        private const val DEFAULT_PORT = 43594
        private const val DEFAULT_MINOR_REVISION = 1
        private val DEFAULT_HOME = listOf(3200, 3200)
        private val DEFAULT_ENV = GameEnv.Production

        private const val TESTING_ENV_IDENTIFIER = "test"
        private const val DEVELOPMENT_ENV_IDENTIFIER = "dev"
        private const val PRODUCTION_ENV_IDENTIFIER = "prod"
    }
}