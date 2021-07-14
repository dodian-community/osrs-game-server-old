package io.nozemi.runescape.events;

import io.nozemi.runescape.events.types.GameEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private final Map<Integer, List<GameEvent>> events = new HashMap<>();
}
