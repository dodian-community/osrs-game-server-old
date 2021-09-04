package io.nozemi.runescape.content.tools.editmode;

import io.nozemi.runescape.content.tools.editmode.modes.EditorMode;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EditModeHandler {

    private Mode mode;
    private EditorMode editorModeInstance;

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Mode getMode() {
        return mode;
    }

    public void setEditorModeInstance(EditorMode editorModeInstance) {
        this.editorModeInstance = editorModeInstance;
    }

    public EditorMode getEditorModeInstance() {
        return editorModeInstance;
    }

    public enum Mode {
        SPAWNING_NPC,
        SPAWNING_OBJECT,
        SPAWNING_GROUND_ITEM,
        REMOVING_NPC,
        REMOVING_OBJECT,
        REMOVING_GROUND_ITEM,
        MODIFYING_NPC,
        MODIFYING_OBJECT,
        MODIFYING_GROUND_ITEM
    }
}
