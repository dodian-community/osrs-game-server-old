package io.nozemi.runescape.model.map.steroids;

public class Clip {
	
	//NORMAL/'STEP' FLAG BLOCKS FROM ACTUALLY ENTERING THE TILE
	//HIGH is an optional flag indicating it blocks projectiles
	//PATH if not set it lets you path through it. Sort of like an invisble wall, used for all traps and a few things like bank booths, border guards, ... lets you path 'through' the booth by clicking inside the bank, instead of running to the wall outside of the bank etc
	
	public static final int NW_PILLAR = 0x1;
	public static final int NW_PILLAR_HIGH = 0x200;
	public static final int NW_PILLAR_PATH = 0x400000;
	
	/**
	 * Tile has a wall on the north side
	 */
	public static final int N_WALL = 0x2;
	
	/**
	 * Tile has a wall on the north side that is high enough to block projectiles
	 */
	public static final int N_WALL_HIGH = 0x400;
	
	/**
	 * Tile has a wall on the north side that doesn't allow interactions through it
	 */
	public static final int N_WALL_PATH = 0x800000;
	
	public static final int NE_PILLAR = 0x4;
	public static final int NE_PILLAR_HIGH = 0x800;
	public static final int NE_PILLAR_PATH = 0x1000000;
	
	public static final int E_WALL = 0x8;
	public static final int E_WALL_HIGH = 0x1000;
	public static final int E_WALL_PATH = 0x2000000;
	
	public static final int SE_PILLAR = 0x10;
	public static final int SE_PILLAR_HIGH = 0x2000;
	public static final int SE_PILLAR_PATH = 0x4000000;
	
	public static final int S_WALL = 0x20;
	public static final int S_WALL_HIGH = 0x4000;
	public static final int S_WALL_PATH = 0x8000000;
	
	public static final int SW_PILLAR = 0x40;
	public static final int SW_PILLAR_HIGH = 0x8000;
	public static final int SW_PILLAR_PATH = 0x10000000;
	
	public static final int W_WALL = 0x80;
	public static final int W_WALL_HIGH = 0x10000;
	public static final int W_WALL_PATH = 0x20000000;
	
	/**
	 * Tile is blocked by an object.
	 */
	public static final int OBSTACLE = 0x100;
	
	/**
	 * Tile has an object high enough to block all projectiles.
	 */
	public static final int OBSTACLE_HIGH = 0x20000;
	
	/**
	 * Tile is blocking interaction
	 */
	public static final int OBSTACLE_PATH = 0x40000000;
	
	/**
	 * Tile is blocked due to a floor decoration object
	 */
	public static final int FLOOR_DECO_BLOCKED = 0x40000;
	
	/**
	 * If this flag is set you can interact (in the destination reachability check) with wall objects from the sides
	 * <p>
	 * Example with this flag
	 * <p>
	 * <pre>
	 * x x
	 * x|x
	 * x x
	 * </pre>
	 * <p>
	 * Without this flag it would be
	 * <p>
	 * <pre>
	 * x|x
	 * </pre>
	 * <p>
	 * NOTE: There is seems to be no code that actually sets this flag.
	 */
	public static final int INTERACT_SIDE_UNUSED = 0x80000;
	
	/**
	 * Tile is blocked from entering by tile setting 0x1 (water...)
	 */
	public static final int TILE_BLOCKED = 0x200000;
	
	/**
	 * Unused/reserved bit
	 */
	public static final int UNUSEDx100000 = 0x100000;
	
	/**
	 * Unused/reserved bit
	 */
	public static final int UNUSEDx80000000 = 0x80000000;
	
	//Computed flags to make pathfinding more readable
	
	/**
	 * Combination of flags to check if a tile can be entered at all
	 */
	public static final int BLOCK_ENTER = TILE_BLOCKED | FLOOR_DECO_BLOCKED | OBSTACLE;
	
	/**
	 * Combination of flags to check there are no extra constraints that would block entering a north western tile
	 */
	public static final int BLOCK_ENTER_NW = SE_PILLAR | S_WALL | E_WALL | BLOCK_ENTER;
	
	/**
	 * Combination of flags to check there are no extra constraints that would block entering a northern tile
	 */
	public static final int BLOCK_ENTER_N = S_WALL | BLOCK_ENTER;
	
	/**
	 * Combination of flags to check there are no extra constraints that would block entering a north eastern tile
	 */
	public static final int BLOCK_ENTER_NE = SW_PILLAR | S_WALL | W_WALL | BLOCK_ENTER;
	
	/**
	 * Combination of flags to check there are no extra constraints that would block entering a eastern tile
	 */
	public static final int BLOCK_ENTER_E = W_WALL | BLOCK_ENTER;
	
	/**
	 * Combination of flags to check there are no extra constraints that would block entering a south eastern tile
	 */
	public static final int BLOCK_ENTER_SE = NW_PILLAR | N_WALL | W_WALL | BLOCK_ENTER;
	
	/**
	 * Combination of flags to check there are no extra constraints that would block entering a southern tile
	 */
	public static final int BLOCK_ENTER_S = N_WALL | BLOCK_ENTER;
	
	/**
	 * Combination of flags to check there are no extra constraints that would block entering a south western tile
	 */
	public static final int BLOCK_ENTER_SW = NE_PILLAR | N_WALL | E_WALL | BLOCK_ENTER;
	
	/**
	 * Combination of flags to check there are no extra constraints that would block entering a western tile
	 */
	public static final int BLOCK_ENTER_W = E_WALL | BLOCK_ENTER;
	
	/**
	 * Combination of flags to check if a projectile can fly over this tile at all
	 */
	public static final int BLOCK_PROJ = /*TILE_BLOCKED | FLOOR_DECO_BLOCKED | */OBSTACLE_HIGH;
	
