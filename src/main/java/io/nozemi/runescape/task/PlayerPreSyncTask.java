package io.nozemi.runescape.task;

import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class PlayerPreSyncTask implements Task {
	
	private static final Logger logger = LogManager.getLogger(PlayerPreSyncTask.class);
	
	@Override
	public void execute(World world) {
		world.getPvpShuffablePid().forEach(this::preUpdate);
	}
	
	private void preUpdate(Player player) {
		
		// Update the player position for their requested movement. Validate path.
		player.post_cycle_movement();
		
		// Sending the region packet is after movement, literally the last thing done before GPI.
		//player.syncMap();
		
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
