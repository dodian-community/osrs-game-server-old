package io.nozemi.runescape.net.message.game.command;

import io.netty.buffer.Unpooled;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class ChangeMapMarker extends Command {
	
	private int x;
	private int z;
	
	public ChangeMapMarker(int x, int z) {
		this.x = x;
		this.z = z;
	}
	
	public ChangeMapMarker(Tile tile) {
		this.x = tile.x;
		this.z = tile.z;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(Unpooled.buffer());
		
		buffer.packet(26);
		
		Tile base = player.activeMap();
		
		buffer.writeByte(x - base.x);
		buffer.writeByte(z - base.z);
		
		return buffer;
	}
}
