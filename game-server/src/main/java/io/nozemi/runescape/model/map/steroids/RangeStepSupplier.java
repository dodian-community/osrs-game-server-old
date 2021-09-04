package io.nozemi.runescape.model.map.steroids;

import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.World;

public class RangeStepSupplier extends MeleeStepSupplier {
	
	public int maxDistance;
	
	public RangeStepSupplier(Entity attacker, Entity target, int distance) {
		super(attacker, target);
		this.maxDistance = distance;
	}
	
	@Override
	public boolean reached(World world, Entity target) {
		if (super.reached(world, target)) {
			return true;
		}
		if (follower.pathBounds().overlaps(target.pathBounds())) {
			return false;
		}
		int targetX = target.tile().x * 2 + target.size() - 1;
		int targetY = target.tile().z * 2 + target.size() - 1;
		int projX = follower.pathQueue().peekLastTile().x * 2 + follower.size() - 1;
		int projY = follower.pathQueue().peekLastTile().z * 2 + follower.size() - 1;
		//Round units that are not in the center of a tile (even sized) towards the other tile
		if ((targetX & 0x1) != 0) {
			targetX += targetX > projX ? -1 : 1;
		}
		if ((targetY & 0x1) != 0) {
			targetY += targetY > projY ? -1 : 1;
		}
		if ((projX & 0x1) != 0) {
			projX += projX > targetX ? -1 : 1;
		}
		if ((projY & 0x1) != 0) {
			projY += projY > targetY ? -1 : 1;
		}
		projX >>= 1;
		projY >>= 1;
		targetX >>= 1;
		targetY >>= 1;
		
		int dx = Math.abs(targetX - projX);
		int dy = Math.abs(targetY - projY);
		
		//double r =  Math.sqrt(Math.pow(projX - targetX, 2) + Math.pow(projY - targetY, 2));
		double barts = Math.max(dx, dy);
		if (barts > maxDistance) {
			/*if(this.follower.isPlayer() && (boolean)follower.attribOr(AttributeKey.DEBUG,false)){
				follower.message("dist: "+barts+" or "+((int)r));
			}*/
			return false;
		}
		
		int sx = projX < targetX ? 1 : -1;
		int sy = projY < targetY ? 1 : -1;
		
		int err = dx - dy;
		int err2;
		int oldX = projX;
		int oldY = projY;
		
		PathRouteFinder finder = new PathRouteFinder(follower);
		while (projX != targetX || projY != targetY) {
			err2 = err << 1;
			if (err2 > -dy) {
				err -= dy;
				projX += sx;
			}
			if (err2 < dx) {
				err += dx;
				projY += sy;
			}
			
			Direction d = Direction.of(projX - oldX, projY - oldY);
			if (!finder.legalProjectileStep(follower.world(), new Tile(oldX, oldY, follower.tile().level), d)) {
				finder.free();
				return false;
			}
			oldX = projX;
			oldY = projY;
		}
		finder.free();
		return true;
	}
	
}
