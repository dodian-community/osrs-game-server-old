package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart on 8/11/2015.
 */
public class NpcOnInterface extends Command {
	
	private int hash;
	private int npc;
	
	public NpcOnInterface(int target, int targetChild, int npc) {
		hash = (target << 16) | targetChild;
		this.npc = npc;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(7));
		buffer.packet(0);
		
		buffer.writeIntV1(hash);
		buffer.writeShortA(npc);
		
		return buffer;
	}
	
}
