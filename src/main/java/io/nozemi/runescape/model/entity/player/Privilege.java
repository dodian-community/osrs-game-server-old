package io.nozemi.runescape.model.entity.player;

/**
 * Created by Gebruiker on 19-1-2015.
 */
public enum Privilege {
	
	/**
	 * A regular player without any privileges.
	 */
	PLAYER,
	
	/**
	 * A game moderator who has access to e.g. kicking and banning commands.
	 */
	MODERATOR,
	
	/**
	 * A game administrator, also known as an owner or programmer or whatnot.
	 */
	ADMIN;
	
	public boolean eligibleTo(Privilege p) {
		return ordinal() >= p.ordinal();
	}
	
}
