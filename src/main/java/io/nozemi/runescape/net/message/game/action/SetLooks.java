package io.nozemi.runescape.net.message.game.action;

import io.netty.channel.ChannelHandlerContext;
import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.player.Privilege;
import io.nozemi.runescape.net.message.game.Action;
import io.nozemi.runescape.net.message.game.PacketInfo;
import io.nozemi.runescape.util.Varp;

/**
 * Created by Bart on 11/15/2015.
 */
@PacketInfo(size = 18)
public class SetLooks implements Action {
	
	private int[] looks = new int[7];
	private int[] colors = new int[5];
	private boolean female;
	
	@Override
	public void decode(RSBuffer buf, ChannelHandlerContext ctx, int opcode, int size, Player player) {
		female = buf.readByte() == 1;
		for (int i = 0; i < 7; i++) {
			looks[i] = buf.readUByte();
			if (looks[i] < 0)
				looks[i] = 0;
		}
		for (int i = 0; i < 5; i++) {
			colors[i] = buf.readUByte();
		}
	}
	
	@Override
	public void process(Player player) {
		player.looks().female(female);
		
		// Custom skin colors, required you have kills to access these.
		int kills = player.varps().varp(Varp.KILLS) + (int) player.attribOr(AttributeKey.ALLTIME_KILLS, 0);
		if (colors[4] == 9 && kills < 100 && !player.privilege().eligibleTo(Privilege.ADMIN)) {
			player.message("<col=ff0000>You need at least 100 all-time kills to use that skin.</col>");
			colors[4] = 1; // reset it
		} else if (colors[4] == 10 && kills < 250 && !player.privilege().eligibleTo(Privilege.ADMIN)) {
			player.message("<col=ff0000>You need at least 250 all-time kills to use that skin.</col>");
			colors[4] = 1; // reset it
		} else if (colors[4] == 11 && kills < 500 && !player.privilege().eligibleTo(Privilege.ADMIN)) {
			player.message("<col=ff0000>You need at least 500 all-time kills to use that skin.</col>");
			colors[4] = 1; // reset it
		} else if (colors[4] == 14 && !player.<Boolean>attribOr(AttributeKey.GOLD_SKIN_UNLOCKED, false)) {
			player.message("<col=ff0000>You don't have the Gold Skin yet.</col>");
			colors[4] = 1; // reset it
		}
		
		player.looks().colors(colors);
		player.looks().looks(looks);
		player.looks().update();
		player.stopActions(true);
	}
}
