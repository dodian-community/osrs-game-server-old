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
public class LunarTeleports extends ButtonRegisterer {

    @Autowired
    public LunarTeleports(ButtonHandler buttonHandler) {
        super(buttonHandler);
    }

    @Button(parentId = 218, childId = 99 )
    public void lunarHomeTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("HOME");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }
        player.message("You have succefull been teleported to Yanille.");
    }
    @Button(parentId = 218, childId = 106)
    public void lunarMoonclanTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("LUNAR");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 153)
    public void lunarOuraniaTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("LUNAR");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 110)
    public void lunarWaterbirthTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("LUNAR");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 114)
    public void lunarBarbianTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("LUNAR");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 118)
    public void lunarKhazardTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("LUNAR");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 126)
    public void lunarFishingGuildTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("LUNAR");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 130)
    public void AlunarCatherbyTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("LUNAR");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 133)
    public void lunarIcePlateauTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("LUNAR");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }

}
