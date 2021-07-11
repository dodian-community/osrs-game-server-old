package io.nozemi.runescape.content.magic;

import io.nozemi.runescape.content.ButtonRegisterer;
import io.nozemi.runescape.content.teleports.MyTeleports;
import io.nozemi.runescape.content.teleports.TeleportEffectChainHandler;
import io.nozemi.runescape.handlers.impl.Button;
import io.nozemi.runescape.handlers.impl.ButtonHandler;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class NormalTeleports extends ButtonRegisterer {

    @Autowired
    public NormalTeleports(ButtonHandler buttonHandler) {
        super(buttonHandler);
    }

    @Button(parentId = 218, childId = 1)
    public void homeTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("LUMBRIDGE_HOME");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get());
        } else {
            player.teleport(new Tile(2606, 3102));
        }
    }
}
