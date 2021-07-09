package io.nozemi.runescape.net.message.game.action;

import io.netty.channel.ChannelHandlerContext;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.PathQueue;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.Privilege;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.PacketInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
@PacketInfo(size = -1)
public class WalkMap implements Action {
	
	private static final Logger logger = LogManager.getLogger();
	
	private int x;
	private int z;
	private int mode;
	
	@Override
	public void decode(RSBuffer buf, ChannelHandlerContext ctx, int opcode, int size, Player player) {
		x = buf.readUShort();
		mode = buf.readByteN();
		z = buf.readULEShort();
		
		log(player, opcode, size, "x=%d z=%d mode=%d", x, z, mode);
	}
	
	@Override
	public void process(Player player) {
		// Mode 2 is ctrl-shift clicking, teleporting to the tile.
		if (mode == 2 && (player.privilege().eligibleTo(Privilege.ADMIN))) {
			player.teleport(x, z, player.tile().level);
			player.interfaces().closeMain();
			player.stopActions(true);
			return;
		}
		
		if (!player.locked() && !player.dead()) {
			double energy = player.attribOr(AttributeKey.RUN_ENERGY, 0.0);
			if (mode == 1 && energy <= 1) {
				mode = 0;
			}
			if (player.looks().trans() == 3008) {
				Tile targ = player.walkTo(x, z, PathQueue.StepType.FORCED_WALK);
			} else {
				Tile targ = player.walkTo(x, z, mode == 1 ? PathQueue.StepType.FORCED_RUN : PathQueue.StepType.REGULAR);
			}
		}
	}
}
