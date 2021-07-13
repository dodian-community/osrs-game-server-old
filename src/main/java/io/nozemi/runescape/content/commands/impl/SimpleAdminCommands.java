package io.nozemi.runescape.content.commands.impl;

import io.nozemi.runescape.content.commands.GameCommand;
import io.nozemi.runescape.content.commands.GameCommandsWrapper;
import io.nozemi.runescape.content.teleports.TeleportEffectChainHandler;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.player.Privilege;
import io.nozemi.runescape.model.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SimpleAdminCommands extends GameCommandsWrapper {

    private static final Logger logger = LogManager.getLogger(SimpleAdminCommands.class);

    private final TeleportEffectChainHandler teleportEffectChainHandler;

    @Autowired
    public SimpleAdminCommands(TeleportEffectChainHandler teleportEffectChainHandler) {
        this.teleportEffectChainHandler = teleportEffectChainHandler;
    }

    @Override
    public void afterPropertiesSet() {
        put("rt", (player, args) -> {
            try {
                teleportEffectChainHandler.loadTeleports();
                player.message("Successfully reloaded the teleport effects chains.");
                logger.info("Loaded new teleport effect chains...");
            } catch (IOException e) {
                logger.info("Failed to load teleport effect chains...", e);
                player.message("Something went wrong while reloading the effects chains...");
                player.message("<col=FF0000>" + e.getMessage());
            }
        }, "Reload teleport effects chain.");

        put("item", (player, args) -> {
            if (args.length < 1) {
                player.message("<col=b55907>You need to provide an item id for the desired item.");
                player.message("<col=b55907>::item [item_id] [(amount)]");
                return;
            }

            Item item = new Item(Integer.parseInt(args[0]), 1);
            player.inventory().add(item, true);
            player.message("<col=28b507>Spawned the item successfully!");
        }, "Spawn an item of desired amount (default 1)");

        put("debug", (player, args) -> {
            boolean debug = player.attribOr(AttributeKey.DEBUG, false);
            player.putattrib(AttributeKey.DEBUG, !debug);
            player.message("Debug is now " + (!debug ? "<col=28b507>enabled" : "<col=b55907>disabled"));
        });

        put("movex", (player, args) -> {
            int tiles = 1;
            if (args.length >= 1) {
                tiles = Integer.parseInt(args[0]);
            }

            player.teleport(new Tile(player.tile().x + tiles, player.tile().z, player.tile().level));
        });

        put("movey", (player, args) -> {
            int tiles = 1;
            if (args.length >= 1) {
                tiles = Integer.parseInt(args[0]);
            }

            player.teleport(new Tile(player.tile().x, player.tile().z + tiles, player.tile().level));
        });

        put("movez", (player, args) -> {
            int tiles = 1;
            if (args.length >= 1) {
                tiles = Integer.parseInt(args[0]);
            }

            player.teleport(new Tile(player.tile().x, player.tile().z, player.tile().level + tiles));
        });
    }

    public void put(String name, GameCommand command, String description) {
        put(Privilege.ADMIN, name, command, description);
    }

    public void put(String name, GameCommand command) {
        put(Privilege.ADMIN, name, command, null);
    }
}