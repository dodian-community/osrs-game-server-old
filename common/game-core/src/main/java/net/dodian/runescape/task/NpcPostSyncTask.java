package net.dodian.runescape.task;

import net.dodian.runescape.model.World;
import net.dodian.runescape.model.entity.Npc;

import java.util.Collection;

/**
 * Created by Bart Pelle on 8/10/2015.
 */
public class NpcPostSyncTask implements Task {
	
	@Override
	public void execute(World world) {
		world.npcs().forEach(this::postUpdate);
	}
	
	private void postUpdate(Npc npc) {
		npc.sync().clear();
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
