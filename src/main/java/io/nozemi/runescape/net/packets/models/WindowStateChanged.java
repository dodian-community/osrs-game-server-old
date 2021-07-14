package io.nozemi.runescape.net.packets.models;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.annotations.Opcodes;

import static io.nozemi.runescape.net.packets.PacketConstants.WINDOW_STATE_CHANGED;

@Opcodes(WINDOW_STATE_CHANGED)
public class WindowStateChanged extends GamePacket {

    private boolean visible;

    @Override
    public WindowStateChanged decode(RSBuffer buffer) {
        this.visible = buffer.readByte() == 1;
        return this;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public WindowStateChanged clone() {
        return new WindowStateChanged();
    }
}
