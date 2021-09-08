package net.dodian.runescape.model.map;

public class FixedTileStrategy extends RouteStrategy {
	
	/**
	 * X position of tile.
	 */
	private int x;
	/**
	 * Y position of tile.
	 */
	private int z;
	
	public FixedTileStrategy(int x, int z) {
		this.x = x;
		this.z = z;
	}
	
	@Override
	public boolean canExit(int currentX, int currentY, int sizeXY, int[][] clip, int clipBaseX, int clipBaseY) {
		return currentX == x && currentY == z;
	}
	
	@Override
	public int getApproxDestinationX() {
		return x;
	}
	
	@Override
	public int getApproxDestinationZ() {
		return z;
	}
	
	@Override
	public int getApproxDestinationSizeX() {
		return 1;
	}
	
	@Override
	public int getApproxDestinationSizeZ() {
		return 1;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof FixedTileStrategy))
			return false;
		FixedTileStrategy strategy = (FixedTileStrategy) other;
		return x == strategy.x && z == strategy.z;
	}
	
}
