package io.nozemi.runescape.tasksystem;

import io.nozemi.runescape.model.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class InterruptibleChain extends Interruptible {
    private static final Logger logger = LogManager.getLogger(InterruptibleChain.class);

    private List<ChainableEvent> events = new ArrayList<>();

    private InterruptibleChain(Entity entity) {
        super(entity);
    }

    private InterruptibleChain(Entity entity, String name) {
        super(entity, name);
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

    @Override
    public InterruptibleChain onComplete(ExecuteInterface execute) {
        super.onComplete(execute);
        return this;
    }

    @Override
    public InterruptibleChain onCancel(ExecuteInterface execute) {
        super.onCancel(execute);
        return this;
    }

    @Override
    public void cycle() {
        if (cancelled) {
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
            this.onCompleted.execute();
            this.completed = true;
        }
    }

    @Override
    public void cancel() {
        this.events = new ArrayList<>();
        this.completed = true;
        this.cancelled = true;
    }
}
