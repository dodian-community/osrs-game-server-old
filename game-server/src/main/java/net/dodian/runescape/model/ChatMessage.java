package net.dodian.runescape.model;

/**
 * Created by bart on 7/19/15.
 */
public class ChatMessage {
	
	private int effects;
	private int colors;
	private String text, starred;
	private boolean autochat;
	private int icon;
	
	public ChatMessage(String text, int effects, int colors, int icon, boolean autochat) {
		this.text = text;
		this.effects = effects;
		this.colors = colors;
		this.autochat = autochat;
		this.icon = icon;
	}
	
	public String text() {
		return text;
	}
	
	public int colors() {
		return colors;
	}
	
	public int effects() {
		return effects;
	}
	
	public int icon() {
		return icon;
	}
	
	public boolean autochat() {
		return autochat;
	}

	public String starred() { return starred; }

	public ChatMessage starred(String s) { this.starred = s; return this; }
}
