package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public class UpdateSkill extends Command {
	
	private int skill;
	private int level;
	private int xp;
	
	public UpdateSkill(int skill, int level, int xp) {
		this.skill = skill;
		this.level = level;
		this.xp = xp;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(7));
		
		buffer.packet(10);

		buffer.writeIntV1(xp);
		buffer.writeByteA(skill);
		buffer.writeByteN(level);
		
		return buffer;
	}
}
