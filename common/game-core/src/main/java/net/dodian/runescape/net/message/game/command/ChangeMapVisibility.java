package net.dodian.runescape.net.message.game.command;

import io.netty.buffer.Unpooled;
import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

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
