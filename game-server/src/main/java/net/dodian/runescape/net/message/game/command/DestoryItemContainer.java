package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

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
