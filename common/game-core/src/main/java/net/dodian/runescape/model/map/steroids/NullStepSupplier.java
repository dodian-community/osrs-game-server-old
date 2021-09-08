package net.dodian.runescape.model.map.steroids;


import net.dodian.runescape.model.World;

/**
 * Represents a step supplier that does nothing, because null references suck.
 */
public class NullStepSupplier implements StepSupplier {
	
	public static final NullStepSupplier INSTANCE = new NullStepSupplier();
	
	private NullStepSupplier() {
	}
	
	@Override
	public Direction get() {
		return null;
	}
	
	@Override
	public boolean reached(World world) {
		return false;
	}
	
}
