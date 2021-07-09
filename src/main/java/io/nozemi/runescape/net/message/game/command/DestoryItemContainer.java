package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Jak on 09/02/2016.
 */
public class DestoryItemContainer extends Command {
	
	private int containerId;
	
	public DestoryItemContainer(int target) {
		containerId = target;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(2));
		buffer.packet(89);
		
		buffer.writeShort(containerId);
		
		return null;//buffer;
	}
	
}
