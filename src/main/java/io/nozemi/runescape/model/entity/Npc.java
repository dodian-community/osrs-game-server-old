package io.nozemi.runescape.model.entity;

import io.nozemi.runescape.content.mechanics.NpcDeath;
import io.nozemi.runescape.events.ScriptExecutor;
import io.nozemi.runescape.events.ScriptRepository;
import io.nozemi.runescape.fs.NpcDefinition;
import io.nozemi.runescape.handlers.impl.NpcSpawnsHandler;
import io.nozemi.runescape.model.*;
import io.nozemi.runescape.model.entity.npc.NpcCombatInfo;
import io.nozemi.runescape.model.entity.npc.NpcMovementSync;
import io.nozemi.runescape.model.entity.player.NpcSyncInfo;
import io.nozemi.runescape.model.entity.player.PlayerDamageTracker;
import io.nozemi.runescape.model.map.steroids.RangeStepSupplier;
import io.nozemi.runescape.script.TimerKey;
import io.nozemi.runescape.util.SpawnDirection;
import io.nozemi.runescape.util.Tuple;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Bart on 8/10/2015.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Npc extends Entity {

	private final ScriptRepository scriptRepository;
	
	private static final Logger logger = LogManager.getLogger(Entity.class);
	
	public static boolean TARG_SWITCH_ON = true;

	public String spawnStack = "";
	
	private int id;
	private Tile spawnTile;
	private int walkRadius;
	private int spawnDirection;
	// If a player can see this npc. if not, what's the point in processing it?
	private boolean inViewport = true;
	private NpcDefinition def;
	private int hp;
	private NpcCombatInfo combatInfo;
	private boolean hidden;
	private boolean respawns = true;
	private boolean venomImmune;
	private boolean poisonImmune;
	private Area spawnArea;

	
	// A list of npc-ids such as Bosses that are immune to venom.
	public static final int[] immunes = new int[]{2668, 3127, 494, 2265, 2266, 2267, 7144, 7145, 7146, 7147, 7148, 7149, 6611, 6612, 2042, 2043, 2044, 2668};
	public static final int[] poiimmunes = new int[]{2668};

	@Autowired
	public Npc(ScriptRepository scriptRepository, World world) {
		super(world, new Tile(2606, 3102));

		this.id = 1306;

		this.scriptRepository = scriptRepository;
		this.world = world;

		this.pathQueue = new PathQueue(this);

		sync = new NpcSyncInfo(this);
		def = world.definitions().get(NpcDefinition.class, id);
		hp = combatInfo == null ? 50 : combatInfo.stats.hitpoints;

		putattrib(AttributeKey.MAX_DISTANCE_FROM_SPAWN, 12);


		for (int types : immunes) {
			if (id == types) {
				setVenomImmune(true);
			}
		}
		for (int types : poiimmunes) {
			if (id == types) {
				setPoisonImmune(true);
			}
		}
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSpawnTile(Tile spawnTile) {
		this.spawnTile = spawnTile;
		spawnArea = new Area(spawnTile, walkRadius);
	}
	
	public void inViewport(boolean b) {
		inViewport = b;
	}
	
	public boolean inViewport() {
		return inViewport;
	}
	
	public void walkRadius(int r) {
		if (walkRadius != r) {
			spawnArea = new Area(spawnTile, r);
		}
		walkRadius = r;
	}
	
	public int walkRadius() {
		return walkRadius;
	}
	
	public Npc spawnDirection(int d) {
		spawnDirection = d;
		return this;
	}

	public Npc spawnDirection(SpawnDirection direction) {
		spawnDirection(direction.getId());
		return this;
	}
	
	public int spawnDirection() {
		return spawnDirection;
	}
	
	public Tile spawnTile() {
		return spawnTile;
	}
	
	public int id() {
		return id;
	}
	
	public NpcSyncInfo sync() {
		return (NpcSyncInfo) sync;
	}
	
	@Override
	public void animate(int id) {
		// Attack sounds..
		if (attackAnimation() == id && combatInfo != null && combatInfo.sounds != null
				&& combatInfo.sounds.attack != null && combatInfo.sounds.attack.length > 0) {
			// TODO: Figure out this part
			/*Entity target = EntityCombat.INSTANCE.getTarget(this);
			if (target != null && target instanceof Player) {
				((Player) target).sound(world.random(combatInfo.sounds.attack));
			}*/
		}
		
		super.animate(id);
	}
	
	public NpcDefinition def() {
		return def;
	}
	
	public void def(NpcDefinition d) {
		this.def = d;
	}
	
	public NpcCombatInfo combatInfo() {
		return combatInfo;
	}
	
	public void combatInfo(NpcCombatInfo info) {
		combatInfo = info;
	}
	
	public void hidden(boolean b) {
		hidden = b;
	}
	
	public boolean hidden() {
		return hidden;
	}
	
	public Npc respawns(boolean b) {
		respawns = b;
		return this;
	}
	
	public boolean respawns() {
		return respawns;
	}
	
	// Keep in mem instead of create every cycle
	//static final Area[] rooms = new Area[]{Graardor.getBANDOS_AREA(), Zilyana.getENCAMPMENT(), Kril.getENCAMPMENT(), Kreearra.getENCAMPMENT()};
	
	@Override
	public void cycle() {
		
		// Then timers
		super.cycle();
		
		// Fire timers
		fire_timers();
		
		// Then scripts after we have checked damage that may kill us. Decided to actually do npc scripts in the same place as contextless scripts.. after the PacketTask Job.
		//world.server().scriptExecutor().cycle(Conditions.context(this));
		
		// After much research (06/04/2017) any damage appearing on an npc this cycle does NOT stop combat.
		// Notably, if an npc 0t kills a player, the player's combat only stops if another PID player also hits them (doesn't need to deal any damage)
		// otherwise the dead players attack will actually happen even though they're dead. I've got vid proof of this but replicating is pretty complex, decided
		// it wasn't worth investigating further.. no harm done.
		cycleHits(true);
		cycleHits(false);
		
		
		WeakReference<Entity> wrTarget = attrib(AttributeKey.TARGET);
		Entity target;
		// TODO May only do this when not in combat and not interacted with. That's going to be tricky :(.
		if (inViewport && walkRadius > 0 && !locked() && !frozen() && !timers.has(TimerKey.IN_COMBAT) && pathQueue.empty() && !(this.id() >= 3116 && this.id() <= 3128)) {
			if (!spawnArea.contains(tile) || world.random(9) == 0) {
				if (!world.performance()) { // When on critical performance mode, don't move randomly.
					if ((int) attribOr(AttributeKey.HUNTER_INFO, 0) == 0) { // More specifics checks. Don't walk when pathing towards a trap.
						//if (target != null)
						//	target.message("fucking cunt ");
						animate(-1);
						int rndX = world.random(walkRadius * 2 + 1) - walkRadius;
						int rndZ = world.random(walkRadius * 2 + 1) - walkRadius;
						walkTo(spawnTile.transform(rndX, rndZ, 0), PathQueue.StepType.REGULAR);
						
						// Make sure we don't walk too many tiles!
						if (spawnArea.contains(tile)) { // Trim outside ONLY if we're inside, otherwise walking back becomes broken
							pathQueue.trimToSize(4);
							pathQueue.removeOutside(spawnArea);
						}
					}
				}
			}
		}
		
		boolean inferno = id >= 7677 && id <= 7710;
		//boolean roomBoss = PlayerCombat.gwdRoomNpc(this) || (def != null && def.name != null && (id >= 2042 && id <= 2044 || inferno));
		
		if (wrTarget != null && (target = wrTarget.get()) != null) {
			// Target is no longer valid. Clear it.
			// Interesting fact, the NPC will path to it's set target and only reset when in distance. So a melee NPC will get within distance
			// (1 tile) then reset combat if unavailable.
			
			// Now we need to be clever and check what sort of combat style this npc uses
			int dist = 1;
			if (combatInfo() != null && combatInfo().scripts != null && combatInfo().scripts.combat != null) { // This will have to do
				// Custom script could still be melee in which case it'll use the wrong distance.
				dist = 10;
			}
			RangeStepSupplier supplier = new RangeStepSupplier(this, target, dist);
			boolean reached = supplier.reached(world, target);
			// Fuck this is not a perfect solution! canAttack always worked but other circumstances such as area/distance checks need to be included too.
			if (!(this.id() >= 3116 && this.id() <= 3128) && this.id() != 5886 && id != 239 && !inferno) {
				
				/*if (!EntityCombat.targetOk(this, target, roomBoss ? 50 : 16) || !PlayerCombat.canAttack(this, target) && (reached || (dist == 1 && this.touches(target)))) {
					//target.message(def.name+" doesnt fucking like you hey?");
					this.clearattrib(AttributeKey.TARGET); // Clear it.
					this.sync().faceEntity(null); // Reset face
				}*/
			}
			
			//If our NPC is a reanimated monster, after 60 seconds remove it!
			boolean isReanimated = attribOr(AttributeKey.IS_REANIMATED_MONSTER, false);
			if (isReanimated) {
				if (!timers.has(TimerKey.REANIMATED_MONSTER_DESPAWN)) {
					target.clearattrib(AttributeKey.HAS_REANIMATED_MONSTER);
					world().unregisterNpc(this);
				}
			}
			
			// Changing target aggression. Gwd boss room minions.
			if (hp() > 0 && Npc.TARG_SWITCH_ON && !locked() && world.cycleCount() - (int) attribOr(AttributeKey.LAST_AGRO_SWITCH, 0) >= 2) {
				// Set anyway, don't check for 2t. Less lag xd
				putattrib(AttributeKey.LAST_AGRO_SWITCH, world.cycleCount());
			}
		}
	}
	
	private void fire_timers() {
		try {
			timerloop:
			for (Iterator<io.nozemi.runescape.script.Timer> it = timers.timers().iterator(); it.hasNext(); ) {
				io.nozemi.runescape.script.Timer entry = it.next();
				if (entry != null && entry.ticks() < 1) {
					TimerKey key = entry.key();
					int oldTicks, attemptsLeft = 10; // We cap attempts to 10 to avoid bugs. Lower for npcs because support for this is brand new as of 16/8/16 - unsure of performance effects
					
					while ((oldTicks = entry.ticks()) <= 0 && attemptsLeft-- >= 0) {
						// Did it not get re-fired, or was the timer removed?
						boolean cont = false;
						if (entry == null || entry.ticks() == oldTicks || !timers.has(key)) {
							timers.cancel(key);
							cont = true;
						}

						// TODO: Figure out this
						//world.server().scriptRepository().triggerTimer(this, key); // Fire event
						
						if (cont) {
							continue timerloop; // Stop firing more events.
						}
					}
					
					if (attemptsLeft < 0) {
						timers.cancel(key);
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error processing timers for {}.", this, e);
		}
	}
	
	@Override
	public int hp() {
		return hp;
	}
	
	@Override
	public int maxHp() {
		return combatInfo != null && combatInfo.stats != null ? combatInfo.stats.hitpoints : 50;
	}
	
	@Override
	public void blockHit(Hit hit) {
		// Handle block animation
		if (!sync.hasFlag(NpcSyncInfo.Flag.ANIMATION.value)) {
			if (combatInfo != null) {
				if (combatInfo.animations != null) {
					if (combatInfo.animations.block > 0)
						animate(combatInfo.animations.block);
				}
			} else {
				super.blockHit(hit);
			}
		}
		
		// Handle block sound
		if (hit != null && hit.origin() instanceof Player && combatInfo != null && combatInfo.sounds != null
				&& combatInfo.sounds.block != null && combatInfo.sounds.block.length > 0) {
			((Player) hit.origin()).sound(world.random(combatInfo.sounds.block));
		}
	}
	
	@Override
	public void hp(int hp, int exceed) {
		this.hp = Math.min(maxHp() + exceed, hp);
	}
	
	@Override
	public int size() {
		return def.size;
	}
	
	@Override
	public boolean isPlayer() {
		return false;
	}
	
	@Override
	public boolean isNpc() {
		return true;
	}
	
	@Override
	public boolean dead() {
		return hp == 0;
	}
	
	@Override
	protected void die() {
		if(this.beanFactory != null) {
			this.beanFactory.getBean(ScriptExecutor.class).executeScript(this, NpcDeath.script);
		}
	}
	
	@Override
	public int attackAnimation() {
		if (combatInfo != null && combatInfo.animations != null) {
			return combatInfo.animations.attack;
		}
		
		return 422;
	}
	
	@Override
	public Area bounds() {
		return new Area(tile.x, tile.z, tile.x + size() - 1, tile.z + size() - 1);
	}
	
	public Area bounds(int enlargedBy) {
		return new Area(tile.x - enlargedBy, tile.z - enlargedBy, (tile.x + size() - 1) + enlargedBy, (tile.z + size() - 1) + enlargedBy);
	}
	
	@Override
	public Area pathbounds() {
		Tile t = pathQueue.peekLastTile();
		return new Area(t.x, t.z, t.x + size() - 1, t.z + size() - 1);
	}
	
	@Override
	public Area basebounds(Tile t) {
		return new Area(t.x, t.z, t.x + size() - 1, t.z + size() - 1);
	}
	
	@Override
	public void postCycleMovement() {
		NpcMovementSync.npc_post_cycle_movement(this);
	}

	@Override
	public Optional<Integer> killer() {
		// If we don't even have any killers, then return an empty optional.
		if (damagers.isEmpty())
			return Optional.empty();

		// Obtain a stream set of all information tracked.
		Set<Map.Entry<Integer, PlayerDamageTracker>> trackset = damagers.entrySet()
				.stream()
				.filter(info -> System.currentTimeMillis() - getDamagerLastTime().get(info.getKey()) <= 300000)
				.collect(Collectors.toSet());


		// Try to find the killer based on hitters
		Comparator<Map.Entry<Integer, PlayerDamageTracker>> comparator = (e1, e2) -> e2.getValue().damage().compareTo(e1.getValue().damage());

		// Identify the result
		Map.Entry<Integer, PlayerDamageTracker> result = trackset.stream().sorted(comparator).findFirst().orElse(null);

		// An anti-farming mechanic on W2 - checks if you ate or just suicided. Why suicide?
		int[] totalDamageTaken = new int[1];
		trackset.forEach(e -> totalDamageTaken[0] += e.getValue().damage());

		int account_id = result != null ? result.getKey() : -1;
		if (account_id != -1) {
			putattrib(AttributeKey.MOST_DAM_TRACKER, new Tuple<>(totalDamageTaken[0], result.getValue()));
			return Optional.ofNullable(account_id); // And find the highest damager :)
		} else {
			clearattrib(AttributeKey.MOST_DAM_TRACKER);
			return Optional.empty();
		}
	}

	public boolean isVenomImmune() {
		return venomImmune;
	}
	
	public void setVenomImmune(boolean venomImmune) {
		this.venomImmune = venomImmune;
	}
	
	public boolean isPoisonImmune() {
		return poisonImmune;
	}
	
	public void setPoisonImmune(boolean poisonImmune) {
		this.poisonImmune = poisonImmune;
	}
}
