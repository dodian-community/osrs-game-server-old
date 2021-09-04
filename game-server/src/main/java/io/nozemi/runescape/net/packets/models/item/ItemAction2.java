package io.nozemi.runescape.net.packets.models.item;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.annotations.Opcodes;

import static io.nozemi.runescape.net.packets.PacketConstants.ITEM_ACTION_2;

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
