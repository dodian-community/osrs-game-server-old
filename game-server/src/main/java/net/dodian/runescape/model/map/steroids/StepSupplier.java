package net.dodian.runescape.model.map.steroids;

import net.dodian.runescape.model.World;

import java.util.function.Supplier;

public interface StepSupplier extends Supplier<Direction> {
	
	public boolean reached(World world);
	
}
