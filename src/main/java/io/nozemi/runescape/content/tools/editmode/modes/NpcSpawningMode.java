package io.nozemi.runescape.content.tools.editmode.modes;

import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.util.SpawnDirection;

public class NpcSpawningMode extends NpcMode {

    private static Npc npc;

    public static void showNpcSpawningModeConfigurator(Player player) {
        player.getEditModeHandler().setEditorModeInstance(new NpcSpawningMode());
        NpcSpawningMode editor = (NpcSpawningMode) player.getEditModeHandler().getEditorModeInstance();

        npc = new Npc(395, player.world(), new Tile(player.tile().x + 1, player.tile().z, player.tile().level));
        player.world().registerNpc(npc);

        player.inputInteger("Provide an NPC ID", npcId -> {
            editor.npcId = npcId;
            player.world().unregisterNpc(npc);
            npc = new Npc(npc.id(), npc.world(), npc.tile());
            player.world().registerNpc(npc);
            player.inputInteger("What walk radius do you want?", walkRadius -> {
                editor.walkRadius = walkRadius;
                player.inputString("What facing direction do you want?", spawnDirection -> {
                    editor.spawnDirection = SpawnDirection.valueOf(spawnDirection.toUpperCase());
                    player.world().unregisterNpc(npc);
                    npc = new Npc(npc.id(), npc.world(), npc.tile());
                    npc.spawnDirection(editor.spawnDirection);
                    player.world().registerNpc(npc);
                    player.message("You've configured npc id '%s', with walk radius of %s tiles, and direction of %s", editor.npcId, editor.walkRadius, editor.spawnDirection.toString());
                });
            });
        });
    }
}
