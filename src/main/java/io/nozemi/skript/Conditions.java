package io.nozemi.skript;

/**
 * Created by Bart on 1/7/2017.
 */
public class Conditions {
	
	public static Condition context(final Object context) {
		return s -> s.ctx() == context;
	}
	
	public static Condition contextOfType(final Class<?> type) {
		return s -> s.ctx() != null && s.ctx().getClass() == type;
	}
	
	public static Condition not(final Condition other) {
		return s -> !other.check(s);
	}
}
