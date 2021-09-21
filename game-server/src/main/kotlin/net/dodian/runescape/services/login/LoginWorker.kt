package net.dodian.runescape.services.login

import com.github.michaelbull.logging.InlineLogger
import net.dodian.runescape.GameInitializer
import net.dodian.runescape.crypto.IsaacRand
import net.dodian.runescape.handlers.impl.DataHandler
import net.dodian.runescape.model.Tile
import net.dodian.runescape.model.entity.Player
import net.dodian.runescape.net.ServerHandler
import net.dodian.runescape.net.future.ClosingChannelFuture
import net.dodian.runescape.net.message.LoginRequestMessage
import net.dodian.runescape.services.serializers.player.PlayerLoadResult
import nl.bartpelle.dawnguard.DataStore
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.BeanFactoryAware
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.net.InetSocketAddress
import java.util.*

private val logger = InlineLogger()

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class LoginWorker : Runnable, BeanFactoryAware {


    private var beanFactory: BeanFactory? = null

    var loginService: LoginService? = null

    private val store: DataStore? = GameInitializer.handler(DataHandler::class.java)?.dataStore()

    init {
        if (store == null) throw RuntimeException("Couldn't proceed with login, the datastore was null.")
    }

    private fun processLoginJob() {
        val message: LoginRequestMessage = loginService!!.messages.take()

        if (message.delayedUntil() > System.currentTimeMillis()) {
            loginService!!.enqueue(message)
            Thread.sleep(30)
            return
        }

        logger.debug { ("Attempting to process logging request for ${message.username()}") }

        for (i in 0..15) {
            if (message.crcs()[i] != store!!.getIndex(i).crc) {
                val resp = message.channel().alloc().buffer(1).writeByte(6)
                message.channel().writeAndFlush(resp).addListener(ClosingChannelFuture())
                continue
            }
        }

        val socketAddress = message.channel().remoteAddress() as InetSocketAddress
        val inetaddress = socketAddress.address
        val ip = inetaddress.hostAddress // IP address of client

        // Block logins right now
        /*if (world.ticksUntilUpdate() >= 0) {
            ByteBuf resp = message.channel().alloc().buffer(1).writeByte(14);
            message.channel().writeAndFlush(resp).addListener(new ClosingChannelFuture());
            return;
        }*/

        // Prepare random gens

        // Block logins right now
        /*if (world.ticksUntilUpdate() >= 0) {
            ByteBuf resp = message.channel().alloc().buffer(1).writeByte(14);
            message.channel().writeAndFlush(resp).addListener(new ClosingChannelFuture());
            return;
        }*/

        // Prepare random gens
        val seed = message.isaacSeed()
        val inRand = IsaacRand(seed)
        val outRand = IsaacRand(Arrays.stream(seed).map { i: Int -> i + 50 }.toArray())

        val player: Player = beanFactory!!.getBean(Player::class.java)
            .channel(message.channel())
            .username(message.username())
            .inRand(inRand)
            .outRand(outRand)

        //player.world(world);

        //player.world(world);
        player.tile(Tile(3222, 3222))

        val success = loginService!!.serializer.loadPlayer(
            player, null, message.password(), {
                if (!it?.equals(PlayerLoadResult.OK)!!) {
                    val resp = message.channel().alloc().buffer(1).writeByte(it.code())
                    message.channel().writeAndFlush(resp).addListener { ClosingChannelFuture() }
                    return@loadPlayer
                }

                GameInitializer.clientInitializer?.initForGame(message.channel())

                player.channel().attr(ServerHandler.ATTRIB_PLAYER).set(player)

                val world = GameInitializer.world

                GameInitializer.serverProcessor?.submitLogic {
                    if (world?.playerByName(player.username())?.isPresent!!) {

                    }
                }
            }, message
        )
    }

    override fun run() {
        while (true) {
            try {
                processLoginJob()
            } catch (e: Exception) {
                logger.error { "Error processing login worker job!" }
                e.printStackTrace()
            }
        }
    }

    override fun setBeanFactory(beanFactory: BeanFactory) {
        this.beanFactory = beanFactory
    }
}