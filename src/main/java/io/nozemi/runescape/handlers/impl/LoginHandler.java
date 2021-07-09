package io.nozemi.runescape.handlers.impl;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.nozemi.runescape.GameInitializer;
import io.nozemi.runescape.crypto.IsaacRand;
import io.nozemi.runescape.handlers.Handler;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.LoginRequestMessage;
import io.nozemi.runescape.net.message.PreLoginResponseMessage;
import io.nozemi.runescape.service.login.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static io.nozemi.runescape.net.message.HandshakeResponse.ALL_OK;

@Component
@ChannelHandler.Sharable
public class LoginHandler extends ChannelInboundHandlerAdapter implements Handler, BeanFactoryAware {

    private static final Logger logger = LogManager.getLogger(LoginHandler.class);

    private LoginService loginService;

    private BeanFactory beanfactory;

    @Override
    public void initialize() {
        ServiceHandler serviceHandler = GameInitializer.handler(ServiceHandler.class)
                .orElseThrow(() -> new RuntimeException("Failed to get ServiceHandler..."));

        this.loginService = serviceHandler.service(LoginService.class, false)
                .orElseThrow(() -> new RuntimeException("Failed to get LoginService..."));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);

        if (msg instanceof PreLoginResponseMessage) {
            PreLoginResponseMessage pre = (PreLoginResponseMessage) msg;
            ctx.writeAndFlush(ALL_OK);
        } else if (msg instanceof LoginRequestMessage) {
            LoginRequestMessage message = (LoginRequestMessage) msg;

            if (loginService != null) {
                loginService.enqueue(message);
            } else {
                logger.error("No LoginService is present for handling player logins...");
            }

            String username = message.username();
            String password = message.password();

            logger.trace("Player logged in: {}.", username);

            int[] seed = message.isaacSeed();
            IsaacRand inRand = new IsaacRand(seed);
            IsaacRand outRand = new IsaacRand(Arrays.stream(seed).map(i -> i + 50).toArray());

            Player player = beanfactory.getBean(Player.class)
                    .channel(message.channel())
                    .username(message.username())
                    .inRand(inRand)
                    .outRand(outRand);

            player.tile(new Tile(3088, 3505));
            player.id(player.username());
            loginService.complete(player, message);
        }
    }

    @Override
    public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
        this.beanfactory = beanFactory;
    }
}
