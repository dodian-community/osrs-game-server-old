package net.dodian.runescape.net.message;

/**
 * Created by Bart on 8/4/2014.
 */
public enum HandshakeResponse {
	
	ALL_OK(0),
	OUT_OF_DATE(6);
	
	private int value;
	
	private HandshakeResponse(int value) {
		this.value = value;
	}
	
	public int value() {
		return value;
	}
	
}
