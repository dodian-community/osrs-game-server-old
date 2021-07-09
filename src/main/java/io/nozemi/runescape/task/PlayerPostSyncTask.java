package io.nozemi.runescape.task;

import io.nozemi.runescape.model.Area;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class PlayerPostSyncTask implements Task {
	
	private static final Logger logger = LogManager.getLogger(PlayerPostSyncTask.class);
	
	@Override
	public void execute(World world) {
		world.players().forEach(this::postUpdate);
	}
	
	private void postUpdate(Player player) {
		player.sync().clear();
		
		boolean regionChanged = player.attribOr(AttributeKey.REGION_CHANGING, false);
		boolean heightChanged = player.attribOr(AttributeKey.HEIGHT_CHANGING, false);
		if (regionChanged || heightChanged) {
			Area prev = player.attribOr(AttributeKey.PREVIOUS_MAP, null);
			player.world().syncMap(player, prev, heightChanged || player.tile().level != prev.level);
			player.activeMap(new Tile(player.activeMap().x, player.activeMap().z, player.tile().level));
			player.putattrib(AttributeKey.REGION_CHANGING, false);
			player.putattrib(AttributeKey.HEIGHT_CHANGING, false);
		}
		
		player.updateRemoteLocation();
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
