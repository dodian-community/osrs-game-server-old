package io.nozemi.runescape.events;

import it.unimi.dsi.fastutil.objects.Object2LongArrayMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import kotlin.jvm.functions.Function1;
import org.springframework.stereotype.Component;

@Component
public class ScriptExecutor {

    private boolean profile = false;

    private int cycle;

    private final ObjectArrayList<Script> scheduled = new ObjectArrayList<>();
    private final ObjectArrayList<Script> toRun = new ObjectArrayList<>();
    private final ObjectArrayList<Script> toRemove = new ObjectArrayList<>();
    private final Object2LongArrayMap<Class<?>> profileResults = new Object2LongArrayMap<>();

    public final void executeScript(Object context, final Function1<Script, ?> function) {
        final Script script = new Script(context, WaitReason.NONE, null, cycle, null, null, function);

        FunctionFiber fiber = new FunctionFiber(script);
        script.setStarted(true);

        long start = System.nanoTime();
        fiber.run();
        long end = System.nanoTime();

        if (profile) {
            putProfileData(function.getClass(), end - start);
        }

        awaitAndSchedule(script);
    }

    public void cycle() {
        cycle(null);
    }

    public void cycle(Condition condition) {
        for (int i = 0; i < scheduled.size(); i++) {
            Script script = scheduled.get(i);
            if (script.isInterrupted()) {
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
                } else if (!script.isStarted()) {
                    script.setWaitReason(WaitReason.NONE);
                    toRun.add(script);
                }
            }
        }

        for (Script value : toRemove) {
            scheduled.remove(value);
        }

        for (Script script : toRun) {
            scheduled.remove(script);

            if (script.isStarted()) {
                continueScript(script, script.getWaitReturnVal());
            } else {
                script.setStarted(true);

                awaitAndSchedule(script);
            }
        }

        toRemove.clear();
        toRun.clear();
    }

    public final void continueScript(Script script, Object returnVal) {
        script.setWaitReason(WaitReason.NONE);
        script.setWaitReturnVal(returnVal);

        long start = System.nanoTime();
        awaitAndSchedule(script);
        long end = System.nanoTime();

        if (profile) {
            putProfileData(script.getExecutedFunction().getClass(), end - start);
        }
    }

    public final void awaitAndSchedule(Script script) {
        script.setLastTick(cycle);

        if (script.getWaitReason() != WaitReason.NONE) {
            scheduled.add(script);
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

    public int incCycle() {
        return ++cycle;
    }
}
