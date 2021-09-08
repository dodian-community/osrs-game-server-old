package net.dodian.runescape.content.interfaces;

import net.dodian.runescape.content.ButtonRegisterer;
import net.dodian.runescape.handlers.impl.Button;
import net.dodian.runescape.handlers.impl.ButtonHandler;
import net.dodian.runescape.model.AttributeKey;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.util.Varp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SettingsPanel extends ButtonRegisterer {

    @Autowired
    public SettingsPanel(ButtonHandler buttonHandler) {
        super(buttonHandler);
    }

    @Button(parentId = 261, childId = 77)
    public void runToggle(Player player, int option, int item) {
        if ((Double) player.attribOr(AttributeKey.RUN_ENERGY, 0.0) >= 1.0) {
            player.varps().varp(Varp.RUNNING_ENABLED, player.varps().varp(Varp.RUNNING_ENABLED) == 1 ? 0 : 1);
        }
    }
}
