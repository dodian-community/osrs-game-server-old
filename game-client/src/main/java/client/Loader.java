package client;

import com.allatori.annotations.DoNotRename;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@DoNotRename
public class Loader implements AppletStub {

	public static boolean local = true;
	public static String host = local ? "localhost" : "localhost";
	public static final String WORLDLIST = "http://world2b.os-scape.com:8181/worldlist.ws";
	private static String params;
	public static final int REVISION = 149;
	public static int port = 43594;

	private static final String[] MEMES = {
		"The nulls were back! Not anymore!",
		"Do you even stake, bro?",
		"This isn't even Dodian anymore!",
		"Ah shit, here we go again."
	};

	public static Properties parameters = new Properties();

	public static JFrame frame;

	@DoNotRename
	public static void main(final String[] args) {
		if (args.length > 1) {
			params = args[1];
		}

		Custom.trackLaunch();
		Custom.readDrag();
		Custom.cleanLogFiles();

		final Loader applet = new Loader();
		applet.readParameters();

		final GameClient instance = new GameClient();
		frame = new JFrame("Dodian.net Client - Uber Server OSRS - " + MEMES[new Random().nextInt(MEMES.length)]);

		instance.setBounds(0, 0, 765, 503);
		// TODOD new OverlayPanel();
		frame.add(instance);
		frame.setVisible(true);
		frame.setSize(781, 541);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		instance.setStub(applet);
		instance.init();
		instance.start();
	}

	private void readParameters() {
		try {
			URL url = Loader.class.getResource("/params.txt");

			if (params != null) {
				params = params.replace("\\n", "\n");
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(params == null ? url.openConnection().getInputStream() : new ByteArrayInputStream(params.getBytes())));
			List<String> lines = new ArrayList<String>();
			String in;
			while ((in = reader.readLine()) != null) {
				lines.add(in);
			}

			for (String line : lines) {
				if (line.contains("param=")) {
					line = line.replace("param=", "");

					String parameterKey = line.substring(0, line.indexOf("="));
					String parameterValue = line.substring(line.indexOf("=") + 1, line.length());
					parameters.put(parameterKey, parameterValue);

					if (parameterKey.equals("ip")) {
						host = parameterValue;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		port = 43594;
	}

	@Override
	public String getParameter(final String paramName) {
		return (String) parameters.get(paramName);
	}

	@Override
	public URL getDocumentBase() {
		try {
			return new URL("http://" + host);
		} catch (final MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public URL getCodeBase() {
		try {
			return new URL("http://" + host);
		} catch (final MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isActive() {
		return true;
	}

	@Override
	public AppletContext getAppletContext() {
		return null;
	}

	@Override
	public void appletResize(final int width, final int height) {
	}



}
