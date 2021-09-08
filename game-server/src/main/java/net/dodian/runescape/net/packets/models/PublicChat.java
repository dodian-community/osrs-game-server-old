package net.dodian.runescape.net.packets.models;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.SEND_PUBLIC_MESSAGE;

@Opcodes(SEND_PUBLIC_MESSAGE)
public class PublicChat extends GamePacket {

    private int effect;
    private int color;
    private int len;
    private byte[] data;
    private int type;
    
    @Override
    public PublicChat decode(RSBuffer buffer) {
        this.type = buffer.readByte();
        this.color = buffer.readByte();
        this.effect = buffer.readByte();
        this.len = buffer.readCompact();
        this.data = new byte[buffer.get().readableBytes()];
        buffer.get().readBytes(data);
        return this;
    }

    @Override
    public PublicChat newInstance() {
        return new PublicChat();
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
