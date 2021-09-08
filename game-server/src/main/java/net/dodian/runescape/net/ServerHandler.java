package net.dodian.runescape.net;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.ReadTimeoutException;
import io.netty.util.AttributeKey;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.script.TimerKey;
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
            bound.putattrib(net.dodian.runescape.model.AttributeKey.LOGOUT, true);
            bound.timers().register(TimerKey.CONNECTION_FORCE_LOGOUT, 100);

            // Make an extra check
            if (bound.world() == null) {
                logger.error("Desynchronized player not in world! {} from {}.", bound.username(), bound.ip());
            }
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        try {
            if (cause.getStackTrace().length > 0 && cause.getStackTrace()[0].getMethodName().equals("read0")) return;

            if (cause instanceof ReadTimeoutException) {
                logger.info("Channel disconnected due to read timeout (30s): {}.", ctx.channel());
                ctx.channel().close();
            } else {
                logger.error("An exception has been caused in the pipeline: ", cause);
            }
        } catch (Throwable e) {
            logger.error("Uncaught server exception!", e);
        }

        super.exceptionCaught(ctx, cause);
    }
}
