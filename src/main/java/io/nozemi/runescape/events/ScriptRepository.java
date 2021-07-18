package io.nozemi.runescape.events;

import io.nozemi.runescape.content.Testing;
import io.nozemi.runescape.model.AttributeKey;
import io.nozemi.runescape.model.Entity;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.map.MapObj;
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

    private final Map<Integer, Function1<Script, Unit>> npcAction1Triggers = new HashMap<>();
    private final Map<Integer, Function1<Script, Unit>> npcAction2Triggers = new HashMap<>();

    private final Map<Integer, Function1<Script, Unit>> objectTriggers = new HashMap<>();

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
}
