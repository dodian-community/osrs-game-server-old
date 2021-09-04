package io.nozemi.mapeditor;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapEditorApplication {

    public static void main(String[] args) {
        Application.launch(WrapperApplication.class, args);
    }
}
