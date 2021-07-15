package io.nozemi.runescape.net.packets.models;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.annotations.Opcodes;

import static io.nozemi.runescape.net.packets.PacketConstants.CHANGE_DISPLAY_MODE;

@Opcodes(CHANGE_DISPLAY_MODE)
public class ChangeDisplayMode extends GamePacket {
    
    private int displayMode;
    private int displayWidth;
    private int displayHeight;

    @Override
    public ChangeDisplayMode decode(RSBuffer buffer) {
        displayMode = buffer.readByte();
        displayWidth = buffer.readUShort();
        displayHeight = buffer.readUShort();
        return this;
    }

    @Override
    public GamePacket newInstance() {
        return new ChangeDisplayMode();
    }

    public int getDisplayMode() {
        return displayMode;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }
}