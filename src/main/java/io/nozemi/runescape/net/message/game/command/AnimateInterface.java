package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart on 8/11/2015.
 */
public class AnimateInterface extends Command {
	
	private int hash;
	private int anim;
	
	public AnimateInterface(int target, int targetChild, int anim) {
		hash = (target << 16) | targetChild;
		this.anim = anim;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(7));
		buffer.packet(65);

		buffer.writeLEShort(anim);
		buffer.writeIntV2(hash);
		
		return buffer;
	}
	
}
