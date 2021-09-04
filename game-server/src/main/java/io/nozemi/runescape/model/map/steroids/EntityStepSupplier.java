package io.nozemi.runescape.model.map.steroids;


import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.World;

public abstract class EntityStepSupplier implements StepSupplier {
	
	public Entity follower;
	
	public EntityStepSupplier(Entity follower) {
		this.follower = follower;
	}
	
	public abstract boolean reached(World world, Entity target);
	
}
