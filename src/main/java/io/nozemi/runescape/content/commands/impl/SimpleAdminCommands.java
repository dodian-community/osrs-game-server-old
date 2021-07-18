package io.nozemi.runescape.content.commands.impl;

import io.nozemi.runescape.content.commands.GameCommand;
import io.nozemi.runescape.content.commands.GameCommandsWrapper;
import io.nozemi.runescape.content.teleports.TeleportEffectChainHandler;
import io.nozemi.runescape.fs.NpcDefinition;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.player.Privilege;
import io.nozemi.runescape.model.item.Item;
import io.nozemi.runescape.model.item.ItemAttrib;
import io.nozemi.runescape.util.SpawnDirection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SimpleAdminCommands extends AdminCommandsWrapper {

    private static final Logger logger = LogManager.getLogger(SimpleAdminCommands.class);

    private final TeleportEffectChainHandler teleportEffectChainHandler;
    private final World world;

    @Autowired
    public SimpleAdminCommands(TeleportEffectChainHandler teleportEffectChainHandler, World world) {
        this.teleportEffectChainHandler = teleportEffectChainHandler;
        this.world = world;
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

            int amount = 1;
            if(args.length >= 2) {
                amount = Integer.parseInt(args[1]);
            }

            Item item = new Item(Integer.parseInt(args[0]), amount);
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

        for (String s : new String[]{"coords", "loc", "pos", "mypos"}) {
            put(s, (player, args) -> player.message("Your coordinates are [%d, %d, %d]. Region %d, RelX=%d, RelZ=%d, Chunk-id %d.",
                    player.tile().x, player.tile().z, player.tile().level,
                    player.tile().region(), player.tile().regionX(),
                    player.tile().regionZ(), player.tile().chunk()));
        }

        put("pnpc", (player, args) -> {
            if(args.length < 1) {
                player.message("You need to specify an NPC id to transform into.");
                return;
            }
            int id = Integer.parseInt(args[0]);

            if (id == -1) {
                player.looks().resetRender();
            } else {
                player.looks().render(player.world().definitions().get(NpcDefinition.class, id).renderpairs());
            }

            player.message("Transmogged player into %s.", args[0]);
        });

        put("addnpc", (player, args) -> {
            if(args.length < 1) {
                player.message("You need to provide an NPC id.");
                return;
            }

            Npc npc = new Npc(Integer.parseInt(args[0]), world, player.tile());
            npc.spawnDirection(SpawnDirection.SOUTH);
            npc.walkRadius(2);

            world.registerNpc(npc);
        });

        put("addprop", (player, args) -> {
            if(args.length < 1) {
                player.message("You need to specify an item slot (1-28).");
                return;
            }

            int slot = Integer.parseInt(args[0]);

            player.inventory().get(slot - 1).modifyProperty(ItemAttrib.CHARGES, 2, 4);
        });
    }
}
