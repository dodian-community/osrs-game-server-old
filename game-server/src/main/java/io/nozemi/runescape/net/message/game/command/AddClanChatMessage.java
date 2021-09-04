package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;
import io.nozemi.runescape.util.UsernameUtilities;

import java.security.SecureRandom;

/**
 * Created by Bart on 8/11/2015.
 */
public class AddClanChatMessage extends Command {
	
	public static SecureRandom random = new SecureRandom();
	
	private String sender;
	private String chatname;
	private int world;
	private String text;
	private int icon;
	private int id = random.nextInt(0xFFFFFF);
	
	public AddClanChatMessage(String sender, String chat, int icon, int world, String text) {
		this.sender = sender;
		this.chatname = chat;
		this.world = world;
		this.text = text;
		this.icon = icon;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(text.length())).packet(24).writeSize(RSBuffer.SizeType.BYTE);
		
		buffer.writeString(sender);
		buffer.writeLong(UsernameUtilities.encodeUsername(chatname));
		buffer.writeShort(world);
		buffer.writeTriByte(id);
		buffer.writeByte(icon);
		
		byte[] huffmandata = new byte[256];
		// TODO: Get huffman instance here
		//int len = player.world().server().huffman().encode(text, huffmandata);
		
		buffer.writeCompact(text.length());
		//buffer.get().writeBytes(huffmandata, 0, len);
		
		return buffer;
	}
	
}
