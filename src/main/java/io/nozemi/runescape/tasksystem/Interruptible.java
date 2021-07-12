package io.nozemi.runescape.tasksystem;

import io.nozemi.runescape.model.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Interruptible {
    protected String name;
    protected Entity entity;
    protected ChainableEvent onCompleted = null;
    protected ChainableEvent onCancelled = null;
    protected boolean completed = false;
    protected boolean cancelled = false;

    protected boolean cancellableByWalking = true;

    protected Interruptible(Entity entity) {
        this.entity = entity;
    }

    protected Interruptible(Entity entity, String name) {
        this.entity = entity;
        this.name = name;
    }

    public Interruptible onComplete(ExecuteInterface execute) {
        if (onCompleted == null) {
            this.onCompleted = new ChainableEvent(execute);
        }
        return this;
    }

    public Interruptible onCancel(ExecuteInterface execute) {
        if (onCancelled == null) {
            this.onCancelled = new ChainableEvent(execute);
        }
        return this;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void cancel() {
        this.completed = true;
        this.cancelled = true;
    }

    public Interruptible isCancellableByWalking(boolean b) {
        this.cancellableByWalking = b;
        return this;
    }

    public boolean isCancellableByWalking() {
        return this.cancellableByWalking;
    }

    abstract void cycle();

    public void submit(Map<Integer, List<Interruptible>> list) {
        List<Interruptible> chain = new ArrayList<>();
        if (list.containsKey(entity.index())) {
            chain = list.get(entity.index());
        }

        chain.add(this);

        list.put(entity.index(), chain);
    }
}
