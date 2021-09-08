package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class UpdatePlayers extends Command {
	
	private RSBuffer buffer;
	
	public UpdatePlayers(RSBuffer payload) {
		buffer = payload;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		return buffer;
	}
}
