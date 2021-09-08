package net.dodian.runescape.model.instance;

import com.google.common.base.Preconditions;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.dodian.runescape.fs.MapDefinition;
import net.dodian.runescape.model.Area;
import net.dodian.runescape.model.Entity;
import net.dodian.runescape.model.Tile;
import net.dodian.runescape.model.World;
import net.dodian.runescape.model.entity.Player;
import net.dodian.runescape.model.map.MapObj;

import java.util.Optional;

/**
 * Created by Bart on 3/28/2016.
 */
public class InstancedMap extends Area {
	
	/**
	 * int[level][x][z]
	 */
	private int[][][] copies;
	
	private World world;
	
	// Should the map stay loaded when no players are in it?
	private boolean persistent;
	
	/**
	 * If present, the identifier signifies that this map is unique from other maps
	 * and contains a value. Otherwise, this map has no unique identifier. This strategy
	 * is used because of the inherit difficult of extending an InstancedMap and using
	 * the instanceof keyword to define unique maps.
	 */
	private Optional<InstancedMapIdentifier> identifier = Optional.empty();
	
	/**
	 * A flag that determines whether or not this map should be deallocated or destructed
	 * when the player dies. By default this value is true.
	 */
	private boolean deallocateOnDeath = true;
	
	/**
	 * A flag to determine whether or not this instanced map deallocates on a player-logout
	 * basis.
	 */
	private boolean deallocateOnLogout = true;
	
	// If instances have any more attributes this can be replaced with AttributeKey in the future
	private boolean lose_items_on_death;
	
	// Is this instance multi combat?
	private boolean isMultiwayCombat;
	
	
	/**
	 * Coordinate to tele port the player to when exiting this map either by logout or by dealloc.
	 */
	private Tile exit = new Tile(3222, 3222);
	
	/**
	 * A flag to determine if the entities in the area are always agressive regardless of aspects
	 * like combat level difference.
	 */
	private boolean entitiesAgressiveInArea;
	
	private long createdAt = System.currentTimeMillis();
	
	private Entity getCreatedFor() {
		return createdFor;
	}
	
	public void setCreatedFor(Entity createdFor) {
		this.createdFor = createdFor;
	}
	
	private Entity createdFor;
	
	public boolean dangerous() {
		return lose_items_on_death;
	}
	
	public InstancedMap setDangerous(boolean lose_items) {
		lose_items_on_death = lose_items;
		return this;
	}
	
	public InstancedMap setMulti(boolean multi) {
		isMultiwayCombat = multi;
		return this;
	}
	
	public boolean isMulti() {
		return isMultiwayCombat;
	}
	
	public InstancedMap(World world, int x1, int z1, int x2, int z2, Tile exit) {
		super(x1, z1, x2, z2);
		Preconditions.checkArgument((x1 & 63) == 0, "you can only allocate maps on [64,64] map granularity");
		Preconditions.checkArgument((z1 & 63) == 0, "you can only allocate maps on [64,64] map granularity");
		this.world = world;
		
		copies = new int[4][width() / 8][length() / 8];
		this.exit = exit;
	}
	
	public void set(int chunkX, int chunkZ, int level, Tile copy, int orientation, boolean clip) {
		if ((copy.x & ~7) != copy.x || (copy.z & ~7) != copy.z) {
			System.err.println("Warning: copying map from [" + copy.x + ", " + copy.z + "] on NON-chunk granularity.");
			copy = new Tile(copy.x & ~7, copy.z & ~7);
			System.err.println("Warning: chuck will be changed to [" + copy.x + ", " + copy.z + "] to avoid issues.");
		}
		
		int destX = x1 + (chunkX << 3);
		int destZ = z1 + (chunkZ << 3);
		
		copies[level][chunkX][chunkZ] = copy.palletteHash(orientation);
		
		// If we're instructed to clip, we simply copy all the clipping data from A to B.
		if (clip) {
			MapDefinition target = world.definitions().get(MapDefinition.class, Tile.coordsToRegion(destX, destZ), true);
			MapDefinition source = world.definitions().get(MapDefinition.class, copy.region());
			
			if (source == null) {
				//System.err.printf("Invalid xteas for region %d - unable to create instance.%n", copy.region());
				return;
			}
			
			// Make a copy of the entire layer now
			// TODO: 3/28/2016 See if it's possible to use arraycopy to gain speed..?
			for (int lx = 0; lx < 8; lx++) {
				for (int lz = 0; lz < 8; lz++) {
					if (source.getMasks() != null && source.getMasks()[copy.level] != null) {
						target.getMasks()[level][(destX + lx) & 63][(destZ + lz) & 63] = source.getMasks()[copy.level][(copy.x + lx) & 63][(copy.z + lz) & 63];
					}
					
					if (source.getObjs() != null && source.getObjs()[copy.level] != null) {
						
						//TODO improve performance by removing redundant assignment - JMK
						// if the list isn't null, then set the tile position of any MapObj to the new location.
						if (source.getObjs()[copy.level][(copy.x + lx) & 63][(copy.z + lz) & 63] != null) {
							
							target.getObjs()[level][(destX + lx) & 63][(destZ + lz) & 63] = new ObjectArrayList<MapObj>();
							final int llx = lx;
							final int llz = lz;
							// Fill the LinkedList with temp dummies
							source.getObjs()[copy.level][(copy.x + lx) & 63][(copy.z + lz) & 63].forEach(o -> target.getObjs()[level][(destX + llx) & 63][(destZ + llz) & 63].add(null));
							
							// Replace the dummies with proper objects using the source region, but with new tile locations
							for (int index = 0; index < source.getObjs()[copy.level][(copy.x + lx) & 63][(copy.z + lz) & 63].size(); index++) {
								
								target.getObjs()[level][(destX + lx) & 63][(destZ + lz) & 63].set(index,
										new MapObj((MapObj) source.getObjs()[copy.level][(copy.x + lx) & 63][(copy.z + lz) & 63].get(index),
												new Tile(destX + lx, destZ + lz)));
							}
						}
					}
				}
			}
		}
	}
	
