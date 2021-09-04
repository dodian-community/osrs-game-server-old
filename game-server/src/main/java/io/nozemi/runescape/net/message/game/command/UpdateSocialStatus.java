package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart on 11/15/2015.
 */
public class UpdateSocialStatus extends Command {
	
	private int publicChat;
	private int trading;
	
	public UpdateSocialStatus(int publicchat, int trading) {
		this.publicChat = publicchat;
		this.trading = trading;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		return new RSBuffer(player.channel().alloc().buffer(3)).packet(44).writeByteN(trading).writeByteN(publicChat);
	}
	
}
