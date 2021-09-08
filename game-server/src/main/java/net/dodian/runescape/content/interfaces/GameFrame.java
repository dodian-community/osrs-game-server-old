package net.dodian.runescape.content.interfaces;

import net.dodian.runescape.content.ButtonRegisterer;
import net.dodian.runescape.handlers.impl.Button;
import net.dodian.runescape.handlers.impl.ButtonHandler;
import net.dodian.runescape.model.AttributeKey;
import net.dodian.runescape.model.Tile;
import net.dodian.runescape.model.entity.PathQueue;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.tasksystem.InterruptibleTask;
import net.dodian.runescape.tasksystem.TaskManager;
import net.dodian.runescape.util.Varp;
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
            .submit(TaskManager.playerEvents());
    }
}
