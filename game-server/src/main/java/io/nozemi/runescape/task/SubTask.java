package io.nozemi.runescape.task;

import io.nozemi.runescape.model.World;

import java.util.concurrent.Callable;

/**
 * Created by Bart on 8/2/2015.
 */
public abstract class SubTask implements Callable<Object> {
	
	protected World world;
	
	public SubTask(World world) {
		this.world = world;
	}
	
	@Override
	public Object call() throws Exception {
		execute();
		return null;
	}
	
	public abstract void execute();
	
}
