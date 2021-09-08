package net.dodian.runescape.content.mechanics;

import net.dodian.runescape.model.AttributeKey;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.map.MapObj;
import org.springframework.stereotype.Component;

@Component
public class ObjectInteraction {

    public static void handle(Player player) {
        MapObj obj = player.attrib(AttributeKey.INTERACTION_OBJECT);
        int option = player.attrib(AttributeKey.INTERACTION_OPTION);

        player.walkToThen(obj, obj.tile(), () -> {
            player.message("Arrived!");
            player.stopActions(true);
            player.faceObj(obj);
        });

        /*InterruptibleTask.bound(player).isCancellableByWalking(false).execute(() -> {
            player.message("Distance: " + player.tile().distance(obj.tile()));
            player.walkTo(obj.tile(), PathQueue.StepType.REGULAR, false);
        }).onComplete(() -> {
            player.message("Arrived! Wohoo!");
            player.message("Distance: " + player.tile().distance(obj.tile()));
            player.message("Object Size: " + obj.definition(player.world()).sizeX + "x" + obj.definition(player.world()).sizeY);
            player.faceObj(obj);
        }).onCancel(() -> player.stopActions(true))
            .completeCondition(() -> player.tile().distance(obj.tile()) <= 1)
            .submit(TaskManager.playerChains());*/
    }
}
