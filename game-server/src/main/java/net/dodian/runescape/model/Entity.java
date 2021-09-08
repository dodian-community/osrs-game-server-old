package net.dodian.runescape.model;

import net.dodian.runescape.content.combat.CombatSounds;
import net.dodian.runescape.content.combat.PlayerCombat;
import net.dodian.runescape.content.interfaces.Equipment;
import net.dodian.runescape.content.mechanics.Transmogrify;
import net.dodian.runescape.content.mechanics.VarbitAttributes;
import net.dodian.runescape.events.Script;
import net.dodian.runescape.events.ScriptRepository;
import net.dodian.runescape.model.entity.*;
import net.dodian.runescape.model.entity.player.*;
import net.dodian.runescape.model.item.Item;
import net.dodian.runescape.model.item.ItemAttrib;
import net.dodian.runescape.model.item.ItemContainer;
import net.dodian.runescape.model.map.*;
import net.dodian.runescape.model.map.steroids.Direction;
import net.dodian.runescape.model.map.steroids.PathRouteFinder;
import net.dodian.runescape.model.map.steroids.Route;
import net.dodian.runescape.net.message.game.command.ChangeMapMarker;
import net.dodian.runescape.script.TimerKey;
import net.dodian.runescape.script.TimerRepository;
import net.dodian.runescape.tasksystem.*;
import net.dodian.runescape.content.teleports.MyTeleports;
import net.dodian.runescape.util.Varbit;
import net.dodian.runescape.util.Varp;
import kotlin.jvm.functions.Function1;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import java.lang.ref.WeakReference;
import java.util.*;

@Component
public abstract class Entity implements HitOrigin, BeanFactoryAware {

    private static final Logger logger = LogManager.getLogger(Entity.class);

    protected int index;
    protected World world;
    protected Tile tile;
    protected Varps varps;
    protected PathQueue pathQueue;
    protected Map<AttributeKey, Object> attribs;
    protected TimerRepository timers = new TimerRepository();
    private LockType lock = LockType.NONE;
    protected SyncInfo sync;
    protected boolean noRetaliation = false;
    protected LinkedList<Hit> hits = new LinkedList<>();
    protected Map<Integer, PlayerDamageTracker> damagers = new HashMap<>();

    private Skills skills;

    protected Map<Integer, Long> damagerLastTime = new HashMap<>();

    protected BeanFactory beanFactory;

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

    public Map<Integer, Long> getDamagerLastTime() {
        return damagerLastTime;
    }

    public Map<Integer, PlayerDamageTracker> getDamagers() {
        return damagers;
    }
    public void clearDamagers() {
        damagers.clear();
    }

