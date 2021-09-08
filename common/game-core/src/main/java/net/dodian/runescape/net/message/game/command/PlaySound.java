package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Bart on 8/25/2015.
 */
public class PlaySound extends Command {
	
	private int id;
	private int delay;
	private int times = 1;
	
	public PlaySound(int id) {
		this(id, 0);
	}
	
	public PlaySound(int id, int delay) {
		this.id = id;
		this.delay = delay;
	}
	
	public PlaySound(int id, int delay, int times) {
		this.id = id;
		this.delay = delay;
		this.times = times;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(1 + 2 + 1 + 2)).packet(78);
		
		buffer.writeShort(id);
		buffer.writeByte(times);
		buffer.writeShort(delay);
		
		return buffer;
	}
	
}
