package io.nozemi.runescape.net.message.game.action;

import io.netty.channel.ChannelHandlerContext;
import io.nozemi.runescape.GameInitializer;
import io.nozemi.runescape.content.mechanics.Censor;
import io.nozemi.runescape.handlers.impl.DataHandler;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.ChatMessage;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.PacketInfo;
import io.nozemi.runescape.util.HuffmanCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
@PacketInfo(size = -1)
public class PublicChat implements Action {
	
	private static final int TYPE_NORMAL = 0;
	private static final int TYPE_AUTOCHAT = 1;
	private static final int TYPE_CLANCHAT = 2;
	
	private int effect;
	private int color;
	private int len;
	private byte[] data;
	private int type;

	private final HuffmanCodec codec;

	public PublicChat(DataHandler dataHandler) {
		this.codec = dataHandler.huffman();
	}
	
	@Override
	public void process(Player player) {
		// Don't allow muted people to speak. They are baddies.
		// If they shadow muted they get special treatment :D
		/*if (!player.shadowMuted() && player.muted()) {
			player.message("You're currently muted and cannot talk.");
			return;
		}*/
		
		// Decode huffman data
		byte[] stringData = new byte[256];
		codec.decode(data, stringData, 0, 0, len);
		String message = new String(stringData, 0, len);
		
		/*if (type == TYPE_CLANCHAT) {
			// Resolve our clan and print if none
			Optional<ClanChat> chat = ClanChat.current(player);
			if (!chat.isPresent()) {
				player.message("You are currently not in a clan chat channel.");
				return;
			}
			
			String line = L10n.formatChatMessage(message.substring(1));
			chat.get().chat(player, line);
			return;
		}*/

		int icon = player.calculateBaseIcon();
		
		ChatMessage chatMessage = new ChatMessage(message, effect, color, icon, type == TYPE_AUTOCHAT);
		player.sync().publicChatDampered = Censor.dampered(player, message);
		chatMessage.starred(Censor.starred(message));
		player.sync().publicChatMessage(chatMessage);
		
		// Log it
		if (type != TYPE_AUTOCHAT && !player.bot()) {
			/*player.world().server().service(LoggingService.class, true).ifPresent(s -> {
				s.logPublicChat((Integer) player.id(), player.world().id(), player.tile().x, player.tile().z, player.tile().level, message);
			});*/
		}
	}
	
	@Override
	public void decode(RSBuffer buf, ChannelHandlerContext ctx, int opcode, int size, Player player) {
		type = buf.readByte();
		color = buf.readByte();
		effect = buf.readByte();
		
		len = buf.readCompact();
		data = new byte[buf.get().readableBytes()];
		buf.get().readBytes(data);
	}
	
}
