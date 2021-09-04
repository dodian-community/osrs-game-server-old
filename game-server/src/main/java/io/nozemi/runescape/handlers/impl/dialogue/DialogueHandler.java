package io.nozemi.runescape.handlers.impl.dialogue;

import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.entity.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DialogueHandler {

    private static final Logger logger = LogManager.getLogger(DialogueHandler.class);

    private Player player;

    private List<String> options;
    private List<DialogueOptionAction> actions;
    private boolean terminate;

    public void initialize(Player player, boolean terminate, String... options) {
        this.terminate = terminate;
        this.player = player;
        this.options = Arrays.stream(options)
                .collect(Collectors.toList());
        this.actions = new ArrayList<>();
    }

    public void initialize(Player player, String... options) {
        this.initialize(player, false, options);
    }

    public void setActions(DialogueOptionAction... actions) {
        this.actions = Arrays.stream(actions).collect(Collectors.toList());
    }

    public void setAction(DialogueOptionAction action) {
        if(this.actions == null) {
            this.actions = new ArrayList<>();
        }
        this.actions.add(action);
    }

    public void executeOption(int option) {
        if(actions.size() >= option && actions.get(option - 1) != null) {
            actions.get(option - 1).execute();
        } else {
            if(player.attribOr(AttributeKey.DEBUG, false)) {
                player.message("That option has no action.");
                logger.info("That option has no action...");
            }
        }

        if(this.terminate) {
            this.close();
            this.terminate();
        }
    }

    public void close() {
        player.interfaces().close(162, 550);
    }

    public void terminate() {
        this.close();
        this.player.setDialogueHandler(null);
    }
}
