package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Jak on 04/08/2016.
 */
public class ShakeScreen extends Command {
	
	private int[] info;
	
	public ShakeScreen(int[] info) {
		this.info = info;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(4)).packet(-1);
		buffer.writeByte(info[0]);
		buffer.writeByte(info[1]);
		buffer.writeByte(info[2]);
		buffer.writeByte(info[3]);
		return buffer;
	}
}
