package net.dodian.runescape.service.login;

import io.netty.buffer.ByteBuf;
import net.dodian.runescape.GameInitializer;
import net.dodian.runescape.crypto.IsaacRand;
import net.dodian.runescape.handlers.impl.DataHandler;
import net.dodian.runescape.model.Tile;
import net.dodian.runescape.model.World;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.entity.player.Privilege;
import net.dodian.runescape.net.ServerHandler;
import net.dodian.runescape.net.future.ClosingChannelFuture;
import net.dodian.runescape.net.message.LoginRequestMessage;
import net.dodian.runescape.service.serializers.PlayerLoadResult;
import nl.bartpelle.dawnguard.DataStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Arrays;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class LoginWorker implements Runnable, BeanFactoryAware {

    private static final Logger logger = LogManager.getLogger(LoginWorker.class);

    public static boolean acceptLogins = false;

    private BeanFactory beanFactory;

    private LoginService loginService;

    private DataStore store;

    @Autowired
    public LoginWorker() {
        this.store = GameInitializer.handler(DataHandler.class)
                .orElseThrow(() -> new RuntimeException("Couldn't find DataHandler..."))
                .dataStore();

        if(store == null) {
            throw new RuntimeException("Couldn't proceed with login, the datastore was null.");
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                processLoginJob();
            } catch(Exception e) {
                logger.error("Error processing login worker job!", e);
            }
        }
    }

    private void processLoginJob() throws Exception {
        LoginRequestMessage message = loginService.messages().take();

        if(message.delayedUntil() > System.currentTimeMillis()) {
            loginService.enqueue(message);
            Thread.sleep(30); // TODO: See what to do here later...
            return;
        }

        logger.debug("Attempting to process logging request for {}", message.username());

        for (int i = 0; i < 16; i++) {
            if (message.crcs()[i] != store.getIndex(i).getCRC()) {
                ByteBuf resp = message.channel().alloc().buffer(1).writeByte(6);
                message.channel().writeAndFlush(resp).addListener(new ClosingChannelFuture());
                continue;
            }
        }

        InetSocketAddress socketAddress = (InetSocketAddress) message.channel().remoteAddress();
        InetAddress inetaddress = socketAddress.getAddress();
        String ip = inetaddress.getHostAddress(); // IP address of client

        // Block logins right now
        /*if (world.ticksUntilUpdate() >= 0) {
            ByteBuf resp = message.channel().alloc().buffer(1).writeByte(14);
            message.channel().writeAndFlush(resp).addListener(new ClosingChannelFuture());
            return;
        }*/

        // Prepare random gens
        int[] seed = message.isaacSeed();
        IsaacRand inRand = new IsaacRand(seed);
        IsaacRand outRand = new IsaacRand(Arrays.stream(seed).map(i -> i + 50).toArray());

        Player player = beanFactory.getBean(Player.class)
                .channel(message.channel())
                .username(message.username())
                .inRand(inRand)
                .outRand(outRand);

        //player.world(world);
        player.tile(new Tile(3222, 3222));

        boolean success = LoginService.serializer().loadPlayer(player, null, message.password(), result -> {
            if(!result.equals(PlayerLoadResult.OK)) {
                ByteBuf resp = message.channel().alloc().buffer(1).writeByte(result.code());
                message.channel().writeAndFlush(resp).addListener(new ClosingChannelFuture());
                return;
            }

            // Convert pipeline
            GameInitializer.clientInitializer().initForGame(message.channel());

            // Attach player to session
            player.channel().attr(ServerHandler.ATTRIB_PLAYER).set(player);

            World world = GameInitializer.world();

            GameInitializer.serverProcessor().submitLogic(() -> {
                if(world.playerByName(player.username()).isPresent()) {
                    ByteBuf resp = message.channel().alloc().buffer(1).writeByte(PlayerLoadResult.ALREADY_ONLINE.code());
                    message.channel().writeAndFlush(resp).addListener(new ClosingChannelFuture());
                    logger.error("Critical post-login online state! Name {} on IP {}.", player.username(), player.ip());
                    return;
                }

                // See if we may be registered (world full??)
                if (!world.registerPlayer(player) || (player.privilege() != Privilege.ADMIN && world.players().size() > World.plimit)) {
                    ByteBuf resp = message.channel().alloc().buffer(1).writeByte(PlayerLoadResult.WORLD_FULL.code());
                    message.channel().writeAndFlush(resp).addListener(new ClosingChannelFuture());
                    logger.error("Critical world full state! Name {} on IP {}.", player.username(), player.ip());
                    return;
                }

                ByteBuf temp = message.channel().alloc().buffer(11);
                temp.writeByte(2);

                temp.writeByte(0); // Something trigger bla?
                temp.writeInt(0); // idk this is 4 bytes of isaac ciphered keys

                int privilege = player.privilege() == null ? 0 : player.privilege().ordinal();
                /*if (player.seniorModerator()) {
                    privilege = 2; // To make CTRL-click teleporting work. :)
                }*/

                temp.writeByte(privilege); // Rights
                temp.writeBoolean(true); // Member
                temp.writeShort(player.index()); // Index
                temp.writeBoolean(true); // Member

                message.channel().write(temp);

                loginService.complete(player, message);
            });
        }, message);

        if(!success) {
            loginService.enqueue(message);
            Thread.sleep(100); // TODO: Look into this...
        }
    }

    public void loginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
