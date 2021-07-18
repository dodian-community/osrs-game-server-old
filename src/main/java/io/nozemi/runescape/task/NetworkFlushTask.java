package io.nozemi.runescape.task;

import io.nozemi.runescape.events.Script;
import io.nozemi.runescape.events.ScriptExecutor;
import io.nozemi.runescape.model.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by Bart on 5-3-2015.
 * <p>
 * A simple task ran at the end of every cycle that flushes the Netty channels. This is instead of
 * the write-and-flush alternative because it's more efficient (imagine a flush() call after every single message...)
 */
@Component
public class NetworkFlushTask implements Task {

	private final ScriptExecutor scriptExecutor;

	@Autowired
	public NetworkFlushTask(ScriptExecutor scriptExecutor) {
		this.scriptExecutor = scriptExecutor;
	}
	
	@Override
	public void execute(World world) {
		world.players().forEach(p -> {
			if (!p.bot()) {
				p.channel().flush();
			}
		});
		this.scriptExecutor.incCycle();
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
