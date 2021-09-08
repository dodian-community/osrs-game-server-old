package net.dodian.runescape.model.map.steroids;


import net.dodian.runescape.model.Entity;
import net.dodian.runescape.model.World;

public abstract class EntityStepSupplier implements StepSupplier {
	
	public Entity follower;
	
	public EntityStepSupplier(Entity follower) {
		this.follower = follower;
	}
	
	public abstract boolean reached(World world, Entity target);
	
}
