package net.dodian.runescape.net.packets;

import io.netty.channel.ChannelHandlerContext;
import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.packets.annotations.MessageListener;
import net.dodian.runescape.net.packets.annotations.Opcodes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;
import org.reflections.scanners.*;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Component
public class PacketProvider implements InitializingBean, BeanFactoryAware {

    private final Logger logger = LogManager.getLogger(PacketProvider.class);

    private final Map<Integer, GamePacket> opcodeInstances = new HashMap<>();
    private final Map<Class<? extends GamePacket>, Map<Object, Method>> messageListeners = new HashMap<>();

    private BeanFactory beanFactory;

    private final Reflections reflections;

    @Autowired
    public PacketProvider() {
        this.reflections = new Reflections(new ConfigurationBuilder()
                        .setUrls(ClasspathHelper.forPackage("net.dodian.runescape"))
                        .addScanners(new MethodAnnotationsScanner())
                        .addScanners(new SubTypesScanner()));
    }

    public void processBuffer(RSBuffer buffer, ChannelHandlerContext ctx, int opcode, int size, Player player) {
        if(opcodeInstances.containsKey(opcode)) {
            GamePacket packet = opcodeInstances.get(opcode).newInstance();
            packet.setSize(size);
            packet.setOpcode(opcode);
            packet.setPlayer(player);
            packet.setCtx(ctx);
            packet.decode(buffer);

            player.pendingPackets().add(packet);
        } else {
            buffer.skip(size);
            logger.warn("Unknown action: {}, probable size: {}.", opcode, size);
        }
    }

    public <T extends GamePacket> void handlePacket(T packet) {
        long start = System.currentTimeMillis();

        GamePacket packetInstance;
        if (opcodeInstances.containsKey(packet.getOpcode())) {
            packetInstance = opcodeInstances.get(packet.getOpcode());
        } else {
            logger.warn("Unknown action: {}, probable size: {}.", packet.getOpcode(), packet.getSize());
            return;
        }

        if (messageListeners.containsKey(packetInstance.getClass())) {
            Map<Object, Method> handlers = messageListeners.get(packetInstance.getClass());
            handlers.forEach((listenerInstance, method) -> {
                try {
                    // We need to check that there are two arguments
                    // We need the first argument to be the packet
                    if(method.getParameterTypes().length == 1
                    && method.getParameterTypes()[0] == packet.getClass()) {
                        // TODO: Find a way to avoid reflection calls like this.
                        method.invoke(listenerInstance, packet);
                    } else {
                        if(method.getParameterTypes().length != 1) {
                            logger.error("Method {}:{} should only have 1 parameter, which should be an object derived from GamePacket.class.", method.getDeclaringClass().getSimpleName(), method.getName());
                        } else {
                            logger.error("Method {}:{} has one parameter of type {}, which isn't derived from GamePacket.class", method.getDeclaringClass().getSimpleName(), method.getName(), method.getParameterTypes()[0].getSimpleName());
                        }
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    logger.error("Failed to invoke: {}:{} for packet: {}.", method.getDeclaringClass().getSimpleName(), method.getName(), packetInstance.getClass().getSimpleName(), e);
                }
            });
        } else {
            logger.warn("There were no handlers for action: {}.", packet.getOpcode());
        }
    }

    @Override
    public void afterPropertiesSet() {
        mapPacketsToOpcodes();
        mapListenersToPackets();
    }

    public void mapListenersToPackets() {
        Set<Method> methods = reflections.getMethodsAnnotatedWith(MessageListener.class);

        logger.info("Found {} message listeners.", methods.size());

        methods.forEach(method -> {
            Class<?> packet = method.getParameterTypes()[0];
            if (GamePacket.class.isAssignableFrom(packet)) {
                Object listenerInstance = beanFactory.getBean(method.getDeclaringClass());

                Map<Object, Method> handlers = new HashMap<>();
                if (messageListeners.containsKey(GamePacket.class)) {
                    handlers = messageListeners.get(GamePacket.class);
                }

                handlers.put(listenerInstance, method);
                messageListeners.put((Class<? extends GamePacket>) method.getParameterTypes()[0], handlers);
            } else {
                logger.warn("{} is not assignable from GamePacket.class", packet.getSimpleName());
            }
        });

        logger.info("Loaded listeners for {} game packets.", messageListeners.size());
    }

    public void mapPacketsToOpcodes() {
        Set<Class<? extends GamePacket>> packets = reflections.getSubTypesOf(GamePacket.class);

        packets.forEach(packetType -> {
            if (packetType.isAnnotationPresent(Opcodes.class)) {
                try {
                    Opcodes opcodes = packetType.getAnnotation(Opcodes.class);
                    GamePacket packet  = packetType.getConstructor().newInstance();
                    Arrays.stream(opcodes.value()).forEach(opcode -> opcodeInstances.put(opcode, packet));
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    logger.error("Failed to create and add instance of packet type: {}.", packetType.getSimpleName());
                }
            } else {
                logger.warn("Packet of type '{}' does not have Opcodes annotation.", packetType.getSimpleName());
            }
        });

        logger.info("Loaded {} opcodes.", opcodeInstances.size());
    }

    @Override
    public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
