package io.nozemi.runescape.tasksystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {

    private static final Logger logger = LogManager.getLogger(TaskManager.class);

    private final static Map<Integer, List<Interruptible>> playerEvents = new HashMap<>();
    private final static Map<Integer, List<Interruptible>> npcEvents = new HashMap<>();

    public static Map<Integer, List<Interruptible>> playerEvents() {
        return playerEvents;
    }

    public static Map<Integer, List<Interruptible>> npcEvents() {
        return npcEvents;
    }

    public static void cyclePlayerChains() {
        cycle(playerEvents);
    }

    public static void cycleNpcEvents() {
        cycle(npcEvents);
    }

    private static void cycle(Map<Integer, List<Interruptible>> eventsList) {
        eventsList.forEach((entityIndex, events) -> {
            for (int i = events.size() - 1; i >= 0; i--) {
                events.get(i).cycle();

                if(events.get(i).isCompleted()) {
                    events.remove(events.get(i));
                }
            }
        });
    }
}
