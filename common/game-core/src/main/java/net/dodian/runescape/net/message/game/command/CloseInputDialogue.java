package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Bart on 10/2/2015.
 * <p>
 * Closes a dialogue on the screen.
 */
public class CloseInputDialogue extends Command {
	
	@Override
	public RSBuffer encode(Player player) {
		return new RSBuffer(player.channel().alloc().buffer(1)).packet(45);
	}
	
}
