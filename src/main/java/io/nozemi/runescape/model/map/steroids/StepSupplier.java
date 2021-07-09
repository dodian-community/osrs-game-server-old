package io.nozemi.runescape.model.map.steroids;

import io.nozemi.runescape.model.World;

import java.util.function.Supplier;

public interface StepSupplier extends Supplier<Direction> {
	
	public boolean reached(World world);
	
}
