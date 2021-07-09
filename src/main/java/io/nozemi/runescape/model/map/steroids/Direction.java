package io.nozemi.runescape.model.map.steroids;

import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.Tile;

public enum Direction {
	
	//Order is important!
	North(0, 1), NorthEast(1, 1), East(1, 0), SouthEast(1, -1), South(0, -1), SouthWest(-1, -1), West(-1, 0), NorthWest(-1, 1);
	
	public final int x;
	public final int y;
	
	private Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static final int GRANULARITY = 2048;
	public static final Direction[] values = Direction.values();
	public static final Direction[] ORTHOGONALS = {North, East, South, West};
	public static final Direction[] DIAGONALS = {NorthEast, SouthEast, SouthWest, NorthWest};
	
	/**
	 * Rounds this angle to the nearest direction
	 */
	public static Direction of(int angle) {
		return values[(angle + 1024 & 0x3fff) >> 11];
	}
	
	public Direction opposite() {
		return Direction.diagonal(-x, -y);
	}
	
	/**
	 * Base angle for this direction
	 */
	public final int angle() {
		return angle(x, y);
	}
	
	public final Direction rotate(int r) {
		return Direction.of(angle() + r * (GRANULARITY * 2));
	}
	
	/**
	 * Angle for two entities, taking into account their sizes/center
	 */
	public static final int angle(Entity from, Entity to) {
		return ((int) (Math.atan2((to.tile().x + (to.size() / 2.0)) - (from.tile().x + (from.size() / 2.0)), (to.tile().z + (to.size() / 2.0)) - (from.tile().z + (from.size() / 2.0))) * ((GRANULARITY * 4) / Math.PI))) & (GRANULARITY * 8 - 1);
	}
	
	public static final int angle(Tile from, Tile to) {
		return ((int) (Math.atan2(to.x - from.x, to.z - from.z) * ((GRANULARITY * 4) / Math.PI))) & (GRANULARITY * 8 - 1);
	}
	
	public static final int angle(double xOffset, double yOffset) {
		return ((int) (Math.atan2(xOffset, yOffset) * ((GRANULARITY * 4) / Math.PI))) & (GRANULARITY * 8 - 1);
	}
	
	public static final int angle(int xOffset, int yOffset) {
		return ((int) (Math.atan2(xOffset, yOffset) * ((GRANULARITY * 4) / Math.PI))) & (GRANULARITY * 8 - 1);
	}
	
	/**
	 * Gets the closest direction for two offsets without bias towards diagonal or orthogonal
	 */
	public static Direction of(int xOffset, int yOffset) {
		return of(angle(xOffset, yOffset) & 0x3fff);
	}
	
	//Less precise versions of the same calculation, but the client needs bigger resolutions for coordinate facing, so let's just use high resolution ones everywhere
//	public static final double angle2(int xOffset, int yOffset) {
//		return Math.atan2(xOffset, yOffset) * (4 / Math.PI);
//	}
//	
//	public static Direction closest2(int xOffset, int yOffset) {
//		return of2((int)Math.floor(angle2(xOffset, yOffset) + 0.5) & 0x7);
//	}
//	
//	public static Direction of2(int angle) {
//		return values[angle];
//	}
	
	/**
	 * Gets the direction for two offsets, always preferring diagonal
	 */
	public static Direction diagonal(int dx, int dy) {
		if (dx < 0) {
			if (dy < 0)
				return SouthWest;
			else if (dy > 0)
				return NorthWest;
			else
				return West;
		} else if (dx > 0) {
			if (dy < 0)
				return SouthEast;
			else if (dy > 0)
				return NorthEast;
			else
				return East;
		} else {
			if (dy < 0)
				return South;
			else if (dy > 0)
				return North;
		}
		throw new RuntimeException("Not a direction "+dx+" "+dy);
	}
	
	/**
	 * Gets the direction for two offsets, always preferring vertical/horizontal
	 */
	public static Direction orthogonal(int dx, int dy) {
		if (dx > 0) {
			if (dy >= 0) {
				if (dx == dy) {
					return NorthEast;
				} else if (dx > dy) {
					return East;
				} else {
					return North;
				}
			} else {
				if (dx == -dy) {
					return SouthEast;
				} else if (dx > -dy) {
					return East;
				} else {
					return South;
				}
			}
		} else if (-dx > 0) {
			if (dy >= 0) {
				if (-dx == dy) {
					return NorthWest;
				} else if (-dx > dy) {
					return West;
				} else {
					return North;
				}
			} else {
				if (-dx == -dy) {
					return SouthWest;
				} else if (-dx > -dy) {
					return West;
				} else {
					return South;
				}
			}
		} else if (dy > 0) {
			return North;
		} else if (-dy > 0) {
			return South;
		}
		throw new RuntimeException("Not a direction");
	}
	
}