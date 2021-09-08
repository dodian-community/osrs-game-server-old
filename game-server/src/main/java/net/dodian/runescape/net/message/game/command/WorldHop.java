package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Jak on 22/01/2016. #Gundrilla all nighter whats up
 * Finished by Bart 5/16/2016.
 */
public class WorldHop extends Command {
	
	private String host;
	private int id;
	private int flags;
	
	public WorldHop(String host, int id, int flags) {
		this.host = host;
		this.id = id;
		this.flags = flags;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(50)).packet(47).writeSize(RSBuffer.SizeType.BYTE);
		
		buffer.writeString(host);
		buffer.writeShort(id);
		buffer.writeInt(flags);
		
		return buffer;
	}
	
}
