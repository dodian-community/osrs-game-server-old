package net.dodian.runescape.net.packets;

import io.netty.channel.ChannelHandlerContext;
import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import org.springframework.stereotype.Component;

@Component
public abstract class GamePacket {
    protected Player player;
    protected int opcode;
    protected int size;
    protected ChannelHandlerContext ctx;

    public void setSize(int size) {
        this.size = size;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getOpcode() {
        return opcode;
    }

    public int getSize() {
        return size;
    }

    public Player getPlayer() {
        return player;
    }

    public void setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public abstract GamePacket decode(RSBuffer buffer);
    public abstract GamePacket newInstance();
}
