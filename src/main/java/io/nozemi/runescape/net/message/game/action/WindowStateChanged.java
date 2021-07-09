package io.nozemi.runescape.net.message.game.action;

import io.netty.channel.ChannelHandlerContext;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.PacketInfo;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
@PacketInfo(size = 1)
public class WindowStateChanged implements Action {
	
	private boolean visible;
	
	@Override
	public void decode(RSBuffer buf, ChannelHandlerContext ctx, int opcode, int size, Player player) {
		visible = buf.readByte() == 1;
	}
	
	@Override
	public void process(Player player) {
		/* We could register this for antibotting :D */
	}
}
