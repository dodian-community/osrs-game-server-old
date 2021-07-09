package io.nozemi.runescape.net.message.game.action;

import io.netty.channel.ChannelHandlerContext;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.PacketInfo;
import io.nozemi.runescape.util.Varbit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Bart on 9-7-2015.
 */
@PacketInfo(size = 5)
public class ChangeDisplayMode implements Action {
	
	private static final Logger logger = LogManager.getLogger(ChangeDisplayMode.class);
	
	private int displayMode;
	private int displayWidth;
	private int displayHeight;
	
	@Override
	public void decode(RSBuffer buf, ChannelHandlerContext ctx, int opcode, int size, Player player) {
		displayMode = buf.readByte();
		displayWidth = buf.readUShort();
		displayHeight = buf.readUShort();
		
		log(player, opcode, size, "mode=%d width=%d height=%d", displayMode, displayWidth, displayHeight);
	}
	
	@Override
	public void process(Player player) {
		//player.debug("Displaymode change: mode={%d}, width={%d}, height={%d}", displayMode, displayWidth, displayHeight);
		boolean wasResizable = player.interfaces().resizable();
		if ((wasResizable && displayMode == 2) || (!wasResizable && displayMode == 1)) { // dimension change only
			//System.err.println("same mode. ignoring...");
			return;
		}
		player.interfaces().resizable(displayMode == 2);
		
		player.interfaces().sendForMode(!wasResizable ? 0 : player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 1 ? 2 : 1,
				displayMode == 1 ? 0 : displayMode == 2 && player.varps().varbit(Varbit.SIDESTONES_ARRANGEMENT) == 1 ? 2 : 1);
		
	}
}
