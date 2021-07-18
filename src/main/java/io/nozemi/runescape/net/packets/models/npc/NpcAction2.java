package io.nozemi.runescape.net.packets.models.npc;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.annotations.Opcodes;

import static io.nozemi.runescape.net.packets.PacketConstants.NPC_ACTION_2;

@Opcodes(NPC_ACTION_2)
public class NpcAction2 extends NpcAction {

    @Override
    public NpcAction2 decode(RSBuffer buffer) {
        this.run = buffer.readByteA() == 1;
        this.index = buffer.readULEShortA();
        return this;
    }

    @Override
    public NpcAction2 newInstance() {
        return new NpcAction2();
    }
}
