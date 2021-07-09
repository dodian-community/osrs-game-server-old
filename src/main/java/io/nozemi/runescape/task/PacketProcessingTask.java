package io.nozemi.runescape.task;

import io.nozemi.runescape.model.EntityList;
import kotlin.ranges.IntRange;
import io.nozemi.runescape.ServerProcessor;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bart Pelle on 8/23/2014.
 * <p>
 * Processes the scheduled actions for the players.
 */
public class PacketProcessingTask implements Task {
	
	private static final Logger logger = LogManager.getLogger(PacketProcessingTask.class);
	
	@Override
	public void execute(World world) {
		// As the first Task in the Engine, increment the cycles.
		world.gameCycles++;
		
		// Shuffle our players' PID value.
		shufflePlayers(world);
		
		// Packets boi.
		world.getPvpShuffablePid().forEach(player -> {
			if (player.pendingActions().size() > 20) {
				logger.warn("Flooding? Size {} queue from {} at ip {}.", player.pendingActions().size(), player.username(), player.ip());
				player.pendingActions().clear(); // FUck you cya
			}
			
			player.pendingActions().forEach(packet -> {
				try {
					long start = System.currentTimeMillis();
					packet.process(player);
					long taken = System.currentTimeMillis() - start;
					ServerProcessor.computeTimes.compute(player.username(), (s, integer) -> integer == null ? taken : (taken + integer));
				} catch (Exception e) {
					logger.error("Error processing message {} for player {} at {}.", packet.getClass().getSimpleName(), player.username(), player.tile().toStringSimple());
					logger.error("Caused by: ", e);
				}
			});
			
			// Remove actions
			player.pendingActions().clear();
			
			// Sync containers, if dirty. Why here? Because... Fake lag fix. Just don't question me :-)
			//player.postcycle_dirty();
		});
	}
	
	private static long lastPvPShuffle = System.currentTimeMillis();
	
	private void shufflePlayers(World world) {
		if (System.currentTimeMillis() - lastPvPShuffle >= 75000 + world.random(new IntRange(-15000, 15000))) {
			lastPvPShuffle = System.currentTimeMillis();
			
			Entity[] old = world.getPvpShuffablePid().raw();
			
			List<Player> raw = new ArrayList<>(old.length); // gen
			
			for (Entity e : old)
				if (e != null)
					raw.add((Player) e);
			
			Collections.shuffle(raw); // shuffle
			world.setPvpShuffablePid(new EntityList<>(2048)); // re-gen
			raw.forEach(p -> p.pvpPid = world.getPvpShuffablePid().add(p)); // update new
			raw = null;
			old = null;
		}
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
