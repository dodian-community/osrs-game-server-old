package net.dodian.runescape.net

import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.embedded.EmbeddedChannel
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.traffic.GlobalTrafficShapingHandler
import io.netty.handler.traffic.TrafficCounter
import net.dodian.runescape.GameInitializer
import net.dodian.runescape.handlers.LoginHandler
import net.dodian.runescape.handlers.impl.ConfigHandler
import net.dodian.runescape.handlers.impl.DataHandler
import net.dodian.runescape.net.codec.game.ActionDecoder
import net.dodian.runescape.net.codec.game.CommandEncoder
import net.dodian.runescape.net.codec.pregame.HandshakeResponseEncoder
import net.dodian.runescape.net.codec.pregame.Js5DataEncoder
import net.dodian.runescape.net.codec.pregame.PreGameDecoder
import net.dodian.runescape.net.codec.pregame.PreGameLoginEncoder
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.BeanFactoryAware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class ClientInitializer @Autowired constructor(
    private val loginHandler: LoginHandler,
    private val configHandler: ConfigHandler,
    private val dataHandler: DataHandler
) : ChannelInitializer<Channel>(), BeanFactoryAware {

    private val trafficHandler = GlobalTrafficShapingHandler(Executors.newSingleThreadScheduledExecutor(), 0, 0, 1000)

    private var beanFactory: BeanFactory? = null

    private var js5Handler: Js5Handler? = null
    private var serverHandler: ServerHandler? = null
    private var commandEncoder: CommandEncoder? = null

    init {
        this.js5Handler = Js5Handler(dataHandler.dataStore(), configHandler.config())
        this.serverHandler = ServerHandler()
        this.commandEncoder = CommandEncoder()
    }

    override fun initChannel(ch: Channel?) {
        ch!!.pipeline().addLast(
            trafficHandler,
            // TODO: implement config here
            PreGameDecoder(171),
            Js5DataEncoder(),
            HandshakeResponseEncoder(),
            PreGameLoginEncoder(),
            js5Handler,
            loginHandler,
            serverHandler
        )
    }

    fun initForGame(channel: Channel) {
        if (channel !is EmbeddedChannel) {
            while (channel.pipeline().last() != null) {
                channel.pipeline().removeLast()
            }

            channel.pipeline().addLast(
                ReadTimeoutHandler(30, TimeUnit.SECONDS),
                trafficHandler,
                commandEncoder,
                beanFactory!!.getBean(ActionDecoder::class.java),
                serverHandler
            )
        }
    }

    fun trafficStats(): TrafficCounter {
        return trafficHandler.trafficCounter()
    }

    override fun setBeanFactory(beanFactory: BeanFactory) {
        this.beanFactory = beanFactory
    }
}