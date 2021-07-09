package io.nozemi.runescape.model.map;

import io.nozemi.runescape.fs.ObjectDefinition;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.util.Tuple;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by Bart on 8/23/2015.
 */
public class MapObj {
	
	private final Tile tile;
	private final int id;
	private byte type;
	private byte rot;
	private boolean interactAble = true;
	private boolean custom = false;
	
	public MapObj(Tile tile, int id, int type, int rot) {
		this.id = id;
		this.tile = tile;
		this.type = (byte) type;
		this.rot = (byte) rot;
	}
	
	public MapObj(Tile tile, int id, int type, int rot, boolean custom) {
		this(tile, id, type, rot);
		this.custom = custom;
	}
	
	public MapObj(MapObj object, Tile tile) {
		this(tile, object.id, object.type, object.rot);
		this.interactAble = object.interactAble;
	}
	
	public MapObj(MapObj object, int id) {
		this(object.tile(), id, object.type(), object.rot());
	}
	
	public ObjectDefinition definition(World world) {
		return world.definitions().get(ObjectDefinition.class, id);
	}
	
	public Tile tile() {
		return tile;
	}
	
	public int id() {
		return id;
	}
	
	public int type() {
		return type;
	}
	
	public int rot() {
		return rot;
	}
	
	public boolean interactAble() {
		return interactAble;
	}
	
	public MapObj interactAble(boolean interactAble) {
		this.interactAble = interactAble;
		return this;
	}
	
	// Checks if this mapobj is still valid in the world.
	// First find the equivilent obj type on this coord (ignore invalid stuff like walls, floor decoration)
	// Then compare the object ID that matches. Otherwise when a tree gets replaced with a stump it'd still be classed as valid
	// Due to the tree and stump having the same object type.
	public boolean valid(World world) {
		return valid(world, false);
	}
	
	public boolean valid(World world, boolean uuidMatch) {
		MapObj currentAtTile = world.objByType(type, tile.x, tile.z, tile.level);
		if (currentAtTile == null) return false;
		if (uuidMatch && currentAtTile.attribOr(AttributeKey.MAPOBJ_UUID, -2) != attribOr(AttributeKey.MAPOBJ_UUID, -1)) {
			//System.out.printf(this+" vs "+currentAtTile+" didnt match!%n");
			return false;
		}
		return id == currentAtTile.id();
	}
	
	public MapObj replaceWith(MapObj obj, World world) {
		return replaceWith(obj, world, false);
	}
	
	public MapObj replaceWith(MapObj obj, World world, boolean attribTransfer) {
		world.removeObj(this);
		MapObj newobj = world.spawnObj(obj);
		if (attribTransfer) { // Used for doors, getting stuck open.
			newobj.cloneattribs(this);
		}
		return newobj;
	}
	
	public MapObj replaceWith(int obj, World world) {
		return replaceWith(new MapObj(tile, obj, type, rot), world);
	}
	
	private Map<AttributeKey, Object> attribs;
	
	public Map<AttributeKey, Object> attribs() {
		return attribs;
	}
	
	public <T> T attrib(AttributeKey key) {
		return attribs == null ? null : (T) attribs.get(key);
	}
	
	public <T> T attribOr(AttributeKey key, Object defaultValue) {
		return attribs == null ? (T) defaultValue : (T) attribs.getOrDefault(key, defaultValue);
	}
	
	public void clearattrib(AttributeKey key) {
		if (attribs != null)
			attribs.remove(key);
	}
	
	public MapObj putattrib(AttributeKey key, Object v) {
		if (attribs == null)
			attribs = new EnumMap<>(AttributeKey.class);
		attribs.put(key, v);
		return this;
	}
	
	public MapObj cloneattribs(MapObj source) {
		attribs = source.attribs;
		return this;
	}
	
	/**
	 * Returns an active Player instance which is linked to this MapObj via the OWNING_PLAYER Attribute.
	 *
	 * @param world World the owner belongs to
	 * @return The owner active player instance, or Null if offline.
	 */
	public Player owner(World world) {
		Tuple<Integer, Player> ownerLink = attrib(AttributeKey.OWNING_PLAYER);
		Player owner = null;
		if (ownerLink != null && (owner = ownerLink.second()) != null && owner.finished()) {
			return world.playerForId(ownerLink.first()).orElse(null);
		}
		return owner;
	}
	
	public boolean custom() {
		return custom;
	}
	
	public static int INCREMENTING_MAPOBJ_UUID = 1;
	
	@Override
	public String toString() {
		return "MapObj[id=" + id + ", tile=" + tile + ", type=" + type + ", rot=" + rot + "]";
	}
}
