package io.nozemi.runescape.handlers.impl.dialogue;

public interface InputValueAction<T> {
    void execute(T value);
}
