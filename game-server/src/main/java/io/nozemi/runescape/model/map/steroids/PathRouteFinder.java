package io.nozemi.runescape.model.map.steroids;

import io.nozemi.runescape.fs.MapDefinition;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.World;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.LinkedList;

import static io.nozemi.runescape.model.map.steroids.Clip.*;

public class PathRouteFinder implements RouteFinder {
	
	static final Unsafe unsafe = getTheUnsafe();
	static final int ALT_RADIUS = 10;
	static final int RECENTER_DISTANCE = 24; //Increasing improves performance but may make it not calculate some very long paths sometimes
	
	static Unsafe getTheUnsafe() {
		try {
			Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
			theUnsafe.setAccessible(true);
			return (Unsafe) theUnsafe.get(null);
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}
	
	private static class Offsets {
		
		public static final int MEMSIZE = (128 * 128) + (Short.BYTES * 128 * 128) + 1024 + 1024 + 1_500_000;
		final long parent;
		final long cost;
		final long queueX;
		final long queueY;
		
		public Offsets() {
			parent = unsafe.allocateMemory(MEMSIZE);
			cost = parent + 128 * 128;
			queueX = cost + Short.BYTES * 128 * 128;
			queueY = queueX + 1024;
			unsafe.setMemory(parent, 128, (byte) -1); //Clear left border
			unsafe.setMemory(parent + 128 * 127, 128, (byte) -1); //Clear right border
		}
		
		@Override
		protected void finalize() throws Throwable {
			super.finalize();
			//TODO: Move to logout or other appropriate place
			unsafe.freeMemory(parent);
		}
		
	}
	
	private static final ThreadLocal<Offsets> offsets = ThreadLocal.withInitial(() -> new Offsets());
	private final long flags = unsafe.allocateMemory(Integer.BYTES * 128 * 128 + 500_000);
	private boolean freed;
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		//TODO: Move to logout or other appropriate place
		free();
	}
	
	private int loadedX;
	private int loadedY;
	private int loadedZ;
	private int loadedCycle;
	private int routeX;//TODO: remove, do via route request target
	private int routeY;
	private Tile entity;
	private final World world;
	private boolean valid = false;
	
	public PathRouteFinder(Entity entity) {
		this.entity = entity.tile();
		this.world = entity.world();
		recenter();
	}
	
	public PathRouteFinder(Tile tile, World world) {
		this.entity = tile;
		this.world = world;
		recenter();
	}
	
	public void free() {
		if (!freed) {
			freed = true;
			unsafe.freeMemory(flags);
		}
	}
	
	@Override
	public void load() {
		//Called synchronously from world thread, once per cycle
		final int fx = entity.x - 64;
		final int tx = entity.x + 64;
		final int fy = entity.z - 64;
		final int ty = entity.z + 64;
		for (int rx = fx >> 6; rx <= tx >> 6; rx++) {
			for (int ry = fy >> 6; ry <= ty >> 6; ry++) {
				//This will force the map to load, invalidate if needed
				//World.reference(rx, ry).load();
			}
		}
	}
	
