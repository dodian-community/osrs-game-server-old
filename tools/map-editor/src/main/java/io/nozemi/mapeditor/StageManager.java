package io.nozemi.mapeditor;

import io.nozemi.mapeditor.events.StageReadyEvent;
import io.nozemi.mapeditor.resources.EditorResourceLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.IOException;

@Component
public class StageManager implements ApplicationListener<StageReadyEvent> {

    private String applicationTitle;
    private final ApplicationContext applicationContext;
    private final ResourceLoader resourceLoader;

    Stage window;

    public StageManager(@Value("${spring.application.ui.title}") String applicationTitle,
                        ApplicationContext applicationContext,
                        ResourceLoader resourceLoader) {
        this.applicationTitle = applicationTitle;
        this.applicationContext = applicationContext;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        window = event.getWindow();
        loadScene("classpath:fxml/editor_main.fxml", true);
    }

    public void loadScene(String sceneFxml, boolean resizable) {
        try {
            Resource chartResource = resourceLoader.getResource(sceneFxml);
            FXMLLoader fxmlLoader = new FXMLLoader(chartResource.getURL());
            fxmlLoader.setControllerFactory(applicationContext::getBean);

            window.setScene(new Scene(fxmlLoader.load()));
            window.setTitle(applicationTitle);
            window.initStyle(StageStyle.TRANSPARENT);
            window.getIcons().addAll(EditorResourceLoader.getSingleton().getIcons());

            window.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void addWindowControls(Stage primaryStage, HBox insertInto, Node dragBar, boolean resizable) throws IOException {
        //Resource windowControlsResource = resourceLoader.getResource("classpath:fxml/scenecontrols.fxml");
        //FXMLLoader windowControlsLoader = new FXMLLoader(windowControlsResource.getURL());
        //windowControlsLoader.setController(this);
        //windowControlsLoader.load();

        //closeButton.setText("X");
        //closeButton.setOnAction(event -> System.exit(0));

        //insertInto.getChildren().addAll(minimizeButton, maximizeButton, closeButton);
    }
}
