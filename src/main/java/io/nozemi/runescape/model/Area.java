package io.nozemi.runescape.model;

/**
 * Created by Bart on 8/22/2015.
 */
public class Area {
	
	public final int x1, x2, z1, z2, level;
	private boolean largeViewPort;
	
	public Area(int x1, int z1, int x2, int z2) {
		this(x1, z1, x2, z2, 0);
	}
	
	public Area(int x1, int z1, int x2, int z2, int level) {
		this.x1 = x1;
		this.x2 = x2;
		this.z1 = z1;
		this.z2 = z2;
		this.level = level;
	}
	
	public Area(int rid) {
		x1 = (rid >> 8) * 64;
		x2 = x1 + 63;
		z1 = (rid & 0xFF) * 64;
		z2 = x1 + 63;
		level = 0;
	}
	
	public Area(Tile spawnTile, int radius) {
		this(spawnTile.x - radius, spawnTile.z - radius, spawnTile.x + radius, spawnTile.z + radius, spawnTile.level);
	}
	
	public Area(Tile botleft, Tile topright) {
		this(botleft.x, botleft.z, topright.x, topright.z);
	}
	
	public Area(Tile botleft, Tile topright, int level) {
		this(botleft.x, botleft.z, topright.x, topright.z, level);
	}
	
	public Area(Area area) {
		this(area.x1, area.z1, area.x2, area.z2, area.level);
	}
	
	public Area(Area area, int level) {
		this(area.x1, area.z1, area.x2, area.z2, level);
	}
	
	public boolean contains(Tile t) {
		return contains(t, false);
	}
	
	public boolean contains(Tile t, boolean checkHeight) {
		return t.x >= x1 && t.x <= x2 && t.z >= z1 && t.z <= z2 && (!checkHeight || t.level == level);
	}
	
	public boolean containsClosed(Tile t) {
		return containsClosed(t, false);
	}
	
	public boolean containsClosed(Tile t, boolean checkHeight) {
		return t.x >= x1 && t.x < x2 && t.z >= z1 && t.z < z2 && (!checkHeight || t.level == level);
	}
	
	public boolean contains(Entity e) {
		return contains(e.tile());
	}
	
	public boolean contains(Entity e, boolean checkHeight) {
		return contains(e.tile(), checkHeight);
	}
	
	
	public int x1() {
		return x1;
	}
	
	public int x2() {
		return x2;
	}
	
	public int z1() {
		return z1;
	}
	
	public int z2() {
		return z2;
	}
	
	public int level() {
		return level;
	}
	
	public int width() {
		return x2 - x1;
	}
	
	public int length() {
		return z2 - z1;
	}
	
	public Tile center() {
		return new Tile(x1 + (x2 - x1) / 2, z1 + (z2 - z1) / 2, level);
	}
	
	public Tile bottomLeft() {
		return new Tile(x1, z1, level);
	}
	
	public Tile bottomRight() {
		return new Tile(x2, z1, level);
	}
	
	public Tile topRight() {
		return new Tile(x2, z2, level);
	}
	
	public Tile topLeft() {
		return new Tile(x1, z2, level);
	}
	
	public Area enlarge(int tiles) {
		return new Area(x1 - tiles, z1 - tiles, x2 + tiles, z2 + tiles, level);
	}
	
	public Tile randomTile() {
		double wx = x2 - x1;
		double wz = z2 - z1;
		return new Tile(x1 + (int) Math.round(wx * Math.random()), z1 + (int) Math.round(wz * Math.random()), level);
	}
	
	public Tile randomClippedTile(World w) {
		return randomClippedTile(w, 1);
	}
	
	public Tile randomClippedTile(World world, int size) {
		double wx = x2 - x1;
		double wz = z2 - z1;
		Tile t = new Tile(x1 + (int) Math.round(wx * Math.random()), z1 + (int) Math.round(wz * Math.random()), level);
		int attempts = 10;
		while (attempts-- > 0 && !world.isFloorFree(t, size)) {
			t = new Tile(x1 + (int) Math.round(wx * Math.random()), z1 + (int) Math.round(wz * Math.random()), level);
		}
		return t;
	}
	
	public Tile relative(Tile tile) {
		return bottomLeft().plus(tile);
	}
	
	public Area relative(Area area) {
		return new Area(x1 + area.x1, z1 + area.z1, x1 + area.x2, z1 + area.z2, level + area.level);
	}
	
	public boolean overlaps(Area other) {
		return Tile.overlaps(x1, z1, x2 - x1 + 1, z2 - z1 + 1, other.x1, other.z1, other.x2 - other.x1 + 1, other.z2 - other.z1 + 1);
	}
	
	public Area setLargeViewPort(boolean largeViewPort) {
		this.largeViewPort = largeViewPort;
		return this;
	}
	
	public boolean largeViewPort() {
		return largeViewPort;
	}
	
	@Override
	public String toString() {
		return "Area[" + x1 + ".." + z1 + ", " + x2 + ".." + z2 + "]";
	}
}
