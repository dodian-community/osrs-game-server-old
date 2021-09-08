package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Bart Pelle on 8/22/2014.
 * <p>
 * Jak: I've dumped being in/out of wildy, challenge DA arena, inside actual DA fight arena to gather the correct positons.
 */
public class SetPlayerOption extends Command {
	
	private int slot;
	private boolean top;
	private String option;
	
	public SetPlayerOption(int slot, boolean top, String option) {
		this.slot = slot;
		this.top = top;
		this.option = option;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(1 + 1 + 1 + option.length() + 1 + 1));
		buffer.packet(17).writeSize(RSBuffer.SizeType.BYTE);

		buffer.writeByteS(top ? 1 : 0);
		buffer.writeByteN(slot);
		buffer.writeString(option);
		
		return buffer;
	}
	
}
