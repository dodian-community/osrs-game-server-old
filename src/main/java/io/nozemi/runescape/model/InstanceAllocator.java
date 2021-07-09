package io.nozemi.runescape.model;

import com.google.common.base.Preconditions;
import io.nozemi.runescape.model.instance.InstancedMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Created by Bart on 3/28/2016.
 */
public class InstanceAllocator {
	
	private static final Logger logger = LogManager.getLogger(World.class);
	
	private static final Area ALLOC_SECTOR = new Area(128, 7104, 3376, 8808);
	public static final int MAP_SIZE = 64;
	public static final int MAP_BIT_SIZE = 63;
	public static final int MAP_BIT_MASK = ~63;
	
	private World world;
	private List<InstancedMap> allocated = new ArrayList<>();
	
	public InstanceAllocator(World world) {
		this.world = world;
	}

    /**
     * Creates an instanced map with the specified amount of chunks respecting a [64,64] granularity.
     * @param chunkCount the amount of chunks involved in the instance.
     * @param exit the exit tile for this instance.
     * @return
     */
	public Optional<InstancedMap> allocate(int chunkCount, Tile exit) {
		return allocate(64 * chunkCount, 64 * chunkCount, exit);
	}
	
	public Optional<InstancedMap> allocate(int sizeX, int sizeZ, Tile exit) {
		Preconditions.checkArgument(sizeX == sizeZ, "Instance sizes must match, you cannot have half dimensions - http://pastebin.com/raw/cZ1X55cH");
		Preconditions.checkArgument((sizeX & 63) == 0, "you can only allocate maps on [64,64] map granularity");
		Preconditions.checkArgument((sizeZ & 63) == 0, "you can only allocate maps on [64,64] map granularity");
		
		for (int x = ALLOC_SECTOR.x1; x < ALLOC_SECTOR.x2; x += MAP_SIZE) {
			for (int z = ALLOC_SECTOR.z1; z < ALLOC_SECTOR.z2; z += MAP_SIZE) {
				
				// Make sure we're not going to overwrite any maps.
				final int tryx = x;
				final int tryz = z;
				if (allocated.stream().anyMatch(map -> map.contains(new Tile(tryx, tryz)))) {
					//System.out.println(" "+tryx+" "+tryz+" is in use..");
					continue;
				}
				
				// Add the map entry, allocate, return
				InstancedMap map = new InstancedMap(world, x & MAP_BIT_MASK, z & MAP_BIT_MASK, ((x + sizeX) & MAP_BIT_MASK), ((z + sizeZ) & MAP_BIT_MASK), exit);
				allocated.add(map);
				//System.out.println("allocated at "+(x & MAP_BIT_MASK)+" "+(z & MAP_BIT_MASK)+" sizes "+sizeX+" "+sizeZ+" so ends at "+((x+sizeX) & MAP_BIT_MASK)+", "+((z+sizeZ) & MAP_BIT_MASK));
				return Optional.of(map);
			}
		}
		
		return Optional.empty();
	}
	
	public void cleanup() {
		/*if (world.server().isVerbose())
			logger.info("Cleaning up allocated maps...");*/
		
		// Calculate a list of tiles that players are currently at.
		Set<Tile> maps = new HashSet<>();
		world.players().forEach(player -> maps.add(player.tile));
		
		// Iterate over all the allocated maps, check for any players inside and if none, clear it.
		List<InstancedMap> dealloc = new LinkedList<>();
		allocated.stream().filter(map -> !map.persistent()).filter(map -> !containsany(map, maps)).forEach(dealloc::add);
		
		// Remove young maps (ones that are younger than 30 seconds)
		dealloc.removeIf(map -> System.currentTimeMillis() - map.createdAt() < 30_000);
		
		// Sweep the marked maps
		dealloc.forEach(this::deallocate);
		
		/*if (world.server().isVerbose())
			logger.info("Cleaned up a total of {} allocated maps.", dealloc.size());*/
	}
	
	private static boolean containsany(final InstancedMap map, final Set<Tile> tiles) {
		for (Tile t : tiles) {
			if (map.contains(t)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Deallocates the map without explicitly removing entities from the map as to
	 * allow for other implementations to do this.
	 *
	 * @param map the map to be deallocated.
	 */
	public void deallocateQuietly(InstancedMap map) {
		if (map.persistent()) {
			return;
		}
		allocated.remove(map);
		logger.info("Removed instance quietly at {}.", (Area) map);
	}
	
	public void deallocate(InstancedMap map) {
		// DO not deallocate persistent maps.
		if (map.persistent()) {
			return;
		}
		
		// unregister all entities in the map area
		world.unregisterAll(map);
		
		// Teleport any players out of the spot (just in case).
		world.players().forEachInArea(map, p -> p.teleport(map.exit()));
		
		// Finally, remove the map from the allocation set.
		allocated.remove(map);
		logger.info("Removed instance at {}.", (Area) map);
	}
	
	public Optional<InstancedMap> active(Tile tile) {
		InstancedMap map = null;
		
		for (int i = 0; i < allocated.size(); i++) {
			InstancedMap m = allocated.get(i);
			if (m != null && m.contains(tile)) {
				map = m;
				break;
			}
		}
		return Optional.ofNullable(map);
	}
	
}
