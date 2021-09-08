package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class CloseInterface extends Command {
	
	private int hash;
	
	public CloseInterface(int target, int targetChild) {
		hash = (target << 16) | targetChild;
	}
	
	public CloseInterface(int hash) {
		this.hash = hash;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(5));
		buffer.packet(11);
		buffer.writeInt(hash);
		return buffer;
	}
	
}
