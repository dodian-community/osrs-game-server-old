package net.dodian.runescape.net.message.game.command;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.Entity;
import net.dodian.runescape.model.Tile;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.net.message.game.Command;

/**
 * Created by Jak on 19/12/2015.
 */
public class SetHintArrow extends Command {
	
	private Entity target = null;
	
	// Not sure what this is for again, need to check client
	private int type = 1;
	private int x;
	private int y;
	private int heightAboveTile;
	
	public SetHintArrow(Entity e, int type) {
		this.target = e;
		this.type = type;
	}
	
	public SetHintArrow(Entity e) {
		this.target = e;
	}
	
	public SetHintArrow(int type) {
		this.target = null;
		this.type = 1;
	}
	
	public SetHintArrow(Tile tile) {
		this.type = 2;
		this.x = tile.x;
		this.y = tile.z;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(6)).packet(-1);
		
		if (type < 2) {
			buffer.writeByte(target == null ? 1 : target.isPlayer() ? 10 : 1);
			buffer.writeShort(target == null ? -1 : target.index());
			buffer.writeTriByte(0);//actually 3 bytes but lazy
		} else {
			buffer.writeByte(type);
			buffer.writeShort(x);
			buffer.writeShort(y);
			buffer.writeByte(heightAboveTile);
		}
		
		return buffer;
	}
}
