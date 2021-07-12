package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.Opcodes;
import org.springframework.stereotype.Component;

import static io.nozemi.runescape.net.packets.PacketConstants.SEND_PUBLIC_MESSAGE;

@Component
@Opcodes(SEND_PUBLIC_MESSAGE)
public class PublicChat extends GamePacket {

    private int effect;
    private int color;
    private int len;
    private byte[] data;
    private int type;

    @Override
    public PublicChat createFrom(RSBuffer packet) {
        this.type = packet.readByte();
        this.color = packet.readByte();
        this.effect = packet.readByte();
        this.len = packet.readCompact();
        this.data = new byte[packet.get().readableBytes()];
        packet.get().readBytes(data);
        return this;
    }

    public int getEffect() {
        return effect;
    }

    public int getColor() {
        return color;
    }

    public int getLen() {
        return len;
    }

    public byte[] getData() {
        return data;
    }

    public int getType() {
        return type;
    }
}
