package io.nozemi.runescape.script;


import io.nozemi.skript.ScriptMain;
import it.unimi.dsi.fastutil.objects.Object2LongArrayMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import io.nozemi.skript.Script;
import io.nozemi.runescape.model.*;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.item.Item;
import io.nozemi.runescape.model.map.MapObj;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Bart on 7/9/2015.
 * <p>
 * The man of the triggers.
 */
public class ScriptRepository {
	
	private static final Logger logger = LogManager.getLogger(ScriptRepository.class);
	
	private List<Function1<Script, Unit>> loginTriggers = new LinkedList<>();
	private List<Function1<Script, Unit>> worldInitTriggers = new LinkedList<>();
	private Map<Integer, Function1<Script, Unit>> buttonTriggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> npcSpawnTriggers = new HashMap<>();
	private List<Function1<Script, Unit>> npcCreateTriggers = new LinkedList<>();
	private Map<Integer, Function1<Script, Unit>> objectTriggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> itemOnObjectTriggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> spellOnEntityTriggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> itemOnPlayer = new HashMap<>();
	private Map<Integer, Set<Function1<Script, Unit>>> regionEnterTriggers = new HashMap<>();
	private Map<Integer, Set<Function1<Script, Unit>>> regionExitTriggers = new HashMap<>();
	private Map<Integer, Set<Function1<Script, Unit>>> chunkEnterTriggers = new HashMap<>();
	private Map<Integer, Set<Function1<Script, Unit>>> chunkExitTriggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> interfaceCloseTriggers = new HashMap<>();
	private Map<TimerKey, Function1<Script, Unit>> timerTriggers = new EnumMap<>(TimerKey.class);
	private Map<TimerKey, Function1<Script, Unit>> worldTimerTriggers = new EnumMap<>(TimerKey.class);
	private Set<Integer> remoteInteractableObjects = new HashSet<>();
	
	private Map<Integer, Function1<Script, Unit>> item1Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> item2Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> item3Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> item4Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> item5Triggers = new HashMap<>();
	private Map<Long, Function1<Script, Unit>> itemOnItemTriggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> grounditem1Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> grounditem2Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> grounditem3Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> invitemOnGrounditem = new HashMap<>();
	
	private Map<Integer, Function1<Script, Unit>> npc1Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> npc2Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> npc3Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> npc4Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> itemOnNpcTriggers = new HashMap<>();
	
	private Map<Integer, Function1<Script, Unit>> itemEquipTriggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> itemUnequipTriggers = new HashMap<>();
	
	private Map<Integer, Function1<Script, Unit>> equipment1Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> equipment2Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> equipment3Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> equipment4Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> equipment5Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> equipment6Triggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> equipment7Triggers = new HashMap<>();
	
	private Map<Integer, Function1<Script, Unit>> spellOnItemTriggers = new HashMap<>();
	
	private List<Function1<Script, Unit>> player1Triggers = new LinkedList<>();
	private List<Function1<Script, Unit>> player2Triggers = new LinkedList<>();
	private List<Function1<Script, Unit>> player3Triggers = new LinkedList<>();
	private List<Function1<Script, Unit>> player4Triggers = new LinkedList<>();
	private List<Function1<Script, Unit>> player5Triggers = new LinkedList<>();
	private List<Function1<Script, Unit>> player6Triggers = new LinkedList<>();
	private List<Function1<Script, Unit>> player7Triggers = new LinkedList<>();
	private List<Function1<Script, Unit>> player8Triggers = new LinkedList<>();
	
	private Map<Integer, Function1<Script, Unit>> spellOnGroundItemTriggers = new HashMap<>();
	private Map<Integer, Function1<Script, Unit>> spellOnObjectTriggers = new HashMap<>();
	
	private Object2LongArrayMap<TimerKey> timerProfiler = new Object2LongArrayMap<>();
	
	private Map<Tile, Function1<Script, Unit>> walkDestinationTriggers = new HashMap<>();
	
	public ScriptRepository() {
	}
	
	public Object2LongArrayMap<TimerKey> getTimerProfiler() {
		return timerProfiler;
	}
	
