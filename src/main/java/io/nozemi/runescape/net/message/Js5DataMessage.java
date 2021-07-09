package io.nozemi.runescape.net.message;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class Js5DataMessage {
	
	private byte[] data;
	private int index;
	private int container;
	private boolean urgent;
	
	public Js5DataMessage(int index, int container, byte[] data, boolean urgent) {
		this.index = index;
		this.container = container;
		this.data = data;
		this.urgent = urgent;
	}
	
	public int index() {
		return index;
	}
	
	public int container() {
		return container;
	}
	
	public byte[] data() {
		return data;
	}
	
	public boolean urgent() {
		return urgent;
	}
	
}
