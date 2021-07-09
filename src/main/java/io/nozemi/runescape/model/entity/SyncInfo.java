package io.nozemi.runescape.model.entity;

import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.Hit;
import io.nozemi.runescape.model.Tile;

import java.util.LinkedList;

/**
 * Created by Bart Pelle on 8/23/2014.
 */
public abstract class SyncInfo {
	
	protected byte[] animationSet = new byte[3];
	protected byte[] graphicSet = new byte[6];
	protected byte[] faceEntitySet = new byte[2];
	protected byte[] facetile = new byte[4];
	protected byte[] forcemove = new byte[9];
	protected byte[] shout = new byte[0]; // Dynamically reallocated
	protected byte[] tripleStrings = new byte[0]; // Dynamically reallocated
	
	protected int calculatedFlag;
	protected int primaryStep = -1;
	protected int secondaryStep = -1;
	protected boolean teleported = true;
	protected Tile facedTile;
	
	/**
	 * The calculated entity index serialized to be send as the face entity mask. -1 when inactive. Reset post-sync
	 */
	public int FORCE_FACE_ID = -1;
	
	/**
	 * The tile you are actively facing. Reset when entity moves (changes tile) currently called in #Entity.walkTo().
	 * It's not in pre-sync movement calc because if the player TPs I'm not sure that code is used. No path just a coord change.
	 */
	public Tile FORCE_TILE;
	
	/**
	 * Precycle we set the direction we're facing, so newly added players face the right way when added to someones local list.
	 */
	public int FACE_DIR = 6;
	
	public LinkedList<Hit> hits = new LinkedList<>();
	
	protected Entity entity;
	
	public SyncInfo(Entity entity) {
		this.entity = entity;
	}
	
	public boolean dirty() {
		return calculatedFlag != 0 || primaryStep != -1 || teleported || !hits.isEmpty();
	}
	
	public void addFlag(int flag) {
		calculatedFlag |= flag;
	}
	
	public int calculatedFlag() {
		return calculatedFlag;
	}
	
	public boolean hasFlag(int flag) {
		return (calculatedFlag & flag) != 0;
	}
	
	public void step(int primary, int secondary) {
		primaryStep = primary;
		secondaryStep = secondary;
	}
	
	public int primaryStep() {
		return primaryStep;
	}
	
	public int secondaryStep() {
		return secondaryStep;
	}
	
	public void teleported(boolean b) {
		teleported = b;
	}
	
	public boolean teleported() {
		return teleported;
	}
	
	public abstract void animation(int id, int delay);
	
	public abstract void graphic(int id, int height, int delay);
	
	public abstract void faceEntity(Entity e);
	
	public abstract void facetile(Tile tile);
	
	public abstract void shout(String message);
	
	public abstract void hit(Hit hit);
	
	public abstract void sufixPrefixName(String[] str);
	
	public byte[] animationSet() {
		return animationSet;
	}
	
	public byte[] graphicSet() {
		return graphicSet;
	}
	
	public byte[] faceEntitySet() {
		return faceEntitySet;
	}
	
	public abstract byte[] hitSet();
	
	public byte[] faceTileSet() {
		return facetile;
	}
	
	public byte[] forceMoveSet() {
		return forcemove;
	}
	
	public byte[] shout() {
		return shout;
	}
	
	public byte[] tripleStrings() {
		return tripleStrings;
	}
	
	public Tile facedTile() {
		return facedTile;
	}
	
	public void clear() {
		calculatedFlag = 0;
		primaryStep = -1;
		secondaryStep = -1;
		teleported = false;
		FORCE_FACE_ID = -1;
		FORCE_TILE = null;
		hits.clear();
	}
	
	public void clearMovement() {
		primaryStep = secondaryStep = -1;
	}
	
	// For both npcs and players, grab the current attrubitekey value and store it to act as a more direct/faster access (?)
	// Than using the EnumMap
	public void updateUniversalAttribStates() {
		FORCE_FACE_ID = entity.attribOr(AttributeKey.LAST_FACE_ENTITY_IDX, -1);
		FORCE_TILE = entity.attribOr(AttributeKey.LAST_FACE_TILE, null);
		FACE_DIR = entity.attribOr(AttributeKey.FACING_DIRECTION, 6);
	}
}
