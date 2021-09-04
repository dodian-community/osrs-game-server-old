package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart on 8/22/2015.
 */
public class SendTileGraphic extends Command {
	
	private int id;
	private Tile tile;
	private int height;
	private int delay;
	
	public SendTileGraphic(int id, Tile tile, int height, int delay) {
		this.id = id;
		this.tile = tile;
		this.height = height;
		this.delay = delay;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer packet = new RSBuffer(player.channel().alloc().buffer(8)).packet(246);
		
		packet.writeByte(((tile.x % 8) << 4) | (tile.z % 8));
		packet.writeShort(id);
		packet.writeByte(height);
		packet.writeShort(delay);
		
		return packet;
	}
	
}

