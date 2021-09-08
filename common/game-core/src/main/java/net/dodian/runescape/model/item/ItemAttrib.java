package net.dodian.runescape.model.item;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Bart on 9/28/2015.
 */
public enum ItemAttrib {
	// Charges before this item degrades.
	CHARGES(1),
	
	// The item ID which this gnomish firelighter is charged with. player can have more than 1 gnomeish at a time.
	LIGHTER_ID(2),
	
	// Blowpipe - tracks scales in. Reduces 1 per 3 attacks.
	ZULRAH_SCALES(3),
	
	// Blowpipe tracks how many darts are in.
	DARTS_COUNT(4),
	
	// The item ID of the darts, you can use any type.
	DART_ITEMID(5),
	
	// For the blowpipe, every 3 attacks two scales are used.
	CONSECUTIVE_ATTACKS,
	;
	
	
	private boolean persistent;
	private int persistencyKey;
	
	ItemAttrib() {
		// Does not persist
	}
	
	ItemAttrib(int persistKey) {
		this.setPersistencyKey(persistKey);
		this.setPersistent(true);
	}
	
	public boolean isPersistent() {
		return persistent;
	}
	
	public void setPersistent(boolean persistent) {
		this.persistent = persistent;
	}
	
	public int getPersistencyKey() {
		return persistencyKey;
	}
	
	public void setPersistencyKey(int persistencyKey) {
		this.persistencyKey = persistencyKey;
	}
	
	public static Optional<ItemAttrib> forPersistencyKey(int key) {
		for (ItemAttrib tk : values()) {
			if (tk.persistencyKey == key)
				return Optional.of(tk);
		}
		return Optional.empty();
	}
	
	public static void verifyIntegrity() {
		// Critical check for overlapping timer keys - that'd be disastrous.
		Set<Integer> uniques = new HashSet<>();
		for (ItemAttrib key : values()) {
			if (key.persistent) {
				if (uniques.contains(key.persistencyKey)) {
					System.err.println("=================================== WARNING ===================================");
					System.err.println("WARNING: DUPLICATE ITEM ATTRIBUTE KEY " + key.persistencyKey + " ON " + key.name() + "!");
					System.err.println("REJECTING SERVER BOOT FOR OBVIOUS REASONS.");
					System.err.println("=================================== WARNING ===================================");
					System.exit(1);
				} else {
					uniques.add(key.persistencyKey);
				}
			}
		}
	}
}
