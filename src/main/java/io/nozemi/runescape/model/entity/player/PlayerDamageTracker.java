package io.nozemi.runescape.model.entity.player;

import io.nozemi.runescape.model.entity.Player;

/**
 * Created by Jak on 01/03/2016.
 * <p>
 * The purpose of this class is to associate a Player.class instance with their account-id.
 * In the event that the player logs off, the game-world cannot access their profile (could.. but stressful to load..)
 * in order to check if they are an ironman - which is used in ItemsOnDeath to make sure Ironmen cannot get items by PKing.
 * Solution: attach the player's online instance when they cause damage, and refer to it if they're offline.
 */
public class PlayerDamageTracker {
	
	// The guy attacking us.
	private Player attacker;
	
	// The damage he's done.
	private int damageDelt = 0;
	
	// Update damage this guys done to us.
	public PlayerDamageTracker update(Player attacher, int damage) {
		this.attacker = attacher;
		this.damageDelt += damage;
		return this;
	}
	
	// The damage the killer did
	public Integer damage() {
		return damageDelt;
	}
	
	// Get the last valid instance of the attacker. Check this guy's ironman status etc
	public Player killer() {
		return attacker;
	}
	
	@Override
	public String toString() {
		return String.valueOf(damageDelt);
	}
}
