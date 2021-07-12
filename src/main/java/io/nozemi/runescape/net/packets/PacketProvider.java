package io.nozemi.runescape.net.packets;

import io.netty.channel.ChannelHandlerContext;
import io.nozemi.runescape.GameInitializer;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.packets.handlers.PacketHandler;
import io.nozemi.runescape.net.packets.handlers.PacketListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PacketProvider {

    private static final Logger logger = LogManager.getLogger(PacketProvider.class);

    private final List<GamePacket> packets;
    private final List<PacketListener> listeners;

    @Autowired
    public PacketProvider(List<GamePacket> packets, List<PacketListener> listeners) {
        this.packets = packets;
        this.listeners = listeners;
    }

    public boolean hasPacket(int opcode) {
        return packets.stream().anyMatch(gamePacket -> gamePacketHasOpcode(gamePacket, opcode));
    }

    public Optional<GamePacket> getPacket(RSBuffer buffer, int opcode, Player player) {
        Optional<? extends GamePacket> optionalGamePacket = packets.stream()
                .filter(gamePacket -> gamePacketHasOpcode(gamePacket, opcode))
                .findFirst();

        if (optionalGamePacket.isEmpty()) {
            logger.warn("Unknown action: {}, probable size: {}.", opcode, buffer.get().readableBytes());
            return Optional.empty();
        }

        GamePacket gamePacket = optionalGamePacket.get().createFrom(buffer);
        gamePacket.setOpcode(opcode);

        return Optional.of(gamePacket);
    }

    public void handlePacket(GamePacket gamePacket, Player player) {
        listeners.forEach(listener -> {
            List<Method> methods = Arrays.stream(listener.getClass().getMethods())
                    .filter(method -> method.isAnnotationPresent(PacketHandler.class))
                    .filter(method -> method.getParameterTypes()[0].equals(gamePacket.getClass()))
                    .collect(Collectors.toList());

            methods.forEach(method -> {
                try {
                    if (!gamePacket.isCancelled()) {
                        method.invoke(listener, gamePacket, player);
                    } else {
                        logger.info("{}: packet execution was cancelled by a previous listener.", listener.getClass().getSimpleName());
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        });

        gamePacket.setCancelled(false);
    }

    private boolean gamePacketHasOpcode(GamePacket gamePacket, int opcode) {
        if (gamePacket.getClass().isAnnotationPresent(Opcodes.class)) {
            return Arrays.stream(gamePacket.getClass().getAnnotation(Opcodes.class).value())
                    .anyMatch(code -> code == opcode);
        }

        return false;
    }
}
