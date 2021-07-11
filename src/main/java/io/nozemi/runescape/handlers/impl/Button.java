package io.nozemi.runescape.handlers.impl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Button {
    int parentId();
    int childId();
}
