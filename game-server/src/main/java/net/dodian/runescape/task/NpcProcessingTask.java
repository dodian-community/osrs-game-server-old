package net.dodian.runescape.task;

import net.dodian.runescape.model.Entity;
import net.dodian.runescape.model.World;
import net.dodian.runescape.tasksystem.TaskManager;

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
					raw[i].postCycleMovement();
			}
		}

		TaskManager.cycleNpcEvents();
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
