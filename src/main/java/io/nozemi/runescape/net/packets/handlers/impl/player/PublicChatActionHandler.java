package io.nozemi.runescape.net.packets.handlers.impl.player;

import io.nozemi.runescape.content.mechanics.Censor;
import io.nozemi.runescape.handlers.impl.DataHandler;
import io.nozemi.runescape.model.ChatMessage;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.packets.handlers.PacketHandler;
import io.nozemi.runescape.net.packets.handlers.PacketListener;
import io.nozemi.runescape.net.packets.impl.PublicChat;
import io.nozemi.runescape.util.HuffmanCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublicChatActionHandler extends PacketListener {

    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_AUTO_CHAT = 1;
    private static final int TYPE_CLAN_CHAT = 2;

    private final HuffmanCodec codec;

    @Autowired
    public PublicChatActionHandler(DataHandler dataHandler) {
        this.codec = dataHandler.huffman();
    }

    @PacketHandler
    public void onChat(PublicChat packet, Player player) {
        byte[] stringData = new byte[256];
        codec.decode(packet.getData(), stringData, 0, 0, packet.getLen());
        String message = new String(stringData, 0, packet.getLen());

        int icon = player.calculateBaseIcon();

        ChatMessage chatMessage = new ChatMessage(message, packet.getEffect(), packet.getColor(), icon, packet.getType() == TYPE_AUTO_CHAT);
        player.sync().publicChatDampered = Censor.dampered(player, message);
        chatMessage.starred(Censor.starred(message));
        player.sync().publicChatMessage(chatMessage);
    }
}
