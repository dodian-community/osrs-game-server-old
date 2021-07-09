package io.nozemi.runescape.net;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.script.TimerKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ChannelHandler.Sharable
public class ServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LogManager.getLogger(ServerHandler.class);

    /**
     * The attribute key for the Player attachment of the channel.
     */
    public static final AttributeKey<Player> ATTRIB_PLAYER = AttributeKey.valueOf("player");

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);

        logger.trace("A new client has connected: {}", ctx.channel());
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);

        logger.trace("A client has disconnected: {}", ctx.channel());

        Player bound = ctx.channel().attr(ATTRIB_PLAYER).get();
        if (bound != null) {
            bound.putattrib(io.nozemi.runescape.model.AttributeKey.LOGOUT, true);
            bound.timers().register(TimerKey.CONNECTION_FORCE_LOGOUT, 100);

            // Make an extra check
            if (bound.world() == null) {
                logger.error("Desynchronized player not in world! {} from {}.", bound.username(), bound.ip());
            }
        }
    }
}
