package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class InterfaceVisibility extends Command {
	
	private int hash;
	private boolean hidden;
	
	public InterfaceVisibility(int hash, boolean hidden) {
		this.hash = hash;
		this.hidden = hidden;
	}
	
	public InterfaceVisibility(int parent, int child, boolean hidden) {
		this.hash = (parent << 16) | child & 0xFFFF;
		this.hidden = hidden;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(5));
		buffer.packet(20);
		buffer.writeIntV2(hash);
		buffer.writeByteN(hidden ? 1 : 0);
		return buffer;
	}
	
}
