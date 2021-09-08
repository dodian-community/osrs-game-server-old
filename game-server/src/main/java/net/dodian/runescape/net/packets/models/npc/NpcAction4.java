package net.dodian.runescape.net.packets.models.npc;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.NPC_ACTION_4;

@Opcodes(NPC_ACTION_4)
public class NpcAction4 extends NpcAction {

    @Override
    public NpcAction4 decode(RSBuffer buffer) {
        this.run = buffer.readByte() == 1;
        this.index = buffer.readUShortA();
        return this;
    }

    @Override
    public NpcAction4 newInstance() {
        return new NpcAction4();
    }
}
