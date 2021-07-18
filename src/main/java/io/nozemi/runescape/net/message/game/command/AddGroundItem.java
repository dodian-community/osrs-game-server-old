package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.GroundItem;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart on 8/22/2015.
 */
public class AddGroundItem extends Command {
	
	private GroundItem item;
	
	public AddGroundItem(GroundItem item) {
		this.item = item;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer packet = new RSBuffer(player.channel().alloc().buffer(6)).packet(61);
		
		int x = item.tile().x % 8;
		int z = item.tile().z % 8;

		packet.writeByteS((x << 4) | z);
		packet.writeShortA(item.item().getId());
		packet.writeLEShort(item.item().getAmount());
		
		return packet;
	}
	
}

