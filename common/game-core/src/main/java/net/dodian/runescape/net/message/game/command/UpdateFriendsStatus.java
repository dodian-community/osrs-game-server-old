package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

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
