package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.WidgetTimer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

public class SendWidgetTimer extends Command {

	private WidgetTimer widgetTimer;
	private int seconds;

	public SendWidgetTimer(WidgetTimer widgetTimer, int seconds) {
		this.widgetTimer = widgetTimer;
		this.seconds = seconds;
	}
	
	@Override
	protected RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(4)).packet(91).writeSize(RSBuffer.SizeType.SHORT);

		buffer.writeByte(widgetTimer.getSpriteId());
		buffer.writeShort(seconds * 50);
		buffer.writeString(widgetTimer.getName());
		buffer.writeString(widgetTimer.getDescription());
		
		return buffer;
	}

	private static int strLen(String string) {
		return string == null ? 0 : string.length() + 1;
	}


}
