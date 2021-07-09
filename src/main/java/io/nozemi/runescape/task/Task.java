package io.nozemi.runescape.task;

import io.nozemi.runescape.model.World;

import java.util.Collection;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public interface Task {
	
	public void execute(World world);
	
	public boolean isAsyncSafe();
	
	public Collection<io.nozemi.runescape.task.SubTask> createJobs(World world);
	
}
