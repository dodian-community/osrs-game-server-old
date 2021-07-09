package io.nozemi.runescape.model.map.steroids;

import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.World;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static io.nozemi.runescape.model.map.steroids.Clip.*;

/**
 * Melee combat following works mostly on the position the target was at before the cycle, unless there is a conflict with overlapping we won't take into account the movement for this cycle of the target
 */
public class MeleeStepSupplier extends EntityStepSupplier {
	
	public Entity target;
	public Tile targtile;
	
	public MeleeStepSupplier(Entity entity, Entity target) {
		super(entity);
		this.target = target;
		targtile = target.tile();
	}
	
	public MeleeStepSupplier(Entity entity, Entity target, Tile targtile) {
		super(entity);
		this.target = target;
		this.targtile = targtile;
	}
	
	private static final List<Direction> ORTHOGONAL = Arrays.asList(Direction.West, Direction.East, Direction.South, Direction.North);
	
	@Override
	public Direction get() {
		return get(follower.pathQueue().peekLastTile());
	}
	
	public Direction get(Tile t) {
		Stream<Direction> valid;
		Tile current = t;
		boolean conflict = follower.pathBounds().overlaps(target.baseBounds(targtile));
		//Distance from center
		double dx = (conflict ? target.pathQueue().peekLastTile().x : targtile.x) + (target.size() / 2.0) - (current.x + (follower.size() / 2.0));
		double dy = (conflict ? target.pathQueue().peekLastTile().z : targtile.z) + (target.size() / 2.0) - (current.z + (follower.size() / 2.0));
		if (dx == 0 && dy == 0) {
			//We are exactly in the center of the target, so try to move in any orthogonal direction
			valid = ORTHOGONAL.stream();
		} else {
			Stream.Builder<Direction> stream = Stream.builder();
			//Round away from zero since with even sizes, the center will be between two tiles, but that's still a valid direction
//			int dxi = (int) (dx > 0 ? Math.ceil(dx) : Math.floor(dx));
//			int dyi = (int) (dy > 0 ? Math.ceil(dy) : Math.floor(dy));
			int dxi = (int) dx; //TODO: maybe we dont need to round?
			int dyi = (int) dy;
			//TODO: Instead we need to take into account their full size? and move in any direction that has same mindistance
			
			//We don't want to go diagonal when we are on the corner (would collide with npc) or when dx or dy is 0.5 it will cause zigzag
			if (!conflict && Math.abs(dx) >= 1 && Math.abs(dy) >= 1 && !corner()) {
				stream.add(Direction.diagonal(dxi, dyi));
			}
			//Check if there is atleast ONE direction and move orthogonal in the strongest direction first
			if (dxi != 0 || dyi != 0) {
				stream.add(Math.abs(dx) > Math.abs(dy) ? Direction.diagonal(dxi, 0) : Direction.diagonal(0, dyi));
				//Check if there are TWO and then in the weakest
				if (dxi != 0 && dyi != 0) {
					stream.add(Math.abs(dx) > Math.abs(dy) ? Direction.diagonal(0, dyi) : Direction.diagonal(dxi, 0));
				}
			} else {
				//center of even sized npc
				//both dx or dy should be +0.5 or -0.5
				if (dx != 0) //Should always be true because entities are NxN and not NxK, but just to be safe
					stream.add(Direction.diagonal((int) Math.signum(dx), 0));
				if (dy != 0) //Should always be true because entities are NxN and not NxK, but just to be safe
					stream.add(Direction.diagonal(0, (int) Math.signum(dy)));
			}
			valid = stream.build();
			//We are under the target, so move AWAY instead of towards
			if (conflict) {
				valid = valid.map(Direction::opposite);
			}
		}
		//Find the first direction that's legal
		PathRouteFinder finder = new PathRouteFinder(follower);
		try {
			return valid.filter(next -> RouteFinder.isLegal(follower.world(), current, next, follower.size())).findFirst().orElse(null);
		} finally {
			finder.free();
		}
	}
	
	private boolean corner() {
		int x1 = follower.pathQueue().peekLastTile().x;
		int y1 = follower.pathQueue().peekLastTile().z;
		int tx1 = target.tile().x;
		int ty1 = target.tile().z;
		int x2 = follower.size() + x1;
		int y2 = follower.size() + y1;
		int tx2 = target.size() + tx1;
		int ty2 = target.size() + ty1;
		if (x1 == tx2 && ty2 == y1) {
			return true;
		}
		if (x1 == tx2 && y2 == ty1) {
			return true;
			
		}
		if (tx1 == x2 && ty2 == y1) {
			return true;
			
		}
		if (tx1 == x2 && y2 == ty1) {
			return true;
			
		}
		return false;
	}
	
	@Override
	public boolean reached(World world) {
		return reached(world, target);
	}
	
	@Override
	public boolean reached(World world, Entity target) {
		return reached(world, target, follower.pathQueue().peekLastTile());
	}
	
	public boolean reached(World world, Entity target, Tile t) {
		//This would allow safespotting. only check for players?
		if (follower.bounds().overlaps(target.bounds())) {
			return false;
		}
		int x1 = t.x;
		int y1 = t.z;
		//There is a conflict but it was already solved (willOverlap returned false, so use the non conflicted coordinate version)
		boolean conflict = follower.pathBounds().overlaps(target.pathBounds());
		int tx1 = conflict ? target.pathQueue().peekLastTile().x : target.tile().x;
		int ty1 = conflict ? target.pathQueue().peekLastTile().z : target.tile().z;
		int x2 = follower.size() + x1;
		int y2 = follower.size() + y1;
		int tx2 = target.size() + tx1;
		int ty2 = target.size() + ty1;
		if (x1 == tx2) {
			//We are directly east to it
			int yLow = ty1 >= y1 ? ty1 : y1; //take the highest bottom of the 2 rectangles
			int yHigh = y2 >= ty2 ? ty2 : y2; //take the lowest top of the 2 rectangles
			while (yLow < yHigh) { //If the rectangles are not bordering, the highest bottom is lower than the lowest top and it won't loop at all!
				if ((world.clipAt(tx2 - 1, yLow++, follower.tile().level) & E_WALL) == 0) {
					return true;
				}
			}
		} else if (tx1 == x2) {
			int yLow = y1 <= ty1 ? ty1 : y1;
			for (int yHigh = y2 >= ty2 ? ty2 : y2; yHigh > yLow; yLow++) {
				if ((world.clipAt(tx1, yLow, follower.tile().level) & W_WALL) == 0) {
					return true;
				}
			}
		} else if (ty2 == y1) {
			int xLow = x1 <= tx1 ? tx1 : x1;
			for (int xHigh = tx2 <= x2 ? tx2 : x2; xLow < xHigh; xLow++) {
				if ((world.clipAt(xLow, ty2 - 1, follower.tile().level) & N_WALL) == 0) {
					return true;
				}
			}
		} else if (y2 == ty1) {
			int xLow = tx1 < x1 ? x1 : tx1;
			for (int xHigh = tx2 <= x2 ? tx2 : x2; xHigh > xLow; xLow++) {
				if ((world.clipAt(xLow, ty1, follower.tile().level) & S_WALL) == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
}
