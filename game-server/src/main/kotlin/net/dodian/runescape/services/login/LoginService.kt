package net.dodian.runescape.services.login

import com.github.michaelbull.logging.InlineLogger
import io.netty.channel.ChannelHandlerContext
import net.dodian.runescape.io.RSBuffer
import net.dodian.runescape.model.entity.Player
import net.dodian.runescape.net.ServerHandler
import net.dodian.runescape.net.message.LoginRequestMessage
import net.dodian.runescape.net.message.game.Action
import net.dodian.runescape.net.message.game.command.DisplayMap
import net.dodian.runescape.net.message.game.command.SetRealm
import net.dodian.runescape.services.Service
import net.dodian.runescape.services.serializers.player.PlayerSerializer
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.BeanFactoryAware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue

private val logger = InlineLogger()

@Component
class LoginService @Autowired constructor(
    @Qualifier("jsonPlayerSerializer")
    val serializer: PlayerSerializer
) : Service, BeanFactoryAware {

    private var beanFactory: BeanFactory? = null

    val messages = LinkedBlockingQueue<LoginRequestMessage>()

    fun enqueue(message: LoginRequestMessage) {
        messages.add(message)
    }

    fun complete(player: Player, message: LoginRequestMessage) {
        player.interfaces().resizable(message.resizableInterfaces())
        player.teleport(player.tile())

        player.channel().attr(ServerHandler.ATTRIB_PLAYER).set(player)

        player.write(DisplayMap(player, true))
        player.write(SetRealm(player.world().realm().id()))

        player.world().syncMap(player, null, false)
        player.channel().flush()

        player.pendingActions().add(object : Action {
            override fun decode(buf: RSBuffer, ctx: ChannelHandlerContext, opcode: Int, size: Int, player: Player) {}

            override fun process(player: Player) {
                player.interfaces().setupGamePane(false)
                player.initiate()
            }
        })
    }

    override fun setup() {
        logger.info { "Using ${serializer.javaClass.simpleName} to serialize and deserialize player data." }
    }

    override fun start(): Boolean {
        val executor: Executor = Executors.newFixedThreadPool(2)

        for (i in 0..2) {
            val loginWorker = beanFactory!!.getBean(LoginWorker::class.java)
            loginWorker.loginService = this
            executor.execute(loginWorker)
        }

        return true
    }

    override fun stop(): Boolean {
        return false
    }

    override fun isAlive(): Boolean {
        return true
    }

    override fun setBeanFactory(beanFactory: BeanFactory) {
        this.beanFactory = beanFactory
    }
}