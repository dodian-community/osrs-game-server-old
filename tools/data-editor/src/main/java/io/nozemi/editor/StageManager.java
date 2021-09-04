package io.nozemi.editor;

import io.nozemi.editor.events.StageReadyEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

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
        loadScene("classpath:fxml/editor_main.fxml");
    }

    public void loadScene(String sceneFxml) {
        try {
            Resource chartResource = resourceLoader.getResource(sceneFxml);
            FXMLLoader fxmlLoader = new FXMLLoader(chartResource.getURL());
            fxmlLoader.setControllerFactory(applicationContext::getBean);

            window.setScene(new Scene(fxmlLoader.load()));
            window.setTitle(applicationTitle);

            window.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
