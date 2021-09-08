package net.dodian.runescape.content.commands.impl;

import net.dodian.runescape.content.editmode.modes.NpcSpawningMode;
import net.dodian.runescape.model.AttributeKey;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.content.editmode.EditModeHandler;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class EditModeCommands extends AdminCommandsWrapper implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void afterPropertiesSet() {
        put("edit", (player, args) -> {
            boolean editMode = player.attribOr(AttributeKey.EDIT_MODE, false);

            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("reconfigure")) {
                    this.reconfigureEditorMode(player);
                } else {
                    player.message("Argument %s is not valid.", args[0]);
                }
                return;
            }

            if(!editMode) {
                showWelcomeDialogue(player);
            } else {
                player.message("Editor mode is disabled.");
                player.putattrib(AttributeKey.EDIT_MODE, false);
                player.setEditModeHandler(null);
            }
        });

        for (String s : new String[]{"editreset", "resetedit", "editr"}) {
            put(s, (player, args) -> {
                player.setEditModeHandler(beanFactory.getBean(EditModeHandler.class));
                player.message("Successfully reset your edit mode.");
            });
        }
    }

    private void reconfigureEditorMode(Player player) {
        boolean editMode = player.attribOr(AttributeKey.EDIT_MODE, false);
        if (editMode) {
            if(player.getEditModeHandler().getMode().equals(EditModeHandler.Mode.SPAWNING_NPC)) {
                NpcSpawningMode.showNpcSpawningModeConfigurator(player);
            }
        } else {
            player.message("Edit mode is not enabled. Please enable it by typing ::edit.");
        }
    }

    private void showWelcomeDialogue(Player player) {
        player.chatPlayer("You're about to enable editor mode. This allows you to manage things in the world.", 588)
                .setActions(() -> showModeSelectDialogue(player));
    }

    private void showModeSelectDialogue(Player player) {
        player.optionsTitled("Select Editor Mode", "NPC Modes", "Player Modes", "Object Modes", "Ground Item Modes")
                .setActions(
                        () -> showNpcModesSelectDialogue(player),
                        () -> {
                            player.message("Not implemented yet.");
                            player.getDialogueHandler().close();
                            player.getDialogueHandler().terminate();
                        },
                        () -> {
                            player.message("Not implemented yet.");
                            player.getDialogueHandler().close();
                            player.getDialogueHandler().terminate();
                        },
                        () -> {
                            player.message("Not implemented yet.");
                            player.getDialogueHandler().close();
                            player.getDialogueHandler().terminate();
                        }
                );
    }

    private void showNpcModesSelectDialogue(Player player) {
        player.optionsTitled( "Select NPC Mode", "NPC Spawning", "NPC Editing", "NPC Removing")
                .setActions(
                        () -> {
                            enableEditMode(player);
                            player.getEditModeHandler().setMode(EditModeHandler.Mode.SPAWNING_NPC);
                            player.message("You're now using NPC Spawning tool.");
                            player.getDialogueHandler().terminate();

                            if(player.getEditModeHandler().getEditorModeInstance() != null) {
                                player.optionsTitled("Do you want to reconfigure NPC spawn editor?", "Yes", "No")
                                        .setActions(
                                                () -> player.getDialogueHandler().terminate(),
                                                () -> player.getDialogueHandler().terminate()
                                        );
                            } else {
                                NpcSpawningMode.showNpcSpawningModeConfigurator(player);
                            }
                        },
                        () -> {
                            enableEditMode(player);
                            player.getEditModeHandler().setMode(EditModeHandler.Mode.MODIFYING_NPC);
                            player.message("You're now using NPC Editing tool.");
                            player.getDialogueHandler().terminate();
                        },
                        () -> {
                            enableEditMode(player);
                            player.getEditModeHandler().setMode(EditModeHandler.Mode.REMOVING_NPC);
                            player.message("You're now using NPC Removing tool.");
                            player.getDialogueHandler().terminate();
                        }
                );
    }

    private void enableEditMode(Player player) {
        boolean editMode = player.attribOr(AttributeKey.EDIT_MODE, false);
        player.putattrib(AttributeKey.EDIT_MODE, !editMode);
        player.setEditModeHandler(beanFactory.getBean(EditModeHandler.class));
    }

    @Override
    public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
