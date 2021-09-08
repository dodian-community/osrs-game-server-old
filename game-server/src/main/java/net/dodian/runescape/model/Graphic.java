package net.dodian.runescape.model;

/**
 * Created by Bart on 10/28/2015.
 */
public class Graphic {
	
	private final int id;
	private final int height;
	private final int delay;
	
	public Graphic(int id) {
		this.id = id;
		this.height = 0;
		this.delay = 0;
	}
	
	public Graphic(int id, int height) {
		this.id = id;
		this.height = height;
		this.delay = 0;
	}
	
	public Graphic(int id, int height, int delay) {
		this.id = id;
		this.height = height;
		this.delay = delay;
	}
	
	public int id() {
		return id;
	}
	
	public int height() {
		return height;
	}
	
	public int delay() {
		return delay;
	}
	
}
