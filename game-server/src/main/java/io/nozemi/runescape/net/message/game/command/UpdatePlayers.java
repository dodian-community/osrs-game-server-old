package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

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
