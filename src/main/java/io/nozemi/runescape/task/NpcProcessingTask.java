package io.nozemi.runescape.task;

import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.World;

import java.util.Collection;

/**
 * Created by Bart on 8/26/2015.
 */
public class NpcProcessingTask implements Task {
	
	@Override
	public void execute(World world) {
		Entity[] raw = world.npcs().raw();
		for (int i = 0; i < raw.length; i++) {
			if (raw[i] != null) {
				raw[i].cycle();
				
				if (raw[i] != null) // unregistered in cycle()?
					raw[i].post_cycle_movement();
			}
		}
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
