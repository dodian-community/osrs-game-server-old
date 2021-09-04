package io.nozemi.runescape.util;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class UsernameUtilities {
	
	private static final char[] USERNAME_CHARACTERS = {'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '=', ':', ';', '.', '>', '<', ',', '"',
			'[', ']', '|', '?', '/', '`'};
	
	
	public static String decodeUsername(long nameLong) {
		if (nameLong % 37L == 0L)
			return "";
		
		int i = 0;
		for (long temp = nameLong; temp != 0L; temp /= 37L)
			i++;
		
		StringBuilder result = new StringBuilder(i);
		while (nameLong != 0L) {
			long old = nameLong;
			nameLong /= 37L;
			result.append(USERNAME_CHARACTERS[(int) (-(nameLong * 37L) + old)]);
		}
		
		return result.reverse().toString();
	}
	
	public static long encodeUsername(String name) {
		long result = 0;
		
		for (int pos = 0; pos < name.length() && pos < 12; pos++) {
			char c = name.charAt(pos);
			result *= 37L;
			
			if (c >= 'A' && c <= 'Z')
				result += c - 'A' + 1;
			else if (c >= 'a' && c <= 'z')
				result += c - 'a' + 1;
			else if (c >= '0' && c <= '9')
				result += c - '0' + 1;
		}
		
		while (result % 37L == 0L && result != 0L)
			result /= 37L;
		
		return result;
	}
	
}
