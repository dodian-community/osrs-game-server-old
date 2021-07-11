package io.nozemi.runescape.content.commands;

import io.nozemi.runescape.model.entity.Player;

public interface GameCommand {
    void execute(Player player, String[] arguments);
}
