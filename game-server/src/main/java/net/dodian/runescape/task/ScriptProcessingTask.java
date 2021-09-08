package net.dodian.runescape.task;

import net.dodian.runescape.events.ScriptExecutor;
import net.dodian.runescape.model.World;
import net.dodian.runescape.model.entity.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by Bart on 3-2-2015.
 */
@Component
public class ScriptProcessingTask implements Task {
	
	private static final Logger logger = LogManager.getLogger(ScriptProcessingTask.class);

	private final ScriptExecutor executor;

	@Autowired
	public ScriptProcessingTask(ScriptExecutor executor) {
		this.executor = executor;
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
		executor.cycle(script -> !(script.getContext() instanceof Player));
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
