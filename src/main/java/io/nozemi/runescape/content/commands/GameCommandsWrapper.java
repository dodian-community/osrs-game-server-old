package io.nozemi.runescape.content.commands;

import io.nozemi.runescape.model.entity.player.Privilege;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public abstract class GameCommandsWrapper implements InitializingBean {

    public void put(Privilege privilege, String name, GameCommand command) {
        put(privilege, name, command, null);
    }
    public void put(Privilege privilege, String name, GameCommand command, String description) {
        CommandHandler.registerCommand(name, command);
    }
}
