package io.nozemi.runescape.content.commands.impl;

import io.nozemi.runescape.content.commands.CommandInfo;
import io.nozemi.runescape.content.commands.GameCommand;
import io.nozemi.runescape.content.teleports.TeleportEffectChainHandler;
import io.nozemi.runescape.model.entity.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@CommandInfo(name = "rt", description = "Reloading teleport effect chains")
public class ReloadTeleportsCommand implements GameCommand {

    private static final Logger logger = LogManager.getLogger(ReloadTeleportsCommand.class);

    private final TeleportEffectChainHandler teleportEffectChainHandler;

    @Autowired
    public ReloadTeleportsCommand(TeleportEffectChainHandler teleportEffectChainHandler) {
        this.teleportEffectChainHandler = teleportEffectChainHandler;
    }

    @Override
    public void execute(Player player, String[] arguments) {
        try {
            teleportEffectChainHandler.loadTeleports();
            logger.info("Loaded new teleport effect chains...");
        } catch (IOException e) {
            logger.info("Failed to load teleport effect chains...", e);
        }
    }
}
