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
    @Button(parentId = 218, childId = 16)
    public void varrockTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("VARROCK");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2722, 3484), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2722, 3484));
        }
    }
    @Button(parentId = 218, childId = 19)
    public void LumbridgeTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("LUMBRIDGE");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2803, 3434), teleport.get()); //Catherby
        } else {
            player.teleport(new Tile(2803, 3434));
        }
    }
    @Button(parentId = 218, childId = 22)
    public void FaladorTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("FALADOR");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2892, 3455), teleport.get()); //Taverley
        } else {
            player.teleport(new Tile(2892, 3455));
        }
    }
    @Button(parentId = 218, childId = 27)
    public void CamelotTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("CAMELOT");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2465, 3434), teleport.get()); //Gnome Course
        } else {
            player.teleport(new Tile(2465, 3434));
        }
    }
    @Button(parentId = 218, childId = 33)
    public void ArdougneTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ARDOUGNE");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2662, 3306), teleport.get()); //East Ardougne
        } else {
            player.teleport(new Tile(2662, 3306));
        }
    }
    @Button(parentId = 218, childId = 38)
    public void WatchtowerTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("WATCHTOWER");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2553, 3114), teleport.get()); //Watchtower
        } else {
            player.teleport(new Tile(2553, 3114));
        }
    }
    @Button(parentId = 218, childId = 45)
    public void TrollheimTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("TROLLHEIM");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2890, 3677), teleport.get()); //Trollheim
        } else {
            player.teleport(new Tile(2890, 3677));
        }
    }
    @Button(parentId = 218, childId = 48)
    public void ApetollTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("APETOLL");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2737, 2785), teleport.get()); //Apetoll Marim
        } else {
            player.teleport(new Tile(2737, 2785));
        }
    }
    @Button(parentId = 218, childId = 53)
    public void KourendTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("KOUREND");

        if(teleport.isPresent()) {
            player.teleport(new Tile(1644, 3673), teleport.get()); //Kourend Castle
        } else {
            player.teleport(new Tile(1644, 3673));
        }
    }
}
