package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Jak on 04/08/2016.
 */
public class InterfaceSwitchBulk extends Command {
	
	private int pane;
	private int[][] sendinterfaces;
	private int[][] cs;
	
	public InterfaceSwitchBulk(int pane, int[][] faces, int[][] settings) {
		this.pane = pane;
		this.sendinterfaces = faces;
		this.cs = settings;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(2 + (sendinterfaces.length * 7)
				+ (cs.length * 12))).packet(117);
		buffer.writeShort(pane);
		buffer.writeShort(sendinterfaces.length);
		for (int[] info : sendinterfaces) {
			buffer.writeInt(info[0]); // target hash
			buffer.writeShort(info[1]); // id
			buffer.writeByte(info[2]); // click through / solid
		}
		// Yes, the write methods are different from the individual packets.
		for (int[] info : cs) {
			buffer.writeInt(info[0]); // target hash
			buffer.writeShort(info[1]); // from
			buffer.writeShort(info[2]); // to
			buffer.writeInt(info[3]); // vlalue
		}
		return buffer;
	}
}
