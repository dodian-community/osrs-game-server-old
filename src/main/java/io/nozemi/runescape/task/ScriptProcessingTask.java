package io.nozemi.runescape.task;

import io.nozemi.runescape.model.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

/**
 * Created by Bart on 3-2-2015.
 */
public class ScriptProcessingTask implements Task {
	
	private static final Logger logger = LogManager.getLogger(ScriptProcessingTask.class);
	
	public ScriptProcessingTask() {
		/*Fiber.setDefaultUncaughtExceptionHandler((strand, throwable) -> {
			logger.error("Error in processing script (non entity) for {}.", strand, throwable);
		});*/
	}
	
	@Override
	public void execute(World world) {
		// Ground items
		world.cycle();
		// Contextless or npc context (such as npc combat) scripts.
		//world.server().scriptExecutor().cycle(script -> !(script.getContext() instanceof Player));
	}
	
	@Override
	public Collection<SubTask> createJobs(World world) {
		return null;
	}
	
	@Override
	public boolean isAsyncSafe() {
		return false;
	}
	
}
