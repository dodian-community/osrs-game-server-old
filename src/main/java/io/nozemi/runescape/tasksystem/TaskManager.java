package io.nozemi.runescape.tasksystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {

    private static final Logger logger = LogManager.getLogger(TaskManager.class);

    private final static Map<Integer, List<Interruptible>> playerChains = new HashMap<>();
    private final static Map<Integer, List<Interruptible>> loginEvents = new HashMap<>();

    public static Map<Integer, List<Interruptible>> playerChains() {
        return playerChains;
    }

    public static Map<Integer, List<Interruptible>> loginEvents() {
        return loginEvents;
    }

    public static void cyclePlayerChains() {
        cycle(playerChains);
    }

    public static void cycleLoginEvents() {
        cycle(loginEvents);
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
