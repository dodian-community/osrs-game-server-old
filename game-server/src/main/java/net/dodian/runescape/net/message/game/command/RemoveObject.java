package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.map.MapObj;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Bart on 8/29/2015.
 */
public class RemoveObject extends Command {
	
	private MapObj obj;
	
	public RemoveObject(MapObj obj) {
		this.obj = obj;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(3)).packet(58);
		
		buffer.writeByte((obj.type() << 2) | obj.rot());
		buffer.writeByteS(((obj.tile().x & 7) << 4) | (obj.tile().z & 7));
		
		return buffer;
	}
	
	
}
