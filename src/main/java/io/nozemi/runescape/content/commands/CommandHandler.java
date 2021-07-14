package io.nozemi.runescape.content.commands;

import io.nozemi.runescape.handlers.Handler;
import io.nozemi.runescape.model.entity.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandHandler implements Handler {

    private final Logger logger = LogManager.getLogger(CommandHandler.class);

    private final List<GameCommand> gameCommands;

    private static final Map<String, GameCommand> commands = new HashMap<>();

    @Autowired
    public CommandHandler(List<GameCommand> gameCommands) {
        this.gameCommands = gameCommands;
    }

    @Override
    public void initialize() {
        gameCommands.forEach(gameCommand -> {
            if(gameCommand.getClass().isAnnotationPresent(CommandInfo.class)) {
                CommandInfo commandInfo = gameCommand.getClass().getAnnotation(CommandInfo.class);
                commands.put(commandInfo.name(), gameCommand);
                logger.info("Loaded command: {}", gameCommand.getClass().getSimpleName());
            } else {
                logger.info("Failed to load command: {}", gameCommand.getClass().getSimpleName());
            }
        });
    }

    public static void registerCommand(String name, GameCommand command) {
        commands.put(name, command);
    }

    public void triggerCommand(Player player, String command, String[] arguments) {
        if(commands.containsKey(command)) {
            commands.get(command).execute(player, arguments);
        } else {
            player.message("<col=FF0000>This command does not exist.");
        }
    }
}
