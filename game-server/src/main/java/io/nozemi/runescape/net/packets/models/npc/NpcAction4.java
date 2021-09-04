package io.nozemi.runescape.net.packets.models.npc;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.annotations.Opcodes;

import static io.nozemi.runescape.net.packets.PacketConstants.NPC_ACTION_4;

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
