package net.dodian.runescape.script;

/**
 * Created by Bart on 8/12/2015.
 */
public class Timer {
	
	private TimerKey key;
	private int ticks;
	
	public Timer(TimerKey key, int ticks) {
		this.key = key;
		this.ticks = ticks;
	}
	
	public int ticks() {
		return ticks;
	}
	
	public void ticks(int ticks) {
		this.ticks = ticks;
	}
	
	public TimerKey key() {
		return key;
	}
	
	public void tick() {
		if (ticks > 0)
			ticks--;
	}
	
}
