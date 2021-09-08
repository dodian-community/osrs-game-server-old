package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class SetRootPane extends Command {
	
	private int paneId;
	
	public SetRootPane(int paneId) {
		this.paneId = paneId;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(4));
		
		buffer.packet(16);
		buffer.writeShort(paneId);
		
		return buffer;
	}
}
