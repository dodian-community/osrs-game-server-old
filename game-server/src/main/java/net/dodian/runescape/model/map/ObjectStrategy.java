package net.dodian.runescape.model.map;


import net.dodian.runescape.fs.ObjectDefinition;
import net.dodian.runescape.model.World;

public class ObjectStrategy extends RouteStrategy {
	
	/**
	 * Contains object pos x.
	 */
	private int x;
	/**
	 * Contains object pos y.
	 */
	private int z;
	/**
	 * Contains object route type.
	 */
	private int routeType;
	/**
	 * Contains object type.
	 */
	private int type;
	/**
	 * Contains object rotation.
	 */
	private int rotation;
	/**
	 * Contains object size X.
	 */
	private int sizeX;
	/**
	 * Contains object size Y.
	 */
	private int sizeZ;
	/**
	 * Contains block flag.
	 */
	private int accessBlockFlag;
	
	public ObjectStrategy(World world, MapObj obj) {
		ObjectDefinition def = obj.definition(world);
		
		x = obj.tile().x;
		z = obj.tile().z;
		routeType = getType(obj.type());
		type = obj.type();
		rotation = def.id == 29150 ? 0 : obj.rot(); //Cheapfix for occult altar pathing.
		sizeX = rotation == 0 || rotation == 2 ? def.sizeX : def.sizeY;
		sizeZ = rotation == 0 || rotation == 2 ? def.sizeY : def.sizeX;
		accessBlockFlag = def.cflag;
		if (rotation != 0)
			accessBlockFlag = ((accessBlockFlag << rotation) & 0xF) + (accessBlockFlag >> (4 - rotation));
	}
	
	@Override
	public boolean canExit(int currentX, int currentY, int sizeXY, int[][] clip, int clipBaseX, int clipBaseY) {
		switch (routeType) {
			case 0:
				return RouteStrategy.checkWallInteract(clip, currentX - clipBaseX, currentY - clipBaseY, sizeXY, x - clipBaseX, z - clipBaseY, type, rotation);
			case 1:
				return RouteStrategy.checkWallDecorationInteract(clip, currentX - clipBaseX, currentY - clipBaseY, sizeXY, x - clipBaseX, z - clipBaseY, type, rotation);
			case 2:
				return RouteStrategy.checkFilledRectangularInteract(clip, currentX - clipBaseX, currentY - clipBaseY, sizeXY, sizeXY, x - clipBaseX, z - clipBaseY, sizeX, sizeZ, accessBlockFlag);
			case 3:
				return currentX == x && currentY == z;
		}
		return false;
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
		return sizeX;
	}
	
	@Override
	public int getApproxDestinationSizeZ() {
		return sizeZ;
	}
	
	private int getType(int type) {
		if ((type >= 0 && type <= 3) || type == 9)
			return 0; // wall
		else if (type < 9)
			return 1; // deco
		else if (type == 10 || type == 11 || type == 22)
			return 2; // ground
		else
			return 3; // misc
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof ObjectStrategy))
			return false;
		ObjectStrategy strategy = (ObjectStrategy) other;
		return x == strategy.x && z == strategy.z && routeType == strategy.routeType && type == strategy.type && rotation == strategy.rotation && sizeX == strategy.sizeX && sizeZ == strategy.sizeZ && accessBlockFlag == strategy.accessBlockFlag;
	}
	
}
