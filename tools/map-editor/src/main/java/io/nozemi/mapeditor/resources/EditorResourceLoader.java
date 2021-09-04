package io.nozemi.mapeditor.resources;

import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class EditorResourceLoader {
	
	private static EditorResourceLoader singleton;
	public static EditorResourceLoader getSingleton() {
		if(singleton == null)
			singleton = new EditorResourceLoader();
		return singleton;
	}
	
	private final Image logo16;
	private final Image logo32;
	private final Image logo64;
	private final Image logo128;
	
	public EditorResourceLoader() {
		logo16 = new Image(getClass().getResource("/images/logo128.png").toString(), 16, 16, true, true, true);
		logo32 = new Image(getClass().getResource("/images/logo128.png").toString(), 32, 32, true, true, true);
		logo64 = new Image(getClass().getResource("/images/logo128.png").toString(), 64, 64, true, true, false);
		logo128 = new Image(getClass().getResource("/images/logo128.png").toString(), 128, 128, true, true, true);
	}

	public Image getLogo16() {
		return logo16;
	}

	public Image getLogo32() {
		return logo32;
	}

	public Image getLogo64() {
		return logo64;
	}

	public Image getLogo128() {
		return logo128;
	}


	public List<Image> getIcons() {
		return Arrays.asList(logo16, logo32, logo64, logo128);
	}
}
