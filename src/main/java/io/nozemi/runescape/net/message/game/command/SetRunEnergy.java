package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Jak on 19/12/2015.
 */
public class SetRunEnergy extends Command {
	
	private int run = 0;
	
	private static final SetRunEnergy[] energyBuffers = new SetRunEnergy[101];
	
	public static SetRunEnergy get(int run) {
		return energyBuffers[run] == null ? (energyBuffers[run] = new SetRunEnergy(run).markReusable()) : energyBuffers[run];
	}
	
	private SetRunEnergy(int run) {
		this.run = run;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(1)).packet(46);
		buffer.writeByte(run);
		return buffer;
	}
	
}
