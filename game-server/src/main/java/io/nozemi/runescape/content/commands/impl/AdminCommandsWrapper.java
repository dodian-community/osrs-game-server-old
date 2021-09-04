package io.nozemi.runescape.content.commands.impl;

import io.nozemi.runescape.content.commands.GameCommand;
import io.nozemi.runescape.content.commands.GameCommandsWrapper;
import io.nozemi.runescape.model.entity.player.Privilege;

public abstract class AdminCommandsWrapper extends GameCommandsWrapper {

    public void put(String name, GameCommand command, String description) {
        put(Privilege.ADMIN, name, command, description);
    }

    public void put(String name, GameCommand command) {
        put(Privilege.ADMIN, name, command, null);
    }
}
