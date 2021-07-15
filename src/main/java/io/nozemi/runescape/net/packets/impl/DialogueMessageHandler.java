package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.handlers.impl.dialogue.InputValueAction;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.Privilege;
import io.nozemi.runescape.net.packets.annotations.MessageListener;
import io.nozemi.runescape.net.packets.models.dialogue.DialogueContinue;
import io.nozemi.runescape.net.packets.models.dialogue.InputInteger;
import io.nozemi.runescape.net.packets.models.dialogue.InputString;
import io.nozemi.runescape.script.TimerKey;
import org.springframework.stereotype.Component;

import java.lang.ref.WeakReference;

@Component
public class DialogueMessageHandler {

    @MessageListener
    public void onInputString(InputString input) {
        if (input.getValue() == null || input.getValue().isEmpty())
            return;

        InputValueAction<String> action = input.getPlayer().getInputStringAction();
        if(action != null) {
            action.execute(input.getValue());
        }
    }

    @MessageListener
    public void onInputInteger(InputInteger input) {
        if (input.getValue() < 0)
            return;

        InputValueAction<Integer> action = input.getPlayer().getInputIntegerAction();
        if(action != null) {
            action.execute(input.getValue());
        }
    }

    @MessageListener
    public void onDialogueContinue(DialogueContinue dialogueContinue) {
        Player player = dialogueContinue.getPlayer();

        if (player.privilege().eligibleTo(Privilege.ADMIN) && player.<Boolean>attribOr(AttributeKey.DEBUG, false))
            player.message("Dialogue [%d:%d], slot: %d", dialogueContinue.getHash() >> 16, dialogueContinue.getHash() & 0xFFFF, dialogueContinue.getSlot());

        if (player.timers().has(TimerKey.DIALOGUE_CONTINUE)) {
            return;
        }

        int id = dialogueContinue.getHash() >> 16;
        int child = dialogueContinue.getHash() & 0xFFFF;

        Object returnval = null;
        if (id == 219 || id == 187 || id == 475) {
            returnval = dialogueContinue.getSlot();
        } else if (id == 270 || id == 309 || id == 304 || id == 303 || id == 305 || id == 154 || id == 306 || id == 582 || id == 94) {
            returnval = child;
        }

        //Stash the make X amount, if possible.
        if (dialogueContinue.getSlot() > 0 && id == 270) player.putattrib(AttributeKey.MAKE_X_AMT, dialogueContinue.getSlot());

        if (id == 27 || id == 310 || id == 499 || id == 507) {
            player.putattrib(AttributeKey.INTERACTION_OPTION, 1);
            // TODO: Look into what to do for this.
            //player.world().server().scriptRepository().triggerButton(player, hash >> 16, hash & 0xFFFF, slot, 1, 0);
        } else {
            // TODO: Look into what to do for this.
            //player.world().server().scriptExecutor().continueFor(player, WaitReason.DIALOGUE, returnval);
            if(returnval != null) {
                player.getDialogueHandler().executeOption((int) returnval);
            } else {
                player.getDialogueHandler().executeOption(1);
            }

        }

        if (id == 217 || id == 231) { // Player and Npc dialogue interfaces
            Entity speakingTo = ((WeakReference<Entity>) player.attribOr(AttributeKey.TARGET, new WeakReference<Entity>(null))).get();
            if (speakingTo != null) {
                player.faceTile(speakingTo.tile());

                // Not walking around and not already facing us.
                if (speakingTo.tile().nextTo(player.tile()) && (int) speakingTo.attribOr(AttributeKey.LAST_FACE_ENTITY_IDX, -1) != player.index() + 32768) {
                    if (speakingTo.isNpc()) {
                        final Npc npc = (Npc) speakingTo;
                        if (npc.id() != 7494 && npc.id() != 7496 && npc.id() != 7497 && npc.id() != 7498 && npc.id() != 7499 && npc.id() != 7501 &&
                                npc.id() != 7502 && npc.id() != 7503 && npc.id() != 7504 && npc.id() != 276 && npc.id() != 3343) {
                            speakingTo.faceTile(player.tile());
                        }
                    } else {
                        speakingTo.faceTile(player.tile());
                    }
                }
            }
        }
    }
}
