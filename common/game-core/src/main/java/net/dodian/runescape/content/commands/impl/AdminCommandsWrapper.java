package net.dodian.runescape.content.commands.impl;

import net.dodian.runescape.content.commands.GameCommand;
import net.dodian.runescape.content.commands.GameCommandsWrapper;
import net.dodian.runescape.model.entity.player.Privilege;

public abstract class AdminCommandsWrapper extends GameCommandsWrapper {

    public void put(String name, GameCommand command, String description) {
        put(Privilege.ADMIN, name, command, description);
    }

    public void put(String name, GameCommand command) {
        put(Privilege.ADMIN, name, command, null);
    }
}
