package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

public class SendTournamentFighters extends Command {

	private String playerOne;
	private String playerTwo;


	public SendTournamentFighters(String playerOne, String playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}
	
	@Override
	protected RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(4)).packet(21).writeSize(RSBuffer.SizeType.SHORT);

		buffer.writeString(playerOne);
		buffer.writeString(playerTwo);

		return buffer;
	}
}
