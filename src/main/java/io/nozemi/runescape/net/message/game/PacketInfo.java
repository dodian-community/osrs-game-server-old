package io.nozemi.runescape.net.message.game;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Bart Pelle on 8/23/2014.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface PacketInfo {
	int size();
}
