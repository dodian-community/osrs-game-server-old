package io.nozemi.runescape.net.packets;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import org.springframework.stereotype.Component;

@Component
public abstract class GamePacket {
    protected int opcode;
    protected boolean cancelled = false;

    public abstract GamePacket createFrom(RSBuffer packet);

    public void cancel() {
        this.cancelled = true;
    }

    public int getOpcode() {
        return opcode;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
