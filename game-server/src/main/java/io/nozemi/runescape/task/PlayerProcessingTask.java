package io.nozemi.runescape.task;

import io.nozemi.runescape.ServerProcessor;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.command.SystemUpdateTimer;
import io.nozemi.runescape.tasksystem.TaskManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

/**
 * Created by Bart on 5-3-2015.
 */
public class PlayerProcessingTask implements Task {
	
	private static final Logger logger = LogManager.getLogger(PlayerProcessingTask.class);
	
	@Override
	public void execute(World world) {
		boolean update = world.ticksUntilUpdate() > 1;
		
		/*Fiber.setDefaultUncaughtExceptionHandler((strand, throwable) -> {
			logger.error("Error in processing script (entity context) for {}.", strand, throwable);
		});*/
		
		world.getPvpShuffablePid().forEach((Player player) -> {
			try {
				long start = System.currentTimeMillis();
				player.cycle();
				// After scripts/packets, but before movement.
				
				// Sync containers, if dirty
				player.postCycleDirty();
				
				if (update) {
					player.write(new SystemUpdateTimer(world.ticksUntilUpdate()));
				}

				// Flush network channel
				if (!player.bot()) {
					player.channel().flush();
				}
				
				long taken = System.currentTimeMillis() - start;
				ServerProcessor.computeTimes.compute(player.username(), (String s, Long integer)
						-> integer == null ? taken : (taken + integer));
			} catch (Exception e) {
				logger.error("Error processing logic for {}.", player, e);
			}
		});

		TaskManager.cyclePlayerChains();
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
