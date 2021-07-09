package io.nozemi.skript;

public class Fiber<T> {

    public void unpark(Object emergencyUnblocker) {

    }

    public Object getState() {
        return null;
    }

    public boolean isAlive() {
        return false;
    }

    public void start() {

    }

    /**
     * A strand's running state
     */
    public static enum State {
        /**
         * Strand created but not started
         */
        NEW,
        /**
         * Strand started but not yet running.
         */
        STARTED,
        /**
         * Strand is running.
         */
        RUNNING,
        /**
         * Strand is blocked.
         */
        WAITING,
        /**
         * Strand is blocked with a timeout
         */
        TIMED_WAITING,
        /**
         * Strand has terminated.
         */
        TERMINATED
    };
}
