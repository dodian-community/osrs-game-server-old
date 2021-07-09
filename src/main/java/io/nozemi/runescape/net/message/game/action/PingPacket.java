package io.nozemi.runescape.net.message.game.action;

import io.netty.channel.ChannelHandlerContext;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.PacketInfo;

/**
 * Created by Jonathan on 08/03/2017.
 */
@PacketInfo(size = 0)
public class PingPacket implements Action {
	
	@Override
	public void decode(RSBuffer buf, ChannelHandlerContext ctx, int opcode, int size, Player player) {
		player.lastPing(System.currentTimeMillis());
	}
	
	@Override
	public void process(Player player) {
	}
}
