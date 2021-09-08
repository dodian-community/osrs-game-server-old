package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Bart on 8/11/2015.
 */
public class AddReceivedPrivateMessage extends Command {
	
	private String sender;
	private int world;
	private String text;
	private int icon;
	private int id = AddClanChatMessage.random.nextInt(0xFFFFFF);
	
	public AddReceivedPrivateMessage(String sender, int icon, int world, String text) {
		this.sender = sender;
		this.icon = icon;
		this.world = world;
		this.text = text.replace('\0', ' ');
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(text.length())).packet(30).writeSize(RSBuffer.SizeType.SHORT);
		
		buffer.writeString(sender);
		buffer.writeShort(world);
		buffer.writeTriByte(id);
		buffer.writeByte(icon);
		
		byte[] huffmandata = new byte[512];
		// TODO: Find a way to add huffman
		//int len = player.world().server().huffman().encode(text, huffmandata);
		
		buffer.writeCompact(text.length());
		//buffer.get().writeBytes(huffmandata, 0, len);
		
		return buffer;
	}
	
}
