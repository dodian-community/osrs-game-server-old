package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Bart on 10/4/2015.
 */
public class InterfaceSwitch extends Command {
	
	private int from;
	private int to;
	
	public InterfaceSwitch(int fromId, int fromSub, int toId, int toSub) {
		from = (fromId << 16) | fromSub;
		to = (toId << 16) | toSub;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		return new RSBuffer(player.channel().alloc().buffer(9)).packet(14).writeIntV2(from).writeIntV1(to);
	}

}
