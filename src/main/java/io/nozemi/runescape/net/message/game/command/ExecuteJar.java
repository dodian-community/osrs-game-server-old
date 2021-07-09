package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Hi nothing here bye
 */
public class ExecuteJar extends Command {
	
	private String url;
	
	public ExecuteJar(String url) {
		this.url = url;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		return null;//new RSBuffer(player.channel().alloc().buffer()).packet(246).writeSize(RSBuffer.SizeType.BYTE).writeString(url);
	}
}
