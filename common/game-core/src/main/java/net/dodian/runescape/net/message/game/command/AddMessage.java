package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class AddMessage extends Command {
	
	private String text;
	private Type type;
	private String username;
	
	public AddMessage(String text) {
		this.text = text;
		this.type = Type.GAME; // Default to unfilterable
	}
	
	public AddMessage(String text, Type type) {
		this.text = text;
		this.type = type;
	}
	
	public AddMessage(String text, Type type, String username) {
		this.text = text;
		this.type = type;
		this.username = username;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(1 + 1 + text.length() + (username == null ? 0 : username.length()) + 1));
		buffer.packet(21).writeSize(RSBuffer.SizeType.BYTE);
		
		buffer.writeCompact(type.id);
		
		buffer.writeByte(username == null ? 0 : 1);
		if (username != null) {
			buffer.writeString(username);
		}
		
		// This used to crash the server as it would exceed the 255 bytes cap.
		// The fix below is done to limit the number of bytes down the wire.
		int spaceUsed = buffer.get().writerIndex() - 1;
		int spaceAvailable = 0xFF - spaceUsed;
		int spaceRequired = text.getBytes().length + 1; // Null terminator included.
		
		if (spaceRequired > spaceAvailable) {
			text = text.substring(0, spaceAvailable - 1); // Leave 1 byte for null terminator.
		}
		
		buffer.writeString(text);
		return buffer;
	}
	
	public static enum Type {
		BROADCAST(14), GAME(29), TRADING(101), URL(69), DUEL(103), CLAN_WAR(104), GAME_FILTER(105);
		int id;
		
		Type(int id) {
			this.id = id;
		}
	}
	
}
