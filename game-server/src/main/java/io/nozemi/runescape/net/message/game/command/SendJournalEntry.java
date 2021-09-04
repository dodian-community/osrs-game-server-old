package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

public class SendJournalEntry extends Command {

	private int childId, colorIndex;
	private String text;

	public SendJournalEntry(int childId, String text, int colorIndex) {
		this.childId = childId;
		this.text = text;
		this.colorIndex = colorIndex;
	}
	
	@Override
	protected RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(2 + strLen(text) + 1)).packet(85).writeSize(RSBuffer.SizeType.BYTE); //6 for entry

		buffer.writeCompact(childId);
		buffer.writeString(text);
		buffer.writeByte(colorIndex);
		
		return buffer;
	}

	private static int strLen(String string) {
		return string == null ? 0 : string.length() + 1;
	}


}
