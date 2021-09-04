package io.nozemi.runescape.tasksystem;

public class ChainableEvent {
    private int delay = 0;
    private boolean executed;
    private final ExecuteInterface executeInterface;

    public ChainableEvent(ExecuteInterface executeInterface) {
        this.executeInterface = executeInterface;
    }

    public ChainableEvent(int delay, ExecuteInterface executeInterface) {
        this.delay = delay;
        this.executeInterface = executeInterface;
    }

    public ChainableEvent(ExecuteInterface executeInterface, int delay) {
        this.executeInterface = executeInterface;
        this.delay = delay;
    }

    public void delay(int delay) {
        this.delay = delay;
    }

    public int delay() {
        return this.delay;
    }

    public void executed(boolean b) {
        this.executed = b;
    }

    public boolean executed() {
        return this.executed;
    }

    public ExecuteInterface toExecute() {
        return this.executeInterface;
    }

    public void execute() {
        this.toExecute().execute();
    }
}
