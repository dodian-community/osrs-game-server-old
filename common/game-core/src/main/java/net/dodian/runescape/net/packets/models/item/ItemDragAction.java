package net.dodian.runescape.net.packets.models.item;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.ITEM_DRAG_ACTION;

@Opcodes(ITEM_DRAG_ACTION)
public class ItemDragAction extends GamePacket {
    private int from;
    private int to;
    private boolean insert;
    private int packedInteger;

    @Override
    public ItemDragAction decode(RSBuffer buffer) {
        this.insert = buffer.readByteS() == 1;
        this.from = buffer.readULEShort();
        this.packedInteger = buffer.readLEInt();
        this.to = buffer.readULEShort();
        return this;
    }

    @Override
    public ItemDragAction newInstance() {
        return new ItemDragAction();
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public boolean isInsert() {
        return insert;
    }

    public void setInsert(boolean insert) {
        this.insert = insert;
    }

    public int getPackedInteger() {
        return packedInteger;
    }

    public void setPackedInteger(int packedInteger) {
        this.packedInteger = packedInteger;
    }
}
