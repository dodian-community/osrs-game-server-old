package io.nozemi.runescape.tasksystem;

public class MyFunction {
    private int delay;
    private boolean executed;
    private final MyFunctionExecute toExecute;

    public MyFunction(MyFunctionExecute toExecute) {
        this.toExecute = toExecute;
    }

    public MyFunction(int delay, MyFunctionExecute toExecute) {
        this.toExecute = toExecute;
        this.delay = delay;
    }

    public MyFunction(MyFunctionExecute toExecute, int delay) {
        this.toExecute = toExecute;
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

    public MyFunctionExecute toExecute() {
        return this.toExecute;
    }

    public void execute() {
        this.toExecute.execute();
    }
}