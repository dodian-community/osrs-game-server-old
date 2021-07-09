package io.nozemi.runescape.model;

import io.nozemi.runescape.model.entity.*;
import io.nozemi.runescape.model.map.FixedTileStrategy;
import io.nozemi.runescape.model.map.WalkRouteFinder;
import io.nozemi.runescape.model.map.steroids.Direction;
import io.nozemi.runescape.model.map.steroids.PathRouteFinder;
import io.nozemi.runescape.model.map.steroids.Route;
import io.nozemi.runescape.net.message.game.command.ChangeMapMarker;
import io.nozemi.runescape.script.TimerKey;
import io.nozemi.runescape.script.TimerRepository;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class Entity {
    protected int index;
    protected World world;
    protected Tile tile;
    private Varps varps;
    protected PathQueue pathQueue;
    protected Map<AttributeKey, Object> attribs;
    protected TimerRepository timers = new TimerRepository();
    private LockType lock = LockType.NONE;
    protected SyncInfo sync;
    protected LinkedList<Hit> hits = new LinkedList<>();

    public Entity() {
        this(null, new Tile(0, 0, 0));
    }

    public Entity(World world, Tile tile) {
        this.world = world;
        this.tile = new Tile(tile);
        this.pathQueue = new PathQueue(this);

        if (isPlayer())
            attribs = new EnumMap<>(AttributeKey.class);
    }

    public int index() {
        return this.index;
    }

    public void index(int index) {
        this.index = index;
    }

    public boolean finished() {
        return index < 1;
    }

    public World world() {
        return this.world;
    }

    public Tile tile() {
        return tile;
    }

    public void tile(Tile tile) {
        this.tile = tile;
    }

    public int size() {
        return 1;
    }

    public Varps varps() {
        return varps;
    }

    public PathQueue pathQueue() {
        return pathQueue;
    }

    public Area bounds() {
        return new Area(tile.x, tile.z, tile.x, tile.z);
    }

    public Area pathBounds() {
        Tile t = pathQueue.peekLastTile();
        return new Area(t.x, t.z, t.x, t.z);
    }

    public TimerRepository timers() {
        return timers;
    }

    public Area baseBounds(Tile t) {
        return new Area(t.x, t.z, t.x, t.z);
    }

    public boolean hasAttrib(AttributeKey key) {
        return attribs != null && attribs.containsKey(key);
    }

    public <T> T attrib(AttributeKey key) {
        return attribs == null ? null : (T) attribs.get(key);
    }

    public <T> T attribOr(AttributeKey key, Object defaultValue) {
        return attribs == null ? (T) defaultValue : (T) attribs.getOrDefault(key, defaultValue);
    }

    public void clearattrib(AttributeKey key) {
        if (attribs != null)
            attribs.remove(key);
    }

    public void stopActions(boolean cancelMoving) {
        if (locked()) {
            return;
        }

        // TODO: Figure out this part
        //world.server().scriptExecutor().interruptFor(this);
        sync.faceEntity(null);
        // Graphics and animations are not reset when you walk.
        if (cancelMoving)
            pathQueue.clear();
    }

    public void putattrib(AttributeKey key, Object v) {
        if (attribs == null)
            attribs = new EnumMap<>(AttributeKey.class);
        attribs.put(key, v);
    }
    public Tile walkTo(Tile tile, PathQueue.StepType mode) {
        return walkTo(tile.x, tile.z, mode);
    }

    public static final boolean steroidsRoute = true;

    public Tile walkTo(int x, int z, PathQueue.StepType mode) {
        pathQueue.clear();
        stopActions(true);

        if (isPlayer()) {
            ((Player) this).write(new ChangeMapMarker(x, z));
        }

        if (!(boolean) attribOr(AttributeKey.IGNORE_FREEZE_MOVE, false)) {
            if (stunned()) {
                if (mode == PathQueue.StepType.REGULAR)
                    message("You're stunned!");
                return tile;
            }


            // Are we frozen? - make sure this logic is AFTER stun/stop actions -> any type of walking resets combat.
            if (frozen()) {
                //PlayerCombat.unfreeze_when_out_of_range(this);
                if (frozen()) { // Are we still frozen after the freezer check?
                    message("A magical force stops you from moving.");
                    if (isPlayer()) {
                        ((Player) this).sound(154);
                    }
                    return tile;
                }
            }
        }

        //Reset the busy state on first successful step.
        if (isPlayer() && ((Player) this).busy()) {
            ((Player) this).busy(false);
        }

        // When you click, your facing entity no longer faces the target when they move.
        clearattrib(AttributeKey.LAST_FACE_ENTITY_IDX);

        // When you move away from the current tile, your previously faced tile changes.
        // However, if you click on the same tile (don't actually move) you continue facing in that direction.
        if (tile.x != x || tile.z != z)
            clearattrib(AttributeKey.LAST_FACE_TILE);

        if (steroidsRoute) {
            LinkedList<Direction> dirs = new LinkedList<>();
            PathRouteFinder prf = new PathRouteFinder(this);
            prf.path(Route.to(new Tile(x, z, tile.level)), tile.x, tile.z, tile.level, size(), dirs);

            Tile cur = tile;
            while (!dirs.isEmpty()) {
                Direction next = dirs.poll();
                cur = cur.transform(next.x, next.y, 0);
                pathQueue.stepClipped(cur.x, cur.z, mode);

            }
            prf.free();

            if (isPlayer()) {
                ((Player) this).write(new ChangeMapMarker(cur.x, cur.z));
            }
            return cur;
        } else {
            FixedTileStrategy target = new FixedTileStrategy(x, z);
            int steps = WalkRouteFinder.findRoute(world().definitions(), tile.x, tile.z, tile.level, size(), target, true, false);
            int[] bufferX = WalkRouteFinder.getLastPathBufferX();
            int[] bufferZ = WalkRouteFinder.getLastPathBufferZ();

            for (int i = steps - 1; i >= 0; i--) {
                pathQueue.interpolateClipped(bufferX[i], bufferZ[i], mode);
            }

            if (isPlayer()) {
                ((Player) this).write(new ChangeMapMarker(bufferX[0], bufferZ[0]));
            }

            return new Tile(bufferX[0], bufferZ[0], tile.level);
        }
    }

    public boolean locked() {
        return lock != null && lock != LockType.NONE;
    }

    public boolean isDamageOkLocked() {
        return lock == LockType.FULL_WITHDMG;
    }

    public boolean isNullifyDamageLock() {
        return lock == LockType.NULLIFY_DAMAGE;
    }

    public boolean isDelayDamageLocked() {
        return lock == LockType.DELAY_DAMAGE;
    }

    public boolean frozen() {
        return timers().has(TimerKey.FROZEN);
    }

    public boolean stunned() {
        return timers().has(TimerKey.STUNNED);
    }

    public boolean dead() {
        //int queuedDamage = hits.stream().mapToInt(Hit::damage).sum();
        return hp()/* - queuedDamage*/ < 1;
    }

    public boolean alive() {
        return !dead();
    }

    public void message(String format, Object... params) {
        // Stub to ease player-specific messaging
    }

    public void heal(int amount) {
        heal(amount, 0);
    }

    public void heal(int amount, int exceed) {
        hp(hp() + amount, exceed);
    }

    public Hit hit(HitOrigin origin, int hit) {
        return hit(origin, hit, 0);
    }

    public Hit hit(HitOrigin origin, int hit, int delay) {
        return hit(origin, hit, delay, null, true);
    }

    public Hit hit(HitOrigin origin, int hit, int delay, Hit.Type hittype) {
        return hit(origin, hit, delay, hittype, true);
    }

    /**
     * Hit constructor with overhead protection prayers, PID and a CombatStyle chained on.
     * Marked as not built so hit.submit() is required to finalize.
     */
    public Hit hitpvp(HitOrigin origin, int hit, int delay, CombatStyle style) {
        Hit h = hit(origin, hit, delay, false).combatStyle(style).applyProtection().pidAdjust();
        return h;
    }

    public Hit hit(HitOrigin origin, int hit, int delay, boolean built) {
        return hit(origin, hit, delay, null, built);
    }

    public Hit hit(HitOrigin origin, int hit, int delay, Hit.Type type, boolean built) {
        // TODO: Fix this method...
        Hit h = new Hit(hit, type != null ? type : hit > 0 ? Hit.Type.REGULAR : Hit.Type.MISS, delay, built).origin(origin).target(this).applyDamageReduction();

        // Target is performing a delayed action where damage is disregarded.
        if (!isNullifyDamageLock() && h.built()) {
            // No problems with instant taking 0 delay hits, rather than queuing them. They are the first thing (juust after timers) in player processed, before scripts.
            // Since Npc process is after player process (and hence player.hitprocess()) npc 0t hits must be applied instantly because the hitprocess() won't be called again until the next tick!
            if (delay <= 0 && h.hasPidAdjusted) {
                //takeHit(h);
            } else {
                //hits.add(h);
            }
        }

        // If this was an entity that damaged us, register it.
        if (origin instanceof Entity) {
            // Put a timer on 17 ticks to avoid logging out now.
            timers.extendOrRegister(TimerKey.COMBAT_LOGOUT, 20);

            Entity fromEntity = (Entity) origin;
            if (fromEntity.isNpc()) {
                // Every single damage attack from an Npc subjects the Npc to being venomed by the victim.
                // For players, this is checked in PlayerCombat, per 'attack' rather than per 'hit' (such as claws are 4 hits.. affects chance)
                //Equipment.checkTargetVenomGear(fromEntity, this);
            }
        }
        return h;
    }

    public void cycle_hits(boolean fromPlayerOrigin) {

        // Only process hits if not locked!
        if (hp() > 0) {

            // When teleporting, all damage is forgotten
            if (lock == LockType.NULLIFY_DAMAGE) {
                hits.clear();

                // In other situations, damage is only shown when not locked.
            } else if (!locked() || lock == LockType.FULL_WITHDMG) {
                for (int i = 0; i < hits.size(); i++) {
                    Hit hit = hits.get(i);

                    // For Player#process -> iterate player hits before scripts execute.
                    if (fromPlayerOrigin && (hit.origin() == null || !(hit.origin() instanceof Player))) {
                        continue;
                    } else if (!fromPlayerOrigin && hit.origin() != null && hit.origin() instanceof Player) {
                        continue;
                    }

                    // Note: due to instant-hitting 0t hits (from Npcs or PID players) exclusions must be in takeHit() ..
                    // since this cycle method isn't used for 0t hits! They go straight to takeHit
                    if (hit.invalid()) {
                        hits.remove(i);
                        i--;
                        continue;
                    }

                    // See #blockHit for the mechanics of when block animations are performed.
                    if (hit.delay() == 1 && hit.style() == CombatStyle.RANGE && hit.block() && !hit.hasPidAdjusted) {
                        blockHit(hit);
                    }
                    if (hit.delay() <= 0) {
                        hits.remove(i);
                        i--;

                        // TODO: Figure out this
                        //takeHit(hit);
                    } else {
                        hit.delay(hit.delay() - 1);
                    }
                }
            }
        }

        if (hp() < 1 && !locked()) { // Avoid dieing while doing something critical! Such as getting speared...
            hits.clear();
            die();
        }
    }

    public void animate(int id) {
        if (isPlayer()) {
            if (((Player) this).looks().trans() == 3008)
                return;
        }

        sync.animation(id, 0);
    }

    public void animate(int id, int delay) {
        if (isPlayer()) {
            if (((Player) this).looks().trans() == 3008)
                return;
        }

        sync.animation(id, delay);
    }

    /**
     * Does the block animation.
     */
    public void blockHit(Hit hit) {
        if (hit != null && hit.style() == CombatStyle.RANGE && hit.origin() != null && hit.origin() instanceof Player) {
            // range attacks trigger block animation when the attack is done, not after! Been on 07 to prove.
        } else {
            animate(424);
        }
    }

    public Area pathbounds() {
        Tile t = pathQueue.peekLastTile();
        return new Area(t.x, t.z, t.x, t.z);
    }

    public Area basebounds(Tile t) {
        return new Area(t.x, t.z, t.x, t.z);
    }

    public void face(Entity e) {
        sync.faceEntity(e);
    }

    public SyncInfo sync() {
        return sync;
    }

    public void cycle() {
        timers.cycle();
    }

    public abstract boolean isPlayer();

    public abstract boolean isNpc();

    public abstract void hp(int hp, int exceed);

    public abstract int hp();

    public abstract int maxHp();

    protected abstract void die();

    public abstract int attackAnimation();

    public abstract void post_cycle_movement();
}
