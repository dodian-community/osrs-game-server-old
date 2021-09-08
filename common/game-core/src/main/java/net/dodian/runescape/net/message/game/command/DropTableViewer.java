package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

import java.util.List;

public class DropTableViewer extends Command {

	private String name;
	private int petId, petAverage;
	private List<Integer[]> drops;

	public DropTableViewer(String name, int petId, int petAverage, List<Integer[]> drops) {
		this.name = name;
		this.petId = petId;
		this.petAverage = petAverage;
		this.drops = drops;
	}
	
	@Override
	protected RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(3 + strLen(name) + 4 + (drops.size() * 13))).packet(86).writeSize(RSBuffer.SizeType.SHORT);

		buffer.writeString(name);
		buffer.writeShort(petId);
		buffer.writeShort(petAverage);

		for(Integer[] drop : drops) {
			buffer.writeShort(drop[0]);	//id
			buffer.writeByte(drop[1]);	//broadcast
			buffer.writeInt(drop[2]);	//min
			buffer.writeInt(drop[3]);	//max
			buffer.writeShort(drop[4]);	//average
		}
		
		return buffer;
	}

	private static int strLen(String string) {
		return string == null ? 0 : string.length() + 1;
	}


}
