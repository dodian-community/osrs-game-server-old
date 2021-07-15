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
public class ArceuusTeleports extends ButtonRegisterer {

    @Autowired
    public ArceuusTeleports(ButtonHandler buttonHandler) {
        super(buttonHandler);
    }

    @Button(parentId = 218, childId = 145)
    public void arceuusHomeTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("HOME");

        if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }
        player.message("You have succefull been teleported to Yanille.");
    }
    @Button(parentId = 218, childId = 147)
    public void arcueesLumbridgeGraveyardTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ARCEUUS");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 151)
    public void arcueesDraynorManorTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ARCEUUS");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 156)
    public void arcueesMindAltarTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ARCUEES");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 158)
    public void arcueesRespawnTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ARCEUUS");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 160)
    public void arcueesSlaveGraveyardTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ARCEUUS");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 164)
    public void arcueesFrenkenstrainCastleTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ARCEUUS");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 167)
    public void arcueesWestArdoungeTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ARCEUUS");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 170)
    public void arcueesHarmonyIslandTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ARCEUUS");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 172)
    public void arcueesCemeteryTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ARCEUUS");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 176)
    public void arcueesBarrowsTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ARCEUUS");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
    @Button(parentId = 218, childId = 178)
    public void arceuusApeAtollTeleport(Player player, int option, int item) {
        Optional<MyTeleports> teleport = TeleportEffectChainHandler.getTeleport("ARCEUUS");

        /*if(teleport.isPresent()) {
            player.teleport(new Tile(2606, 3102), teleport.get()); //Yanille
        } else {
            player.teleport(new Tile(2606, 3102));
        }*/
        player.message("<col=ff1900>This teleport is currently disabled!");
    }
}
