package io.nozemi.runescape.net.message.game.command;

import io.nozemi.runescape.io.RSBuffer;
import io.nozemi.runescape.model.CameraType;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.net.message.game.Command;

/**
 * Created by Situations on 2016-12-31.
 */

public class CameraMovement extends Command {
	
	private CameraType type;
	private int x;
	private int z;
	private int angle;
	private int speed;
	private int zoomSpeed;
	private int shakeIntensity;
	
	public CameraMovement(Tile tile, int angle, int speed, int zoomSpeed, CameraType type) {
		this.x = tile.x;
		this.z = tile.z;
		this.angle = angle;
		this.speed = speed;
		this.zoomSpeed = zoomSpeed;
		this.type = type;
	}
	
	public CameraMovement(int intensity) {
		this.shakeIntensity = intensity;
		this.type = CameraType.SHAKE;
	}
	
	public CameraMovement(Tile tile, CameraType type) {
		this.x = tile.x;
		this.z = tile.z;
		this.angle = 900;
		this.speed = 8;
		this.zoomSpeed = 0;
		this.type = type;
	}
	
	public CameraMovement() {
		this.type = CameraType.RESET;
	}
	
	public int getSceneX(Tile tile) {
		return x - ((tile.chunkX() - 6) << 3);
	}
	
	public int getSceneZ(Tile tile) {
		return z - ((tile.chunkZ() - 6) * 8);
	}
	
	@Override
	public RSBuffer encode(Player player) {
		RSBuffer buffer = new RSBuffer(player.channel().alloc().buffer(6)).packet(type.packet());
		
		switch (type) {
			case ROTATION:
			case POSITION:
				buffer.writeByte(getSceneX(player.tile()));
				buffer.writeByte(getSceneZ(player.tile()));
				buffer.writeShort(angle);
				buffer.writeByte(speed);
				buffer.writeByte(zoomSpeed);
				break;
			case SHAKE:
				buffer.writeByte(0);
				buffer.writeByte(shakeIntensity);
				buffer.writeByte(shakeIntensity);
				buffer.writeByte(shakeIntensity);
				break;
			case RESET:
				break;
		}
		return buffer;
	}
}
