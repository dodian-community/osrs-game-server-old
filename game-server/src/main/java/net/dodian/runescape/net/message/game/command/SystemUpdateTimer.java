package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

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
