package net.dodian.runescape.task;

import net.dodian.runescape.model.EntityList;
import net.dodian.runescape.net.packets.PacketProvider;
import kotlin.ranges.IntRange;
import net.dodian.runescape.ServerProcessor;
import net.dodian.runescape.model.Entity;
import net.dodian.runescape.model.World;
import net.dodian.runescape.model.entity.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bart Pelle on 8/23/2014.
 * <p>
 * Processes the scheduled actions for the players.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PacketProcessingTask implements Task {
	
	private static final Logger logger = LogManager.getLogger(PacketProcessingTask.class);

	private final PacketProvider packetProvider;

	@Autowired
	public PacketProcessingTask(PacketProvider packetProvider) {
		this.packetProvider = packetProvider;
	}
	
	@Override
	public void execute(World world) {
		// As the first Task in the Engine, increment the cycles.
		world.gameCycles++;
		
		// Shuffle our players' PID value.
		shufflePlayers(world);
		
		// Packets boi.
		world.getPvpShuffablePid().forEach(player -> {
			if(player.pendingPackets().size() > 20) {
				logger.warn("Flooding? Size {} queue from {} at ip {}.", player.pendingPackets().size(), player.username(), player.ip());
				player.pendingPackets().clear(); // FUck you cya
			}

			player.pendingPackets().forEach(packet -> {
				long start = System.currentTimeMillis();
				packetProvider.handlePacket(packet);
				long taken = System.currentTimeMillis() - start;
				ServerProcessor.computeTimes.compute(player.username(), (s, integer) -> integer == null ? taken : (taken + integer));
			});

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
			player.pendingPackets().clear();
			player.pendingActions().clear();
			
			// Sync containers, if dirty. Why here? Because... Fake lag fix. Just don't question me :-)
			player.postCycleDirty();

			// Flush net
			if (!player.bot())
				player.channel().flush();
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
