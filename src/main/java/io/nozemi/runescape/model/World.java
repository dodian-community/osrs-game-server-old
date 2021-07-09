package io.nozemi.runescape.model;

import com.typesafe.config.Config;
import io.nozemi.runescape.GameInitializer;
import io.nozemi.runescape.content.mechanics.VarbitAttributes;
import io.nozemi.runescape.fs.DefinitionRepository;
import io.nozemi.runescape.fs.MapDefinition;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.npc.NpcCombatInfo;
import io.nozemi.runescape.model.item.Item;
import io.nozemi.runescape.model.map.Flags;
import io.nozemi.runescape.model.map.MapObj;
import io.nozemi.runescape.net.message.game.command.*;
import io.nozemi.runescape.script.Timer;
import io.nozemi.runescape.script.TimerKey;
import io.nozemi.runescape.script.TimerRepository;
import io.nozemi.runescape.util.EquipmentInfo;
import kotlin.ranges.IntRange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class World {

    private static final Logger logger = LogManager.getLogger(World.class);

    public static int plimit = 2000;

    private Realm realm;
    private DefinitionRepository definitionRepository;

    private InstanceAllocator instanceAllocator = new InstanceAllocator(this);

    private EntityList<Player> players = new EntityList<>(2048);
    private EntityList<Player> pvpShuffablePid = new EntityList<>(2048);
    private Map<Object, Player> playerLookupMap = new HashMap<>();
    private Map<String, Player> playerNameLookupMap = new HashMap<>();

    private EntityList<Npc> npcs = new EntityList<>(0xFFFF);

    private List<MapObj> spawnedObjs = new LinkedList<>();
    private List<MapObj> removedObjs = new LinkedList<>();

    private List<GroundItem> groundItems = new LinkedList<>();

    private NpcCombatInfo[] combatInfo;

    private Random random = new SecureRandom();
    private boolean performance;
    private TimerRepository timers = new TimerRepository();

    public int gameCycles; // Used more accurately identify an action that happened on a cycle, regardless of PID

    private int ticksUntilSystemUpdate = -1;

    @Autowired
    public World(DefinitionRepository definitionRepository) {
        this.definitionRepository = definitionRepository;

        Config config = GameInitializer.config();
        realm(config.getString("server.realm"));
    }

    public Realm realm() {
        return realm;
    }

    public void realm(Realm realm) {
        this.realm = realm;
    }

    public void realm(String realm) {
        this.realm = Realm.valueOf(realm);
    }

    public boolean performance() {
        return performance;
    }

    public void performance(boolean b) {
        performance = b;
    }

    public InstanceAllocator allocator() {
        return instanceAllocator;
    }

    public EntityList<Player> players() {
        return players;
    }

    public EntityList<Npc> npcs() {
        return npcs;
    }

    public DefinitionRepository definitions() {
        return definitionRepository;
    }

    public void update(int ticks) {
        ticksUntilSystemUpdate = ticks;
    }

    public int ticksUntilUpdate() {
        return ticksUntilSystemUpdate;
    }

    private void syncChunk(Player p, int x, int z) { // POST UPDATE
        Area area = new Area(x, z, x + 7, z + 7);
        for (GroundItem item : groundItems) {
            if (item != null && area.contains(item.tile()) && Tile.sameH(p, item)) {
                // Is this an item for us?
                if (!p.id().equals(item.owner()) && !item.broadcasted()) {// Not ours, and not public yet. Bye.
                    continue;
                }
                p.write(new SetMapBase(p, item.tile()));
                p.write(new AddGroundItem(item));
            }
        }
        for (MapObj obj : removedObjs) {
            if (obj != null && area.contains(obj.tile()) && Tile.sameH(p, obj)) {
                p.write(new SetMapBase(p, obj.tile()));
                p.write(new RemoveObject(obj));
            }
        }
        for (MapObj obj : spawnedObjs) {
            if (obj != null && area.contains(obj.tile()) && Tile.sameH(p, obj)) {
                p.write(new SetMapBase(p, obj.tile()));
                p.write(new SpawnObject(obj));
            }
        }
    }

    private void desyncChunk(Player p, int x, int z) { // PRE UPDATE
        Area chunk = new Area(x, z, x + 7, z + 7);
        groundItems.stream().filter(g -> (g.broadcasted() || g.owner() == p.id()) && chunk.contains(g.tile()) && Tile.sameLastH(p, g)).forEach(item -> {
            p.write(new SetMapBase(p, item.tile()));
            p.write(new RemoveGroundItem(item));
        });
        for (MapObj obj : spawnedObjs) {
            if (obj != null && chunk.contains(obj.tile()) && Tile.sameLastH(p, obj)) {
                p.write(new SetMapBase(p, obj.tile()));
                p.write(new RemoveObject(obj));
            }
        }
    }

    public void syncMap(Player player, Area previousMap, boolean levelChange) {
        Area active = player.activeArea();
        for (int x = active.x1(); x < active.x2(); x += 8) {
            for (int z = active.z1(); z < active.z2(); z += 8) {
                if (previousMap == null || !previousMap.containsClosed(new Tile(x, z)) || levelChange) { // prev map is 104x104. dont re-send already visible stuff.
                    syncChunk(player, x, z);
                }
            }
        }
    }

    public int floorAt(Tile tile) {
        MapDefinition active = definitionRepository.get(MapDefinition.class, tile.region());
        return active == null ? 0 : active.getFloors()[tile.level][tile.x & 63][tile.z & 63];
    }

    public boolean isFloorFree(Tile t) {
        return (clipAt(t) & (Flags.FLOOR_BLOCKSWALK | Flags.FLOORDECO_BLOCKSWALK | Flags.OBJ)) == 0;
    }

    public int clipAt(int x, int z, int level) {
        return clipAt(new Tile(x, z, level));
    }

    public int clipAt(Tile tile) {
        MapDefinition active = definitionRepository.get(MapDefinition.class, tile.region());
        return active == null ? 0 : active.getMasks() == null ? 0 : active.getMasks()[tile.level][tile.x & 63][tile.z & 63];
    }

    public boolean isFloorFree(Tile t, int size) {
        for (int tileX = t.x; tileX < t.x + size; tileX++)
            for (int tileY = t.z; tileY < t.z + size; tileY++)
                if (!isFloorFree(t))
                    return false;
        return true;
    }

    public MapObj objByType(int type, Tile tile) {
        return objByType(type, tile.x, tile.z, tile.level);
    }

    public MapObj objByType(int type, int x, int z, int level) {
        Optional<MapObj> removed = removedObjs.stream().filter(m -> m.type() == type && m.tile().equals(x, z, level)).findAny();
        if (removed.isPresent())
            return null;

        Optional<MapObj> spawned = spawnedObjs.stream().filter(m -> m.type() == type && m.tile().equals(x, z, level)).findAny();
        if (spawned.isPresent())
            return spawned.get();
        MapDefinition mapdef = definitionRepository.get(MapDefinition.class, Tile.coordsToRegion(x, z)); // Can be null, don't want to operate on such.
        return mapdef == null ? null : mapdef.objByType(level, x & 63, z & 63, type);
    }

    public MapObj spawnObj(MapObj obj) {
        return spawnObj(obj, true);
    }

    public MapObj spawnObj(MapObj obj, boolean addClip) {
        spawnedObjs.removeIf(o -> o.type() == obj.type() && o.tile().equals(obj.tile())); // TODO remove the clip of that obj
        spawnedObjs.add(obj);

        MapDefinition def = definitionRepository.get(MapDefinition.class, obj.tile().region());
        if (addClip && def != null) {
            def.clip(this, obj);
        }
        // Remove any previously spawned obj
        removedObjs.removeIf(o -> o.type() == obj.type() && o.tile().equals(obj.tile())); // TODO remove the clip of that obj

        players.forEach(p -> {
            if (p.activeArea().contains(obj.tile()) && Tile.sameH(p, obj)) {
                p.write(new SetMapBase(p, obj.tile()));
                p.write(new SpawnObject(obj));
            }
        });
        return obj;
    }

    public void removeObj(MapObj obj) {
        removeObj(obj, true);
    }

    public void removeObj(MapObj obj, boolean removeClip) {
        if (obj == null || obj.tile() == null)
            return;
        // Remove duplicates!
        removedObjs.removeIf(o -> o == null || o.tile() == null || o.type() == obj.type() && o.tile().equals(obj.tile()));
        removedObjs.add(obj);

        MapDefinition def = definitionRepository.get(MapDefinition.class, obj.tile().region());
        if (removeClip && def != null)
            def.unclip(this, obj);
        // Remove any previously spawned obj
        spawnedObjs.removeIf(o -> o == null || o.tile() == null || o.type() == obj.type() && o.tile().equals(obj.tile()));

        players.forEach(p -> {
            if (p.activeArea().contains(obj.tile()) && Tile.sameH(p, obj)) {
                p.write(new SetMapBase(p, obj.tile()));
                p.write(new RemoveObject(obj));
            }
        });
    }
    public GroundItem spawnGroundItem(GroundItem item) {
        // Nonstackable but more than 1?
        if (item.item().amount() > 1 && !item.item().definition(this).stackable()) {
            for (int i = 0; i < Math.min(10, item.item().amount()); i++) {
                spawnGroundItem(new GroundItem(this, new Item(item.item(), 1), item.tile(), item.owner()));
            }

            return item;
        }

        /// Try to merge
        boolean updated = false;
        GroundItem newItem = item;
        if (item.item().definition(this).stackable()) {
            for (GroundItem g : groundItems) {
                if (g.tile().equals(item.tile()) && g.item().id() == item.item().id() && (Objects.equals(g.owner(), item.owner()) || (g.owner() == null && item.owner() == null))) {
                    if (!((long) g.item().amount() + (long) item.item().amount() > Integer.MAX_VALUE)) { // Amt becomes negative.
                        g.item(new Item(g.item().id(), g.item().amount() + item.item().amount()));
                        updated = true;
                        newItem = g;
                        break;
                    }
                }
            }
        }

        if (!updated) {
            groundItems.add(item);

            final GroundItem finalNewItem = newItem;
            // Broadcast it.
            players.forEach(p -> {
                if (p.activeArea().contains(finalNewItem.tile()) && Tile.sameH(p, finalNewItem)) {
                    // Is this an item for us?
                    if (finalNewItem.owner() == null || p.id().equals(finalNewItem.owner()) || finalNewItem.broadcasted()) {
                        p.write(new SetMapBase(p, finalNewItem.tile()));
                        p.write(new AddGroundItem(finalNewItem));
                    }
                }
            });
        }

        return item;
    }

    public void syncDespawnOldHeight(Player player, Area previousMap) {
        for (int x = previousMap.x1(); x < previousMap.x2(); x += 8) {
            for (int z = previousMap.z1(); z < previousMap.z2(); z += 8) {
                if (previousMap.containsClosed(new Tile(x, z))) { // prev map is 104x104. dont re-send already visible stuff.
                    desyncChunk(player, x, z);
                }
            }
        }
    }

    public boolean groundItemValid(GroundItem item) {
        return groundItems.contains(item);
    }

    public Optional<Player> playerForId(Object id) {
        return Optional.ofNullable(playerLookupMap.get(id));
    }

    public Optional<Player> playerByName(String glue) {
        return Optional.ofNullable(playerNameLookupMap.get(glue.toLowerCase()));
    }

    public boolean flagTradable(Item item) {
        return true;
    }

    public NpcCombatInfo combatInfo(int id) {
        return id > combatInfo.length - 1 ? null : combatInfo[id];
    }

    /**
     * @param i Maximum - INCLUSIVE!
     * @return Integer between 1 - MAX
     */
    public int random(int i) {
        if (i < 1) {
            return 0;
        }

        return random.nextInt(i + 1);
    }

    public double randomDouble() {
        return random.nextDouble();
    }

    public <T> T random(T[] i) {
        return i[random.nextInt(i.length)];
    }

    public int random(int[] i) {
        return i[random.nextInt(i.length)];
    }

    public int random(IntRange range) {
        return random.nextInt(range.getEndInclusive() - range.getStart() + 1) + range.getStart();
    }

    public boolean registerNpc(Npc npc) {
        int slot = npcs.add(npc);

        if (slot == -1)
            return false;

        npc.index(slot);
        npc.spawnStack = new Throwable().getStackTrace()[1].toString();
        // TODO: Figure out this
        //server.scriptRepository().triggerNpcSpawn(npc);
        //server.scriptRepository().triggerNpcCreate(npc);
        return true;
    }

    public void unregisterNpc(Npc npc) {
        npcs.remove(npc);
        npc.index(-1);
    }

    public int cycleCount() {
        return gameCycles;
    }

    public boolean registerPlayer(Player player) {
        int slot = players.add(player);


        if (slot == -1)
            return false;

        player.index(slot);
        player.pvpPid = getPvpShuffablePid().add(player);
        playerLookupMap.put(player.id(), player);
        playerNameLookupMap.put(player.username().toLowerCase(), player);
        return true;
    }

    public void unregisterPlayer(Player player) {
        players.remove(player);
        getPvpShuffablePid().remove(player);
        player.pvpPid = -1;
        playerLookupMap.remove(player.id());
        playerNameLookupMap.remove(player.username().toLowerCase());
        player.index(-1);//sets our PID as -1, representing this instance is no longer valid.

        try {
            // If status is offline, this will already have been pushed.
            if (VarbitAttributes.varbit(player, VarbitAttributes.VarbitInfo.PM_STATUS.getVarbitid()) != 2) {
                /*server.service(PmService.class, true).ifPresent(s -> {
                    s.onUserOffline(player);
                });*/
            }

            // Clan chat removal
            //ClanChat.current(player).ifPresent(cc -> cc.leave(player, true));

            //Log kills
            /*server.service(LoggingService.class, true).ifPresent(s -> {
                player.npcKills().forEach((k, v) -> {
                    s.logNpcKill(player.characterId(), k, v);
                });
            });*/
        } catch (Exception e) {
            logger.error("Error unregistering player!", e);
        }
    }

    /**
     * Unregisters all entities in the {@link #npcs} and {@link #players} collection.
     *
     * @param area the area the entities must be within bounds of.
     */
    public void unregisterAll(Area area) {
        if (area == null) return;
        List<Npc> npcsToRemove = npcs.stream().filter(Objects::nonNull).filter(area::contains).
                collect(Collectors.toList());
        npcsToRemove.forEach(npc -> {
            npc.stopActions(true);
            unregisterNpc(npc);
        });
        List<GroundItem> itemsToRemove = groundItems.stream().filter(Objects::nonNull).filter(item -> area.contains(item.tile())).
                collect(Collectors.toList());
        itemsToRemove.forEach(this::removeGroundItem);

        spawnedObjs.removeIf(obj -> obj != null && area.contains(obj.tile()));
        removedObjs.removeIf(obj -> obj != null && area.contains(obj.tile()));
    }

    public boolean removeGroundItem(GroundItem item) {
        boolean b = groundItems.remove(item);
        despawnItem(item);
        // Being picked up, not despawning by lifetime expiration
        return b;
    }

    private void despawnItem(GroundItem item) {
        players().forEach(p -> {
            if (p.seesChunk(item.tile().x, item.tile().z) && Tile.sameH(p, item)) {
                if (item.broadcasted() || p.id().equals(item.owner())) {
                    p.write(new SetMapBase(p, item.tile()));
                    p.write(new RemoveGroundItem(item));
                }
            }
        });
    }

    public EntityList<Player> getPvpShuffablePid() {
        return pvpShuffablePid;
    }

    public void setPvpShuffablePid(EntityList<Player> pvpShuffablePid) {
        this.pvpShuffablePid = pvpShuffablePid;
    }

    public void postLoad() {
        loadEquipmentInfo();
    }


    // Despawn because the time ran out, NOT because it was picked up or called to be removed some other way.
    public static void onDespawned(GroundItem item, World world) {
        int droppedId = item.item().id();
        /*for (int untradId : ItemsOnDeath.RS_UNTRADABLES_LIST) {
            if (droppedId == untradId) {
                world.playerForId(item.owner()).ifPresent(p -> {
                    p.message("<col=FF0000>Your " + item.item().name(p.world()) + " despawned and has been lost forever.");
                });
            }
        }*/
        /*if (item.item() != null && item.item().realPrice(world) >= (world.realm().isPVP() ? 5_000 : 500_000)) {
            world.server().service(LoggingService.class, true).ifPresent(s -> s.logGrounditemExpired(item, world));
        }*/
    }

    private long lastMinuteScan;

    public void cycle() {
        timers.cycle();

        //Temporary minute check until a better system is created.
        if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - lastMinuteScan) >= 60) {

            lastMinuteScan = System.currentTimeMillis();
        }

        // Fire timers
        for (Iterator<Timer> it = timers.timers().iterator(); it.hasNext(); ) {
            Timer entry = it.next();

            if (entry != null && entry.ticks() < 1) {
                TimerKey key = entry.key();
                timers.cancel(key);

                //server.scriptRepository().triggerWorldTimer(this, key);
            }
        }

        // Ground items which need synching...
        groundItems.stream().filter(g -> !g.broadcasted() && g.shouldBroadcast()).forEach(item -> {
            item.broadcasted(true);
            item.forceBroadcast(false);

            // See who's getting broadcasted!
            players().forEach(p -> {
                if (!p.bot() && !p.id().equals(item.owner()) && p.seesChunk(item.tile().x, item.tile().z) && Tile.sameH(p, item)) {
                    p.write(new SetMapBase(p, item.tile()));
                    p.write(new AddGroundItem(item));
                }
            });
        });

        // Ground items which need removal..
        for (Iterator<GroundItem> gi = groundItems.iterator(); gi.hasNext(); ) {
            GroundItem g = gi.next();
            if (g.shouldBeRemoved()) {
                this.despawnItem(g);
                onDespawned(g, this);
                gi.remove();
            }
        }

        // System update
        if (ticksUntilSystemUpdate-- == 0) {
            players.forEach(p -> {
                if (p != null) {
                    try {
                        p.logout();
                    } catch (Exception e) {
                        logger.error("Error logging player from game!", e);
                    }
                }
            });

            ticksUntilSystemUpdate = 1; // Next tick we GO ALL OVER AGAIN to make sure everyone goes out.
        }
    }

    private EquipmentInfo equipmentInfo;
    public EquipmentInfo equipmentInfo() {
        return equipmentInfo;
    }

    public void loadEquipmentInfo() {
        equipmentInfo = new EquipmentInfo(
                new File("data/list/equipment_info.json"),
                new File("data/list/renderpairs.txt"),
                new File("data/list/bonuses.json"),
                new File("data/list/weapon_types.txt"),
                new File("data/list/weapon_speeds.txt"));
    }
}
