package io.nozemi.runescape.handlers.impl;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.nozemi.runescape.crypto.IsaacRand;
import io.nozemi.runescape.handlers.Handler;
import io.nozemi.runescape.net.message.LoginRequestMessage;
import io.nozemi.runescape.net.message.PreLoginResponseMessage;
import io.nozemi.runescape.service.login.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static io.nozemi.runescape.net.message.HandshakeResponse.ALL_OK;

@Component
@ChannelHandler.Sharable
public class LoginHandler extends ChannelInboundHandlerAdapter implements Handler {

    private static final Logger logger = LogManager.getLogger(LoginHandler.class);

    private LoginService loginService;

    @Override
    public void initialize() {

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
            }

            String username = message.username();
            String password = message.password();

            logger.trace("Player logged in: {}.", username);

            int[] seed = message.isaacSeed();
            IsaacRand inRand = new IsaacRand(seed);
            IsaacRand outRand = new IsaacRand(Arrays.stream(seed).map(i -> i + 50).toArray());

            //Player player = new Player(message.channel(), message.username(), server.world(), new Tile(3088, 3505), inRand, outRand);
        }
    }
}
