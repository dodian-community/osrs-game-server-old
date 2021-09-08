package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Situations on 8/26/2016.
 */
public class SetRealm extends Command {
	
	private int realm;
	
	public SetRealm(int realm) {
		this.realm = realm;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(3));
		buffer.packet(253);
		
		buffer.writeShort(realm);
		
		return buffer;
	}
}
