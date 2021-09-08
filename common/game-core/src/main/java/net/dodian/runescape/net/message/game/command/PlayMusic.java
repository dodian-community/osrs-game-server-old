package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class PlayMusic extends Command {
	
	private int track;
	
	public PlayMusic(int track) {
		this.track = track;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(3));
		buffer.packet(29);
		
		buffer.writeShortA(track);
		
		return buffer;
	}
}
