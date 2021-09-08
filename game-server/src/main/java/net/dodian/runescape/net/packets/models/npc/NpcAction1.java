package net.dodian.runescape.net.packets.models.npc;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.NPC_ACTION_1;

@Opcodes(NPC_ACTION_1)
public class NpcAction1 extends NpcAction {

    @Override
    public NpcAction1 decode(RSBuffer buffer) {
        this.index = buffer.readUShortA();
        this.run = buffer.readByteN() == 1;
        return this;
    }

    @Override
    public NpcAction1 newInstance() {
        return new NpcAction1();
    }
}
