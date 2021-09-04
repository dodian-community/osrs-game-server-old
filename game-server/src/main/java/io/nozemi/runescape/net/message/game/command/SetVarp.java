package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class SetVarp extends Command {
	
	private int id;
	private int value;
	private boolean small;
	
	public SetVarp(int id, int value) {
		this.id = id;
		this.value = value;
		small = value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(small ? 4 : 7));
		buffer.packet(small ? 49 : 50);
		
		if (small) {
			buffer.writeByteS(value);
			buffer.writeLEShort(id);
		} else {
			buffer.writeLEInt(value);
			buffer.writeLEShort(id);
		}
		
		return buffer;
	}
}
