package io.nozemi.runescape.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Bart on 8/9/2015.
 * <p>
 * Basic localisation features.
 */
public class L10n {
	
	private static final NumberFormat BRITISH = NumberFormat.getNumberInstance(Locale.UK);
	
	public static String format(long number) {
		return BRITISH.format(number);
	}
	
	public static String formatChatMessage(String message) {
		StringBuilder sb = new StringBuilder(message.length());
		
		boolean allowCapital = true;
		boolean forceCapital = true;
		for (int idx = 0; idx < message.length(); idx++) {
			char c = message.charAt(idx);
			
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
				if (forceCapital) {
					c = Character.toUpperCase(c);
					forceCapital = false;
				} else if (!allowCapital) {
					c = Character.toLowerCase(c);
					allowCapital = true;
				}
			}
			
			sb.append(c);
			
			// Set info for next char
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
				allowCapital = false;
			} else {
				allowCapital = true;
			}
			if (c == '.' || c == '?' || c == '!') {
				forceCapital = true;
			}
		}
		
		return sb.toString();
	}
	
	public static String replaceTags(String raw) {
		StringBuilder sb = new StringBuilder();
		for (char c : raw.toCharArray()) {
			if (c == '<') {
				sb.append("<lt>");
			} else if (c == '>') {
				sb.append("<gt>");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
}
