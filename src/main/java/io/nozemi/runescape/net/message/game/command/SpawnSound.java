package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart on 8/18/2015.
 */
public class SpawnSound extends Command {
	
	private Tile at;
	private int id;
	private int radius;
	private int delay;
	
	public SpawnSound(Tile at, int id, int radius, int delay) {
		this.at = at;
		this.id = id;
		this.radius = radius;
		this.delay = delay;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(7));
		
		buffer.packet(43);

		buffer.writeByteN(delay);
		buffer.writeByte((radius << 4) | 1); // | 1 = number of times.
		buffer.writeByteN(((at.x % 8) << 4) | (at.z % 8));
		buffer.writeLEShortA(id);
		
		return buffer;
	}
	
}
