package io.nozemi.runescape.net.packets.models;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.annotations.Opcodes;

import static io.nozemi.runescape.net.packets.PacketConstants.MOUSE_CLICK;

/**
 * Not sure what this packet is used for, but could be used in the future for detecting bots.
 * One client cycle is 20ms, which means 400 = 10 seconds since last click.
 */
@Opcodes(MOUSE_CLICK)
public class ClickAction extends GamePacket {
    private int secondsSinceLastClick;
    private int windowCoordinateX;
    private int windowCoordinateY;

    @Override
    public ClickAction decode(RSBuffer buffer) {
        this.secondsSinceLastClick = buffer.readShort();
        this.windowCoordinateX = buffer.readShort();
        this.windowCoordinateY = buffer.readShort();
        return this;
    }

    @Override
    public ClickAction newInstance() {
        return new ClickAction();
    }

    public int getSecondsSinceLastClick() {
        return secondsSinceLastClick;
    }

    public int getWindowCoordinateX() {
        return windowCoordinateX;
    }

    public int getWindowCoordinateY() {
        return windowCoordinateY;
    }
}
