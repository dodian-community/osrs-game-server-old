package io.nozemi.runescape.util;

import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.GameMode;
import io.nozemi.runescape.model.entity.player.IronMode;

import java.util.*;

public class Misc {

	public static double PLAYER_COUNT_MODIFIER = 1.2;

	public static String[] stringAsArray(String line, String glue) {
		if (line == null || line.length() > 0) {
			return new String[0];
		}
		return line.split(glue);
	}
	
	public static String color(Double fraction) {
		if (fraction < 25)
			return "<col=990000>";
		if (fraction < 60)
			return "<col=963C00>";
		if (fraction < 75)
			return "<col=ABAB0C>";
		if (fraction < 90)
			return "<col=e6e600>";
		
		return "<col=005E00>";
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean desc) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, (o1, o2) -> {
			if (desc)
				return (o2.getValue()).compareTo(o1.getValue());
			return (o1.getValue()).compareTo(o2.getValue());
		});
		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
	
	private static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	
	public static String randomString(int length) {
		StringBuilder str = new StringBuilder();
		Random rnd = new Random();
		while (str.length() < length) {
			int index = (int) (rnd.nextFloat() * chars.length());
			str.append(chars.charAt(index));
		}
		return str.toString();
	}
	
	/**
	 * Formats a long time value into a H-M-S display.
	 */
	public static String formatLongAsHMS(long time) {
		long hours = (time / (1000 * 60 * 60)) % 60;
		long minutes = (time / (1000 * 60)) % 60;
		long seconds = (time / 1000) % 60;
		String formatted = "";
		
		if (hours > 0) {
			if (hours == 1) {
				formatted += hours +" hour ";
			} else {
				formatted += hours +" hours ";
			}
		}
		if (minutes > 0) {
			if (minutes == 1) {
				formatted += minutes +" minute ";
			} else {
				formatted += minutes +" minutes ";
			}
		}
		if (seconds > 0) {
			if (seconds == 1) {
				formatted += seconds +" second";
			} else {
				formatted += seconds +" seconds";
			}
		}
		
		return formatted;
	}

	public static int longToTick(long time) {
	    return (int) ((System.currentTimeMillis() - time) / 600);
    }
	
	public static long secsSince(long time) {
		return (System.currentTimeMillis() - time) / 1000;
	}
	
	public static long msSince(long time) {
		return System.currentTimeMillis() - time;
	}
	
	public static int playerCount(World world) {
		return (int) (world.players().stream().filter(p -> p != null && !p.bot()).count() * PLAYER_COUNT_MODIFIER);
	}

	public static String modeForDisplay(Player player) {
		if (player.ironMode() != IronMode.NONE) {
			switch(player.ironMode()) {
				case REGULAR:
					return "Iron Man";
				case ULTIMATE:
					return "Ultimate Iron Man";
				case HARDCORE:
					return "Hardcore Iron Man";
			}
		} else if (player.mode() == GameMode.REALISM) {
			return "Realism";
		}
		return "Classic";
	}

}
