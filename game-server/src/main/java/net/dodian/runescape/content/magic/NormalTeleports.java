package net.dodian.runescape.content.magic;

import net.dodian.runescape.content.ButtonRegisterer;
import net.dodian.runescape.content.teleports.MyTeleports;
import net.dodian.runescape.content.teleports.TeleportEffectChainHandler;
import net.dodian.runescape.handlers.impl.Button;
import net.dodian.runescape.handlers.impl.ButtonHandler;
import net.dodian.runescape.model.Tile;
import net.dodian.runescape.model.entity.Player;
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
