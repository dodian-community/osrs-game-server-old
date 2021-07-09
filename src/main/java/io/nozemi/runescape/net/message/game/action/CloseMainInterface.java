package io.nozemi.runescape.net.message.game.action;

import io.netty.channel.ChannelHandlerContext;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.PacketInfo;

/**
 * Created by Bart Pelle on sept 18 2015
 */
@PacketInfo(size = 0)
public class CloseMainInterface implements Action {
	
	@Override
	public void process(Player player) {
		player.interfaces().closeMain();
	}
	
	@Override
	public void decode(RSBuffer buf, ChannelHandlerContext ctx, int opcode, int size, Player player) {
		log(player, opcode, size, "");
	}
	
}
