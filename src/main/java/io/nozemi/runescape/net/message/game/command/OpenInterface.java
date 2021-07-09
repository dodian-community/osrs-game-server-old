package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class OpenInterface extends Command {
	
	private int id;
	private boolean autoclose;
	private int target;
	private int targetChild;
	
	public OpenInterface(int id, int target, int targetChild, boolean autoclose) {
		this.id = id;
		this.target = target;
		this.targetChild = targetChild;
		this.autoclose = autoclose;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(8));
		
		buffer.packet(79);

		buffer.writeByteS(autoclose ? 1 : 0);
		buffer.writeLEInt((target << 16) | targetChild);
		buffer.writeShortA(id);
		
		return buffer;
	}
	
}
