package io.nozemi.runescape.model;

import com.google.common.base.MoreObjects;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.map.MapObj;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * Created by Bart Pelle on 8/22/2014.
 */
public class Tile {
	
	public final int x;
	public final int z;
	public final int level;
	
	public Tile(Tile t) {
		x = t.x;
		z = t.z;
		level = Math.min(3, Math.max(0, t.level));
	}
	
	public Tile(int x, int z) {
		this.x = x;
		this.z = z;
		this.level = 0;
	}
	
	public Tile(int x, int z, int level) {
		this.x = x;
		this.z = z;
		this.level = Math.min(3, Math.max(0, level));
	}
	
	public int distance(Tile tile) {
		int dx = tile.x - x;
		int dz = tile.z - z;
		return (int) Math.sqrt(dx * dx + dz * dz);
	}
	
	public boolean inArea(int lowestX, int lowestY, int highestX, int highestY) {
		return x >= lowestX && z >= lowestY && x <= highestX && z <= highestY;
	}
	
	public boolean inArea(Area area) {
		return x >= area.x1 && z >= area.z1 && x <= area.x2 && z <= area.z2;
	}
	
	public Tile minus(Tile t) {
		return new Tile(x - t.x, z - t.z, level - t.level);
	}
	
	public Tile plus(Tile t) {
		return new Tile(x + t.x, z + t.z, level + t.level);
	}
	
	public int region() {
		return ((x >> 6) << 8) | (z >> 6);
	}
	
	public Tile regionCorner() {
		return new Tile((region() >> 8) << 6, (region() & 0xFF) << 6);
	}
	
	public int chunk() {
		return ((x >> 3) << 16) | (z >> 3);
	}
	
	public int chunkX() {
		return x >> 3;
	}
	
	public int chunkZ() {
		return z >> 3;
	}
	
	public Tile chunkCorner() {
		return new Tile(((chunk() >> 16) << 3), ((chunk() & 0xFFFF) << 3));
	}
	
	public static Tile chunkToTile(int chunkId) {
		return new Tile(((chunkId >> 16) << 3), ((chunkId & 0xFFFF) << 3));
	}
	
	public static Tile regionToTile(int regionId) {
		return new Tile(((regionId >> 8) << 6), ((regionId & 0xFF) << 6));
	}
	
	public static int coordsToRegion(int x, int z) {
		return ((x >> 6) << 8) | (z >> 6);
	}
	
	public Tile transform(int dx, int dz, int dh) {
		return new Tile(x + dx, z + dz, level + dh);
	}
	
	public Tile transform(int dx, int dz) {
		return new Tile(x + dx, z + dz, level);
	}
	
	public int palletteHash(int rotation) {
		return ((level & 0x3) << 24) | ((chunkX() & 0x3FF) << 14) | ((chunkZ() & 0x7FF) << 3) | ((rotation & 0x3) << 1);
	}
	
	public int regionX() {
		return x >> 6;
	}
	
	public int localX() {
		return x & 0x3F;
	}
	
	public int localZ() {
		return z & 0x3F;
	}
	
	public int regionZ() {
		return z >> 6;
	}
	
	public int tectonicPlateX() {
		return x >> 13;
	}
	
	public int tectonicPlateZ() {
		return z >> 13;
	}
	
	public int hash18() {
		return (level << 16) + (tectonicPlateX() << 8) + tectonicPlateZ();
	}
	
	public int hash30() {
		return (level << 28) | (x << 14) | z;
	}
	
	@Override
	public int hashCode() {
		return (level << 30) | (x << 14) | z;
	}
	
	public Area area(int radius) {
		return new Area(x - radius, z - radius, x + radius, z + radius);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Tile))
			return false;
		Tile o = (Tile) obj;
		return o.x == x && o.z == z && o.level == level;
	}
	
	public boolean equals(int x, int z, int level) {
		return this.x == x && this.z == z && this.level == level;
	}
	
	public boolean equals(int x, int z) {
		return this.x == x && this.z == z;
	}
	
	public static final boolean overlaps(int currX, int currY, int unitSizeX, int unitSizeY, int targetX, int targetY, int targetSizeX, int targetSizeY) {
		if (currX >= targetX + targetSizeX || targetX >= currX + unitSizeX) {
			return false;
		}
		if (currY >= targetY + targetSizeY || targetY >= currY + unitSizeY) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("x", x).add("z", z).add("level", level).toString();
	}
	
	/**
	 * @return Formatted [X, Y, Z]
	 */
	public String toStringSimple() {
		return "[" + x + "," + z + "," + level + "]";
	}
	
	/**
	 * Used for barrage/retribution 3x3 close targets.
	 *
	 * @param tile
	 * @param span
	 * @return
	 */
	public boolean inSqRadius(Tile tile, int span) {
		return this.inArea(tile.x - span,
				tile.z - span,
				tile.x + span,
				tile.z + span);
	}
	
	/**
	 * If the player and grounditem height are the same.
	 *
	 * @param p
	 * @param item
	 * @return
	 */
	public static boolean sameH(Player p, GroundItem item) {
		return p.tile.level == item.tile().level;
	}
	
	/**
	 * If the player and mapobj height are the same.
	 *
	 * @param p
	 * @param obj
	 * @return
	 */
	public static boolean sameH(Player p, MapObj obj) {
		return p.tile().level == obj.tile().level;
	}
	
	/**
	 * The checks have to use the last cycle's pvp height - like how bart's sync() method uses last cycles previousArea()<Area>
	 *
	 * @param p
	 * @param item
	 * @return
	 */
	public static boolean sameLastH(Player p, GroundItem item) { // used by ENGINE ONLY
		return p.activeMap().level == item.tile().level;
	}
	
	public static boolean sameLastH(Player p, MapObj obj) { // used by ENGINE ONLY
		return p.activeMap().level == obj.tile().level;
	}
	
	/**
	 * If the given tile is N, E, S or W by 1 tile of this tile.
	 */
	public boolean nextTo(Tile tile) {
		return transform(1, 0).equals(tile) || transform(0, 1).equals(tile) || transform(-1, 0).equals(tile) || transform(0, -1).equals(tile);
	}
	
	public int angleTo(Tile target) {
		return (int) (Math.atan2(x - target.x, z - target.z) * 325.949D) & 2047;
	}
	
	@NotNull
	public Tile randomize(int radius) {
		return this.transform(-radius + new Random().nextInt(radius*2), -radius + new Random().nextInt(radius*2));
	}


	public static int getClosestX(Entity src, Entity target) {
		if (src.size() == 1)
			return src.tile().x;
		if (target.tile().x < src.tile().x)
			return src.tile().x;
		else if (target.tile().x >= src.tile().x && target.tile().x <= src.tile().x + src.size() - 1)
			return target.tile().x;
		else
			return src.tile().x + src.size() - 1;
	}

	public static int getClosestY(Entity src, Entity target) {
		if (src.size() == 1)
			return src.tile().z;
		if (target.tile().z < src.tile().z)
			return src.tile().z;
		else if (target.tile().z >= src.tile().z && target.tile().z <= src.tile().z + src.size() - 1)
			return target.tile().z;
		else
			return src.tile().z + src.size() - 1;
	}

	public static Tile getClosestPosition(Entity src, Entity target) {
		return new Tile(getClosestX(src, target), getClosestY(src, target), src.tile.level);
	}

}
