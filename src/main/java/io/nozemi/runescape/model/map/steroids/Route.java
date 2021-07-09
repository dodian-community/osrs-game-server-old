package io.nozemi.runescape.model.map.steroids;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.map.MapObj;

public class Route {
	
	int strategy;
	public int targetX;
	public int targetY;
	int targetSX;
	int targetSY;
	int orientation;
	int allowedDirections;
	public Runnable orient;
	public boolean alternative;
	public boolean failed;
	
	public boolean fireImmediately;
	
	private Route(int strategy, int targetX, int targetY, int targetSX, int targetSY, int orientation, int allowedDirections, boolean alternative, boolean fireImmediately) {
		this.strategy = strategy;
		this.targetX = targetX;
		this.targetY = targetY;
		this.targetSX = targetSX;
		this.targetSY = targetSY;
		this.orientation = orientation;
		this.allowedDirections = allowedDirections;
		this.alternative = alternative;
		this.fireImmediately = fireImmediately;
	}
	
	public void reject() {
		orient.run();
	}
	
	public void resolve() {
		orient.run();
	}
	
	public static final int EXACT = -4;
	public static final int OVERLAP = -3;
	public static final int BORDERING = -2;
	public static final int OVERLAP_OR_BORDERING = -1;
	
	public static Route to(World world, MapObj object) {
		if (object.type() == 10 || object.type() == 11 || object.type() == 22) {
			int sx = object.definition(world).sizeX;
			int sz = object.definition(world).sizeY;
			if (object.rot() == 1 || object.rot() == 3) {
				int tmp = sx;
				sx = sz;
				sz = tmp;
			}
			
			return new Route(BORDERING, object.tile().x, object.tile().z, sx, sz, object.rot(), rotateBits(object.definition(world).cflag, 4, object.rot()), true, false);
		} else {
			return new Route(object.type(), object.tile().x, object.tile().z, object.definition(world).sizeX,
					object.definition(world).sizeY, object.rot(), 0, true, false);
		}
	}
	
	public static int rotateBits(int mask, int bits, int rotate) {
		return (RSBuffer.BIT_MASK[bits] & (mask << rotate)) + (mask >> (bits - rotate));
	}
	
	public static Route to(Entity entity) {
		return new Route(BORDERING, entity.tile().x, entity.tile().z, entity.size(), entity.size(), 0, 0, true, true);
	}
	
	public static Route to(Tile location) {
		return new Route(EXACT, location.x, location.z, 1, 1, 0, 0, true, false);
	}
	
	public static Route to(Tile location, boolean alternative) {
		return new Route(EXACT, location.x, location.z, 1, 1, 0, 0, alternative, false);
	}
	
}