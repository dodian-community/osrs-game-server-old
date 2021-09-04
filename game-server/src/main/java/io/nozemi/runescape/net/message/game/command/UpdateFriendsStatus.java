package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart on 11/15/2015.
 */
public class UpdateFriendsStatus extends Command {
	
	private int status;
	
	public UpdateFriendsStatus(int status) {
		this.status = status;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		return new RSBuffer(player.channel().alloc().buffer(2)).packet(27).writeByte(status);
	}
	
}
