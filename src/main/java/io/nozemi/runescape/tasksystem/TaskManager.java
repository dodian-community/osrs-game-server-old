package io.nozemi.runescape.tasksystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {
    private final static Map<Integer, List<InterruptibleChain>> playerChains = new HashMap<>();

    public static Map<Integer, List<InterruptibleChain>> playerChains() {
        return playerChains;
    }

    public static void cyclePlayerChains() {
        playerChains.forEach((entityIndex, eventChain) -> {
            for (int i = eventChain.size() - 1; i >= 0; i--) {
                eventChain.get(i).cycle();

                if(eventChain.get(i).isCompleted()) {
                    eventChain.remove(eventChain.get(i));
                }
            }
        });
    }
}
