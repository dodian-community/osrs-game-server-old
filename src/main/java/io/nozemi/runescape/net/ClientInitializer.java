package io.nozemi.runescape.net;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.traffic.GlobalTrafficShapingHandler;
import io.netty.handler.traffic.TrafficCounter;
import io.nozemi.runescape.GameInitializer;
import io.nozemi.runescape.handlers.impl.LoginHandler;
import io.nozemi.runescape.net.codec.game.ActionDecoder;
import io.nozemi.runescape.net.codec.game.CommandEncoder;
import io.nozemi.runescape.net.codec.pregame.HandshakeResponseEncoder;
import io.nozemi.runescape.net.codec.pregame.Js5DataEncoder;
import io.nozemi.runescape.net.codec.pregame.PreGameDecoder;
import io.nozemi.runescape.net.codec.pregame.PreGameLoginEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ClientInitializer extends ChannelInitializer<Channel> {

    private final GlobalTrafficShapingHandler trafficHandler = new GlobalTrafficShapingHandler(Executors.newSingleThreadScheduledExecutor(), 0, 0, 1000);

    //private static ServerHandler serverHandler;

    private final LoginHandler loginHandler;
    private final Js5Handler js5Handler;
    private final ServerHandler serverHandler;
    private final CommandEncoder commandEncoder;

    @Autowired
    public ClientInitializer(LoginHandler loginHandler) {
        this.loginHandler = loginHandler;
        this.js5Handler = new Js5Handler();
        this.serverHandler = new ServerHandler();
        this.commandEncoder = new CommandEncoder();
    }

    @Override
    protected void initChannel(Channel channel) {
        channel.pipeline().addLast(
                trafficHandler,
                new PreGameDecoder(GameInitializer.config().getInt("server.revision")),
                new Js5DataEncoder(),
                new HandshakeResponseEncoder(),
                new PreGameLoginEncoder(),
                js5Handler,
                loginHandler,// LoginHandler
                serverHandler// ServerHandler
        );
    }

    public void initForGame(Channel channel) {
        if (!(channel instanceof EmbeddedChannel)) {
            while (channel.pipeline().last() != null) {
                channel.pipeline().removeLast();
            }

            channel.pipeline().addLast(new ReadTimeoutHandler(30, TimeUnit.SECONDS), trafficHandler, commandEncoder, new ActionDecoder(), serverHandler);
        }
    }

    public TrafficCounter trafficStats() {
        return trafficHandler.trafficCounter();
    }
}
