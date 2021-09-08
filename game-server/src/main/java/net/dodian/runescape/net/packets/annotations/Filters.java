package net.dodian.runescape.net.packets.annotations;

import net.dodian.runescape.net.packets.Filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Implement the logic around filters
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Filters {
    Class<? extends Filter>[] value();
}
