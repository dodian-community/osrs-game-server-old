package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

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
