package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart on 8/11/2015.
 */
public class PlayerOnInterface extends Command {
	
	private int hash;
	
	public PlayerOnInterface(int target, int targetChild) {
		hash = (target << 16) | targetChild;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(5));
		buffer.packet(70);
		
		buffer.writeIntV2(hash);
		
		return buffer;
	}
	
}
