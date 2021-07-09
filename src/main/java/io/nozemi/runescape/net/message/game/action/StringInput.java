package io.nozemi.runescape.net.message.game.action;

import io.netty.channel.ChannelHandlerContext;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.PacketInfo;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
@PacketInfo(size = -1)
public class StringInput implements Action {
	
	private String value;
	
	@Override
	public void process(Player player) {
		if (value == null || value.isEmpty())
			return;
		//player.world().server().scriptExecutor().continueFor(player, WaitReason.DIALOGUE, value);
	}
	
	@Override
	public void decode(RSBuffer buf, ChannelHandlerContext ctx, int opcode, int size, Player player) {
		value = buf.readString();
		log(player, opcode, size, "%s", value);
	}
	
}
