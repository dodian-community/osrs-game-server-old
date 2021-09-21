package net.dodian.runescape.handlers

import com.github.michaelbull.logging.InlineLogger
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import net.dodian.runescape.GameInitializer
import net.dodian.runescape.crypto.IsaacRand
import net.dodian.runescape.model.Tile
import net.dodian.runescape.model.entity.Player
import net.dodian.runescape.model.entity.player.Privilege
import net.dodian.runescape.net.message.HandshakeResponse
import net.dodian.runescape.net.message.LoginRequestMessage
import net.dodian.runescape.net.message.PreLoginResponseMessage
import net.dodian.runescape.services.login.LoginService
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.BeanFactoryAware
import org.springframework.stereotype.Component
import java.util.*

private val logger = InlineLogger()

@Component
@Sharable
class LoginHandler : ChannelInboundHandlerAdapter(), Handler, BeanFactoryAware {

    private var loginService: LoginService? = null
    private var beanFactory: BeanFactory? = null

    override fun initialize() {
        val serviceHandler = GameInitializer.handler(ServiceHandler::class.java) ?: throw RuntimeException("Failed to get ServiceHandler...")

        loginService = serviceHandler.service(LoginService::class.java, false) ?: throw RuntimeException("Failed to get LoginService...")
    }

    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any?) {
        super.channelRead(ctx, msg)

        if(msg is PreLoginResponseMessage) {
            ctx?.writeAndFlush(HandshakeResponse.ALL_OK)
        } else {
            val message = msg as LoginRequestMessage

            if(loginService != null) {
                loginService!!.enqueue(message)
            } else {
                logger.error { "No LoginService is present for handling player logins." }
            }

            val username = message.username()
            val password = message.password()

            logger.trace { "Player, $username logged in." }

            val seed = message.isaacSeed()
            val inRand = IsaacRand(seed)
            val outRand = IsaacRand(Arrays.stream(seed).map { i: Int -> i + 50 }.toArray())

            val player = beanFactory!!.getBean(Player::class.java)
                .channel(message.channel())
                .username(message.username())
                .inRand(inRand)
                .outRand(outRand)

            if(GameInitializer.devServer) {
                player.privilege(Privilege.valueOf(password.uppercase(Locale.getDefault())))
            }

            player.tile(Tile(3088, 3505))
            player.id(player.username())
            loginService!!.complete(player, message)
        }
    }

    override fun setBeanFactory(beanFactory: BeanFactory) {
        this.beanFactory = beanFactory
    }
}