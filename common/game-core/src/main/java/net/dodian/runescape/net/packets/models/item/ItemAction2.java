package net.dodian.runescape.net.packets.models.item;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.ITEM_ACTION_2;

@Opcodes(ITEM_ACTION_2)
public class ItemAction2 extends ItemAction {

    @Override
    public GamePacket decode(RSBuffer buffer) {
        this.slot = buffer.readUShort();
        this.item = buffer.readULEShort();
        this.hash = buffer.readLEInt();
        return this;
    }

    @Override
    public ItemAction2 newInstance() {
        return new ItemAction2();
    }
}
