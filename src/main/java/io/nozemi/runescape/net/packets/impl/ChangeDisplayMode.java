package io.nozemi.runescape.net.packets.impl;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.Opcodes;
import org.springframework.stereotype.Component;

import static io.nozemi.runescape.net.packets.PacketConstants.CHANGE_DISPLAY_MODE;

@Component
@Opcodes(CHANGE_DISPLAY_MODE)
public class ChangeDisplayMode extends GamePacket {

    private int displayMode;
    private int displayWidth;
    private int displayHeight;

    @Override
    public ChangeDisplayMode createFrom(RSBuffer packet) {
        displayMode = packet.readByte();
        displayWidth = packet.readUShort();
        displayHeight = packet.readUShort();
        return this;
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
