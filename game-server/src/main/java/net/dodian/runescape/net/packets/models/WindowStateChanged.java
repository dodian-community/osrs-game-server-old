package net.dodian.runescape.net.packets.models;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.WINDOW_STATE_CHANGED;

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
    public WindowStateChanged newInstance() {
        return new WindowStateChanged();
    }
}