	public void set(int chunkX, int chunkZ, Tile copyStart, Tile copyEnd, int orientation, boolean clip) {
		int chunksX = (copyEnd.x - copyStart.x) >> 3;
		int chunksZ = (copyEnd.z - copyStart.z) >> 3;
		
		for (int cx = 0; cx < chunksX; cx++) {
			for (int cz = 0; cz < chunksZ; cz++) {
				for (int l = 0; l < 4; l++) {
					set(chunkX + cx, chunkZ + cz, l, copyStart.transform(cx * 8, cz * 8, l), orientation, clip);
				}
			}
		}
	}
	
	public Optional<Integer> copyAtAbsolute(Tile absoluteTile) {
		// Can only resolve a tile within out boundaries!
		if (!contains(absoluteTile)) {
			return Optional.empty();
		}
		
		int relativeX = absoluteTile.x - x1;
		int relativeZ = absoluteTile.z - z1;
		int chunkIndexX = relativeX >> 3;
		int chunkIndexZ = relativeZ >> 3;
		
		// Ensure we operate in the array to avoid exceptions
		if (chunkIndexX < 0 || chunkIndexX >= copies[0].length || chunkIndexZ < 0 || chunkIndexZ >= copies[0].length) {
			return Optional.empty();
		}
		
		return Optional.of(copies[absoluteTile.level][chunkIndexX][chunkIndexZ]);
	}
	
	public int[][][] buildForMessage(Player player) {
		int[][][] built = new int[4][13][13];
		
		int playerX = player.tile().x;
		int playerZ = player.tile().z;
		int startX = playerX - (8 * 6);
		int startZ = playerZ - (8 * 6);
		
		for (int level = 0; level < 4; level++) {
			for (int x = 0; x < 13; x++) {
				for (int z = 0; z < 13; z++) {
					Optional<Integer> cpy = copyAtAbsolute(new Tile(startX + x * 8, startZ + z * 8, level));
					
					if (cpy.isPresent() && cpy.get() != 0) {
						built[level][x][z] = cpy.get();
					} else {
						built[level][x][z] = -1;
					}
				}
			}
		}
		
		return built;
	}
	
	public Tile exit() {
		return exit;
	}
	
	public boolean persistent() {
		return persistent;
	}
	
	public void setPersists(boolean persistent) {
		this.persistent = persistent;
	}
	
	public InstancedMap persist() {
		persistent = true;
		return this;
	}
	
	public boolean areEntitiesAggressiveInArea() {
		return entitiesAgressiveInArea;
	}
	
	public boolean deallocatesOnDeath() {
		return deallocateOnDeath;
	}
	
	public void setDeallocateOnDeath(boolean deallocateOnDeath) {
		this.deallocateOnDeath = deallocateOnDeath;
	}
	
	public void setEntitiesAggressiveInArea(boolean entitiesAgressiveInArea) {
		this.entitiesAgressiveInArea = entitiesAgressiveInArea;
	}
	
	public InstancedMap setIdentifier(InstancedMapIdentifier identifier) {
		this.identifier = Optional.of(identifier);
		return this;
	}
	
	public Optional<InstancedMapIdentifier> getIdentifier() {
		return identifier;
	}
	
	public void setDeallocatesOnLogout(boolean deallocateOnLogout) {
		this.deallocateOnLogout = deallocateOnLogout;
	}
	
	public boolean deallocatesOnLogout() {
		return deallocateOnLogout;
	}
	
	public long createdAt() {
		return createdAt;
	}
	
	public boolean isCreatedFor(Entity player) {
		return (getCreatedFor() == null || getCreatedFor() == player);
	}
}
