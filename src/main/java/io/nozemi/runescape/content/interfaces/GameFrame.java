package io.nozemi.runescape.content.interfaces;

import io.nozemi.runescape.content.ButtonRegisterer;
import io.nozemi.runescape.handlers.impl.Button;
import io.nozemi.runescape.handlers.impl.ButtonHandler;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.PathQueue;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.tasksystem.InterruptibleTask;
import io.nozemi.runescape.tasksystem.TaskManager;
import io.nozemi.runescape.util.AttackMode;
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

    @Button(parentId = 593, childId = 3)
    public void onFlick(Player player, int option, int item) {
        player.varps().varp(43, 0);
    }

    @Button(parentId = 593, childId = 7)
    public void onLash(Player player, int option, int item) {
        player.varps().varp(43, 1);
    }

    @Button(parentId = 593, childId = 15)
    public void onDeflect(Player player, int option, int item) {
        player.varps().varp(43, 3);
    }

    public void test(Player player, int option, int item) {
        Tile destination = new Tile(2606, 3102);

        InterruptibleTask.bound(player).isCancellableByWalking(false).execute(() -> {
            player.walkTo(destination, PathQueue.StepType.REGULAR, false);
            player.message("You're currently " + player.tile().distance(destination) + " tiles away!");
        }).onComplete(() -> player.message("You arrived!"))
            .onCancel(() -> player.stopActions(true))
            .completeCondition(() -> player.tile().distance(destination) <= 1)
            .submit(TaskManager.playerChains());
    }
}
