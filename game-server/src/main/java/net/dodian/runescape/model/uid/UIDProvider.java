package net.dodian.runescape.model.uid;

import net.dodian.runescape.model.entity.Player;

/**
 * Created by Bart on 4-3-2015.
 */
public abstract class UIDProvider {
	
	/**
	 * Try to acquire a new UID for a player. This method may return null if it fails to acquire one, in which case
	 * the server will fall back to any other method available.
	 *
	 * @param player The player which needs a new UID.
	 * @return A UID of whatever object type.
	 */
	public abstract Object acquire(Player player);
	
}
