package net.dodian.runescape.net.packets.models.object;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.OBJECT_ACTION_1;

@Opcodes(OBJECT_ACTION_1)
public class ObjectAction1 extends ObjectAction {

    @Override
    public ObjectAction decode(RSBuffer buffer) {
        this.z = buffer.readUShort();
        this.x = buffer.readUShortA();
        this.id = buffer.readUShort();
        this.run = buffer.readByte() == 1;
        return this;
    }

    @Override
    public ObjectAction1 newInstance() {
        return new ObjectAction1();
    }
}
