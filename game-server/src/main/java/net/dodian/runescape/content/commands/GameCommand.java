package net.dodian.runescape.content.commands;

import net.dodian.runescape.model.entity.Player;

public interface GameCommand {
    void execute(Player player, String[] arguments);
}
