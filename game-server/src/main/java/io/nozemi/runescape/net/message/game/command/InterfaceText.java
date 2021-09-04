package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart on 8/11/2015.
 */
public class InterfaceText extends Command {
	
	private int hash;
	private String text;
	
	public InterfaceText(int target, int targetChild, String text) {
		hash = (target << 16) | targetChild;
		this.text = text;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(text.length() + 1 + 1 + 4));
		buffer.packet(37).writeSize(RSBuffer.SizeType.SHORT);
		
		buffer.writeInt(hash);
		buffer.writeString(text);
		
		return buffer;
	}
	
}
