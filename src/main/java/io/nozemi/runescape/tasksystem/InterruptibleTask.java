package io.nozemi.runescape.tasksystem;

import io.nozemi.runescape.model.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InterruptibleTask extends Interruptible {
    private static final Logger logger = LogManager.getLogger(InterruptibleTask.class);

    private ExecuteInterface event = null;
    private ConditionInterface completeCondition = null;
    private ConditionInterface failCondition = null;

    protected InterruptibleTask(Entity entity) {
        super(entity);
    }

    protected InterruptibleTask(Entity entity, String name) {
        super(entity, name);
    }

    public static InterruptibleTask bound(Entity entity) {
        return new InterruptibleTask(entity);
    }

    public static InterruptibleTask bound(Entity entity, String name) {
        return new InterruptibleTask(entity, name);
    }

    public InterruptibleTask completeCondition(ConditionInterface condition) {
        this.completeCondition = condition;
        return this;
    }

    public InterruptibleTask failCondition(ConditionInterface condition) {
        this.failCondition = condition;
        return this;
    }

    public InterruptibleTask execute(ExecuteInterface event) {
        this.event = event;
        return this;
    }

    @Override
    public InterruptibleTask onComplete(ExecuteInterface execute) {
        super.onComplete(execute);
        return this;
    }

    @Override
    public InterruptibleTask onCancel(ExecuteInterface execute) {
        super.onCancel(execute);
        return this;
    }

    @Override
    public InterruptibleTask isCancellableByWalking(boolean b) {
        super.isCancellableByWalking(b);
        return this;
    }

    @Override
    void cycle() {
        if(cancelled) {
            if(this.onCancelled != null) {
                this.onCancelled.execute();
            }
            return;
        }

        if(event != null) {
            event.execute();
        }

        if(completeCondition != null && completeCondition.check() && !this.completed) {
            this.completed = true;
            if(this.onCompleted != null) {
                ChainableEvent temp = this.onCompleted;
                this.onCompleted = null;
                temp.execute();
            }
        }
    }
}
