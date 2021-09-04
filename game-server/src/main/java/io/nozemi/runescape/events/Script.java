package io.nozemi.runescape.events;

import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import kotlin.jvm.functions.Function1;

import java.lang.ref.WeakReference;

public class Script {

    private boolean started;
    private boolean interrupted;

    private Object context;
    private WaitReason waitReason;
    private Object waitParam;
    private Object waitReturnVal;
    private int lastTick;
    private Function1<Script, ?> executedFunction;
    private Function1<Script, ?> interruptCall;

    public Script(Object context, WaitReason waitReason, Object waitParam, int lastTick, Object waitReturnVal, Function1<Script, ?> interruptCall, Function1<Script, ?> executedFunction) {
        this.context = context;
        this.waitReason = waitReason;
        this.waitParam = waitParam;
        this.waitReturnVal = waitReturnVal;
        this.lastTick = lastTick;
        this.executedFunction = executedFunction;
        this.interruptCall = interruptCall;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isStarted() {
        return started;
    }

    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
    }

    public boolean isInterrupted() {
        return interrupted;
    }

    public final void delay(int time) {
        this.waitReason = WaitReason.DELAYED;
        this.waitParam = time;
    }

    public void setWaitReason(WaitReason waitReason) {
        this.waitReason = waitReason;
    }

    public WaitReason getWaitReason() {
        return waitReason;
    }

    public <T> T getWaitParam() {
        return (T) waitParam;
    }

    public Object getWaitReturnVal() {
        return waitReturnVal;
    }

    public void setWaitParam(Object waitParam) {
        this.waitParam = waitParam;
    }

    public void setWaitReturnVal(Object waitReturnVal) {
        this.waitReturnVal = waitReturnVal;
    }

    public int getLastTick() {
        return lastTick;
    }

    public void setLastTick(int lastTick) {
        this.lastTick = lastTick;
    }

    public Function1<Script, ?> getExecutedFunction() {
        return executedFunction;
    }

    public final <T> T getContext() {
        return (T) this.context;
    }

    public Entity entity() {
        return (Entity) context;
    }

    public Player player() {
        return (Player) context;
    }

    // Server-specific functions
    public void message(String msg) {
        ((Player) context).message(msg);
    }

    public Npc npc() {
        return (Npc) context;
    }

    public Npc targetNpc() {
        return (Npc) entity().<WeakReference<Entity>>attrib(AttributeKey.TARGET).get();
    }

    public Entity target() {
        WeakReference<Entity> holder = entity().attrib(AttributeKey.TARGET);

        if (holder != null)
            return holder.get();

        return null;
    }

    public final void setContext(Object x) {
        this.context = x;
    }
}
