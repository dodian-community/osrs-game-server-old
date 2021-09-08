package net.dodian.runescape.model;

public class ForceMovement {
	
	public final int dx1;
	public final int dx2;
	public final int dz1;
	public final int dz2;
	public final int speed1;
	public final int speed2;
	public final int direction;
	public Tile baseTile;
	
	public ForceMovement(int dx, int dy) {
		this(dx, dy, FaceDirection.forTargetTile(dx, dy));
	}
	
	public ForceMovement(int dx, int dy, FaceDirection direction) {
		this(dx, dy, 35, 90, direction.direction);
	}
	
	public ForceMovement(int dx, int dy, int speed1, int speed2) {
		this(dx, dy, speed1, speed2, FaceDirection.forTargetTile(dx, dy));
	}
	
	public ForceMovement(int dx, int dy, int speed1, int speed2, FaceDirection direction) {
		this(dx, dy, speed1, speed2, direction.direction);
	}
	
	private ForceMovement(int dx, int dy, int speed1, int speed2, int direction) {
		this.dx1 = dx;
		this.dz1 = dy;
		this.dx2 = 0;
		this.dz2 = 0;
		this.speed1 = speed1;
		this.speed2 = speed2;
		this.direction = direction;
	}
	
	public ForceMovement(int dx, int dy, int dx2, int dy2, int speed1, int speed2, FaceDirection direction) {
		this.dx1 = dx;
		this.dz1 = dy;
		this.dx2 = dx2;
		this.dz2 = dy2;
		this.speed1 = speed1;
		this.speed2 = speed2;
		this.direction = direction.direction;
	}
	
	// TODO make private, don't allow magic numbers in direction.
	public ForceMovement(int dx, int dy, int dx2, int dy2, int speed1, int speed2, int direction) {
		this.dx1 = dx;
		this.dz1 = dy;
		this.dx2 = dx2;
		this.dz2 = dy2;
		this.speed1 = speed1;
		this.speed2 = speed2;
		this.direction = direction;
	}
	
	public ForceMovement baseTile(Tile tile) {
		baseTile = tile;
		return this;
	}
	
}
