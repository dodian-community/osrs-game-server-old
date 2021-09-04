package io.nozemi.runescape.model;

public class FaceDirection {
	
	private static final int ONE_EIGTH = 360 / 8;
	private static final int ONE_SIXTEENTH = 360 / 16;
	public static final FaceDirection NORTH = new FaceDirection(0x400, 0);
	public static final FaceDirection NORTH_EAST = new FaceDirection(0x500, 1);
	public static final FaceDirection EAST = new FaceDirection(0x600, 1);
	public static final FaceDirection SOUTH_EAST = new FaceDirection(0x700, 3);
	public static final FaceDirection SOUTH = new FaceDirection(0x000, 2);
	public static final FaceDirection SOUTH_WEST = new FaceDirection(0x100, 5);
	public static final FaceDirection WEST = new FaceDirection(0x200, 3);
	public static final FaceDirection NORTH_WEST = new FaceDirection(0x300, 7);
	
	public final int direction;
	public final int bitDirection;
	
	public FaceDirection(int rotation) {
		direction = rotation;
		bitDirection = 0;
	}
	
	public FaceDirection(int rotation, int bitdir) {
		direction = rotation;
		bitDirection = bitdir;
	}
	
	public static FaceDirection forTargetTile(Tile tile, Tile target) {
		int xOffset = target.x - tile.x;
		int yOffset = target.z - tile.z;
		return forTargetTile(xOffset, yOffset);
	}
	
	public static FaceDirection forTargetTile(int xOffset, int yOffset) {
		double theta = Math.atan2(-xOffset, -yOffset);
		double radians = theta * (180 / Math.PI);
		if (radians < 0)
			radians = 360 + radians;
		return new FaceDirection((int) (theta * 325.949D) & 2047, fromDegrees((int) radians).bitDirection);
	}
	
	public static FaceDirection fromDegrees(int degrees) {
		if (degrees >= 360 - ONE_SIXTEENTH && degrees <= ONE_SIXTEENTH)
			return NORTH;
		else if (degrees >= 45 - ONE_SIXTEENTH && degrees <= 45 + ONE_SIXTEENTH)
			return NORTH_EAST;
		else if (degrees >= 90 - ONE_SIXTEENTH && degrees <= 90 + ONE_SIXTEENTH)
			return EAST;
		else if (degrees >= 135 - ONE_SIXTEENTH && degrees <= 135 + ONE_SIXTEENTH)
			return SOUTH_EAST;
		else if (degrees >= 180 - ONE_SIXTEENTH && degrees <= 180 + ONE_SIXTEENTH)
			return SOUTH;
		else if (degrees >= 225 - ONE_SIXTEENTH && degrees <= 225 + ONE_SIXTEENTH)
			return SOUTH_WEST;
		else if (degrees >= 270 - ONE_SIXTEENTH && degrees <= 270 + ONE_SIXTEENTH)
			return WEST;
		else if (degrees >= 315 - ONE_SIXTEENTH && degrees <= 315 + ONE_SIXTEENTH)
			return NORTH_WEST;
		return NORTH;
	}
	
}
