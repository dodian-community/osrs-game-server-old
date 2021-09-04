package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.map.MapObj;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart on 8/29/2015.
 */
public class SpawnObject extends Command {
	
	private MapObj obj;
	
	public SpawnObject(MapObj obj) {
		this.obj = obj;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(5)).packet(76);

		buffer.writeByteN(((obj.tile().x & 7) << 4) | (obj.tile().z & 7));
		buffer.writeByteS((obj.type() << 2) | obj.rot());
		buffer.writeShortA(obj.id());
		
		return buffer;
	}
	
	
}