	public void load() {
		// Clear all existing script containers
		loginTriggers.clear();
		worldInitTriggers.clear();
		buttonTriggers.clear();
		npcSpawnTriggers.clear();
		npcCreateTriggers.clear();
		objectTriggers.clear();
		itemOnObjectTriggers.clear();
		spellOnEntityTriggers.clear();
		itemOnPlayer.clear();
		regionEnterTriggers.clear();
		regionExitTriggers.clear();
		chunkEnterTriggers.clear();
		chunkExitTriggers.clear();
		interfaceCloseTriggers.clear();
		timerTriggers.clear();
		worldTimerTriggers.clear();
		npc1Triggers.clear();
		npc2Triggers.clear();
		npc3Triggers.clear();
		npc4Triggers.clear();
		player1Triggers.clear();
		player2Triggers.clear();
		player3Triggers.clear();
		player4Triggers.clear();
		player5Triggers.clear();
		player6Triggers.clear();
		player7Triggers.clear();
		player8Triggers.clear();
		itemOnNpcTriggers.clear();
		item1Triggers.clear();
		item2Triggers.clear();
		item3Triggers.clear();
		item4Triggers.clear();
		item5Triggers.clear();
		itemOnItemTriggers.clear();
		grounditem1Triggers.clear();
		grounditem2Triggers.clear();
		grounditem3Triggers.clear();
		invitemOnGrounditem.clear();
		equipment1Triggers.clear();
		equipment2Triggers.clear();
		equipment3Triggers.clear();
		equipment4Triggers.clear();
		equipment5Triggers.clear();
		equipment6Triggers.clear();
		equipment7Triggers.clear();
		spellOnItemTriggers.clear();
		remoteInteractableObjects.clear();
		spellOnGroundItemTriggers.clear();
		spellOnObjectTriggers.clear();
		walkDestinationTriggers.clear();
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
	
	private <K extends Tile, V extends Function1<Script, Unit>> void checkForExisting(Map<K, V> triggers, K tile) {
		if (triggers.containsKey(tile)) {
			logger.log(Level.FATAL, "trigger for mapping already exists: " + tile.toStringSimple());
			System.exit(0);
		}
	}
	
	public void onWalkDestination(Tile tile, Function1<Script, Unit> script) {
		checkForExisting(walkDestinationTriggers, tile);
		walkDestinationTriggers.put(tile, script);
	}
	
	public void onLogin(Function1<Script, Unit> script) {
		loginTriggers.add(script);
	}
	
	public void onWorldInit(Function1<Script, Unit> script) {
		worldInitTriggers.add(script);
	}
	
	public void onButton(int parentWidgetId, int widgetId, Function1<Script, Unit> script) {
		if (buttonTriggers.containsKey((parentWidgetId << 16) | widgetId)) {
			logger.log(Level.WARN, "WARNING: duplicate 'on button' trigger - " + parentWidgetId +", "+ widgetId);
		}
		buttonTriggers.put((parentWidgetId << 16) | widgetId, script);
	}
	
	public void onSpellOnItem(int parent, int childId, Function1<Script, Unit> script) {
		spellOnItemTriggers.put((parent << 16) | childId, script);
	}
	
	public boolean isRemoteObject(int id) {
		return remoteInteractableObjects.contains(id);
	}
	
	public void makeRemoteObject(int id) {
		remoteInteractableObjects.add(id);
	}
	
	public void onObject(int id, Function1<Script, Unit> script) {
		if (objectTriggers.containsKey(id)) {
			logger.log(Level.WARN, "WARNING: duplicate 'on object' trigger - " + id);
		}
		objectTriggers.put(id, script);
	}
	
	public void onItemOnObject(int objectId, Function1<Script, Unit> script) {
		if (itemOnObjectTriggers.containsKey(objectId)) {
			System.out.println("WARNING: duplicate 'item on object' trigger - " + objectId);
		}
		itemOnObjectTriggers.put(objectId, script);
	}
	
	public void onSpellOnEntity(int parentId, int childId, Function1<Script, Unit> script) {
		if (spellOnEntityTriggers.containsKey(((parentId << 16) | childId))) {
			System.out.println("WARNING: duplicate 'spell on entity' trigger - " + ((parentId << 16) | childId));
		}
		spellOnEntityTriggers.put((parentId << 16) | childId, script);
	}
	
	public void onItemOnPlayer(int item, Function1<Script, Unit> script) {
		if (itemOnPlayer.containsKey(item)) {
			System.out.println("WARNING: duplicate 'item on player' trigger - " + item);
		}
		itemOnPlayer.put(item, script);
	}
	
	public void onNpcSpawn(int npcType, Function1<Script, Unit> script) {
		if (npcSpawnTriggers.containsKey(npcType)) {
			System.out.println("WARNING: duplicate 'on npc spawn' trigger - " + npcType);
		}
		npcSpawnTriggers.put(npcType, script);
	}
	
	public void onNpcCreate(Function1<Script, Unit> script) {
		npcCreateTriggers.add(script);
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
	
	public void onInterfaceClose(int id, Function1<Script, Unit> script) {
		if (interfaceCloseTriggers.containsKey(id)) {
			System.out.println("WARNING: duplicate 'interface close' trigger - " + id);
		}
		interfaceCloseTriggers.put(id, script);
	}
	
	public void onItemOption1(int item, Function1<Script, Unit> script) {
		item1Triggers.put(item, script);
	}
	
	public void onItemOption2(int item, Function1<Script, Unit> script) {
		item2Triggers.put(item, script);
	}
	
	public void onGroundItemOption1(int item, Function1<Script, Unit> script) {
		grounditem1Triggers.put(item, script);
	}
	
	public void onGroundItemOption2(int item, Function1<Script, Unit> script) {
		grounditem2Triggers.put(item, script);
	}
	
	public void onGroundItemOption3(int item, Function1<Script, Unit> script) {
		grounditem3Triggers.put(item, script);
	}
	
	public void onInvitemOnGrounditem(int item, Function1<Script, Unit> script) {
		invitemOnGrounditem.put(item, script);
	}
	
	public void onNpcOption1(int npc, Function1<Script, Unit> script) {
		npc1Triggers.put(npc, script);
	}
	
	public void onItemOnNpc(int npc, Function1<Script, Unit> script) {
		itemOnNpcTriggers.put(npc, script);
	}
	
	public void onNpcOption2(int npcId, Function1<Script, Unit> script) {
		npc2Triggers.put(npcId, script);
	}
	
	public void onNpcOption3(int npcId, Function1<Script, Unit> script) {
		npc3Triggers.put(npcId, script);
	}
	
	public void onNpcOption4(int npcId, Function1<Script, Unit> script) {
		npc4Triggers.put(npcId, script);
	}
	
	public void onItemOption4(int item, Function1<Script, Unit> script) {
		item4Triggers.put(item, script);
	}
	
	public void onItemOption5(int item, Function1<Script, Unit> script) {
		item5Triggers.put(item, script);
	}
	
	public void onItemOption3(int item, Function1<Script, Unit> script) {
		item3Triggers.put(item, script);
	}
	
	public void onItemOnItem(long item1, long item2, Function1<Script, Unit> script) {
		itemOnItemTriggers.put((Math.max(item1, item2) << 32L) | Math.min(item1, item2), script);
	}
	
	public void onItemOnItem(int item1, int item2, Function1<Script, Unit> script) {
		onItemOnItem((long) item1, (long) item2, script);
	}
	
	public void onEquipmentOption(int opt, int item, Function1<Script, Unit> script) {
		switch (opt) {
			case 1:
				equipment1Triggers.put(item, script);
				break;
			case 2:
				equipment2Triggers.put(item, script);
				break;
			case 3:
				equipment3Triggers.put(item, script);
				break;
			case 4:
				equipment4Triggers.put(item, script);
				break;
			case 5:
				equipment5Triggers.put(item, script);
				break;
			case 6:
				equipment6Triggers.put(item, script);
				break;
			case 7:
				equipment7Triggers.put(item, script);
				break;
		}
	}

	public void triggerWorldInit(World world) {
		//worldInitTriggers.forEach(t -> executor.executeScript(world, t));
	}
}
