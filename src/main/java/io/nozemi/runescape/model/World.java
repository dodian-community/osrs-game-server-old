package io.nozemi.runescape.model;

import com.typesafe.config.Config;
import io.nozemi.runescape.GameInitializer;
import io.nozemi.runescape.fs.DefinitionRepository;
import io.nozemi.runescape.fs.MapDefinition;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.model.entity.npc.NpcCombatInfo;
import io.nozemi.runescape.model.item.Item;
import io.nozemi.runescape.model.map.Flags;
import io.nozemi.runescape.model.map.MapObj;
import io.nozemi.runescape.net.message.game.command.AddGroundItem;
import io.nozemi.runescape.net.message.game.command.RemoveObject;
import io.nozemi.runescape.net.message.game.command.SetMapBase;
import io.nozemi.runescape.net.message.game.command.SpawnObject;
import kotlin.ranges.IntRange;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.*;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class World {

    private Realm realm;
    private DefinitionRepository definitionRepository;

    private EntityList<Player> players = new EntityList<>(2048);
    private Map<Object, Player> playerLookupMap = new HashMap<>();
    private Map<String, Player> playerNameLookupMap = new HashMap<>();

    private EntityList<Npc> npcs = new EntityList<>(0xFFFF);

    private List<MapObj> spawnedObjs = new LinkedList<>();
    private List<MapObj> removedObjs = new LinkedList<>();

    private List<GroundItem> groundItems = new LinkedList<>();

    private NpcCombatInfo[] combatInfo;

    private Random random = new SecureRandom();
    private boolean performance;

    public int gameCycles; // Used more accurately identify an action that happened on a cycle, regardless of PID

    public World() {
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

    public EntityList<Player> players() {
        return players;
    }

    public EntityList<Npc> npcs() {
        return npcs;
    }

    public DefinitionRepository definitions() {
        return definitionRepository;
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
}
