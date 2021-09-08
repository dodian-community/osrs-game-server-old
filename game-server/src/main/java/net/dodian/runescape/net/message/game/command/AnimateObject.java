package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.map.MapObj;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Jak on 13/06/2016.
 */
public class AnimateObject extends Command {
	
	private MapObj obj;
	private int anim;
	
	public AnimateObject(MapObj obj, int anim) {
		this.obj = obj;
		this.anim = anim;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(7)).packet(95);
		
		buffer.writeByteN((obj.type() << 2) | obj.rot());
		buffer.writeByteA(((obj.tile().x & 7) << 4) | (obj.tile().z & 7));
		buffer.writeShort(anim);
		
		return buffer;
	}
}
