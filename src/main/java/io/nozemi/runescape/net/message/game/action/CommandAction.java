package io.nozemi.runescape.net.message.game.action;

import io.netty.channel.ChannelHandlerContext;
import io.nozemi.runescape.content.commands.CommandHandler;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.PacketInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

@PacketInfo(size = -1)
public class CommandAction implements Action {

    private static final Logger logger = LogManager.getLogger(CommandAction.class);

    private String command;

    @Override
    public void decode(RSBuffer buf, ChannelHandlerContext ctx, int opcode, int size, Player player) {
        command = buf.readString();
    }

    @Override
    public void process(Player player) {
        String[] parts = command.split(" ");
        String commandName = parts[0];
        String[] arguments = Arrays.copyOfRange(parts, 1, parts.length);

        CommandHandler.triggerCommand(player, commandName, arguments);
    }
}
