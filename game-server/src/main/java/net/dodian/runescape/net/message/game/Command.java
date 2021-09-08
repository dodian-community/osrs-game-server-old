package net.dodian.runescape.net.message.game;

import net.dodian.runescape.io.RSBuffer;
import net.dodian.runescape.model.entity.Player;

/**
 * Created by Bart Pelle on 8/22/2014.
 * <p>
 * Represents a command, or simply a message from the server to the user.
 */
public abstract class Command {
	
	private RSBuffer cached;
	private boolean reuse;
	
	public final RSBuffer write(Player player) {
		if (reuse && cached != null) {
			return cached;
		}
		cached = this.encode(player);
		
		if (reuse) {
			cached.reusable(true);
		}
		return cached;
	}
	
	public <T> T markReusable() {
		this.reuse = true;
		return (T) this;
	}
	
	protected abstract RSBuffer encode(Player player);
}
