package io.nozemi.runescape.service.login;

import io.netty.channel.ChannelHandlerContext;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.instance.InstancedMap;
import io.nozemi.runescape.model.uid.UIDProvider;
import io.nozemi.runescape.net.ServerHandler;
import io.nozemi.runescape.net.message.LoginRequestMessage;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.command.DisplayMap;
import io.nozemi.runescape.net.message.game.command.SetRealm;
import io.nozemi.runescape.service.Service;
import io.nozemi.runescape.service.serializers.JSONFileSerializer;
import io.nozemi.runescape.service.serializers.PlayerSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class LoginService implements Service, BeanFactoryAware {

    private static final Logger logger = LogManager.getLogger(LoginService.class);

    private BeanFactory beanFactory;

    private LinkedBlockingQueue<LoginRequestMessage> messages = new LinkedBlockingQueue<>();

    private Executor executor;

    private PlayerSerializer serializer;
    private UIDProvider uidProvider;

    @Autowired
    public LoginService() {
    }

    @Override
    public void setup() {
        this.serializer = new JSONFileSerializer();
        logger.info("Using {} to serialize and deserialize player data.", serializer.getClass().getSimpleName());
    }

    @Override
    public boolean start() {
        executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 3; i++) {
            LoginWorker loginWorker = beanFactory.getBean(LoginWorker.class);
            loginWorker.loginService(this);
            executor.execute(loginWorker);
        }

        return true;
    }

    @Override
    public boolean stop() {
        return false;
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    public void enqueue(LoginRequestMessage message) {
        messages.add(message);
    }

    public void complete(Player player, LoginRequestMessage message) {
        player.interfaces().resizable(message.resizableInterfaces());
        player.teleport(player.tile());

        player.channel().attr(ServerHandler.ATTRIB_PLAYER).set(player);

        Optional<InstancedMap> activeMap = player.world().allocator().active(player.tile());
        if (activeMap.isPresent()) {
            // This is bad. Log it?
            player.write(new DisplayMap(player, true)); // This has to be the first packet!
            //player.write(new DisplayInstancedMap(activeMap.get(), player, player.tile(), true, true)); // This has to be the first packet!
        } else {
            player.write(new DisplayMap(player, true)); // This has to be the first packet!
        }

        player.write(new SetRealm(player.world().realm().id()));

        player.world().syncMap(player, null, false);
        player.channel().flush();

        player.pendingActions().add(new Action() {

            @Override
            public void decode(RSBuffer buf, ChannelHandlerContext ctx, int opcode, int size, Player player) { }

            @Override
            public void process(Player player) {
                player.interfaces().setupGamePane(false);
                player.initiate();
            }
        });
    }

    public LinkedBlockingQueue<LoginRequestMessage> messages() {
        return messages;
    }

    public PlayerSerializer serializer() {
        return serializer;
    }

    @Override
    public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
