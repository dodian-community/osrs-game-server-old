package net.dodian.runescape.net.message.game;

import io.netty.channel.ChannelHandlerContext;
import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;

/**
 * Created by Bart Pelle on 8/22/2014.
 * <p>
 * Represents an incoming action sent by the client to the server.
 */
public interface Action {
	
	void decode(RSBuffer buf, ChannelHandlerContext ctx, int opcode, int size, Player player);
	
	void process(Player player);
	
	default void log(Player player, int id, int size, String format, Object... params) {
	}
	
}
