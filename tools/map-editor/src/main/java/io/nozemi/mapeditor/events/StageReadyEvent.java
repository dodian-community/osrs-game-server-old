package io.nozemi.mapeditor.events;

import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;

public class StageReadyEvent extends ApplicationEvent {

    public StageReadyEvent(Object source) {
        super(source);
    }

    public Stage getWindow() {
        return ((Stage) getSource());
    }
}
