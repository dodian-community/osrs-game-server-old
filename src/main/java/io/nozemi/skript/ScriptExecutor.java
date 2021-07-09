package io.nozemi.skript;

import it.unimi.dsi.fastutil.objects.Object2LongArrayMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import kotlin.jvm.functions.Function1;

import java.util.*;

public class ScriptExecutor {

    private int cycle;
    private boolean profile = false;

    private ObjectArrayList<Script> scheduled = new ObjectArrayList<>();
    private ObjectArrayList<Script> toRun = new ObjectArrayList<>();
    private ObjectArrayList<Script> toRemove = new ObjectArrayList<>();
    private Object2LongArrayMap<Class> profileResults = new Object2LongArrayMap<>();

    public void cycle() {
        cycle(null);
    }

    public void cycle(Condition condition) {
        for (int i = 0; i < scheduled.size(); i++) {
            Script script = scheduled.get(i);
            if (script.interrupted()) {
                toRemove.add(script);
            } else if (condition == null || condition.check(script)) {
                if (script.getWaitReason() == WaitReason.DELAYED) {
                    if (script.getLastTick() != cycle) {
                        Integer ticks = script.getWaitParam();
                        script.setWaitParam(ticks - 1);

                        if (ticks - 1 < 1) {
                            script.setWaitReason(WaitReason.NONE);
                            toRun.add(script);
                        }
                    }
                } else if (!script.hasStarted()) {
                    script.setWaitReason(WaitReason.NONE);
                    toRun.add(script);
                }
            }
        }

        for (int i = 0; i < toRemove.size(); i++) {
            scheduled.remove(toRemove.get(i));
        }

        for (int i = 0; i < toRun.size(); i++) {
            Script script = toRun.get(i);
            scheduled.remove(script);

            //if (!script.interrupted()) {
            if (script.hasStarted()) {
                continueScript(script, script.getWaitReturnVal());
            } else {
                Fiber fiber = script.getFiber();
                fiber.start();
                script.setStarted(true);

                awaitAndSchedule(script);
            }
            //}
        }

        toRemove.clear();
        toRun.clear();
    }

    public int incCycle() {
        return ++cycle;
    }

    public ObjectArrayList<Script> getScheduled() {
        return scheduled;
    }

    public void setProfile(boolean profile) {
        this.profile = profile;
    }

    public boolean isProfiling() {
        return profile;
    }

    public Map<Class, Long> getProfileResults() {
        return profileResults;
    }

    public final void executeScript(Object context, final Function1<Script, ?> function) {
        final Script script = new Script(null, context, WaitReason.NONE, null, cycle, null, null, function);

        FunctionFiber fiber = new FunctionFiber(script);
        script.setFiber(fiber);
        script.setStarted(true);

        long start = System.nanoTime();
        fiber.start();
        long end = System.nanoTime();

        if (profile) {
            putProfileData(function.getClass(), end - start);
        }

        awaitAndSchedule(script);
    }

    public final void executeLater(Object context, final Function1<Script, ?> function) {
        final Script script = new Script(null, context, WaitReason.NONE, null, cycle, null, null, function);
        script.setFiber(new FunctionFiber(script));

        scheduled.add(script);
    }

    public final void interruptFor(Object context) {
        Collection<Script> temp = new ArrayList<>();

        for (Script scr : scheduled) {
            if (scr.getContext() == context) {
                temp.add(scr);
            }
        }

        for (Script scr : temp) {
            scheduled.remove(scr);
            scr.interrupt();
        }
    }

    public final void continueFor(Object context, WaitReason type, Object returnval) {
        List<Script> toExecute = new LinkedList<>();

        for (Script s : scheduled) {
            if (s.getContext() == context && s.getWaitReason() == type) {
                toExecute.add(s);
            }
        }

        for (Script s : toExecute) {
            scheduled.remove(s);
            continueScript(s, returnval);
        }
    }

    public final void continueScript(Script script, Object returnval) {
        script.setWaitReason(WaitReason.NONE);
        script.setWaitReturnVal(returnval);
        Fiber fiber = script.getFiber();

        long start = System.nanoTime();
        fiber.unpark(ParkableForkJoinTask.EMERGENCY_UNBLOCKER);
        awaitAndSchedule(script);
        long end = System.nanoTime();

        if (profile) {
            putProfileData(script.getExecutedFunction().getClass(), end - start);
        }
    }

    private void putProfileData(Class<?> c, long ns) {
        long duration = profileResults.getLong(c);

        if (duration == -1) {
            profileResults.put(c, 1L);
        } else {
            profileResults.put(c, duration + ns);
        }
    }

    public final void awaitAndSchedule(Script script) {
        script.setLastTick(cycle);

        Fiber fiber = script.getFiber();

        while (fiber.getState() == Fiber.State.NEW || fiber.getState() == Fiber.State.RUNNING || fiber.isAlive() && script.getWaitReason() == WaitReason.NONE) {
            Thread.yield();
        }

        if (fiber.getState() == Fiber.State.WAITING && script.getWaitReason() != WaitReason.NONE) {
            scheduled.add(script);
        }
    }
}
