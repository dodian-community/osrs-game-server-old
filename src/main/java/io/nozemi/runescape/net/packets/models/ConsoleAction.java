package io.nozemi.runescape.net.packets.models;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.net.packets.GamePacket;
import io.nozemi.runescape.net.packets.annotations.Opcodes;

import static io.nozemi.runescape.net.packets.PacketConstants.CONSOLE_ACTION;

@Opcodes(CONSOLE_ACTION)
public class ConsoleAction extends GamePacket {

    private String command;

    @Override
    public ConsoleAction decode(RSBuffer buffer) {
        this.command = buffer.readString();
        return this;
    }

    @Override
    public GamePacket clone() {
        return new ConsoleAction();
    }

    public String getCommand() {
        return command;
    }
}
