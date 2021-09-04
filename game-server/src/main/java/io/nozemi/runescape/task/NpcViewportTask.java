package io.nozemi.runescape.task;

import io.nozemi.runescape.model.World;

import java.util.Collection;

/**
 * Created by Bart on 8/26/2015.
 */
public class NpcViewportTask implements Task {
	
	@Override
	public void execute(World world) {
		// Reset viewport states for npcs
		world.npcs().forEach(n -> n.inViewport(false));
	}
	
	@Override
	public boolean isAsyncSafe() {
		return false;
	}
	
	@Override
	public Collection<SubTask> createJobs(World world) {
		return null;
	}
	
}
