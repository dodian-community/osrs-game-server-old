package io.nozemi.runescape.net.packets.handlers;

import java.lang.annotation.*;

/**
 * Tells the packet provider to execute this method with the appropriate packet as argument.
 *
 * @author Nozemi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface PacketHandler {
    int value() default 0;
}
