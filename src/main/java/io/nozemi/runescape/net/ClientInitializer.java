package io.nozemi.runescape.net;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.traffic.GlobalTrafficShapingHandler;
import io.netty.handler.traffic.TrafficCounter;
import io.nozemi.runescape.GameInitializer;
import io.nozemi.runescape.handlers.impl.LoginHandler;
import io.nozemi.runescape.net.codec.pregame.HandshakeResponseEncoder;
import io.nozemi.runescape.net.codec.pregame.Js5DataEncoder;
import io.nozemi.runescape.net.codec.pregame.PreGameDecoder;
import io.nozemi.runescape.net.codec.pregame.PreGameLoginEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ClientInitializer extends ChannelInitializer<Channel> {

    private final GlobalTrafficShapingHandler trafficHandler = new GlobalTrafficShapingHandler(Executors.newSingleThreadScheduledExecutor(), 0, 0, 1000);

    //private static ServerHandler serverHandler;

    private final LoginHandler loginHandler;

    @Autowired
    public ClientInitializer(LoginHandler loginHandler) {
        this.loginHandler = loginHandler;
    }

    @Override
    protected void initChannel(Channel channel) {
        channel.pipeline().addLast(
                trafficHandler,
                new PreGameDecoder(GameInitializer.config().getInt("server.revision")),
                new Js5DataEncoder(),
                new HandshakeResponseEncoder(),
                new PreGameLoginEncoder(),
                new Js5Handler(),
                loginHandler,// LoginHandler
                null// ServerHandler
        );
    }

    public TrafficCounter trafficStats() {
        return trafficHandler.trafficCounter();
    }
}
