package io.nozemi.mapeditor.controllers;

import com.jagex.Client;
import com.jagex.map.SceneGraph;
import com.rspsi.game.CanvasPane;
import io.nozemi.mapeditor.game.listeners.GameKeyListener;
import io.nozemi.mapeditor.game.listeners.GameMouseListener;
import io.nozemi.mapeditor.util.FontAwesomeUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

@Component
public class MainController implements Initializable {

    private static final Logger logger = LogManager.getLogger(MainController.class);

    private final ResourceLoader resourceLoader;

    @FXML
    private HBox controlBox;

    @FXML
    private Button closeButton;

    @FXML
    private Button minimizeButton;

    @FXML
    private Button maximizeButton;

    @FXML
    private ToggleButton selectTileBtn;

    @FXML
    private AnchorPane gamePane;

    private Client clientInstance;

    //private MultiRegionMapWindow fullMapView;

    @Autowired
    public MainController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        closeButton.setText("X");
        closeButton.setTextFill(Paint.valueOf("WHITE"));
        closeButton.setOnAction(event -> System.exit(0));

        selectTileBtn.setSelected(true);

        clientInstance = Client.initialize(this.gamePane.widthProperty().intValue(), gamePane.heightProperty().intValue());
        clientInstance.loadCache(Paths.get(""));

        CanvasPane gamePane = new CanvasPane(clientInstance.getGameCanvas());

        GameKeyListener gameKeyListener = new GameKeyListener(clientInstance);
        clientInstance.getGameCanvas().addEventHandler(MouseEvent.ANY, new GameMouseListener(clientInstance));
        clientInstance.getGameCanvas().addEventHandler(ScrollEvent.ANY, new GameMouseListener(clientInstance));
        clientInstance.getGameCanvas().addEventHandler(KeyEvent.ANY, gameKeyListener);

        //clientInstance.fullMapVisible.bind(fullMapView.visibleProperty());

        SceneGraph.setMouseIsDown(true);
        SceneGraph.setMouseIsDown(false);

        clientInstance.visible = true;
    }
}
