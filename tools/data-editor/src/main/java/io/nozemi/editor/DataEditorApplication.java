package io.nozemi.editor;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataEditorApplication {

    public static void main(String[] args) {
        Application.launch(WrapperApplication.class, args);
    }
}
