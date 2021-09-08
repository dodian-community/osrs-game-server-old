package net.dodian.runescape.net.packets.models.item;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.ITEM_ACTION_1;

@Opcodes(ITEM_ACTION_1)
public class ItemAction1 extends ItemAction {

    @Override
    public GamePacket decode(RSBuffer buffer) {
        this.slot = buffer.readULEShortA();
        this.item = buffer.readUShortA();
        this.hash = buffer.readInt();
        return this;
    }

    @Override
    public ItemAction1 newInstance() {
        return new ItemAction1();
    }
}
