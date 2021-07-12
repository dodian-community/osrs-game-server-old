package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.Opcodes;
import org.springframework.stereotype.Component;

import static io.nozemi.runescape.net.packets.PacketConstants.WINDOW_STATE_CHANGED;

@Component
@Opcodes(WINDOW_STATE_CHANGED)
public class WindowStateChanged extends GamePacket {

    private boolean visible;

    @Override
    public WindowStateChanged createFrom(RSBuffer packet) {
        visible = packet.readByte() == 1;
        return this;
    }

    public boolean isVisible() {
        return visible;
    }
}
