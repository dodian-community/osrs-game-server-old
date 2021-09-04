package io.nozemi.runescape.task;

import io.nozemi.runescape.model.World;

import java.util.Collection;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public interface Task {
	
	void execute(World world);
	
	boolean isAsyncSafe();
	
	Collection<SubTask> createJobs(World world);
	
}
