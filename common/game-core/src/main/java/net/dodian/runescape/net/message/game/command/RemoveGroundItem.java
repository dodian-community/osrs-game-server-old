package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.GroundItem;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Bart on 8/22/2015.
 */
public class RemoveGroundItem extends Command {
	
	private GroundItem item;
	
	public RemoveGroundItem(GroundItem item) {
		this.item = item;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer packet = new RSBuffer(player.channel().alloc().buffer(6)).packet(75);

		packet.writeLEShortA(item.item().getId());
		packet.writeByteA(((item.tile().x % 8) << 4) | (item.tile().z % 8));
		
		return packet;
	}
	
}

