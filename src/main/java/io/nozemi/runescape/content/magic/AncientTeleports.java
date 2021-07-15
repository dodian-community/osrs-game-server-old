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
public class AncientTeleports extends ButtonRegisterer {

    @Autowired
    public AncientTeleports(ButtonHandler buttonHandler) {
        super(buttonHandler);
    }

    @Button(parentId = 218, childId = 97)
    public void ancientEdgevilleHomeTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("HOME");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get());
        } else {
            player.teleport(new Tile(2606, 3102));
        }
        player.message("You have succefull been teleported to Yanille.");
    }
    @Button(parentId = 218, childId = 88)
    public void ancientPaddewwaTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ANCIENT");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2722, 3484), teleport.get()); //Seers
        } else {
            player.teleport(new Tile(2722, 3484));
        }
        player.message("You have succefull been teleported to Seers Village.");
    }
    @Button(parentId = 218, childId = 89)
    public void ancientSenntistenTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ANCIENT");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2803, 3434), teleport.get()); //Catherby
        } else {
            player.teleport(new Tile(2803, 3434));
        }
        player.message("You have succefull been teleported to Catherby");
    }
    @Button(parentId = 218, childId = 90)
    public void ancientKharyllTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ANCIENT");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2892, 3455), teleport.get()); //Taverley
        } else {
            player.teleport(new Tile(2892, 3455));
        }
        player.message("You have succefull been teleported to Taverley.");
    }
    @Button(parentId = 218, childId = 91)
    public void ancientLassarTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ANCIENT");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2728, 3347), teleport.get()); //Legends Guild
        } else {
            player.teleport(new Tile(2728, 3347));
        }
        player.message("You have succefull been teleported to the Legends Guild.");
    }

    @Button(parentId = 218, childId = 92)
    public void ancientDareeyakTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ANCIENT");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2662, 3306), teleport.get()); //East Ardougne
        } else {
            player.teleport(new Tile(2662, 3306));
        }
        player.message("You have succefull been teleported to East Ardounge.");
    }
    @Button(parentId = 218, childId = 93)
    public void ancientCarrallangarTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ANCIENT");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2603, 3400), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2603, 3400));
        }
        player.message("You have succefull been teleported to the Fishing Guild.");
    }
    @Button(parentId = 218, childId = 94)
    public void ancientAnnakarlTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ANCIENT");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2465, 3434), teleport.get()); //Gnome Course
        } else {
            player.teleport(new Tile(2465, 3434));
        }
        player.message("You have succefull been teleported to the Gnome Course.");
    }
    @Button(parentId = 218, childId = 95)
    public void ancientGhorrockTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ANCIENT");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
}
