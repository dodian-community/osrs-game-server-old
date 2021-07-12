package io.nozemi.runescape;

import com.typesafe.config.Config;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.nozemi.runescape.handlers.Handler;
import io.nozemi.runescape.handlers.impl.ConfigHandler;
import io.nozemi.runescape.handlers.impl.DataHandler;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.net.ClientInitializer;
import io.nozemi.runescape.util.map.MapDecryptionKeys;
import nl.bartpelle.dawnguard.DataStore;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class GameInitializer implements InitializingBean, BeanFactoryAware {

    private final Logger logger = LogManager.getLogger(GameInitializer.class);

    private static ClientInitializer clientInitializer;
    private static List<Handler> handlers;
    private static ServerProcessor serverProcessor;

    private ServerBootstrap bootstrap;
    private BeanFactory beanFactory;

    private static Config config;
    private static DataStore store;
    private static World world;

    private static boolean testServer = true;
    private static boolean devServer = true;

    @Autowired
    public GameInitializer(List<Handler> handlers, ServerProcessor serverProcessor) {
        GameInitializer.serverProcessor = serverProcessor;

        prepareHandlers(handlers);

        ConfigHandler configHandler = handler(ConfigHandler.class)
                .orElseThrow(() -> new RuntimeException("Failed to find ConfigHandler..."));

        config = configHandler.config();
    }

    @Override
    public void afterPropertiesSet() throws InterruptedException, IOException {
        System.setProperty("io.netty.buffer.bytebuf.checkAccessible", "false");

        DataHandler dataHandler = handler(DataHandler.class)
                .orElseThrow(() -> new RuntimeException("Failed to find DataHandler..."));

        store = dataHandler.dataStore();

        File mapKeysFile = new File(config.getString("server.mapkeys"));

        if(!mapKeysFile.exists()) {
            throw new RuntimeException("Failed to find mapkeys at: " + mapKeysFile.getAbsolutePath() + ".");
        }

        MapDecryptionKeys.load(mapKeysFile);
        loadScripts();

        world = beanFactory.getBean(World.class);
        world.postLoad();

        testServer = !config.hasPath("server.test") || config.getBoolean("server.test");
        devServer = !config.hasPath("server.dev") || config.getBoolean("server.dev");

        EventLoopGroup acceptGroup = new NioEventLoopGroup(config.getInt("net.acceptthreads"));
        EventLoopGroup ioGroup = new NioEventLoopGroup(config.getInt("net.iothreads"));

        clientInitializer = beanFactory.getBean(ClientInitializer.class);

        serverProcessor.initialize();

        bootstrap = new ServerBootstrap();
        bootstrap.group(acceptGroup, ioGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childHandler(clientInitializer);
        bootstrap.childOption(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30_000);
        bootstrap.childOption(ChannelOption.TCP_NODELAY, true);
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.option(ChannelOption.ALLOCATOR, new UnpooledByteBufAllocator(false));
        bootstrap.childOption(ChannelOption.ALLOCATOR, new UnpooledByteBufAllocator(false));

        System.gc();

        logger.info("Binding to {}:{} as realm {}{}",
                config.getString("net.address"), config.getInt("net.port"),
                world.realm().name(), testServer ? " in testing mode... " : ""
        );
        bootstrap.bind(config.getString("net.address"), config.getInt("net.port")).sync().awaitUninterruptibly();
    }

    @Override
    public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public static void prepareHandlers(List<Handler> handlers) {
        GameInitializer.handlers = handlers;
        handlers.forEach(Handler::initialize);
    }

    public void loadScripts() {
        logger.log(Level.INFO, "Loading scripts...");
    }

    public static List<Handler> handlers() {
        return handlers;
    }

    public static  <T extends Handler> Optional<T> handler(Class<? extends T> handlerClass) {
        if(handlers == null) {
            return Optional.empty();
        }

        return (Optional<T>) handlers.stream()
                .filter(handler -> handler.getClass().isAssignableFrom(handlerClass))
                .findFirst();
    }

    public static boolean isTestServer() {
        return testServer;
    }

    public static boolean isDevServer() {
        return devServer;
    }

    public static Config config() {
        return config;
    }

    public static DataStore store() {
        return store;
    }

    public static ClientInitializer clientInitializer() {
        return clientInitializer;
    }

    public static World world() {
        return world;
    }

    public static ServerProcessor serverProcessor() {
        return serverProcessor;
    }
}
