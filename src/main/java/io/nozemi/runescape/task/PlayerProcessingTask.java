package io.nozemi.runescape.task;

import io.nozemi.runescape.ServerProcessor;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.command.SystemUpdateTimer;
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
				if (update) {
					duel_arena_update_security(player, world);
				}
				
				// Sync containers, if dirty
				player.postcycle_dirty();
				
				if (update) {
					player.write(new SystemUpdateTimer(world.ticksUntilUpdate()));
				}
				
				long taken = System.currentTimeMillis() - start;
				ServerProcessor.computeTimes.compute(player.username(), (String s, Long integer) -> {
					return integer == null ? taken : (taken + integer);
				});
			} catch (Exception e) {
				logger.error("Error processing logic for {}.", player, e);
			}
		});
	}
	
	private void duel_arena_update_security(Player player, World world) {
		/*if (world.ticksUntilUpdate() == 10) { // Some friendly safety!
			// Force end duels before the update.
			if (player.attribOr(AttributeKey.IN_STAKE, false)) {
				player.putattrib(AttributeKey.STAKING_DOUBLE_DEATH, true);
				Player partner = Staking.duelPartner(player);
				if (partner != null && partner.index() > -1) {
					partner.putattrib(AttributeKey.STAKING_DOUBLE_DEATH, true);
					if (!partner.dead()) { // This will be done already.
						Staking.on_death(partner);
					}
					partner.message("<col=FF0000>Your stake ended early due to the impending system update!");
				}
				if (!player.dead()) { // This will be done already.
					Staking.on_death(player);
				}
				player.message("<col=FF0000>Your stake ended early due to the impending system update!");
			}
			if (!Staking.screen_closed(player)) { // Close the duel screens/winnings. Get our items!
				player.interfaces().closeMain();
				player.message("<col=FF0000>Your interface was closed due to the impending system update!");
			}
		}*/
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
