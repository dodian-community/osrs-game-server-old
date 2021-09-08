package net.dodian.runescape.model.map.steroids;

import net.dodian.runescape.model.Tile;
import net.dodian.runescape.model.World;

import java.util.LinkedList;

import static net.dodian.runescape.model.map.steroids.Clip.*;

public interface RouteFinder {
	
	void path(Route request, int startX, int startY, int plane, int unitSize, LinkedList<Direction> steps);
	
	/**
	 * Checks if a step is legal
	 * Default implementation gets the clipping flags from the World
	 */
	public static boolean isLegal(World world, Tile from, Direction d, int unitSize) {
		if (unitSize == 1) {
			int dx = d.x;
			int dy = d.y;
			if (dx == -1 && (world.clipAt(from.x - 1, from.z, from.level) & BLOCK_ENTER_W) != 0) {
				return false;
			}
			if (dx == 1 && (world.clipAt(from.x + 1, from.z, from.level) & BLOCK_ENTER_E) != 0) {
				return false;
			}
			if (dy == -1 && (world.clipAt(from.x, from.z - 1, from.level) & BLOCK_ENTER_S) != 0) {
				return false;
			}
			if (dy == 1 && (world.clipAt(from.x, from.z + 1, from.level) & BLOCK_ENTER_N) != 0) {
				return false;
			}
			if (dx == -1 && dy == -1 && (world.clipAt(from.x - 1, from.z - 1, from.level) & BLOCK_ENTER_SW) != 0) {
				return false;
			}
			if (dx == 1 && dy == -1 && (world.clipAt(from.x + 1, from.z - 1, from.level) & BLOCK_ENTER_SE) != 0) {
				return false;
			}
			if (dx == -1 && dy == 1 && (world.clipAt(from.x - 1, from.z + 1, from.level) & BLOCK_ENTER_NW) != 0) {
				return false;
			}
			if (dx == 1 && dy == 1 && (world.clipAt(from.x + 1, from.z + 1, from.level) & BLOCK_ENTER_NE) != 0) {
				return false;
			}
			return true;
		} else {
			switch (d) {
				case West:
					if ((world.clipAt(from.x - 1, from.z, from.level) & BLOCK_ENTER_SW) != 0 || (world.clipAt(from.x - 1, from.z - 1 + unitSize, from.level) & BLOCK_ENTER_NW) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize - 1; mid++) {
						if ((world.clipAt(from.x - 1, from.z + mid, from.level) & BLOCK_ENTER_W_BIG) != 0) {
							return false;
						}
					}
					return true;
				case East:
					if ((world.clipAt(from.x + unitSize, from.z, from.level) & BLOCK_ENTER_SE) != 0 || (world.clipAt(from.x + unitSize, from.z - 1 + unitSize, from.level) & BLOCK_ENTER_NE) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize - 1; mid++) {
						if ((world.clipAt(from.x + unitSize, from.z + mid, from.level) & BLOCK_ENTER_E_BIG) != 0) {
							return false;
						}
					}
					return true;
				case South:
					if ((world.clipAt(from.x, from.z - 1, from.level) & BLOCK_ENTER_SW) != 0 || (world.clipAt(from.x + unitSize - 1, from.z - 1, from.level) & BLOCK_ENTER_SE) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize - 1; mid++) {
						if ((world.clipAt(mid + from.x, from.z - 1, from.level) & BLOCK_ENTER_S_BIG) != 0) {
							return false;
						}
					}
					return true;
				case North:
					if ((world.clipAt(from.x, from.z + unitSize, from.level) & BLOCK_ENTER_NW) != 0 || (world.clipAt(from.x + unitSize - 1, from.z + unitSize, from.level) & BLOCK_ENTER_NE) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize - 1; mid++) {
						if ((world.clipAt(mid + from.x, from.z + unitSize, from.level) & BLOCK_ENTER_N_BIG) != 0) {
							return false;
						}
					}
					return true;
				case SouthWest:
					if ((world.clipAt(-1 + from.x, from.z - 1, from.level) & BLOCK_ENTER_SW) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize; mid++) {
						if ((world.clipAt(-1 + from.x, mid + from.z - 1, from.level) & BLOCK_ENTER_W_BIG) != 0 || (world.clipAt(from.x - 1 + mid, from.z - 1, from.level) & BLOCK_ENTER_S_BIG) != 0) {
							return false;
						}
					}
					return true;
				case SouthEast:
					if ((world.clipAt(unitSize + from.x, from.z - 1, from.level) & BLOCK_ENTER_SE) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize; mid++) {
						if ((world.clipAt(unitSize + from.x, mid + from.z - 1, from.level) & BLOCK_ENTER_E_BIG) != 0 || (world.clipAt(from.x + mid, from.z - 1, from.level) & BLOCK_ENTER_S_BIG) != 0) {
							return false;
						}
					}
					return true;
				case NorthWest:
					if ((world.clipAt(-1 + from.x, from.z + unitSize, from.level) & BLOCK_ENTER_NW) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize; mid++) {
						if ((world.clipAt(-1 + from.x, mid + from.z, from.level) & BLOCK_ENTER_W_BIG) != 0 || (world.clipAt(from.x - 1 + mid, from.z + unitSize, from.level) & BLOCK_ENTER_N_BIG) != 0) {
							return false;
						}
					}
					return true;
				case NorthEast:
					if ((world.clipAt(unitSize + from.x, from.z + unitSize, from.level) & BLOCK_ENTER_NE) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize; mid++) {
						if ((world.clipAt(mid + from.x, unitSize + from.z, from.level) & BLOCK_ENTER_N_BIG) != 0 || (world.clipAt(from.x + unitSize, from.z + mid, from.level) & BLOCK_ENTER_E_BIG) != 0) {
							return false;
						}
					}
					return true;
			}
			throw new RuntimeException("Unknown direction");
		}
	}
	
	default boolean legal(World world, Tile from, Direction d, int unitSize) {
		return RouteFinder.isLegal(world, from, d, unitSize);
	}
	
	default boolean legalProjectileStep(World world, Tile from, Direction d) {
		int dx = d.x;
		int dy = d.y;
		if (dx == -1 && (world.clipAt(from.x - 1, from.z, from.level) & Clip.BLOCK_PROJ_W) != 0) {
			return false;
		}
		if (dx == 1 && (world.clipAt(from.x + 1, from.z, from.level) & BLOCK_PROJ_E) != 0) {
			return false;
		}
		if (dy == -1 && (world.clipAt(from.x, from.z - 1, from.level) & BLOCK_PROJ_S) != 0) {
			return false;
		}
		if (dy == 1 && (world.clipAt(from.x, from.z + 1, from.level) & BLOCK_PROJ_N) != 0) {
			return false;
		}
		if (dx == -1 && dy == -1 && (world.clipAt(from.x - 1, from.z - 1, from.level) & BLOCK_PROJ_SW) != 0) {
			return false;
		}
		if (dx == 1 && dy == -1 && (world.clipAt(from.x + 1, from.z - 1, from.level) & BLOCK_PROJ_SE) != 0) {
			return false;
		}
		if (dx == -1 && dy == 1 && (world.clipAt(from.x - 1, from.z + 1, from.level) & BLOCK_PROJ_NW) != 0) {
			return false;
		}
		if (dx == 1 && dy == 1 && (world.clipAt(from.x + 1, from.z + 1, from.level) & BLOCK_PROJ_NE) != 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * Method called from the world thread that allows us to do any non thread safe operations
	 * It will be called every cycle, before path method is called
	 */
	default void load() {
		
	}
	
}
