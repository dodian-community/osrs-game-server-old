package io.nozemi.runescape.content.interfaces;

import io.nozemi.runescape.content.ButtonRegisterer;
import io.nozemi.runescape.handlers.impl.Button;
import io.nozemi.runescape.handlers.impl.ButtonHandler;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.util.Varp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class GameFrame extends ButtonRegisterer {

    @Autowired
    public GameFrame(ButtonHandler buttonHandler) {
        super(buttonHandler);
    }

    @Button(parentId = 182, childId = 8)
    public void logout(Player player, int option, int item) {
        player.putattrib(AttributeKey.LOGOUT, true);
    }

    @Button(parentId = 160, childId = 22)
    public void runToggle(Player player, int option, int item) {
        if ((Double) player.attribOr(AttributeKey.RUN_ENERGY, 0.0) >= 1.0) {
            player.varps().varp(Varp.RUNNING_ENABLED, player.varps().varp(Varp.RUNNING_ENABLED) == 1 ? 0 : 1);
        }
    }
}
