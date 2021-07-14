package io.nozemi.runescape.net.packets.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Opcodes {
    int[] value();
}
