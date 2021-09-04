package io.nozemi.runescape.events;

import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.map.MapObj;
import io.nozemi.runescape.script.TimerKey;
import it.unimi.dsi.fastutil.objects.Object2LongArrayMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.*;

@Component
public class ScriptRepository {

    private static final Logger logger = LogManager.getLogger(ScriptRepository.class);

    private final List<Function1<Script, Unit>> playerLoginTriggers = new LinkedList<>();

    private Map<Integer, Set<Function1<Script, Unit>>> regionEnterTriggers = new HashMap<>();
    private Map<Integer, Set<Function1<Script, Unit>>> regionExitTriggers = new HashMap<>();
    private Map<Integer, Set<Function1<Script, Unit>>> chunkEnterTriggers = new HashMap<>();
    private Map<Integer, Set<Function1<Script, Unit>>> chunkExitTriggers = new HashMap<>();

    private Map<Integer, Function1<Script, Unit>> buttonTriggers = new HashMap<>();

    private final Map<Integer, Function1<Script, Unit>> npcAction1Triggers = new HashMap<>();
    private final Map<Integer, Function1<Script, Unit>> npcAction2Triggers = new HashMap<>();

    private final Map<Integer, Function1<Script, Unit>> objectTriggers = new HashMap<>();

    private Map<TimerKey, Function1<Script, Unit>> timerTriggers = new EnumMap<>(TimerKey.class);
    private Map<TimerKey, Function1<Script, Unit>> worldTimerTriggers = new EnumMap<>(TimerKey.class);

    private Object2LongArrayMap<TimerKey> timerProfiler = new Object2LongArrayMap<>();

    private final ScriptExecutor executor;

    @Autowired
    public ScriptRepository(ScriptExecutor executor) {
        this.executor = executor;
        load();
    }

    public void load() {
        playerLoginTriggers.clear();
        npcAction1Triggers.clear();
        objectTriggers.clear();
        buttonTriggers.clear();

        Set<Method> methods = new Reflections("io.nozemi.runescape.content", new SubTypesScanner(false), new MethodAnnotationsScanner()).getMethodsAnnotatedWith(ScriptMain.class);
        methods.forEach(m -> {
            if (!m.getDeclaringClass().getName().contains("$") && !m.getDeclaringClass().getName().endsWith("Package")) {
                try {
                    m.invoke(null, this);
                } catch (Exception e) {
                    logger.error("Error loading script {}. Could not invoke method.", m.getDeclaringClass(), e);
                }
            }
        });
    }

    public void onLogin(Function1<Script, Unit> script) {
        playerLoginTriggers.add(script);
    }

    public boolean triggerLogin(Player player) {
        playerLoginTriggers.forEach(t -> executor.executeScript(player, t));
        return true;
    }

    public void onNpcAction1(int npc, Function1<Script, Unit> script) {
        npcAction1Triggers.put(npc, script);
    }

    public boolean triggerNpcAction1(Player player, Npc npc) {
        if (npcAction1Triggers.containsKey(npc.id())) {
            player.putattrib(AttributeKey.TARGET, new WeakReference<Entity>(npc));
            executor.executeScript(player, npcAction1Triggers.get(npc.id()));
            return true;
        }
        return false;
    }

    public void onNpcAction2(int npc, Function1<Script, Unit> script) {
        npcAction2Triggers.put(npc, script);
    }

    public boolean triggerNpcAction2(Player player, Npc npc) {
        if (npcAction2Triggers.containsKey(npc.id())) {
            // TODO: Add this
            //if (!npc.locked()) this.executor.interruptFor(npc);
            player.putattrib(AttributeKey.TARGET, new WeakReference<Entity>(npc));
            executor.executeScript(player, npcAction2Triggers.get(npc.id()));
            return true;
        }
        return false;
    }

    public void onObject(int id, Function1<Script, Unit> script) {
        if (objectTriggers.containsKey(id)) {
            logger.log(Level.WARN, "WARNING: duplicate 'on object' trigger - " + id);
        }
        objectTriggers.put(id, script);
    }

    public boolean triggerObject(Player player, MapObj obj, int action) {
        player.putattrib(AttributeKey.INTERACTION_OBJECT, obj);
        player.putattrib(AttributeKey.INTERACTION_OPTION, action);
        if (objectTriggers.containsKey(obj.id())) {
            executor.executeScript(player, objectTriggers.get(obj.id()));
            return true;
        } else {
            return false;
        }
    }

    public void onButton(int parentWidgetId, int widgetId, Function1<Script, Unit> script) {
        if (buttonTriggers.containsKey((parentWidgetId << 16) | widgetId)) {
            logger.log(Level.WARN, "WARNING: duplicate 'on button' trigger - " + parentWidgetId + ", " + widgetId);
        }
        buttonTriggers.put((parentWidgetId << 16) | widgetId, script);
    }

    public void triggerButton(Player player, int parentId, int childId, int slot, int action, int item) {
        player.putattrib(AttributeKey.BUTTON_SLOT, slot);
        player.putattrib(AttributeKey.BUTTON_ACTION, action);
        player.putattrib(AttributeKey.ITEM_ID, item);
        player.putattrib(AttributeKey.CHILD_ID, childId);
        if (buttonTriggers.containsKey((parentId << 16) | childId)) {
            executor.executeScript(player, buttonTriggers.get((parentId << 16) | childId));
        }
    }

    public void onTimer(TimerKey timer, Function1<Script, Unit> script) {
        timerTriggers.put(timer, script);
    }

    public Object2LongArrayMap<TimerKey> getTimerProfiler() {
        return timerProfiler;
    }

    public void triggerTimer(Entity entity, TimerKey timer) {
        long start = System.nanoTime();
        if (timerTriggers.containsKey(timer)) {
            executor.executeScript(entity, timerTriggers.get(timer));
        }

        long delta = System.nanoTime() - start;
        timerProfiler.put(timer, timerProfiler.getOrDefault(timer, 0L) + delta);
    }

    public void onWorldTimer(TimerKey timer, Function1<Script, Unit> script) {
        worldTimerTriggers.put(timer, script);
    }

    public void triggerWorldTimer(World world, TimerKey timer) {
        long start = System.nanoTime();
        if (worldTimerTriggers.containsKey(timer)) {
            executor.executeScript(world, worldTimerTriggers.get(timer));
        }

        long delta = System.nanoTime() - start;
        timerProfiler.put(timer, timerProfiler.getOrDefault(timer, 0L) + delta);
    }

    public void onRegionEnter(int region, Function1<Script, Unit> script) {
        regionEnterTriggers.compute(region, (k, v) -> {
            if (v == null)
                v = new HashSet<>();
            v.add(script);
            return v;
        });
    }

    public void onRegionExit(int region, Function1<Script, Unit> script) {
        regionExitTriggers.compute(region, (k, v) -> {
            if (v == null)
                v = new HashSet<>();
            v.add(script);
            return v;
        });
    }

    public void onChunkEnter(int region, Function1<Script, Unit> script) {
        chunkEnterTriggers.compute(region, (k, v) -> {
            if (v == null)
                v = new HashSet<>();
            v.add(script);
            return v;
        });
    }

    public void onChunkExit(int region, Function1<Script, Unit> script) {
        chunkExitTriggers.compute(region, (k, v) -> {
            if (v == null)
                v = new HashSet<>();
            v.add(script);
            return v;
        });
    }

    public ScriptExecutor getExecutor() {
        return executor;
    }
}
