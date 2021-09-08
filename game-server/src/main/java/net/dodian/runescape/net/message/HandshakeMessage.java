package net.dodian.runescape.net.message;

/**
 * Created by Bart on 8/4/2014.
 */
public class HandshakeMessage {
	
	private final int revision;
	
	public HandshakeMessage(int revision) {
		this.revision = revision;
	}
	
	public int revision() {
		return revision;
	}
	
}
