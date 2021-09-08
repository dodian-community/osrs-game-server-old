package net.dodian.runescape.model;

/**
 * Created by Situations on 2017-01-02.
 */

public enum CameraType {
	POSITION(182),
	ROTATION(131),
	SHAKE(49),
	RESET(155);
	
	private final int packet;
	
	CameraType(int packet) {
		this.packet = packet;
	}
	
	public int packet() {
		return packet;
	}
}

