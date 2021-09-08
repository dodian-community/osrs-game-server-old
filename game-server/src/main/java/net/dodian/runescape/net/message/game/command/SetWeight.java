package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Situations on 12/31/2015.
 */
public class SetWeight extends Command {
	
	private double weight = 0;
	
	public SetWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(3)).packet(53);
		
		buffer.writeShort((int) weight);
		
		return buffer;
	}
	
}