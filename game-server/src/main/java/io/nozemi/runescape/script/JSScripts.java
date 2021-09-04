package io.nozemi.runescape.script;

import io.nozemi.runescape.model.entity.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * Created by Jak on 19/12/2015.
 */
public class JSScripts {
	
	private static final Logger logger = LogManager.getLogger(JSScripts.class);
	
	private static ScriptEngineManager mgr;
	
	private static ScriptEngine engine;
	
	/**
	 * stops engine-setup multiple times
	 */
	private static boolean issetup;
	
	/**
	 * init engine
	 */
	private static void setup() {
		if (issetup) {
			return;
		}
		issetup = true;
		mgr = new ScriptEngineManager();
		engine = mgr.getEngineByName("JavaScript");
	}
	
	public static void bind(Player player) {
		setup();
		if (engine == null) {
			return;
		}
		engine.put("p", player);
		engine.put("player", player);
	}
	
	/**
	 * Loads from dir
	 *
	 * @param dirPath
	 * @param player  to report success of load to
	 */
	private static void loadScripts(String dirPath, Player player) {
		setup();
		File dir = new File(dirPath);
		if (dir.exists() && dir.isDirectory()) {
			File[] children = dir.listFiles();
			if (children.length == 0) {
				if (player != null)
					player.message("No scripts in dir: " + scriptsDir);
				return;
			}
			for (File child : children) {
				if (child.isFile() && child.getName().endsWith(".js"))
					try {
						long start = System.nanoTime();
						long startms = System.currentTimeMillis();
						engine.eval(new InputStreamReader(new FileInputStream(child)));
						logger.info("Script loaded (" + (System.nanoTime() - start) + " ns): " + child);
						mes("reloaded (" + (System.nanoTime() - start) + " ns/" + (System.currentTimeMillis() - startms) + " ms) " + child.getName(), player);
					} catch (ScriptException ex) {
						mes("Load/ScriptException ('" + child.getName() + "') : " + ex.getMessage(), player);
					} catch (FileNotFoundException ex) {
						mes("File missing. ('" + child.getName() + "') : " + ex.getMessage(), player);
					}
				else if (child.isDirectory())
					loadScripts(child.getPath(), player);
			}
		}
	}
	
	private static void mes(String s, Player p) {
		if (p != null) {
			p.message(s);
		}
	}
	
	/**
	 * No feedback on script load success
	 */
	public static void reload() {
		loadScripts(scriptsDir, null);
	}
	
	/**
	 * Sends game msg on success of loading
	 *
	 * @param p
	 */
	public static void reload(Player p) {
		loadScripts(scriptsDir, p);
	}
	
	private static final String scriptsDir = "./data/javascripts/";
	
	public static boolean invokeWithFailTest(String identifier, Player p, Object... args) {
		bind(p);
		Invocable invEngine = (Invocable) engine;
		try {
			long start = System.nanoTime();
			long startms = System.currentTimeMillis();
			invEngine.invokeFunction(identifier, args);
			engine.getBindings(ScriptContext.GLOBAL_SCOPE).remove("p");
			p.message("[Scripts] ran '" + identifier + "' in " + (System.nanoTime() - start) + " ns/" + (System.currentTimeMillis() - startms) + " ms");
			return true;
		} catch (NoSuchMethodException ex) {
			p.message("[Scripts] No method: " + ex.getMessage());
			engine.getBindings(ScriptContext.GLOBAL_SCOPE).remove("p");
			return false;
		} catch (ScriptException ex) {
			p.message("[Scripts] Script ex: " + ex.getMessage());
			engine.getBindings(ScriptContext.GLOBAL_SCOPE).remove("p");
			return false;
		} catch (Exception ex) {
			p.message("[Scripts] Script ex: " + ex.getMessage());
			ex.printStackTrace();
			engine.getBindings(ScriptContext.GLOBAL_SCOPE).remove("p");
			return false;
		}
	}
}
