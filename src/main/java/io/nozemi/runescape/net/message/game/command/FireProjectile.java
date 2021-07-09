package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Bart on 8/18/2015.
 */
public class FireProjectile extends Command {
	
	private Tile from;
	private Entity to;
	private Tile toTile;
	private int gfx;
	private int startHeight;
	private int endHeight;
	private int delay;
	private int lifetime;
	private int angle;
	private int steepness;
	
	public FireProjectile(Tile from, Entity to, int gfx, int startHeight, int endHeight, int delay, int lifetime, int angle, int steepness) {
		this.from = from;
		this.to = to;
		this.gfx = gfx;
		this.startHeight = startHeight;
		this.endHeight = endHeight;
		this.delay = delay;
		this.lifetime = lifetime;
		this.angle = angle;
		this.steepness = steepness;
		
		if (this.to != null)
			toTile = to.tile();
	}
	
	public FireProjectile(Tile from, Tile to, int gfx, int startHeight, int endHeight, int delay, int lifetime, int angle, int steepness) {
		this.from = from;
		this.gfx = gfx;
		this.startHeight = startHeight;
		this.endHeight = endHeight;
		this.delay = delay;
		this.lifetime = lifetime;
		this.angle = angle;
		this.steepness = steepness;
		this.toTile = to;
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(18));
		
		buffer.packet(9);
		buffer.writeShort(delay + lifetime);

		if (to != null)
			buffer.writeShort(to.isNpc() ? to.index() + 1 : -(to.index() + 1));
		else
			buffer.writeShort(0);

		if (to == null) {
			buffer.writeByte(toTile.x); //tz
			buffer.writeByteA(toTile.z); //ty
		} else {
			buffer.writeByte(0);
			buffer.writeByteA(0);
		}

		buffer.writeByte(endHeight);
		buffer.writeByteS(angle);
		buffer.writeByteS(steepness);
		buffer.writeByteS((from.x << 4) | from.z);
		buffer.writeShortA(gfx);
		buffer.writeByteA(startHeight);
		buffer.writeShort(delay);
		
		return buffer;
	}
	
}
