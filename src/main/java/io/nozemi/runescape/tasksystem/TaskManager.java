package io.nozemi.runescape.tasksystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {

    private static final Logger logger = LogManager.getLogger(TaskManager.class);

    private final static Map<Integer, List<Interruptible>> playerChains = new HashMap<>();

    public static Map<Integer, List<Interruptible>> playerChains() {
        return playerChains;
    }

    public static void cyclePlayerChains() {
        playerChains.forEach((entityIndex, event) -> {
            for (int i = event.size() - 1; i >= 0; i--) {
                event.get(i).cycle();

                if(event.get(i).isCompleted()) {
                    logger.info("Removing task...");
                    event.remove(event.get(i));
                }
            }
        });
    }
}
