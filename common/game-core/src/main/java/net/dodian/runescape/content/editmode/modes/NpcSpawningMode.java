package net.dodian.runescape.content.editmode.modes;

import net.dodian.models.SpawnDirection;
import net.dodian.runescape.model.entity.Player;

public class NpcSpawningMode extends NpcMode {

    public static void showNpcSpawningModeConfigurator(Player player) {
        player.getEditModeHandler().setEditorModeInstance(new NpcSpawningMode());
        NpcSpawningMode editor = (NpcSpawningMode) player.getEditModeHandler().getEditorModeInstance();

        player.inputInteger("Provide an NPC ID", npcId -> {
            editor.npcId = npcId;
            player.inputInteger("What walk radius do you want?", walkRadius -> {
                editor.walkRadius = walkRadius;
                player.inputString("What facing direction do you want?", spawnDirection -> {
                    editor.spawnDirection = SpawnDirection.valueOf(spawnDirection.toUpperCase());
                    player.message("You've configured npc id '%s', with walk radius of %s tiles, and direction of %s", editor.npcId, editor.walkRadius, editor.spawnDirection.toString());
                });
            });
        });
    }
}