    public void clearDamageTimes() {
        damagerLastTime.clear();
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

    public void world(World world) {
        this.world = world;
    }

    public Tile tile() {
        return tile;
    }

    public void tile(Tile tile) {
        this.tile = tile;
    }

    public void teleport(Tile tile) {
        teleport(tile.x, tile.z, tile.level);
    }

    public void teleport(int x, int z) {
        teleport(x, z, 0);
    }

    public void teleport(int x, int z, int level) {
        if (this.isPlayer() && Transmogrify.isTransmogrified((Player) this)) {
            Transmogrify.hardReset((Player) this);
        }

        tile = new Tile(x, z, level);
        sync.teleported(true);
        pathQueue.clear();
    }

    public void teleport(Tile tile, MyTeleports teleports) {
        this.stopActions(true);

        InterruptibleChain chain = InterruptibleChain.bound(this, "PLAYER_TELEPORTING_EFFECTS_CHAIN");

        Arrays.stream(teleports.chain()).forEach(effect ->
                chain.then(effect.delay, () -> {
                    if (effect.animation != null) {
                        this.animate(effect.animation);
                    }

                    if (effect.graphics != null) {
                        this.graphic(effect.graphics);
                    }

                    if (isPlayer() && effect.sound != null) {
                        ((Player) this).sound(effect.sound);
                    }
                }));

        chain.onComplete(() -> {
            this.teleport(tile);
        }).onCancel(() -> {
            this.graphic(-1);
            this.animate(-1);
            if (isPlayer()) {
                ((Player) this).sound(-1);
            }
        }).submit(TaskManager.playerEvents());
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

    public Map<AttributeKey, Object> attribs() {
        return attribs;
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
        if (cancelMoving) {
            pathQueue.clear();
        }

        if (TaskManager.playerEvents().containsKey(this.index)) {
            TaskManager.playerEvents().get(this.index).forEach(Interruptible::cancel);
        }
    }

    public void putattrib(AttributeKey key, Object v) {
        if (attribs == null)
            attribs = new EnumMap<>(AttributeKey.class);
        attribs.put(key, v);
    }

    public void faceTile(Tile tile) {
        sync.facetile(new Tile(tile.x, tile.z));
    }

    public void faceTile(double x, double z) {
        sync.facetile(new Tile((int) x, (int) z));
    }

    /**
     * Face coordinates, but take into consideration the center of a large than 1x1 object
     */
    public void faceObj(MapObj obj) {
        int x = obj.tile().x;
        int z = obj.tile().z;

        // Do some trickery to face properly
        if (tile.x == x && tile.z == z && (obj.type() == 0 || obj.type() == 5)) {
            if (obj.rot() == 0) {
                x--;
            } else if (obj.rot() == 1) {
                z++;
            } else if (obj.rot() == 2) {
                x++;
            } else if (obj.rot() == 3) {
                z--;
            }
        }

        int sx = obj.definition(world).sizeX;
        int sz = obj.definition(world).sizeY;

        //sync.facetile(new Tile((int) (x * 2) + sx, (int) (z * 2) + sz));
        sync.facetile(new Tile(x + (sx / 2), z + (sz / 2)));
    }

    public Tile walkTo(Tile tile, PathQueue.StepType mode) {
        return walkTo(tile.x, tile.z, mode, true);
    }

    public Tile walkTo(Tile tile, PathQueue.StepType mode, boolean stopActions) {
        return walkTo(tile.x, tile.z, mode, stopActions);
    }

    public boolean touches(Entity e) {
        return touches(e, tile);
    }

    public boolean touches(Entity targ, Tile from) {
        EntityStrategy strat = new EntityStrategy(targ, 0, true);
        int[][] clipAround = world.clipSquare(targ.tile().transform(-5, -5, 0), 11); // TODO better algo for determining the size we need..
        try {
            return strat.canExit(from.x, from.z, size(), clipAround, targ.tile.x - 5, targ.tile.z - 5);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("AI OOB thrown using args {}, {}, {}, {}", targ, targ.tile, from, e.getMessage());
            logger.error(e);
            return false;
        }
    }

    public static final boolean steroidsRoute = true;

    public boolean walkTo(MapObj obj, PathQueue.StepType mode) {
        pathQueue.clear();

        if (stunned()) {
            if (mode == PathQueue.StepType.REGULAR)
                message("You're stunned!");
            return false;
        }

        if (steroidsRoute) {
            LinkedList<Direction> dirs = new LinkedList<>();
            PathRouteFinder finder = new PathRouteFinder(this);
            Route route = Route.to(world, obj);
            finder.path(route, tile.x, tile.z, tile.level, size(), dirs);

            Tile cur = tile;
            while (!dirs.isEmpty()) {
                Direction next = dirs.poll();
                cur = cur.transform(next.x, next.y, 0);
                pathQueue.stepClipped(cur.x, cur.z, mode);

            }

            finder.free();
            return !route.alternative;//temp
        } else {
            ObjectStrategy target = new ObjectStrategy(world, obj);
            int steps = WalkRouteFinder.findRoute(world().definitions(), tile.x, tile.z, tile.level, 1, target, true, false);
            int[] bufferX = WalkRouteFinder.getLastPathBufferX();
            int[] bufferZ = WalkRouteFinder.getLastPathBufferZ();

            for (int i = steps - 1; i >= 0; i--) {
                pathQueue.interpolateClipped(bufferX[i], bufferZ[i], mode);
            }

            return !WalkRouteFinder.isAlternative;
        }
    }

    public Tile walkTo(int x, int z, PathQueue.StepType mode, boolean stopActions) {
        pathQueue.clear();

        if (stopActions) {
            stopActions(true);
        }

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
            logger.info("Is not steroids route...");
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

    public boolean walkTo(Entity entity, PathQueue.StepType mode) {
        pathQueue.clear();

        if (stunned()) {
            if (mode == PathQueue.StepType.REGULAR)
                message("You're stunned!");
            return false;
        }

        if (steroidsRoute) {
            LinkedList<Direction> dirs = new LinkedList<>();
            PathRouteFinder finder = new PathRouteFinder(this);
            Route route = Route.to(entity);
            finder.path(route, tile.x, tile.z, tile.level, size(), dirs);

            Tile cur = tile;
            while (!dirs.isEmpty()) {
                Direction next = dirs.poll();
                cur = cur.transform(next.x, next.y, 0);
                pathQueue.stepClipped(cur.x, cur.z, mode);

            }

            finder.free();
            return !route.alternative;//temp
        } else {
            EntityStrategy target = new EntityStrategy(entity);
            int steps = WalkRouteFinder.findRoute(world().definitions(), tile.x, tile.z, tile.level, size(), target, true, false);
            int[] bufferX = WalkRouteFinder.getLastPathBufferX();
            int[] bufferZ = WalkRouteFinder.getLastPathBufferZ();

            for (int i = steps - 1; i >= 0; i--) {
                pathQueue.interpolateClipped(bufferX[i], bufferZ[i], mode);
            }

            return !WalkRouteFinder.isAlternative;
        }
    }

    public void walkToThen(Tile destination, ExecuteInterface then) {
        walkToThen(null, destination, then);
    }

    public void walkToThen(Object interactAble, Tile destination, ExecuteInterface then) {
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

    public Hit hit(HitOrigin origin, int hit, int delay, Hit.Type hitType) {
        return hit(origin, hit, delay, hitType, true);
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
                takeHit(h);
            } else {
                hits.add(h);
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
                Equipment.checkTargetVenomGear(fromEntity, this);
            }
        }
        return h;
    }

    public void cycleHits(boolean fromPlayerOrigin) {

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

                        takeHit(hit);
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


    public void takeHit(Hit hit) {
        if (hit.beenProcessed())
            return;
        hit.processed();

        if (hit.invalid())
            return;

        putattrib(AttributeKey.LAST_HIT, hit);

        int damage = hit.damage();
        // Protection prayers :)
        if (isPlayer() && hit.fromEntity()) {
            Player us = (Player) this;

            // NOTE: Protection prayers are applied in playercombat when you swing your weapon, not when the hit is processed.
            // We haven't yet done this for Npcs...
            // Reason: changing it will affect jad timers and that's pretty complex.
            if (hit.origin() instanceof Npc) {
                if (us.varps().varbit(Varbit.PROTECT_FROM_MELEE) == 1 && hit.style() == CombatStyle.MELEE) {
                    damage = 0;
                } else if (us.varps().varbit(Varbit.PROTECT_FROM_MAGIC) == 1 && hit.style() == CombatStyle.MAGIC) {
                    damage = 0;
                } else if (us.varps().varbit(Varbit.PROTECT_FROM_MISSILES) == 1 && hit.style() == CombatStyle.RANGE) {
                    damage = 0;
                }
            }
        }

        boolean meIsPlayer = isPlayer() && hit.origin() instanceof Entity;
        if (damage > 0 && meIsPlayer) {
            Player me = (Player) this;

            //Damage value at this point is final, as modified by shield effects, protection prayers, etc.
            if (!hit.isRecoilDamage()) {

                //If we have used the SOTD special attack, reduce incoming melee damage by 50%.
                if (timers().has(TimerKey.SOTD_DAMAGE_REDUCTION) && equipment().hasAny(11791, 12904, 12902) && hit.style() == CombatStyle.MELEE) {
                    damage *= 0.5;
                }

                int hpdmg = Math.min(damage, hp());

                Entity src = ((Entity) hit.origin());

                // Veng
                if (hit.origin() != this && (Boolean) attribOr(AttributeKey.VENGEANCE_ACTIVE, false)) {
                    clearattrib(AttributeKey.VENGEANCE_ACTIVE);
                    //PID on rs may mean its instant. by default, 1 tick tho
                    src.hit(this, (int) (hpdmg * 0.75), hit.hasPidAdjusted ? 1 : 0).block(false).setIsRecoil();
                    sync.shout("Taste vengeance!");
                    if (src.isNpc()) {
                        if (((Npc) src).id() == 319) {
                            varps().varp(Varp.CORP_BEAST_DAMAGE, varps().varp(Varp.CORP_BEAST_DAMAGE) + (int) (hpdmg * .75));
                        }
                    }
                }

                /*if (Equipment.hasAmmyOfDamned(me) && CombatFormula.fullDharok(me) && world.rollDie(100, 25)) {
                    src.hit(this, (int) (hpdmg * 0.15), hit.hasPidAdjusted ? 1 : 0).block(false).setIsRecoil();
                }*/

                // Ring of recoil damage
                if (hit.origin() instanceof Entity && hit.origin() != this) {
                    if (me.equipment().hasAt(EquipSlot.RING, 2550)) {
                        int charges = (int) attribOr(AttributeKey.RING_OF_RECOIL_CHARGES, 40) - 1;

                        if (charges == 0) {
                            putattrib(AttributeKey.RING_OF_RECOIL_CHARGES, 40);
                            equipment().remove(new Item(2550), true);
                            message("<col=804080>Your ring of recoil has shattered!");
                        } else {
                            putattrib(AttributeKey.RING_OF_RECOIL_CHARGES, charges);
                            ((Entity) hit.origin()).hit(this, damage > 10 ? (damage / 10) : 1, 1).block(false).combatStyle(CombatStyle.MELEE).setIsRecoil(); // Typeless damage
                            if (src.isNpc()) {
                                if (((Npc) src).id() == 319) {
                                    varps().varp(Varp.CORP_BEAST_DAMAGE, varps().varp(Varp.CORP_BEAST_DAMAGE) + (damage > 10 ? (damage / 10) : 1));
                                }
                            }
                        }
                    }
                    boolean suffering_r = me.equipment().hasAt(EquipSlot.RING, 20655);
                    if (!VarbitAttributes.varbiton(this, Varbit.RING_OF_SUFFERING_RECOIL_DISABLED) && (suffering_r || me.equipment().hasAt(EquipSlot.RING, 20657))) {
                        int charges = me.equipment().get(EquipSlot.RING).propertyOr(ItemAttrib.CHARGES, 0);
                        if (charges > 0) {
                            me.equipment().get(EquipSlot.RING).property(ItemAttrib.CHARGES, charges - 1);
                            ((Entity) hit.origin()).hit(this, damage > 10 ? (damage / 10) : 1, 1).block(false).combatStyle(CombatStyle.MELEE).setIsRecoil(); // Typeless damage
                            if (src.isNpc()) {
                                if (((Npc) src).id() == 319) {
                                    varps().varp(Varp.CORP_BEAST_DAMAGE, varps().varp(Varp.CORP_BEAST_DAMAGE) + (damage > 10 ? (damage / 10) : 1));
                                }
                            }
                            if (charges - 1 == 0) {
                                me.message("Your Ring of Suffering has run out of charges.");
                                me.equipment().remove(me.equipment().get(EquipSlot.RING), false, EquipSlot.RING);
                                me.equipment().add(new Item(suffering_r ? 19550 : 19710), false, EquipSlot.RING);
                            }
                        }
                    }
                }
            }
        }

        hit.overkill(damage);
        if (damage > hp()) {
            damage = hp();
        }

        // Make the zero always the block hit
        if (damage < 1) {
            damage = 0;
            hit.type(Hit.Type.MISS);
        }

        final int dmg = damage;
        takeHitSound(hit.adjustDmg(dmg));

        if (hit.origin() != null && hit.origin() instanceof Player) {
            Player attacker = (Player) hit.origin();

            if (hit.getTarget() != null) {

                // Don't record damage delt to ourself if we're a player.
                if (isNpc() || (isPlayer() && ((Player) this).id() != attacker.id())) {

                    if (attacker.id() instanceof Integer) { // String on login

                        // Try to find an existing damage entry..
                        boolean[] matched = {false}; // Required as an Array due to use in Lambda function
                        damagers.forEach((key, value) -> {
                            if (key == (int) attacker.id()) {
                                value.update(attacker, dmg);
                                matched[0] = true;
                                damagerLastTime.put((int) attacker.id(), System.currentTimeMillis());
                                //message("updated tracked dmg total on me id-"+this.index()+" by "+attacker.name()+"  total dmg="+e.getValue().damage()+" (+"+hit+")"); // Debug
                            }
                        });

                        // Did we not update an existing one? Insert new.
                        if (!matched[0]) {
                            logger.info("Updating damagers...");
                            damagers.put((int) attacker.id(), new PlayerDamageTracker().update(attacker, dmg));
                            //message("registered new tracking dmg on "+this.index()+" by "+attacker.name()+"  dmg="+hit); // Debug
                            damagerLastTime.put((int) attacker.id(), System.currentTimeMillis());
                        }
                    }
                }
            }
        }

        //Now apply damage and set in GPI
        if (!VarbitAttributes.varbiton(this, Varbit.INFHP)) {//infhp disabled.
            if (isNpc()) {
                Npc npc = (Npc) this;
                if (npc.id() != 2668) {
                    hp(hp() - damage, 0);
                    if (hp() < 1) {
                        if (hit.origin() instanceof Entity) {
                            putattrib(AttributeKey.KILLER, hit.origin());
                        }
                    }
                }
            } else {
                hp(hp() - damage, 0);
                if (hp() < 1) {
                    if (hit.origin() instanceof Entity) {
                        putattrib(AttributeKey.KILLER, hit.origin());
                    }
                }
            }
        }

        boolean magic_splash = damage == 0
                && hit.type() != null && hit.type() == Hit.Type.MISS
                && hit.style() != null && hit.style() == CombatStyle.MAGIC
                && hit.graphic() != null && hit.graphic().id() == 85;

        if (!magic_splash) { // splashing doesn't show the 0
            if (hit.type() == Hit.Type.PRAYER)
                hit.type(Hit.Type.REGULAR);
            sync.hit(hit);
        }

        if (isNpc()) {
            Npc npc = (Npc) this;
            if (npc.combatInfo() != null && npc.combatInfo().scripts != null && npc.combatInfo().scripts.hit_ != null) {
                putattrib(AttributeKey.LAST_HIT_DMG, hit);
                beanFactory.getBean(ScriptRepository.class).getExecutor().executeScript(this, npc.combatInfo().scripts.hit_);
            }
        }

        // Auto-retaliate
        if (hit.fromEntity() && hit.style() != CombatStyle.GENERIC && hit.origin() instanceof Entity) {
            if (!timers.has(TimerKey.IN_COMBAT)) {
                if (isPlayer()) {
                    Player player = ((Player) this);
                    if (player.varps().varp(Varp.AUTO_RETALIATE_DISABLED) == 0) {
                        // Players only auto retaliate the attacker when out of combat.
                        boolean mayAttack = true;

                        // Check if we're in combat right now with someone who's alive
                        if (player.timers().has(TimerKey.IN_COMBAT)) {
                            mayAttack = false;
                        }

                        // Check attackability
                        if (hit.origin() instanceof Entity && !PlayerCombat.canAttack(this, (Entity) hit.origin())) {
                            mayAttack = false;
                        }

                        if (mayAttack) {
                            autoRetaliate((Entity) hit.origin());
                        }
                    }
                } else {
                    Npc npc = (Npc) this;

                    // 2668 = Combat dummy
                    if (npc.id() != 2668)
                        autoRetaliate((Entity) hit.origin());
                }

                timers.register(TimerKey.IN_COMBAT, 5);
            } else if (isNpc()) {
                // Npcs do switch aggro context if they get attacked.
                autoRetaliate((Entity) hit.origin());
            }
        }

        if (hit.graphic() != null)
            graphic(hit.graphic().id(), hit.graphic().height(), hit.graphic().delay());

        // See #blockHit for circumstance for Block animation triggers.
        if (hit.block() && (hit.style() != CombatStyle.MAGIC || !isPlayer())) {
            blockHit(hit);
        }
    }

    public void autoRetaliate (Entity attacker){
        if (dead() || hp() < 1 || noRetaliation || locked() || attacker == this)
            return;

        // Override logic
        putattrib(AttributeKey.TARGET, new WeakReference<>(attacker));
        // As soon as the hit on us appears, we'll turn around and face the attacker.
        face(attacker);
        // TODO: Look into this...
        //world.server().scriptExecutor().executeScript(this, EntityCombat.autoretaliate);
    }

    public LinkedList<Hit> getHits() {
        return hits;
    }

    /**
     * Sounds that happen when the hit appears.
     * Two distinct: a sound if damage>0 .. and a shield block sound.
     * Note: these sounds are special because they are _personal_ 'effect' sounds - not AREA sounds broadcast to closeby players.
     */
    public void takeHitSound(Hit hit) {
        if (hit == null)
            return;
        // block sounds depends entirely on entity type

        if (hit.origin() != null && hit.origin() instanceof Player) {
            if (hit.damage() > 0)
                ((Player) hit.origin()).sound(CombatSounds.damageSound(world), 20, 0);
        }
    }

    public void animate(int id) {
        sync.animation(id, 0);
    }

    public void animate(int[] values) {
        if (values.length == 1) {
            animate(values[0]);
        } else if (values.length >= 2) {
            animate(values[1]);
        }
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

    public abstract void postCycleMovement();

    public int pvpPid = -1;

    private ItemContainer equipment;

    public ItemContainer equipment() {
        return equipment;
    }

    public void graphic(int id) {
        sync.graphic(id, 0, 0);
    }

    public void graphic(int[] values) {
        if (values.length == 1) {
            this.graphic(values[0]);
        } else if (values.length == 2) {
            this.graphic(values[0], values[1], 0);
        } else if (values.length >= 3) {
            this.graphic(values[0], values[1], values[2]);
        }
    }

    public void graphic(int id, int height, int delay) {
        sync.graphic(id, height, delay);
    }

    public void unlock() {
        lock = LockType.NONE;
    }

    public void lockNoDamage() {
        lock = LockType.NULLIFY_DAMAGE;
    }

    public void executeScript(Function1<Script, Object> s) {
        //world.server().scriptExecutor().executeScript(this, s); // context set to the entity
    }

    public void venom(Entity source) {
        if (source == null)
            return;
        if (isPlayer()) {
            Player p = (Player) this;
            if (Equipment.venomHelm(p)) { // Serp helm stops venom.
                return;
            }
        } else if (isNpc()) {
            Npc me = (Npc) this;
            if (me.isVenomImmune()) {
                return;
            }
        }
        if ((int) attribOr(AttributeKey.VENOM_TICKS, 0) == 0) {
            if (isPlayer()) {
                Player me = (Player) this;
                me.varps().varp(Varp.HP_ORB_COLOR, 1_000_000); // Now venomed
                message("<col=145A32>You've been infected with venom!");
            }
            putattrib(AttributeKey.VENOM_TICKS, 8); // default start. 8 cycles
            timers().register(TimerKey.VENOM, 34);
        }
    }

    public Tile stepTowards(Entity e, int maxSteps) {
        return stepTowards(e, e.tile, maxSteps);
    }

    public Tile stepTowards(Entity e, Tile t, int maxSteps) {
        if (e == null)
            return tile;

        EntityStrategy target = new EntityStrategy(e, 0, t);

        int steps = WalkRouteFinder.findRoute(world().definitions(), tile.x, tile.z, tile.level, size(), target, true, false);
        int[] bufferX = WalkRouteFinder.getLastPathBufferX();
        int[] bufferZ = WalkRouteFinder.getLastPathBufferZ();

        Tile last = tile;
        for (int i = steps - 1; i >= 0; i--) {
            maxSteps -= pathQueue.interpolate(bufferX[i], bufferZ[i], PathQueue.StepType.REGULAR, maxSteps, true);

            last = new Tile(bufferX[i], bufferZ[i], tile.level);
            if (maxSteps <= 0)
                break;
        }

        return last;
    }

    public Tile stepTowards(Tile t, int maxSteps) {
        EntityStrategy target = new EntityStrategy(t);

        int steps = WalkRouteFinder.findRoute(world().definitions(), tile.x, tile.z, tile.level, size(), target, true, false);
        int[] bufferX = WalkRouteFinder.getLastPathBufferX();
        int[] bufferZ = WalkRouteFinder.getLastPathBufferZ();

        Tile last = tile;
        for (int i = steps - 1; i >= 0; i--) {
            maxSteps -= pathQueue.interpolate(bufferX[i], bufferZ[i], PathQueue.StepType.REGULAR, maxSteps, true);

            last = new Tile(bufferX[i], bufferZ[i], tile.level);
            if (maxSteps <= 0)
                break;
        }

        return last;
    }

    public Skills skills() {
        return skills;
    }

    public abstract Optional<Integer> killer();

    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