	/**
	 * Synchronize and re-center the flags array if needed
	 */
	private final void recenter() {
		final int fx = entity.x - 64;
		final int tx = entity.x + 64;
		final int fy = entity.z - 64;
		final int ty = entity.z + 64;
		boolean invalidated = true;
		/*invalidate: for (int rx = fx >> 6; rx <= tx >> 6; rx++) {
			for (int ry = fy >> 6; ry <= ty >> 6; ry++) {
				if (World.reference(rx, ry).lastModified > loadedCycle) {
					invalidated = true;
					break invalidate;
				}
			}
		}*/
		if (Math.abs(loadedX - entity.x) > RECENTER_DISTANCE || Math.abs(loadedY - entity.z) > RECENTER_DISTANCE || !valid || loadedZ != entity.level) {
			invalidated = false;
			valid = true;
			loadedX = entity.x;
			loadedY = entity.z;
			loadedZ = entity.level;
			for (int rx = fx >> 6; rx <= tx >> 6; rx++) {
				int toX = Math.min(entity.x, (rx << 6)) + 63;
				for (int ry = fy >> 6; ry <= ty >> 6; ry++) {
					int toY = Math.min(entity.z, (ry << 6)) + 63;
					//It will already have been loaded
					final MapDefinition reference = world.definitions().get(MapDefinition.class, (rx << 8) | ry);//World.reference(rx, ry);
					if (reference != null) {
						int[][] plane = reference.getMasks()[entity.level];
						//TODO: Maybe we need to keep a Map<Region, Integer> and use a modCount istead of lastModified because this is still not 100% but solves 99+% of caching issues
						//Region A could change, then we synchronize mid cycle for whatever, then region B changes in the same cycle. we miss the update until something else happens
						loadedCycle = 0;//Math.max(reference.lastModified, loadedCycle);
						for (int x = Math.max(entity.x - 64, rx << 6); x <= toX; x++) {
							for (int y = Math.max(entity.z - 64, ry << 6); y <= toY; y++) {
								unsafe.putInt(flags + i(x - entity.x + 64, y - entity.z + 64), plane[x & 0x3F][y & 0x3F]);
							}
						}
					} else {
						for (int x = Math.max(entity.x - 64, rx << 6); x <= toX; x++) {
							for (int y = Math.max(entity.z - 64, ry << 6); y <= toY; y++) {
								unsafe.putInt(flags + i(x - entity.x + 64, y - entity.z + 64), 0xFFFFFFFF);
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public final void path(Route request, int startX, int startY, int plane, final int unitSize, LinkedList<Direction> steps) {
//		if (Math.abs(startX - request.targetX) > 63 - unitSize || Math.abs(startY - request.targetY) > 63 - unitSize) {
//			return;
//		}
		recenter();
		final int shiftX = startX - 64 + loadedX - entity.x;
		final int shiftY = startY - 64 + loadedY - entity.z;
		
		Offsets off = PathRouteFinder.offsets.get();
		//Clear everything except the left and right border
		unsafe.setMemory(off.parent + 128, 126 * 128, (byte) 0);
		//Clear all costs.
		unsafe.setMemory(off.cost, 2 * 128 * 128, (byte) 127); //don't want to set to -1, int will be 2139062143 like this
		
		//We mark the borders as visited to eliminate bound checks in the algorithm
		//Left border is already cleared
		for (int n = 0; n < 128 * 128; n += 128) {
			//Clear the bottom border
			unsafe.putByte(off.parent + n, (byte) -1);
			//Top border * unitsize
			unsafe.setMemory(off.parent + n + 128 - unitSize, unitSize, (byte) -1);
		}
		//Right borders * unitsize
		for (int u = 1; u < unitSize; u++) {
			unsafe.setMemory(off.parent + (127 - u) * 128, 128, (byte) -1);
		}
		
		boolean solved = false;
		if (unitSize == 1) {
			solved = path1(off, request.strategy, request.targetX - shiftX, request.targetY - shiftY, request.targetSX, request.targetSY, request.orientation, request.allowedDirections);
		} else if (unitSize == 2) {
			solved = path2(off, request.strategy, request.targetX - shiftX, request.targetY - shiftY, request.targetSX, request.targetSY, request.orientation, request.allowedDirections);
		} else {
			solved = pathN(off, request.strategy, request.targetX - shiftX, request.targetY - shiftY, request.targetSX, request.targetSY, request.orientation, request.allowedDirections, unitSize);
		}
		int foundX = routeX + shiftX;
		int foundY = routeY + shiftY;
		if (!solved) {
			int bestDistance = 2147483647;
			if (request.alternative) {
				int bestCost = 2147483647;
				for (int x = request.targetX - ALT_RADIUS; x <= request.targetX + ALT_RADIUS; x++) {
					for (int y = request.targetY - ALT_RADIUS; y <= request.targetY + ALT_RADIUS; y++) {
						int shiftedX = x - shiftX;
						int shiftedY = y - shiftY;
						if (shiftedX >= 0 && shiftedY >= 0 && shiftedX < 128 && shiftedY < 128) {
							final short altCost = unsafe.getShort(off.cost + 2 * 128 * shiftedX + 2 * shiftedY);
							if (altCost < 100) {
								int xDist = 0;
								if (x < request.targetX) {
									xDist = request.targetX - x;
								} else if (x > request.targetX + request.targetSX - 1) {
									xDist = x + 1 - request.targetX - request.targetSX;
								}
								int yDist = 0;
								if (y < request.targetY) {
									yDist = request.targetY - y;
								} else if (y > request.targetSY + request.targetY - 1) {
									yDist = y + 1 - request.targetSY - request.targetY;
								}
								int distance = xDist * xDist + yDist * yDist;
								if (bestDistance > distance || distance == bestDistance && bestCost > altCost) {
									foundY = y;
									foundX = x;
									bestDistance = distance;
									bestCost = altCost;
								}
							}
						}
					}
					
				}
			}
			if (bestDistance == 2147483647) {
//				((Player) entity).moveAngle = Math.random() * 2 * Math.PI; //TODO: remove, temp for bots 
				request.failed = true;
				return;
			}
		} else {
			request.alternative = false;
		}
		int direction;
		request.targetX = foundX;
		request.targetY = foundY;
		while (foundX != startX || startY != foundY) {
			direction = unsafe.getByte(off.parent + 128 * (foundX - shiftX) + (foundY - shiftY));
			steps.addFirst(TRANSLATION[direction]);
			if ((direction & 0x2) != 0) {
				foundX++;
			} else if ((direction & 0x8) != 0) {
				foundX--;
			}
			if ((direction & 0x1) != 0) {
				foundY++;
			} else if ((direction & 0x4) != 0) {
				foundY--;
			}
		}
	}
	
	private final boolean path1(final Offsets off, final int strategy, final int targetX, final int targetY, final int targetSX, final int targetSY, final int objectOrientation, final int blockedDirections) {
		int qRead = 0;
		byte currX = (byte) (64 - loadedX + entity.x);
		byte currY = (byte) (64 - loadedY + entity.z);
		int qWrite = 0;
		final long parent = off.parent;
		final long cost = off.cost;
		final long qx = off.queueX;
		final long qy = off.queueY;
		unsafe.putByte(parent + currX * 128 + currY, (byte) 99);
		unsafe.putShort(cost + 2 * currX * 128 + 2 * currY, (short) 0);
		unsafe.putByte(qx + qWrite, currX);
		unsafe.putByte(qy + qWrite++, currY);
		
		while (qWrite != qRead) {
			currX = unsafe.getByte(qx + qRead);
			currY = unsafe.getByte(qy + qRead++);
			qRead &= 0x3ff;
			if (strategy == -4) {
				//Exact match, normal walking, widget on minimap
				if (targetX == currX && targetY == currY) {
					routeX = currX;
					routeY = currY;
					return true;
				}
			} else if (strategy == -3) {
				//Preferred strategy for ground item interaction. If this fails it falls back to strategy -2
				if (Tile.overlaps(currX, currY, 1, 1, targetX, targetY, targetSX, targetSY)) {
					routeX = currX;
					routeY = currY;
					return true;
				}
			} else if (strategy == -2) {
				//Widget/option on player/npc 
				if (isBordering(currX, currY, 1, 1, targetX, targetY, targetSX, targetSY, blockedDirections)) {
					routeY = currY;
					routeX = currX;
					return true;
				}
			} else if (strategy == -1) {
				//Npcs on lobby use this
				if (isOverlapOrBordering(currX, currY, 1, targetX, targetY, targetSX, targetSY, blockedDirections)) {
					routeY = currY;
					routeX = currX;
					return true;
				}
			} else if (strategy == 0 || strategy == 1 || strategy == 2 || strategy == 3 || strategy == 9) {
				//Object type 0, 1, 2, 3, 9, only 0 2 9 have special clipping checks
				if (isNextToObject(strategy, currX, currY, 1, targetX, targetY, objectOrientation)) {
					routeX = currX;
					routeY = currY;
					return true;
				}
			} else {
				//Other types, has special checks for type 6/7/8 (wall deco)
				if (isNextToWallDecoration(strategy, currX, currY, 1, targetX, targetY, objectOrientation)) {
					routeY = currY;
					routeX = currX;
					return true;
				}
			}
			
			long costAddr = cost + Short.BYTES * currX * 128 + Short.BYTES * currY;
			long parentAddr = parent + currX * 128 + currY;
			long flagAddr = flags + Integer.BYTES * 128 * currX + Integer.BYTES * currY;
			short c = (short) (unsafe.getShort(costAddr) + 1);
			//-1 0
			currX--;
			parentAddr -= 128;
			flagAddr -= Integer.BYTES * 128;
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr) & BLOCK_PATH_W) == 0) {
				unsafe.putByte(parentAddr, (byte) 2);
				unsafe.putShort(costAddr - Short.BYTES * 128, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
			//0 -1
			currX++;
			currY--;
			parentAddr += 128 - 1;
			flagAddr += Integer.BYTES * (128 - 1);
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr) & BLOCK_PATH_S) == 0) {
				unsafe.putByte(parentAddr, (byte) 1);
				unsafe.putShort(costAddr - Short.BYTES * 1, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
			//1 0
			currX++;
			currY++;
			parentAddr += 128 + 1;
			flagAddr += Integer.BYTES * (128 + 1);
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr) & BLOCK_PATH_E) == 0) {
				unsafe.putByte(parentAddr, (byte) 8);
				unsafe.putShort(costAddr + Short.BYTES * 128, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
			//0 1
			currX--;
			currY++;
			parentAddr -= 128 - 1;
			flagAddr -= Integer.BYTES * (128 - 1);
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr) & BLOCK_PATH_N) == 0) {
				unsafe.putByte(parentAddr, (byte) 4);
				unsafe.putShort(costAddr + Short.BYTES * 1, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
			//-1 1
			currX--;
			parentAddr -= 128;
			flagAddr -= Integer.BYTES * 128;
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr) & BLOCK_PATH_NW) == 0 && (unsafe.getInt(flagAddr - Integer.BYTES * 1) & BLOCK_PATH_W) == 0 && (unsafe.getInt(flagAddr + Integer.BYTES * 128) & BLOCK_PATH_N) == 0) {
				unsafe.putByte(parentAddr, (byte) 6);
				unsafe.putShort(costAddr - Short.BYTES * 128 + Short.BYTES * 1, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
			//-1 -1
			currY -= 2;
			parentAddr -= 2;
			flagAddr -= Integer.BYTES * 2;
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr) & BLOCK_PATH_SW) == 0 && (unsafe.getInt(flagAddr + Integer.BYTES * 1) & BLOCK_PATH_W) == 0 && (unsafe.getInt(flagAddr + Integer.BYTES * 128) & BLOCK_PATH_S) == 0) {
				unsafe.putByte(parentAddr, (byte) 3);
				unsafe.putShort(costAddr - Short.BYTES * 128 - Short.BYTES * 1, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
			//+1 -1
			currX += 2;
			parentAddr += 2 * 128;
			flagAddr += Integer.BYTES * 2 * 128;
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr) & BLOCK_PATH_SE) == 0 && (unsafe.getInt(flagAddr + Integer.BYTES * 1) & BLOCK_PATH_E) == 0 && (unsafe.getInt(flagAddr - Integer.BYTES * 128) & BLOCK_PATH_S) == 0) {
				unsafe.putByte(parentAddr, (byte) 9);
				unsafe.putShort(costAddr + Short.BYTES * 128 - Short.BYTES * 1, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
			//+1 +1
			currY += 2;
			parentAddr += 2;
			flagAddr += Integer.BYTES * 2;
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr) & BLOCK_PATH_NE) == 0 && (unsafe.getInt(flagAddr - Integer.BYTES * 1) & BLOCK_PATH_E) == 0 && (unsafe.getInt(flagAddr - Integer.BYTES * 128) & BLOCK_PATH_N) == 0) {
				unsafe.putByte(parentAddr, (byte) 12);
				unsafe.putShort(costAddr + Short.BYTES * 128 + Short.BYTES * 1, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
		}
		routeY = targetY;
		routeX = targetX;
		return false;
	}
	
	private final boolean path2(final Offsets off, int strategy, int targetX, int targetY, int s1, int s2, int orientation, int allowedDirections) {
		int qRead = 0;
		byte currX = (byte) (64 - loadedX + entity.x);
		byte currY = (byte) (64 - loadedY + entity.z);
		int qWrite = 0;
		final long parent = off.parent;
		final long cost = off.cost;
		final long qx = off.queueX;
		final long qy = off.queueY;
		unsafe.putByte(parent + currX * 128 + currY, (byte) 99);
		unsafe.putShort(cost + 2 * currX * 128 + 2 * currY, (short) 0);
		unsafe.putByte(qx + qWrite, currX);
		unsafe.putByte(qy + qWrite++, currY);
		while (qWrite != qRead) {
			currX = unsafe.getByte(qx + qRead);
			currY = unsafe.getByte(qy + qRead++);
			qRead &= 0x3ff;
			if (strategy == -4) {
				if (targetX == currX && currY == targetY) {
					routeX = currX;
					routeY = currY;
					return true;
				}
			} else if (strategy == -3) {
				if (Tile.overlaps(currX, currY, 2, 2, targetX, targetY, s1, s2)) {
					routeY = currY;
					routeX = currX;
					return true;
				}
			} else if (strategy == -2) {
				if (isBordering(currX, currY, 2, 2, targetX, targetY, s1, s2, allowedDirections)) {
					routeY = currY;
					routeX = currX;
					return true;
				}
			} else if (strategy == -1) {
				if (isOverlapOrBordering(currX, currY, 2, targetX, targetY, s1, s2, allowedDirections)) {
					routeY = currY;
					routeX = currX;
					return true;
				}
			} else if (strategy == 0 || strategy == 1 || strategy == 2 || strategy == 3 || strategy == 9) {
				if (isNextToObject(strategy, currX, currY, 2, targetX, targetY, orientation)) {
					routeX = currX;
					routeY = currY;
					return true;
				}
			} else {
				if (isNextToWallDecoration(strategy, currX, currY, 2, targetX, targetY, orientation)) {
					routeY = currY;
					routeX = currX;
					return true;
				}
			}
			
			long costAddr = cost + Short.BYTES * currX * 128 + Short.BYTES * currY;
			long parentAddr = parent + currX * 128 + currY;
			long flagAddr = flags + Integer.BYTES * 128 * currX + Integer.BYTES * currY;
			short c = (short) (unsafe.getShort(costAddr) + 1);
			
			//_|* *
			// |x *
			
			//-1 0
			currX--;
			parentAddr -= 128;
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(-1, 0)) & BLOCK_PATH_SW) == 0 && (unsafe.getInt(flagAddr + i(-1, 1)) & BLOCK_PATH_NW) == 0) {
				unsafe.putByte(parentAddr, (byte) 2);
				unsafe.putShort(costAddr - Short.BYTES * 128, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
			//0 -1
			currX++;
			currY--;
			parentAddr += 128 - 1;
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(0, -1)) & BLOCK_PATH_SW) == 0 && (unsafe.getInt(flagAddr + i(+1, -1)) & BLOCK_PATH_SE) == 0) {
				unsafe.putByte(parentAddr, (byte) 1);
				unsafe.putShort(costAddr - Short.BYTES * 1, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
			//1 0
			currX++;
			currY++;
			parentAddr += 128 + 1;
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(2, 0)) & BLOCK_PATH_SE) == 0 && (unsafe.getInt(flagAddr + i(2, 1)) & BLOCK_PATH_NE) == 0) {
				unsafe.putByte(parentAddr, (byte) 8);
				unsafe.putShort(costAddr + Short.BYTES * 128, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
			//0 +1
			currX--;
			currY++;
			parentAddr -= 128 - 1;
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(0, 2)) & BLOCK_PATH_NW) == 0 && (unsafe.getInt(flagAddr + i(1, 2)) & BLOCK_PATH_NE) == 0) {
				unsafe.putByte(parentAddr, (byte) 4);
				unsafe.putShort(costAddr + Short.BYTES * 1, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
			//-1 +1
			currX--;
			parentAddr -= 128;
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(-1, 1)) & BLOCK_PATH_W_BIG) == 0 && (unsafe.getInt(flagAddr + i(-1, 2)) & BLOCK_PATH_NW) == 0 && (unsafe.getInt(flagAddr + i(0, 2)) & BLOCK_PATH_N_BIG) == 0) {
				unsafe.putByte(parentAddr, (byte) 6);
				unsafe.putShort(costAddr - Short.BYTES * 128 + Short.BYTES * 1, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
			//-1 -1
			currY -= 2;
			parentAddr -= 2;
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(-1, 0)) & BLOCK_PATH_W_BIG) == 0 && (unsafe.getInt(flagAddr + i(-1, -1)) & BLOCK_PATH_SW) == 0 && (unsafe.getInt(flagAddr + i(0, -1)) & BLOCK_PATH_S_BIG) == 0) {
				unsafe.putByte(parentAddr, (byte) 3);
				unsafe.putShort(costAddr - Short.BYTES * 128 - Short.BYTES * 1, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
			//+1 -1
			currX += 2;
			parentAddr += 2 * 128;
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(+1, -1)) & BLOCK_PATH_S_BIG) == 0 && (unsafe.getInt(flagAddr + i(+2, -1)) & BLOCK_PATH_SE) == 0 && (unsafe.getInt(flagAddr + i(2, 0)) & BLOCK_PATH_E_BIG) == 0) {
				unsafe.putByte(parentAddr, (byte) 9);
				unsafe.putShort(costAddr + Short.BYTES * 128 - Short.BYTES * 1, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
			//+1 +1
			currY += 2;
			parentAddr += 2;
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(+1, +2)) & BLOCK_PATH_N_BIG) == 0 && (unsafe.getInt(flagAddr + i(+2, +2)) & BLOCK_PATH_NE) == 0 && (unsafe.getInt(flagAddr + i(+2, +1)) & BLOCK_PATH_E_BIG) == 0) {
				unsafe.putByte(parentAddr, (byte) 12);
				unsafe.putShort(costAddr + Short.BYTES * 128 + Short.BYTES * 1, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
		}
		routeY = currY;
		routeX = currX;
		return false;
	}
	
	private final boolean pathN(final Offsets off, int strategy, int targetX, int targetY, int s1, int s2, int orientation, int allowedDirections, int unitSize) {
		int qRead = 0;
		byte currX = (byte) (64 - loadedX + entity.x);
		byte currY = (byte) (64 - loadedY + entity.z);
		int qWrite = 0;
		final long parent = off.parent;
		final long cost = off.cost;
		final long qx = off.queueX;
		final long qy = off.queueY;
		unsafe.putByte(parent + currX * 128 + currY, (byte) 99);
		unsafe.putShort(cost + 2 * currX * 128 + 2 * currY, (short) 0);
		unsafe.putByte(qx + qWrite, currX);
		unsafe.putByte(qy + qWrite++, currY);
		queueLoop:
		while (qWrite != qRead) {
			currX = unsafe.getByte(qx + qRead);
			currY = unsafe.getByte(qy + qRead++);
			qRead &= 0x3ff;
			if (strategy == -4) {
				if (targetX == currX && currY == targetY) {
					routeX = currX;
					routeY = currY;
					return true;
				}
			} else if (strategy == -3) {
				if (Tile.overlaps(currX, currY, unitSize, unitSize, targetX, targetY, s1, s2)) {
					routeY = currY;
					routeX = currX;
					return true;
				}
			} else if (strategy == -2) {
				if (isBordering(currX, currY, unitSize, unitSize, targetX, targetY, s1, s2, allowedDirections)) {
					routeY = currY;
					routeX = currX;
					return true;
				}
			} else if (strategy == -1) {
				if (isOverlapOrBordering(currX, currY, unitSize, targetX, targetY, s1, s2, allowedDirections)) {
					routeY = currY;
					routeX = currX;
					return true;
				}
			} else if (strategy == 0 || strategy == 1 || strategy == 2 || strategy == 3 || strategy == 9) {
				if (isNextToObject(strategy, currX, currY, unitSize, targetX, targetY, orientation)) {
					routeX = currX;
					routeY = currY;
					return true;
				}
			} else {
				if (isNextToWallDecoration(strategy, currX, currY, 2, targetX, targetY, orientation)) {
					routeY = currY;
					routeX = currX;
					return true;
				}
			}
			long costAddr = cost + Short.BYTES * currX * 128 + Short.BYTES * currY;
			long parentAddr = parent + currX * 128 + currY;
			long flagAddr = flags + Integer.BYTES * 128 * currX + Integer.BYTES * currY;
			short c = (short) (unsafe.getShort(costAddr) + 1);
			//-1 0
			currX--;
			parentAddr -= 128;
			exit:
			do {
				//Example checking going west, enter NW top sq, SW bottom square, NSW middle squares
				//_|x x x
				//_|x x x
				// |* x x
				if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(-1, 0)) & BLOCK_PATH_SW) == 0 && (unsafe.getInt(flagAddr + i(-1, unitSize - 1)) & BLOCK_PATH_NW) == 0) {
					for (int i_39_ = 1; i_39_ < unitSize - 1; i_39_++) {
						if ((unsafe.getInt(flagAddr + i(-1, i_39_)) & BLOCK_PATH_W_BIG) != 0) {
							break exit;
						}
					}
					unsafe.putByte(parentAddr, (byte) 2);
					unsafe.putShort(costAddr - Short.BYTES * 128, c);
					unsafe.putByte(qx + qWrite, currX);
					unsafe.putByte(qy + qWrite++, currY);
					qWrite &= 0x3ff;
				}
			} while (false);
			//0 -1
			currX++;
			currY--;
			parentAddr += 128 - 1;
			exit:
			do {
				if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(0, -1)) & BLOCK_PATH_SW) == 0 && (unsafe.getInt(flagAddr + i(unitSize - 1, -1)) & BLOCK_PATH_SE) == 0) {
					for (int i_41_ = 1; -1 + unitSize > i_41_; i_41_++) {
						if ((unsafe.getInt(flagAddr + i(i_41_, -1)) & BLOCK_PATH_S_BIG) != 0) {
							break exit;
						}
					}
					unsafe.putByte(parentAddr, (byte) 1);
					unsafe.putShort(costAddr - Short.BYTES * 1, c);
					unsafe.putByte(qx + qWrite, currX);
					unsafe.putByte(qy + qWrite++, currY);
					qWrite &= 0x3ff;
				}
			} while (false);
			//+1 0
			currX++;
			currY++;
			parentAddr += 128 + 1;
			exit:
			do {
				if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(unitSize, 0)) & BLOCK_PATH_SE) == 0 && (unsafe.getInt(flagAddr + i(unitSize, unitSize - 1)) & BLOCK_PATH_NE) == 0) {
					for (int i_40_ = 1; unitSize - 1 > i_40_; i_40_++) {
						if ((unsafe.getInt(flagAddr + i(unitSize, i_40_)) & BLOCK_PATH_E_BIG) != 0) {
							break exit;
						}
					}
					unsafe.putByte(parentAddr, (byte) 8);
					unsafe.putShort(costAddr + Short.BYTES * 128, c);
					unsafe.putByte(qx + qWrite, currX);
					unsafe.putByte(qy + qWrite++, currY);
					qWrite &= 0x3ff;
				}
			} while (false);
			//0 +1
			currX--;
			currY++;
			parentAddr -= 128 - 1;
			exit:
			do {
				if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(0, unitSize)) & BLOCK_PATH_NW) == 0 && (unsafe.getInt(flagAddr + i(unitSize - 1, unitSize)) & BLOCK_PATH_NE) == 0) {
					for (int i_42_ = 1; unitSize - 1 > i_42_; i_42_++) {
						if ((unsafe.getInt(flagAddr + i(i_42_, unitSize)) & BLOCK_PATH_N_BIG) != 0) {
							break exit;
						}
					}
					unsafe.putByte(parentAddr, (byte) 4);
					unsafe.putShort(costAddr + Short.BYTES * 1, c);
					unsafe.putByte(qx + qWrite, currX);
					unsafe.putByte(qy + qWrite++, currY);
					qWrite &= 0x3ff;
				}
			} while (false);
			//-1 +1
			currX--;
			parentAddr -= 128;
			exit:
			do {
				if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(-1, unitSize)) & BLOCK_PATH_NW) == 0) {
					for (int i_45_ = 1; i_45_ < unitSize; i_45_++) {
						if ((unsafe.getInt(flagAddr + i(-1, i_45_)) & BLOCK_PATH_W_BIG) != 0 || (unsafe.getInt(flagAddr + i(i_45_ - 1, unitSize)) & BLOCK_PATH_N_BIG) != 0) {
							break exit;
						}
					}
					unsafe.putByte(parentAddr, (byte) 6);
					unsafe.putShort(costAddr - Short.BYTES * 128 + Short.BYTES * 1, c);
					unsafe.putByte(qx + qWrite, currX);
					unsafe.putByte(qy + qWrite++, currY);
					qWrite &= 0x3ff;
				}
			} while (false);
			//-1 -1
			currY -= 2;
			parentAddr -= 2;
			exit:
			do {
				if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(-1, -1)) & BLOCK_PATH_SW) == 0) {
					for (int i_43_ = 1; i_43_ < unitSize; i_43_++) {
						if ((unsafe.getInt(flagAddr + i(-1, i_43_ - 1)) & BLOCK_PATH_W_BIG) != 0 || (unsafe.getInt(flagAddr + i(i_43_ - 1, -1)) & BLOCK_PATH_S_BIG) != 0) {
							break exit;
						}
					}
					unsafe.putByte(parentAddr, (byte) 3);
					unsafe.putShort(costAddr - Short.BYTES * 128 - Short.BYTES * 1, c);
					unsafe.putByte(qx + qWrite, currX);
					unsafe.putByte(qy + qWrite++, currY);
					qWrite &= 0x3ff;
				}
			} while (false);
			//1 -1
			currX += 2;
			parentAddr += 2 * 128;
			exit:
			do {
				if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(unitSize, -1)) & BLOCK_PATH_SE) == 0) {
					for (int i_44_ = 1; i_44_ < unitSize; i_44_++) {
						if ((unsafe.getInt(flagAddr + i(unitSize, i_44_ - 1)) & BLOCK_PATH_E_BIG) != 0 || (unsafe.getInt(flagAddr + i(i_44_, -1)) & BLOCK_PATH_S_BIG) != 0) {
							break exit;
						}
					}
					unsafe.putByte(parentAddr, (byte) 9);
					unsafe.putShort(costAddr + Short.BYTES * 128 - Short.BYTES * 1, c);
					unsafe.putByte(qx + qWrite, currX);
					unsafe.putByte(qy + qWrite++, currY);
					qWrite &= 0x3ff;
				}
			} while (false);
			//+1 +1
			currY += 2;
			parentAddr += 2;
			if (unsafe.getByte(parentAddr) == 0 && (unsafe.getInt(flagAddr + i(unitSize, unitSize)) & BLOCK_PATH_NE) == 0) {
				for (int i_46_ = 1; unitSize > i_46_; i_46_++) {
					if ((unsafe.getInt(flagAddr + i(i_46_, unitSize)) & BLOCK_PATH_N_BIG) != 0 || (unsafe.getInt(flagAddr + i(unitSize, i_46_)) & BLOCK_PATH_E_BIG) != 0) {
						continue queueLoop;
					}
				}
				unsafe.putByte(parentAddr, (byte) 12);
				unsafe.putShort(costAddr + Short.BYTES * 128 + Short.BYTES * 1, c);
				unsafe.putByte(qx + qWrite, currX);
				unsafe.putByte(qy + qWrite++, currY);
				qWrite &= 0x3ff;
			}
		}
		routeY = currY;
		routeX = currX;
		return false;
	}
	
	/**
	 * Convert row and column value to memory offset for an 128x128 integer array
	 */
	private final long i(int x, int y) {
		//There are about 50 or so calls to this with constant values, i think javac won't do compile time function execution though?
		//They also arn't in the path1 method, which is the most important one, so i guess it doesn't really matter.
		return Integer.BYTES * 128 * x + Integer.BYTES * y;
	}
	
	/**
	 * Check if 2 rectangles touch each other in any fashion but do not overlap.
	 * <p>
	 * For example:
	 * <p>
	 * <pre>
	 *  __
	 * |  | _
	 * |__||_|
	 * </pre>
	 */
	final boolean isBordering(int x1, int y1, int unitSizeX, int unitSizeY, int tx1, int ty1, int targetSizeX, int targetSizeY, int blockedDirections) {
		int x2 = unitSizeX + x1;
		int y2 = unitSizeY + y1;
		int tx2 = targetSizeX + tx1;
		int ty2 = targetSizeY + ty1;
		long flags = this.flags;
		if (x1 == tx2 && (0x2 & blockedDirections) == 0) {
			//We are directly east to it
			int yLow = ty1 >= y1 ? ty1 : y1; //take the highest bottom of the 2 rectangles
			int yHigh = y2 >= ty2 ? ty2 : y2; //take the lowest top of the 2 rectangles
			while (yLow < yHigh) { //If the rectangles are not bordering, the highest bottom is lower than the lowest top and it won't loop at all!
				if ((unsafe.getInt(flags + i(tx2 - 1, yLow)) & E_WALL) == 0) {
					return true;
				}
				yLow++;
			}
		} else if (tx1 == x2 && (blockedDirections & 0x8) == 0) {
			int yLow = y1 <= ty1 ? ty1 : y1;
			for (int yHigh = y2 >= ty2 ? ty2 : y2; yHigh > yLow; yLow++) {
				if ((unsafe.getInt(flags + i(tx1, yLow)) & W_WALL) == 0) {
					return true;
				}
			}
		} else if (ty2 == y1 && (0x1 & blockedDirections) == 0) {
			int xLow = x1 <= tx1 ? tx1 : x1;
			for (int xHigh = tx2 <= x2 ? tx2 : x2; xLow < xHigh; xLow++) {
				if ((unsafe.getInt(flags + i(xLow, ty2 - 1)) & N_WALL) == 0) {
					return true;
				}
			}
		} else if (y2 == ty1 && (0x4 & blockedDirections) == 0) {
			int xLow = tx1 < x1 ? x1 : tx1;
			for (int xHigh = tx2 <= x2 ? tx2 : x2; xHigh > xLow; xLow++) {
				if ((unsafe.getInt(flags + i(xLow, ty1)) & S_WALL) == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	final boolean isOverlapOrBordering(int x, int y, int unitSize, int tx1, int ty1, int targetSizeX, int targetSizeY, int blockedDirections) {
		if (unitSize > 1) {
			if (Tile.overlaps(x, y, unitSize, unitSize, tx1, ty1, targetSizeX, targetSizeY)) {
				return true;
			}
			return isBordering(x, y, unitSize, unitSize, tx1, ty1, targetSizeX, targetSizeY, blockedDirections);
		}
		int tx2 = targetSizeX + tx1 - 1;
		int ty2 = targetSizeY + ty1 - 1;
		int flag = unsafe.getInt(flags + i(x, y));
		//Overlap
		if (x >= tx1 && tx2 >= x && ty1 <= y && y <= ty2) {
			return true;
		}
		//Or bordering....
		if (x == tx1 - 1 && y >= ty1 && y <= ty2 && (flag & E_WALL) == 0 && (blockedDirections & 0x8) == 0) {
			return true;
		}
		if (x == tx2 + 1 && ty1 <= y && ty2 >= y && (flag & W_WALL) == 0 && (blockedDirections & 0x2) == 0) {
			return true;
		}
		if (ty1 - 1 == y && x >= tx1 && x <= tx2 && (flag & N_WALL) == 0 && (blockedDirections & 0x4) == 0) {
			return true;
		}
		if (y == ty2 + 1 && x >= tx1 && x <= tx2 && (flag & S_WALL) == 0 && (blockedDirections & 0x1) == 0) {
			return true;
		}
		return false;
	}
	
	final boolean isNextToObject(int type, final int x1, final int y1, int unitSize, int tx, int ty, int orientation) {
		//If overlap...
		if (unitSize == 1) {
			if (tx == x1 && y1 == ty) {
				return true;
			}
		} else if (tx >= x1 && tx <= x1 + unitSize - 1 && y1 <= ty && ty <= -1 + unitSize + y1) {
			//WAS && ty >= ty && -1 + ty + unitSize >= ty STILL BROKEN IN RSBETA DEOB SHOULD BE  && y1 <= ty && ty <= -1 + unitSize + y1
			return true;
		}
		//Or...
		if (unitSize == 1) {
			final int flag = unsafe.getInt(flags + i(x1, y1));
			if (type == 0) { //Solid object or I wall
				if (orientation == 0) { //West wall
					if (x1 == tx - 1 && y1 == ty) { //Check if we are on the west tile
						return true;
					}
					//north of it
					if (x1 == tx && y1 == ty + 1 && (flag & BLOCK_PATH_N_SIDE) == 0) { //TILE_BLOCKED | S_INT | OBS_INT | FL_DECO | 0x80000 UNUSED
						return true;
					}
					//south of it
					if (x1 == tx && y1 == ty - 1 && (flag & BLOCK_PATH_S_SIDE) == 0) { //... N_INT
						return true;
					}
				} else if (orientation == 1) { //North
					if (tx == x1 && ty + 1 == y1) {
						return true;
					}
					if (tx - 1 == x1 && y1 == ty && (flag & BLOCK_PATH_W_SIDE) == 0) {
						return true;
					}
					if (x1 == tx + 1 && ty == y1 && (flag & BLOCK_PATH_E_SIDE) == 0) {
						return true;
					}
				} else if (orientation == 2) { //East
					if (x1 == tx + 1 && y1 == ty) {
						return true;
					}
					if (tx == x1 && y1 == ty + 1 && (flag & BLOCK_PATH_N_SIDE) == 0) {
						return true;
					}
					if (tx == x1 && ty - 1 == y1 && (flag & BLOCK_PATH_S_SIDE) == 0) {
						return true;
					}
				} else if (orientation == 3) { //South
					if (tx == x1 && y1 == ty - 1) {
						return true;
					}
					if (x1 == tx - 1 && ty == y1 && (flag & BLOCK_PATH_W_SIDE) == 0) {
						return true;
					}
					if (x1 == tx + 1 && ty == y1 && (flag & BLOCK_PATH_E_SIDE) == 0) {
						return true;
					}
				}
			}
			if (type == 2) { //L wall
				if (orientation == 0) { //West and north
					if (x1 == tx - 1 && ty == y1) { //West
						return true;
					}
					if (tx == x1 && y1 == ty + 1) { //Or north
						return true;
					}
					if (x1 == tx + 1 && ty == y1 && (flag & BLOCK_PATH_E_SIDE) == 0) {
						return true;
					}
					if (tx == x1 && ty - 1 == y1 && (flag & BLOCK_PATH_S_SIDE) == 0) {
						return true;
					}
				} else if (orientation == 1) {
					if (x1 == tx - 1 && y1 == ty && (flag & BLOCK_PATH_W_SIDE) == 0) {
						return true;
					}
					if (x1 == tx && y1 == ty + 1) {
						return true;
					}
					if (x1 == tx + 1 && y1 == ty) {
						return true;
					}
					if (tx == x1 && y1 == ty - 1 && (flag & BLOCK_PATH_S_SIDE) == 0) {
						return true;
					}
				} else if (orientation == 2) {
					if (tx - 1 == x1 && ty == y1 && (flag & BLOCK_PATH_W_SIDE) == 0) {
						return true;
					}
					if (tx == x1 && ty + 1 == y1 && (flag & BLOCK_PATH_N_SIDE) == 0) {
						return true;
					}
					if (tx + 1 == x1 && y1 == ty) {
						return true;
					}
					if (tx == x1 && ty - 1 == y1) {
						return true;
					}
				} else if (orientation == 3) {
					if (tx - 1 == x1 && y1 == ty) {
						return true;
					}
					if (x1 == tx && y1 == ty + 1 && (flag & BLOCK_PATH_N_SIDE) == 0) {
						return true;
					}
					if (x1 == tx + 1 && ty == y1 && (flag & BLOCK_PATH_E_SIDE) == 0) {
						return true;
					}
					if (tx == x1 && ty - 1 == y1) {
						return true;
					}
				}
			}
			if (type == 9) { //Diagonal
				if (tx == x1 && ty + 1 == y1 && (flag & S_WALL) == 0) {
					return true;
				}
				if (tx == x1 && ty - 1 == y1 && (flag & N_WALL) == 0) {
					return true;
				}
				if (tx - 1 == x1 && ty == y1 && (flag & E_WALL) == 0) {
					return true;
				}
				if (tx + 1 == x1 && ty == y1 && (flag & W_WALL) == 0) {
					return true;
				}
			}
		} else {
			int x2 = -1 + unitSize + x1;
			int y2 = -1 + unitSize + y1;
			if (type == 0) {
				if (orientation == 0) {
					if (tx - unitSize == x1 && ty >= y1 && ty <= y2) {
						return true;
					}
					if (tx >= x1 && x2 >= tx && ty + 1 == y1 && (unsafe.getInt(flags + i(tx, y1)) & BLOCK_PATH_N_SIDE) == 0) {
						return true;
					}
					if (tx >= x1 && x2 >= tx && ty - unitSize == y1 && (unsafe.getInt(flags + i(tx, y2)) & BLOCK_PATH_S_SIDE) == 0) {
						return true;
					}
				} else if (orientation == 1) {
					if (tx >= x1 && x2 >= tx && ty + 1 == y1) {
						return true;
					}
					if (x1 == tx - unitSize && ty >= y1 && ty <= y2 && (unsafe.getInt(flags + i(x2, ty)) & BLOCK_PATH_W_SIDE) == 0) {
						return true;
					}
					if (tx + 1 == x1 && ty >= y1 && y2 >= ty && (unsafe.getInt(flags + i(x1, ty)) & BLOCK_PATH_E_SIDE) == 0) {
						return true;
					}
				} else if (orientation == 2) {
					if (tx + 1 == x1 && y1 <= ty && ty <= y2) {
						return true;
					}
					if (tx >= x1 && tx <= x2 && y1 == ty + 1 && (unsafe.getInt(flags + i(tx, y1)) & BLOCK_PATH_N_SIDE) == 0) {
						return true;
					}
					if (x1 <= tx && x2 >= tx && ty - unitSize == y1 && (unsafe.getInt(flags + i(tx, y2)) & BLOCK_PATH_S_SIDE) == 0) {
						return true;
					}
				} else if (orientation == 3) {
					if (tx >= x1 && tx <= x2 && y1 == ty - unitSize) {
						return true;
					}
					if (x1 == tx - unitSize && ty >= y1 && ty <= y2 && (unsafe.getInt(flags + i(x2, ty)) & BLOCK_PATH_W_SIDE) == 0) {
						return true;
					}
					if (x1 == tx + 1 && y1 <= ty && y2 >= ty && (unsafe.getInt(flags + i(x1, ty)) & BLOCK_PATH_E_SIDE) == 0) {
						return true;
					}
				}
			}
			if (type == 2) {
				if (orientation == 0) {
					if (tx - unitSize == x1 && y1 <= ty && ty <= y2) {
						return true;
					}
					if (tx >= x1 && x2 >= tx && y1 == ty + 1) {
						return true;
					}
					if (x1 == tx + 1 && ty >= y1 && ty <= y2 && (unsafe.getInt(flags + i(x1, ty)) & BLOCK_PATH_E_SIDE) == 0) {
						return true;
					}
					if (tx >= x1 && tx <= x2 && y1 == ty - unitSize && (unsafe.getInt(flags + i(tx, y2)) & BLOCK_PATH_S_SIDE) == 0) {
						return true;
					}
				} else if (orientation == 1) {
					if (x1 == tx - unitSize && y1 <= ty && ty <= y2 && (unsafe.getInt(flags + i(x2, ty)) & BLOCK_PATH_W_SIDE) == 0) {
						return true;
					}
					if (tx >= x1 && x2 >= tx && y1 == ty + 1) {
						return true;
					}
					if (tx + 1 == x1 && y1 <= ty && y2 >= ty) {
						return true;
					}
					if (x1 <= tx && x2 >= tx && ty - unitSize == y1 && (unsafe.getInt(flags + i(tx, y2)) & BLOCK_PATH_S_SIDE) == 0) {
						return true;
					}
				} else if (orientation == 2) {
					if (x1 == tx - unitSize && ty >= y1 && y2 >= ty && (unsafe.getInt(flags + i(x2, ty)) & BLOCK_PATH_W_SIDE) == 0) {
						return true;
					}
					if (tx >= x1 && tx <= x2 && ty + 1 == y1 && (unsafe.getInt(flags + i(tx, y1)) & BLOCK_PATH_N_SIDE) == 0) {
						return true;
					}
					if (tx + 1 == x1 && ty >= y1 && y2 >= ty) {
						return true;
					}
					if (tx >= x1 && x2 >= tx && y1 == ty - unitSize) {
						return true;
					}
				} else if (orientation == 3) {
					if (tx - unitSize == x1 && ty >= y1 && y2 >= ty) {
						return true;
					}
					if (x1 <= tx && x2 >= tx && y1 == ty + 1 && (unsafe.getInt(flags + i(tx, y1)) & BLOCK_PATH_N_SIDE) == 0) {
						return true;
					}
					if (x1 == tx + 1 && y1 <= ty && ty <= y2 && (unsafe.getInt(flags + i(x1, ty)) & BLOCK_PATH_E_SIDE) == 0) {
						return true;
					}
					if (x1 <= tx && tx <= x2 && y1 == ty - unitSize) {
						return true;
					}
				}
			}
			if (type == 9) {
				if (x1 <= tx && tx <= x2 && ty + 1 == y1 && (unsafe.getInt(flags + i(tx, y1)) & BLOCK_PATH_N_SIDE) == 0) {
					return true;
				}
				if (tx >= x1 && x2 >= tx && ty - unitSize == y1 && (unsafe.getInt(flags + i(tx, y2)) & BLOCK_PATH_S_SIDE) == 0) {
					return true;
				}
				if (x1 == tx - unitSize && ty >= y1 && y2 >= ty && (unsafe.getInt(flags + i(x2, ty)) & BLOCK_PATH_W_SIDE) == 0) {
					return true;
				}
				if (tx + 1 == x1 && y1 <= ty && y2 >= ty && (unsafe.getInt(flags + i(x1, ty)) & BLOCK_PATH_E_SIDE) == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	final boolean isNextToWallDecoration(int type, int x1, int y1, int unitSize, int tx, int ty, int torientation) {
		//If overlap..
		if (unitSize == 1) {
			if (tx == x1 && y1 == ty) {
				return true;
			}
		} else if (tx >= x1 && tx <= -1 + unitSize + x1 && y1 <= ty && ty <= -1 + unitSize + y1) {
			//y check was && ty <= ty && ty <= -1 + unitSize + ty STILL BROKEN IN RSBETA DEOB SHOULD BE  && y1 <= ty && ty <= -1 + unitSize + y1
			return true;
		}
		//Wall decoration 6/7/8
		if (unitSize == 1) {
			final int flag = unsafe.getInt(flags + i(x1, y1));
			if (type == 6 || type == 7) {
				if (type == 7) {
					torientation = 0x3 & torientation + 2;
				}
				if (torientation == 0) {
					if (tx + 1 == x1 && ty == y1 && (flag & W_WALL) == 0) {
						return true;
					}
					if (x1 == tx && y1 == ty - 1 && (flag & N_WALL) == 0) {
						return true;
					}
				} else if (torientation == 1) {
					if (x1 == tx - 1 && ty == y1 && (flag & E_WALL) == 0) {
						return true;
					}
					if (tx == x1 && ty - 1 == y1 && (flag & N_WALL) == 0) {
						return true;
					}
				} else if (torientation == 2) {
					if (tx - 1 == x1 && y1 == ty && (flag & E_WALL) == 0) {
						return true;
					}
					if (tx == x1 && y1 == ty + 1 && (flag & S_WALL) == 0) {
						return true;
					}
				} else if (torientation == 3) {
					if (x1 == tx + 1 && ty == y1 && (flag & W_WALL) == 0) {
						return true;
					}
					if (tx == x1 && ty + 1 == y1 && (flag & S_WALL) == 0) {
						return true;
					}
				}
			}
			if (type == 8) {
				if (tx == x1 && ty + 1 == y1 && (flag & S_WALL) == 0) {
					return true;
				}
				if (tx == x1 && ty - 1 == y1 && (flag & N_WALL) == 0) {
					return true;
				}
				if (tx - 1 == x1 && y1 == ty && (flag & E_WALL) == 0) {
					return true;
				}
				if (x1 == tx + 1 && ty == y1 && (flag & W_WALL) == 0) {
					return true;
				}
			}
		} else {
			int x2 = unitSize + x1 - 1;
			int y2 = -1 + y1 + unitSize;
			if (type == 6 || type == 7) {
				if (type == 7) {
					torientation = torientation + 2 & 0x3;
				}
				if (torientation == 0) {
					if (x1 == tx + 1 && y1 <= ty && y2 >= ty && (unsafe.getInt(flags + i(x1, ty)) & W_WALL) == 0) {
						return true;
					}
					if (x1 <= tx && tx <= x2 && ty - unitSize == y1 && (unsafe.getInt(flags + i(tx, y2)) & N_WALL) == 0) {
						return true;
					}
				} else if (torientation == 1) {
					if (x1 == tx - unitSize && y1 <= ty && ty <= y2 && (unsafe.getInt(flags + i(x2, ty)) & E_WALL) == 0) {
						return true;
					}
					if (tx >= x1 && tx <= x2 && y1 == ty - unitSize && (unsafe.getInt(flags + i(tx, y2)) & N_WALL) == 0) {
						return true;
					}
				} else if (torientation == 2) {
					if (tx - unitSize == x1 && y1 <= ty && ty <= y2 && (unsafe.getInt(flags + i(x2, ty)) & E_WALL) == 0) {
						return true;
					}
					if (x1 <= tx && tx <= x2 && y1 == ty + 1 && (unsafe.getInt(flags + i(tx, y1)) & S_WALL) == 0) {
						return true;
					}
				} else if (torientation == 3) {
					if (tx + 1 == x1 && ty >= y1 && ty <= y2 && (unsafe.getInt(flags + i(x1, ty)) & W_WALL) == 0) {
						return true;
					}
					if (tx >= x1 && tx <= x2 && y1 == ty + 1 && (unsafe.getInt(flags + i(tx, y1)) & S_WALL) == 0) {
						return true;
					}
				}
			}
			if (type == 8) {
				if (tx >= x1 && tx <= x2 && ty + 1 == y1 && (unsafe.getInt(flags + i(tx, y1)) & S_WALL) == 0) {
					return true;
				}
				if (x1 <= tx && tx <= x2 && y1 == ty - unitSize && (unsafe.getInt(flags + i(tx, y2)) & N_WALL) == 0) {
					return true;
				}
				if (x1 == tx - unitSize && ty >= y1 && ty <= y2 && (unsafe.getInt(flags + i(x2, ty)) & E_WALL) == 0) {
					return true;
				}
				if (x1 == tx + 1 && ty >= y1 && y2 >= ty && (unsafe.getInt(flags + i(x1, ty)) & W_WALL) == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean legal(World world, Tile from, Direction d, int unitSize) {
		recenter();
		int currX = 64 - loadedX + from.x;
		int currY = 64 - loadedY + from.z;
		long flagAddr = flags + Integer.BYTES * 128 * currX + Integer.BYTES * currY;
		if (unitSize == 1) {
			int dx = d.x;
			int dy = d.y;
			if (dx == -1 && (unsafe.getInt(flagAddr + i(-1, 0)) & BLOCK_ENTER_W) != 0) {
				return false;
			}
			if (dx == 1 && (unsafe.getInt(flagAddr + i(+1, 0)) & BLOCK_ENTER_E) != 0) {
				return false;
				
			}
			if (dy == -1 && (unsafe.getInt(flagAddr + i(0, -1)) & BLOCK_ENTER_S) != 0) {
				return false;
				
			}
			if (dy == 1 && (unsafe.getInt(flagAddr + i(0, 1)) & BLOCK_ENTER_N) != 0) {
				return false;
				
			}
			if (dx == -1 && dy == -1 && (unsafe.getInt(flagAddr + i(-1, -1)) & BLOCK_ENTER_SW) != 0) {
				return false;
				
			}
			if (dx == 1 && dy == -1 && (unsafe.getInt(flagAddr + i(1, -1)) & BLOCK_ENTER_SE) != 0) {
				return false;
				
			}
			if (dx == -1 && dy == 1 && (unsafe.getInt(flagAddr + i(-1, +1)) & BLOCK_ENTER_NW) != 0) {
				return false;
				
			}
			if (dx == 1 && dy == 1 && (unsafe.getInt(flagAddr + i(+1, +1)) & BLOCK_ENTER_NE) != 0) {
				return false;
				
			}
		} else {
			switch (d) {
				case West:
					if ((unsafe.getInt(flagAddr + i(-1, 0)) & BLOCK_ENTER_SW) != 0 || (unsafe.getInt(flagAddr + i(-1, unitSize - 1)) & BLOCK_ENTER_NW) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize - 1; mid++) {
						if ((unsafe.getInt(flagAddr + i(-1, mid)) & BLOCK_ENTER_W_BIG) != 0) {
							return false;
						}
					}
					return true;
				case East:
					if ((unsafe.getInt(flagAddr + i(unitSize, 0)) & BLOCK_ENTER_SE) != 0 || (unsafe.getInt(flagAddr + i(unitSize, unitSize - 1)) & BLOCK_ENTER_NE) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize - 1; mid++) {
						if ((unsafe.getInt(flagAddr + i(unitSize, mid)) & BLOCK_ENTER_E_BIG) != 0) {
							return false;
						}
					}
					return true;
				case South:
					if ((unsafe.getInt(flagAddr + i(0, -1)) & BLOCK_ENTER_SW) != 0 || (unsafe.getInt(flagAddr + i(unitSize - 1, -1)) & BLOCK_ENTER_SE) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize - 1; mid++) {
						if ((unsafe.getInt(flagAddr + i(mid, -1)) & BLOCK_ENTER_S_BIG) != 0) {
							return false;
						}
					}
					return true;
				case North:
					if ((unsafe.getInt(flagAddr + i(0, unitSize)) & BLOCK_ENTER_NW) != 0 || (unsafe.getInt(flagAddr + i(unitSize - 1, unitSize)) & BLOCK_ENTER_NE) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize - 1; mid++) {
						if ((unsafe.getInt(flagAddr + i(mid, unitSize)) & BLOCK_ENTER_N_BIG) != 0) {
							return false;
						}
					}
					return true;
				case SouthWest:
					if ((unsafe.getInt(flagAddr + i(-1, -1)) & BLOCK_ENTER_SW) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize; mid++) {
						if ((unsafe.getInt(flagAddr + i(-1, mid - 1)) & BLOCK_ENTER_W_BIG) != 0 || (unsafe.getInt(flagAddr + i(-1 + mid, -1)) & BLOCK_ENTER_S_BIG) != 0) {
							return false;
						}
					}
					return true;
				case SouthEast:
					if ((unsafe.getInt(flagAddr + i(unitSize, -1)) & BLOCK_ENTER_SE) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize; mid++) {
						if ((unsafe.getInt(flagAddr + i(unitSize, mid - 1)) & BLOCK_ENTER_E_BIG) != 0 || (unsafe.getInt(flagAddr + i(mid, -1)) & BLOCK_ENTER_S_BIG) != 0) {
							return false;
						}
					}
					return true;
				case NorthWest:
					if ((unsafe.getInt(flagAddr + i(-1, unitSize)) & BLOCK_ENTER_NW) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize; mid++) {
						if ((unsafe.getInt(flagAddr + i(-1, mid)) & BLOCK_ENTER_W_BIG) != 0 || (unsafe.getInt(flagAddr + i(-1 + mid, unitSize)) & BLOCK_ENTER_N_BIG) != 0) {
							return false;
						}
					}
					return true;
				case NorthEast:
					if ((unsafe.getInt(flagAddr + i(unitSize, unitSize)) & BLOCK_ENTER_NE) != 0) {
						return false;
					}
					for (int mid = 1; mid < unitSize; mid++) {
						if ((unsafe.getInt(flagAddr + i(mid, unitSize)) & BLOCK_ENTER_N_BIG) != 0 || (unsafe.getInt(flagAddr + i(unitSize, mid)) & BLOCK_ENTER_E_BIG) != 0) {
							return false;
						}
					}
					return true;
			}
			throw new RuntimeException("Unknown direction");
		}
		return true;
	}
	
	@Override
	public boolean legalProjectileStep(World world, Tile from, Direction d) {
		recenter();
		int currX = 64 - loadedX + from.x;
		int currY = 64 - loadedY + from.z;
		long flagAddr = flags + Integer.BYTES * 128 * currX + Integer.BYTES * currY;
		int dx = d.x;
		int dy = d.y;
		if (dx == -1 && (unsafe.getInt(flagAddr + i(-1, 0)) & BLOCK_PROJ_W) != 0) {
			return false;
		}
		if (dx == 1 && (unsafe.getInt(flagAddr + i(1, 0)) & BLOCK_PROJ_E) != 0) {
			return false;
			
		}
		if (dy == -1 && (unsafe.getInt(flagAddr + i(0, -1)) & BLOCK_PROJ_S) != 0) {
			return false;
			
		}
		if (dy == 1 && (unsafe.getInt(flagAddr + i(0, 1)) & BLOCK_PROJ_N) != 0) {
			return false;
			
		}
		if (dx == -1 && dy == -1 && (unsafe.getInt(flagAddr + i(-1, -1)) & BLOCK_PROJ_SW) != 0) {
			return false;
			
		}
		if (dx == 1 && dy == -1 && (unsafe.getInt(flagAddr + i(+1, -1)) & BLOCK_PROJ_SE) != 0) {
			return false;
			
		}
		if (dx == -1 && dy == 1 && (unsafe.getInt(flagAddr + i(-1, +1)) & BLOCK_PROJ_NW) != 0) {
			return false;
			
		}
		if (dx == 1 && dy == 1 && (unsafe.getInt(flagAddr + i(1, 1)) & BLOCK_PROJ_NE) != 0) {
			return false;
			
		}
		return true;
	}
	
	private static final Direction[] TRANSLATION = {
			null, Direction.South, Direction.West, Direction.SouthWest, Direction.North, null, Direction.NorthWest, null, Direction.East, Direction.SouthEast, null, null, Direction.NorthEast
	};
	
}
