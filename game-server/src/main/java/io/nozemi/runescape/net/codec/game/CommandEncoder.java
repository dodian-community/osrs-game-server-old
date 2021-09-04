package io.nozemi.runescape.net.codec.game;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.Privilege;
import io.nozemi.runescape.net.ServerHandler;
import io.nozemi.runescape.net.message.game.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
@ChannelHandler.Sharable
public class CommandEncoder extends MessageToByteEncoder<Command> {
	
	private static final Logger logger = LogManager.getLogger(CommandEncoder.class);
	
	static int[] good_boys = new int[]{3, 36, 16, 79, 56, 8, 33, 37, 10, 54, 49, 50, 7, 11, 20, 21, 35, 62,
			58, 76, 82, 46, 14, 71, 13, 47, 44, 27, 17, 64, 26, 24, 42, 30, 45, 53, 84, 85, 0, 65, 70, 68, 29,
			78, 86, 61, 75, 87, 9, 88, 81, 41, 89, 90, 5, 43, 91};
	
	@Override
	protected void encode(ChannelHandlerContext ctx, Command msg, ByteBuf out) throws Exception {
		try {
			Player player = ctx.channel().attr(ServerHandler.ATTRIB_PLAYER).get();
			RSBuffer buffer = msg.write(player);

			if (buffer == null) {
				return;
			}
			
			buffer.finish();
			
			boolean write = false;
			for (int i : good_boys) {
				if (i == buffer.packet()) {
					write = true;
					break;
				}
			}
			
			if (!write && player.privilege() == Privilege.ADMIN) {
				logger.info("Refusing to write packet {} ({}) because it's not whitelisted.", buffer.packet(), msg.getClass().getSimpleName());
			}
			
			if (write && buffer.packet() != -1) {
				out.writeByte((byte) buffer.packet()/* + (byte)player.outrand().nextInt()*/);
				
				byte[] bytes = buffer.get().array();
				for (int i = 0; i < buffer.get().readableBytes(); i++) {
					out.writeByte(bytes[i]);
				}
			}
			
			if (!buffer.reusable())
				buffer.get().release();
		} catch (Exception e) {
			logger.error("Error while encoding {}", msg, e);
		}
	}
	
}
