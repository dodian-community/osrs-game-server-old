package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

public class SetAlignment extends Command {

	private int parentId;
	private int childId;
	private int x;
	private int y;

	public SetAlignment(int parentId, int childId, int x, int y) {
		this.parentId = parentId;
		this.childId = childId;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(9));
		
		buffer.packet(41);

		buffer.writeShort(y);
		buffer.writeLEInt(parentId << 16 | childId);
		buffer.writeLEShortA(x);
		
		return buffer;
	}
}