	/**
	 * Combination of flags to check if a projectile can enter a north western tile
	 */
	public static final int BLOCK_PROJ_NW = SE_PILLAR_HIGH | S_WALL_HIGH | E_WALL_HIGH | BLOCK_PROJ;
	public static final int BLOCK_PROJ_N = S_WALL_HIGH | BLOCK_PROJ;
	public static final int BLOCK_PROJ_NE = SW_PILLAR_HIGH | S_WALL_HIGH | W_WALL_HIGH | BLOCK_PROJ;
	public static final int BLOCK_PROJ_E = W_WALL_HIGH | BLOCK_PROJ;
	public static final int BLOCK_PROJ_SE = NW_PILLAR_HIGH | N_WALL_HIGH | W_WALL_HIGH | BLOCK_PROJ;
	public static final int BLOCK_PROJ_S = N_WALL_HIGH | BLOCK_PROJ;
	public static final int BLOCK_PROJ_SW = NE_PILLAR_HIGH | N_WALL_HIGH | E_WALL_HIGH | BLOCK_PROJ;
	public static final int BLOCK_PROJ_W = E_WALL_HIGH | BLOCK_PROJ;
	
	/**
	 * Combination of flags to check if a tile allows interaction through it (bankers behind bank booths, door behind key doors, ...)
	 */
	public static final int BLOCK_PATH = TILE_BLOCKED | FLOOR_DECO_BLOCKED | OBSTACLE_PATH;
	
	public static final int BLOCK_PATH_NW = SE_PILLAR_PATH | S_WALL_PATH | E_WALL_PATH | BLOCK_PATH;
	public static final int BLOCK_PATH_N = S_WALL_PATH | BLOCK_PATH;
	public static final int BLOCK_PATH_NE = SW_PILLAR_PATH | S_WALL_PATH | W_WALL_PATH | BLOCK_PATH;
	public static final int BLOCK_PATH_E = W_WALL_PATH | BLOCK_PATH;
	public static final int BLOCK_PATH_SE = NW_PILLAR_PATH | N_WALL_PATH | W_WALL_PATH | BLOCK_PATH;
	public static final int BLOCK_PATH_S = N_WALL_PATH | BLOCK_PATH;
	public static final int BLOCK_PATH_SW = NE_PILLAR_PATH | N_WALL_PATH | E_WALL_PATH | BLOCK_PATH;
	public static final int BLOCK_PATH_W = E_WALL_PATH | BLOCK_PATH;
	
	/**
	 * Combination of flags to check there are no extra constraints that would block INTERACT_SIDE_UNUSED when interacting with a southern tile
	 */
	public static final int BLOCK_PATH_S_SIDE = N_WALL | INTERACT_SIDE_UNUSED | BLOCK_ENTER;
	
	/**
	 * Combination of flags to check there are no extra constraints that would block INTERACT_SIDE_UNUSED when interacting with a western tile
	 */
	public static final int BLOCK_PATH_W_SIDE = E_WALL | INTERACT_SIDE_UNUSED | BLOCK_ENTER;
	
	/**
	 * Combination of flags to check there are no extra constraints that would block INTERACT_SIDE_UNUSED when interacting with a northern tile
	 */
	public static final int BLOCK_PATH_N_SIDE = S_WALL | INTERACT_SIDE_UNUSED | BLOCK_ENTER;
	
	/**
	 * Combination of flags to check there are no extra constraints that would block INTERACT_SIDE_UNUSED when interacting with a eastern tile
	 */
	public static final int BLOCK_PATH_E_SIDE = W_WALL | INTERACT_SIDE_UNUSED | BLOCK_ENTER;
	
	/**
	 * Combination of flags to check there are no extra constraints that would block entering a northern tile for non corners of a big unit
	 * For example any of these walls (or pillars) would block the unit, on the corners it doesn't need to check one wall
	 * <p>
	 * <pre>
	 *  |_|
	 * x x x
	 * x x x
	 * x x x
	 * </pre>
	 */
	public static final int BLOCK_PATH_N_BIG = W_WALL_PATH | SW_PILLAR_PATH | S_WALL_PATH | SE_PILLAR_PATH | E_WALL_PATH | BLOCK_PATH;
	public static final int BLOCK_PATH_E_BIG = N_WALL_PATH | NW_PILLAR_PATH | W_WALL_PATH | SW_PILLAR_PATH | S_WALL_PATH | BLOCK_PATH;
	public static final int BLOCK_PATH_S_BIG = W_WALL_PATH | NW_PILLAR_PATH | N_WALL_PATH | NE_PILLAR_PATH | E_WALL_PATH | BLOCK_PATH;
	public static final int BLOCK_PATH_W_BIG = N_WALL_PATH | NE_PILLAR_PATH | E_WALL_PATH | SE_PILLAR_PATH | S_WALL_PATH | BLOCK_PATH;
	
	public static final int BLOCK_ENTER_N_BIG = W_WALL | SW_PILLAR | S_WALL | SE_PILLAR | E_WALL | BLOCK_ENTER;
	public static final int BLOCK_ENTER_E_BIG = N_WALL | NW_PILLAR | W_WALL | SW_PILLAR | S_WALL | BLOCK_ENTER;
	public static final int BLOCK_ENTER_S_BIG = W_WALL | NW_PILLAR | N_WALL | NE_PILLAR | E_WALL | BLOCK_ENTER;
	public static final int BLOCK_ENTER_W_BIG = N_WALL | NE_PILLAR | E_WALL | SE_PILLAR | S_WALL | BLOCK_ENTER;
	
}
