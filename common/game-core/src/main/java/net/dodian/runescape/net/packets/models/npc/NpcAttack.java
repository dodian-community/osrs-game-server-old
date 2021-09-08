package net.dodian.runescape.net.packets.models.npc;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;
import net.dodian.runescape.net.packets.PacketConstants;
import net.dodian.runescape.net.packets.annotations.Opcodes;

@Opcodes(PacketConstants.NPC_ATTACK)
public class NpcAttack extends GamePacket {

    private boolean run;
    private int index;

    @Override
    public NpcAttack decode(RSBuffer buffer) {
        this.index = buffer.readULEShortA();
        this.run = buffer.readByteS() == 1;
        return this;
    }

    @Override
    public NpcAttack newInstance() {
        return new NpcAttack();
    }

    public int getIndex() {
        return index;
    }

    public boolean isRunning() {
        return run;
    }
}
