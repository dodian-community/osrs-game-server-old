package net.dodian.runescape.model.entity;

/**
 * Created by Bart on 8/12/2015.
 */
public enum LockType {
	
	/**
	 * You can't do anything
	 */
	FULL,
	
	/**
	 * You can't move but can do other stuff
	 */
	MOVEMENT,
	
	/**
	 * Default value
	 */
	NONE,
	
	/**
	 * when walking over a plank, or doing an agility obstacle. hits stack up and the last 2 are executed when the event finished
	 */
	NULLIFY_DAMAGE,
	
	/**
	 * when you teleport. any incoming damage is not applied at all.
	 */
	DELAY_DAMAGE,
	
	/**
	 * same as full, except logout button isnt locked
	 */
	FULL_LOGOUT_OK,
	
	/**
	 * Full, but hits are shown as normal
	 */
	FULL_WITHDMG,
	
	/**
	 * Will stop entity from attacking if this lock is active
	 */
	NO_ATTACK
}
