package net.dodian.runescape

import com.github.michaelbull.logging.InlineLogger
import com.typesafe.config.Config
import io.netty.bootstrap.ServerBootstrap
import io.netty.buffer.UnpooledByteBufAllocator
import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import net.dodian.runescape.handlers.Handler
import net.dodian.runescape.handlers.impl.ConfigHandler
import net.dodian.runescape.handlers.impl.DataHandler
import net.dodian.runescape.model.World
import net.dodian.runescape.net.ClientInitializer
import net.dodian.runescape.util.map.MapDecryptionKeys
import nl.bartpelle.dawnguard.DataStore
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.BeanFactoryAware
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.nio.file.Path
import java.util.*

private val logger = InlineLogger()

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class GameInitializer @Autowired constructor(
    handlers: List<Handler>,
    serverProcessor: ServerProcessor
) : InitializingBean, BeanFactoryAware {

    companion object {
        var clientInitializer: ClientInitializer? = null
        var handlers: List<Handler>? = null
        var serverProcessor: ServerProcessor? = null

        var bootstrap: ServerBootstrap? = null
        var beanFactory: BeanFactory? = null

        var config: Config? = null
        var store: DataStore? = null
        var world: World? = null

        var testServer = true
        var devServer = true

        fun prepareHandlers(handlers: List<Handler>) {
            GameInitializer.handlers = handlers
            handlers.forEach { it.initialize() }
        }

        fun <T : Handler> handler(handlerClass: Class<out T>): T? {
            if (handlers == null)
                return null

            return handlers!!.first { handler ->
                handler.javaClass.isAssignableFrom(handlerClass)
            } as T?
        }
    }

    init {
        GameInitializer.serverProcessor = serverProcessor

        prepareHandlers(handlers)

        val configHandler = handler(ConfigHandler::class.java) ?: throw RuntimeException("Failed to find ConfigHandler...")

        config = configHandler.config()
    }

    override fun afterPropertiesSet() {
        System.setProperty("io.netty.buffer.bytebuf.checkAccessible", "false")

        val dataHandler = handler(DataHandler::class.java) ?: throw RuntimeException("Failed to find DataHandler...")

        store = dataHandler.dataStore()

        val mapKeysFile = Path.of(config!!.getString("server.mapkeys"))
        if (!mapKeysFile.toFile().exists())
            throw RuntimeException("Failed to find map keys at: ${mapKeysFile.toAbsolutePath()}")

        MapDecryptionKeys.load(mapKeysFile.toFile())

        //loadScripts()

        world = beanFactory!!.getBean(World::class.java)
        world!!.postLoad()

        testServer = !config!!.hasPath("server.test") || config!!.getBoolean("server.test")
        devServer = !config!!.hasPath("server.dev") || config!!.getBoolean("server.dev")

        val acceptGroup: EventLoopGroup = NioEventLoopGroup(config!!.getInt("net.acceptthreads"))
        val ioGroup: EventLoopGroup = NioEventLoopGroup(config!!.getInt("net.iothreads"))

        clientInitializer = beanFactory!!.getBean(ClientInitializer::class.java)

        GameInitializer.serverProcessor!!.initialize()

        bootstrap = ServerBootstrap()
        bootstrap!!.group(acceptGroup, ioGroup)
        bootstrap!!.channel(NioServerSocketChannel::class.java)
        bootstrap!!.childHandler(clientInitializer)
        bootstrap!!.childOption(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000)
        bootstrap!!.childOption(ChannelOption.TCP_NODELAY, true)
        bootstrap!!.childOption(ChannelOption.SO_KEEPALIVE, true)
        bootstrap!!.option(ChannelOption.ALLOCATOR, UnpooledByteBufAllocator(false))
        bootstrap!!.childOption(ChannelOption.ALLOCATOR, UnpooledByteBufAllocator(false))

        System.gc()

        logger.info { "Binding to ${config!!.getString("net.address")}:${config!!.getInt("net.port")} " +
                "as realm ${world!!.realm().name} ${if (testServer) " in testing mode... " else ""}" }

        bootstrap!!.bind(config!!.getString("net.address"), config!!.getInt("net.port")).sync().awaitUninterruptibly()
    }

    fun loadScripts() {
        logger.info { "Loading scripts..." }
    }

    override fun setBeanFactory(beanFactory: BeanFactory) {
        TODO("Not yet implemented")
    }
}