package io.nozemi.runescape.net.message.game.command;

import io.netty.buffer.Unpooled;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class ChangeMapVisibility extends Command {
	
	private int state;
	
	public ChangeMapVisibility(int state) {
		this.state = state;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(Unpooled.buffer());
		buffer.packet(82);
		buffer.writeByte(state);
		return buffer;
	}

}
