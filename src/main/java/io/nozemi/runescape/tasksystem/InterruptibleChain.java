package io.nozemi.runescape.tasksystem;

import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.entity.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InterruptibleChain {
    private static final Logger logger = LogManager.getLogger(InterruptibleChain.class);

    private String name;
    private Entity entity;
    private List<ChainableEvent> events = new ArrayList<>();
    private ChainableEvent onCompleted = null;
    private ChainableEvent onCancelled = null;
    private boolean completed = false;
    private boolean cancelled = false;

    private InterruptibleChain(Entity entity) {
        this.entity = entity;
    }

    private InterruptibleChain(Entity entity, String name) {
        this.entity = entity;
        this.name = name;
    }

    public static InterruptibleChain bound(Entity entity) {
        return new InterruptibleChain(entity);
    }

    public static InterruptibleChain bound(Entity entity, String name) {
        return new InterruptibleChain(entity, name);
    }

    public InterruptibleChain first(ChainableEvent event) {
        events.add(event);
        return this;
    }

    public InterruptibleChain first(int delay, ExecuteInterface execute) {
        this.first(new ChainableEvent(delay, execute));
        return this;
    }

    public InterruptibleChain first(ExecuteInterface execute) {
        this.first(new ChainableEvent(execute));
        return this;
    }

    public InterruptibleChain then(ChainableEvent event) {
        if (events.size() > 0) {
            int previousDelay = events.get(events.size() - 1).delay();
            event.delay(event.delay() + previousDelay);
        }

        events.add(event);
        return this;
    }

    public InterruptibleChain then(int delay, ExecuteInterface execute) {
        then(new ChainableEvent(delay, execute));
        return this;
    }

    public InterruptibleChain onComplete(ChainableEvent event) {
        if (onCompleted == null) {
            this.onCompleted = event;
        }
        return this;
    }

    public InterruptibleChain onComplete(ExecuteInterface execute) {
        onComplete(new ChainableEvent(execute));
        return this;
    }

    public InterruptibleChain onCancel(ChainableEvent event) {
        if (onCancelled == null) {
            this.onCancelled = event;
        }
        return this;
    }

    public InterruptibleChain onCancel(ExecuteInterface execute) {
        onCancel(new ChainableEvent(execute));
        return this;
    }

    public void submit(Map<Integer, List<InterruptibleChain>> list) {
        List<InterruptibleChain> chain = new ArrayList<>();
        if (list.containsKey(entity.index())) {
            chain = list.get(entity.index());
        }

        chain.add(this);

        list.put(entity.index(), chain);
    }

    public void cycle() {
        logger.info("Cycling {} tasks for entity {}, in task chain {}...", events.size(), ((Player) entity).username(), this.name);

        if (cancelled) {
            logger.info("Executing onCancelled for entity {}, in task chain {}...", ((Player) entity).username(), this.name);
            this.onCancelled.execute();
            return;
        }

        for (int i = events.size() - 1; i >= 0; i--) {
            ChainableEvent event = events.get(i);
            if (event.delay() > 0) {
                event.delay(event.delay() - 1);
            } else {
                events.remove(event);
                event.execute();
            }
        }

        if (events.size() <= 0) {
            logger.info("Completing task chain {} for entity {}...", this.name, ((Player) entity).username());
            this.onCompleted.execute();
            this.completed = true;
        }
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void cancel() {
        logger.info("Cancelled {} tasks for entity {}, in task chain {}...", events.size(), ((Player) entity).username(), this.name);
        this.events = new ArrayList<>();
        this.completed = true;
        this.cancelled = true;
    }
}
