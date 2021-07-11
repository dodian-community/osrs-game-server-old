package io.nozemi.runescape.tasksystem;

import io.nozemi.runescape.model.Entity;

import java.util.*;

public class InterruptibleChain {

    public static final Map<Integer, List<MyFunction>> tasks = new HashMap<>();

    private static final Map<Integer, List<MyFunction>> temporaryTasks = new HashMap<>();

    private final Entity entity;

    private InterruptibleChain(Entity entity) {
        this.entity = entity;
    }

    public static InterruptibleChain bound(Entity entity) {
        return new InterruptibleChain(entity);
    }

    public InterruptibleChain execute(MyFunction function) {
        if(!temporaryTasks.containsKey(entity.index())) {
            temporaryTasks.put(entity.index(), new ArrayList<>());
        }

        List<MyFunction> playerTasks = temporaryTasks.get(entity.index());

        int add = 0;
        if(playerTasks.size() > 0 && playerTasks.get(playerTasks.size() - 1) != null) {
            add = playerTasks.get(playerTasks.size() - 1).delay();
        }

        function.delay(add + function.delay());
        playerTasks.add(function);

        temporaryTasks.put(entity.index(), playerTasks);

        return this;
    }

    public InterruptibleChain then(MyFunction function) {
        execute(function);
        return this;
    }

    public void submit() {
        if(!temporaryTasks.containsKey(entity.index())) {
            return;
        }

        List<MyFunction> pTasks = temporaryTasks.get(entity.index());
        temporaryTasks.remove(entity.index());

        tasks.put(entity.index(), pTasks);
    }
}
