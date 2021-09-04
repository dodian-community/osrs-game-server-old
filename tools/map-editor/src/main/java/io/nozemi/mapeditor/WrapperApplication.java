package io.nozemi.mapeditor;

import io.nozemi.mapeditor.events.StageReadyEvent;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URI;
import java.util.HashMap;

@Component
public class WrapperApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void start(Stage window) throws Exception {
        applicationContext.publishEvent(new StageReadyEvent(window));
        CookieHandler cookieHandler = new CookieManager();
        cookieHandler.put(new URI("io.nozemi"), new HashMap<>());
    }

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(MapEditorApplication.class)
                .web(WebApplicationType.NONE)
                .run();
    }
}
