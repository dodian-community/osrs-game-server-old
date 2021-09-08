package net.dodian.runescape.net.packets.models.object;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.OBJECT_ACTION_2;

@Opcodes(OBJECT_ACTION_2)
public class ObjectAction2 extends ObjectAction {

    @Override
    public ObjectAction decode(RSBuffer buffer) {
        this.x = buffer.readULEShort();
        this.z = buffer.readUShort();
        this.run = buffer.readByte() == 1;
        this.id = buffer.readULEShortA();
        return this;
    }

    @Override
    public ObjectAction2 newInstance() {
        return new ObjectAction2();
    }
}
