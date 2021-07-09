package io.nozemi.runescape.task;

import io.nozemi.runescape.model.World;

import java.util.Collection;

/**
 * Created by Bart on 5-3-2015.
 * <p>
 * A simple task ran at the end of every cycle that flushes the Netty channels. This is instead of
 * the write-and-flush alternative because it's more efficient (imagine a flush() call after every single message...)
 */
public class NetworkFlushTask implements Task {
	
	@Override
	public void execute(World world) {
		world.players().forEach(p -> {
			if (!p.bot()) {
				p.channel().flush();
			}
		});
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
