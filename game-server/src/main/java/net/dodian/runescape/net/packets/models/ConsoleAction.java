package net.dodian.runescape.net.packets.models;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.net.packets.GamePacket;
import net.dodian.runescape.net.packets.annotations.Opcodes;

import static net.dodian.runescape.net.packets.PacketConstants.CONSOLE_ACTION;

@Opcodes(CONSOLE_ACTION)
public class ConsoleAction extends GamePacket {

    private String command;

    @Override
    public ConsoleAction decode(RSBuffer buffer) {
        this.command = buffer.readString();
        return this;
    }

    @Override
    public GamePacket newInstance() {
        return new ConsoleAction();
    }

    public String getCommand() {
        return command;
    }
}
