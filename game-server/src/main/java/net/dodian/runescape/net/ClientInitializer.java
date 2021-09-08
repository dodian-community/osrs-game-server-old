package net.dodian.runescape.net;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.traffic.GlobalTrafficShapingHandler;
import io.netty.handler.traffic.TrafficCounter;
import net.dodian.runescape.GameInitializer;
import net.dodian.runescape.handlers.impl.LoginHandler;
import net.dodian.runescape.net.codec.game.ActionDecoder;
import net.dodian.runescape.net.codec.game.CommandEncoder;
import net.dodian.runescape.net.codec.pregame.HandshakeResponseEncoder;
import net.dodian.runescape.net.codec.pregame.Js5DataEncoder;
import net.dodian.runescape.net.codec.pregame.PreGameDecoder;
import net.dodian.runescape.net.codec.pregame.PreGameLoginEncoder;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ClientInitializer extends ChannelInitializer<Channel> implements BeanFactoryAware {

    private final GlobalTrafficShapingHandler trafficHandler = new GlobalTrafficShapingHandler(Executors.newSingleThreadScheduledExecutor(), 0, 0, 1000);

    private BeanFactory beanFactory;

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
                loginHandler,
                serverHandler
        );
    }

    public void initForGame(Channel channel) {
        if (!(channel instanceof EmbeddedChannel)) {
            while (channel.pipeline().last() != null) {
                channel.pipeline().removeLast();
            }

            channel.pipeline().addLast(new ReadTimeoutHandler(30, TimeUnit.SECONDS), trafficHandler,
                    commandEncoder, beanFactory.getBean(ActionDecoder.class), serverHandler);
        }
    }

    public TrafficCounter trafficStats() {
        return trafficHandler.trafficCounter();
    }

    @Override
    public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
