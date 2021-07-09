package io.nozemi.runescape.net.message.game.action;

import io.netty.channel.ChannelHandlerContext;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.PacketInfo;

/**
 * Created by Bart on 10/3/2015.
 */
@PacketInfo(size = 4)
public class DialogueOption implements Action {
	
	private int hash;
	
	@Override
	public void decode(RSBuffer buf, ChannelHandlerContext ctx, int opcode, int size, Player player) {
		hash = buf.readInt();
		
		log(player, opcode, size, "inter=%d child=%d", hash >> 16, hash & 0xFFFF);
	}
	
	@Override
	public void process(Player player) {
		//player.debug("Dialogue option: [%d:%d]", hash >> 16, hash & 0xFFFF);
		//player.world().server().scriptExecutor().continueFor(player, WaitReason.DIALOGUE, hash);
		//player.world().server().scriptRepository().triggerButton(player, hash >> 16, hash & 0xFFFF, 0, 0, -1);
	}
	
}
