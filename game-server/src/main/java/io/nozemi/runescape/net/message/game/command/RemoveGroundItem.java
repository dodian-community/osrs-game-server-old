package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.GroundItem;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

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

