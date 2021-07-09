package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * @author Mack
 */
public class SetClientTimer extends Command {

    private int id;
    private int ticks;

    public SetClientTimer(int id, int ticks) {
        this.id = id;
        this.ticks = ticks;
    }

    @Override
    protected RSBuffer encode(Player player) {
        RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(1 + 4 + 1)).packet(-1);

        buffer.writeByte(id);
        buffer.writeInt(ticks);

        return buffer;
    }
}
