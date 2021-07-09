package io.nozemi.runescape.model.entity;

import io.nozemi.runescape.model.Area;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.player.Varps;
import io.nozemi.runescape.model.map.steroids.Direction;
import io.nozemi.runescape.util.Varp;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class PathQueue {
	
	private Entity entity;
	private LinkedList<Step> steps = new LinkedList<>();
	private boolean running;
	private Tile lastStep;
	private Varps varps;
	
	public void setDefaultLastStep() {
		if ((entity.world().floorAt(entity.tile().transform(1, 0)) & 0x4) == 0) {
			lastStep = entity.tile().transform(1, 0);
		} else if ((entity.world().floorAt(entity.tile().transform(1, 1)) & 0x4) == 0) {
			lastStep = entity.tile().transform(1, 1);
		} else if ((entity.world().floorAt(entity.tile().transform(-1, 0)) & 0x4) == 0) {
			lastStep = entity.tile().transform(-1, 0);
		} else if ((entity.world().floorAt(entity.tile().transform(-1, -1)) & 0x4) == 0) {
			lastStep = entity.tile().transform(-1, -1);
		} else {
			lastStep = entity.tile();
		}
	}
	
	public PathQueue(Entity entity) {
		this.entity = entity;
	}
	
	public void step(int x, int z) {
		steps.add(new Step(x, z, StepType.REGULAR));
	}
	
	public Step step(Direction dir) {
		return step(dir, StepType.REGULAR);
	}
	
	public Step step(Direction dir, StepType type) {
		if (dir == null)
			return null;
		
		Tile last = peekLastTile();
		Step step = new Step(last.x + dir.x, last.z + dir.y, type);
		steps.add(step);
		return step;
	}
	
	public void step(int x, int z, StepType type) {
		steps.add(new Step(x, z, type));
	}
	
	public void stepClipped(int x, int z, StepType type) {
		steps.add(new Step(x, z, type, true));
	}
	
	public void interpolate(Tile tile) {
		interpolate(tile.x, tile.z, StepType.REGULAR);
	}
	
	public void interpolate(int tx, int tz) {
		interpolate(tx, tz, StepType.REGULAR);
	}
	
	public int interpolate(Tile tile, StepType type) {
		return interpolate(tile.x, tile.z, type, Integer.MAX_VALUE, false);
	}
	
	public int interpolate(int tx, int tz, StepType type) {
		return interpolate(tx, tz, type, Integer.MAX_VALUE, false);
	}
	
	public int interpolateClipped(int tx, int tz, StepType type) {
		return interpolate(tx, tz, type, Integer.MAX_VALUE, true);
	}
	
	public int interpolate(int tx, int tz, StepType type, int maxSteps, boolean clipped) {
		int cx = steps.isEmpty() ? entity.tile().x : steps.getLast().x;
		int cz = steps.isEmpty() ? entity.tile().z : steps.getLast().z;
		
		int taken = 0;
		while (maxSteps-- > 0) {
			if (cx == tx && cz == tz) {
				break;
			}
			if (cx < tx)
				cx++;
			else if (cx > tx)
				cx--;
			if (cz < tz)
				cz++;
			else if (cz > tz)
				cz--;
			
			if (clipped)
				stepClipped(cx, cz, type);
			else
				step(cx, cz, type);
			
			taken++;
		}
		
		return taken;
	}
	
	public boolean empty() {
		return steps.isEmpty();
	}
	
	public Step next() {
		lastStep = entity.tile();
		return steps.poll();
	}
	
	public Step peekNext() {
		return steps.peek();
	}
	
	public Tile peekNextTile() {
		Step step = peekNext();
		if (step == null)
			return entity.tile();
		return step.toTile();
	}
	
	public Step peekAfter(int skip) {
		Iterator<Step> iterator = steps.iterator();
		Step current = steps.peek();
		while (skip-- >= 0 && iterator.hasNext()) {
			Step c = iterator.next();
			if (c != null)
				current = c;
		}
		return current;
	}
	
	public Step peekLast() {
		return steps.peekLast();
	}
	
	public Tile peekLastTile() {
		Step step = peekLast();
		if (step == null)
			return entity.tile();
		return step.toTile();
	}
	
	public void clear() {
		steps.clear();
		//entity.sync().clearMovement(); // nononononono
	}
	
	public void trimToSize(int size) {
		while (steps.size() > size)
			steps.removeLast();
	}
	
	public void removeOutside(Area area) {
		Iterator<Step> it = steps.iterator();
		while (it.hasNext()) {
			Step s = it.next();
			if (!area.contains(s.toTile())) { // Not inside? Prune from here.
				it.remove();
				
				while (it.hasNext()) {
					it.next();
					it.remove();
				}
				
				return;
			}
		}
	}
	
	public Tile lastStep() {
		if (lastStep != null && lastStep.distance(entity.tile()) > 2) { // Must have teleported.
			setDefaultLastStep();
		}
		return lastStep;
	}
	
	public void running(boolean b) {
		running = b;
	}
	
	public boolean running() {
		if (entity.isPlayer()) {
			return entity.varps().varp(Varp.RUNNING_ENABLED) == 1;
		}
		return running;
	}
	
	public static int calculateDirection(int x1, int z1, int x2, int z2) {
		int dx = x2 - x1;
		int dz = z2 - z1;
		
		if (dx == -1 && dz == -1) {
			return 0;
		}
		if (dx == 0 && dz == -1) {
			return 1;
		}
		if (dx == 1 && dz == -1) {
			return 2;
		}
		if (dx == -1 && dz == 0) {
			return 3;
		}
		if (dx == 1 && dz == 0) {
			return 4;
		}
		if (dx == -1 && dz == 1) {
			return 5;
		}
		if (dx == 0 && dz == 1) {
			return 6;
		}
		if (dx == 1 && dz == 1) {
			return 7;
		}
		
		return 0;
	}
	
	public static int calculateRunDirection(int x1, int z1, int x2, int z2) {
		int dx = x2 - x1;
		int dz = z2 - z1;
		
		if (dx == -2 && dz == -2)
			return 0;
		if (dx == -1 && dz == -2)
			return 1;
		if (dx == 0 && dz == -2)
			return 2;
		if (dx == 1 && dz == -2)
			return 3;
		if (dx == 2 && dz == -2)
			return 4;
		if (dx == -2 && dz == -1)
			return 5;
		if (dx == 2 && dz == -1)
			return 6;
		if (dx == -2 && dz == 0)
			return 7;
		if (dx == 2 && dz == 0)
			return 8;
		if (dx == -2 && dz == 1)
			return 9;
		if (dx == 2 && dz == 1)
			return 10;
		if (dx == -2 && dz == 2)
			return 11;
		if (dx == -1 && dz == 2)
			return 12;
		if (dx == 0 && dz == 2)
			return 13;
		if (dx == 1 && dz == 2)
			return 14;
		if (dx == 2 && dz == 2)
			return 15;
		
		return -1;
	}
	
	public static int calculateDirectionOld(int x1, int z1, int x2, int z2) {
		int dx = x2 - x1;
		int dz = z2 - z1;
		
		if (dz == 1) {
			if (dx == -1)
				return 0;
			else if (dx == 0)
				return 1;
			else if (dx == 1)
				return 2;
		} else if (dz == 0) {
			if (dx == -1)
				return 3;
			else if (dx == 1)
				return 4;
		} else if (dz == -1) {
			if (dx == -1)
				return 5;
			else if (dx == 0)
				return 6;
			else if (dx == 1)
				return 7;
		}
		
		return 0;
	}
	
	public static class Step {
		public int x;
		public int z;
		public StepType type;
		public boolean clipped;
		
		public Step(int x, int z, StepType type) {
			this.x = x;
			this.z = z;
			this.type = type;
		}
		
		public Step(int x, int z, StepType type, boolean clipped) {
			this.x = x;
			this.z = z;
			this.type = type;
			this.clipped = clipped;
		}
		
		public Tile toTile() {
			return new Tile(x, z);
		}
	}
	
	public enum StepType {
		REGULAR, FORCED_WALK, FORCED_RUN
	}
	
}
