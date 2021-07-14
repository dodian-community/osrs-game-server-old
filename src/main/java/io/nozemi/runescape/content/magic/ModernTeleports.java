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
public class ModernTeleports extends ButtonRegisterer {

    @Autowired
    public ModernTeleports(ButtonHandler buttonHandler) {
        super(buttonHandler);
    }

    @Button(parentId = 218, childId = 1)
    public void homeTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("HOME");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get());
        } else {
            player.teleport(new Tile(2606, 3102));
        }
        player.message("You have succefull been teleported to Yanille.");
    }
    @Button(parentId = 218, childId = 16)
    public void modernVarrockTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("MODERN");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 19)
    public void modernLumbridgeTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("MODERN");

       /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 22)
    public void modernFaladorTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("MODERN");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 27)
    public void modernCamelotTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("MODERN");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 33)
    public void modernArdougneTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("MODERN");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 38)
    public void modernWatchtowerTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("MODERN");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 45)
    public void modernTrollheimTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("MODERN");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 48)
    public void modernApeAtollTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("MODERN");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 53)
    public void modernKourendTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("MODERN");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
}
