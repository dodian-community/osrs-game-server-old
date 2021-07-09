package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart on 12/1/2015.
 */
public class SystemUpdateTimer extends Command {
	
	private int ticks;
	
	public SystemUpdateTimer(int ticks) {
		this.ticks = ticks;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		return new RSBuffer(player.channel().alloc().buffer(3)).packet(5).writeLEShort(ticks);
	}
	
}
