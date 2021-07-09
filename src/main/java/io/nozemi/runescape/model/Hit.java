package io.nozemi.runescape.model;

import io.nozemi.runescape.model.entity.CombatStyle;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.Player;
import io.nozemi.runescape.util.Varbit;

/**
 * Created by Bart on 8/12/2015.
 */
public class Hit {
	
	private int damage;
	private Type type;
	private int delay; // Ticks
	private HitOrigin origin;
	private Graphic graphic = null;
	private boolean doBlock = true;
	private CombatStyle style = CombatStyle.MELEE;
	private int overkill;
	
	/**
	 * Flag to alwaysQueue hits rather than instant-process if PID applies.
	 * This is extremely important because weapons like Gmaul and Dragon thrownaxe are triggered during the Parse Packet
	 * phase - by an Action Button. This means an instant-processed hit will kill the target in a PID senario before the
	 * target's packets (such as eating food) are even processed! Non-instant special attacks are executed during the
	 * Process Scripts phase - and are therefore not applicable to this circumstance.
	 */
	private boolean queueAlways = false;
	
	public Entity getTarget() {
		return target;
	}
	
	//who the damage is applied to. since entity has Hit as a superclass theres no other way to access it, other than here.
	private Entity target = null;
	
	// Flag that this damage doesn't trigger a recoil or vengeance
	private boolean isRecoilDmg;
	
	/**
	 * This flag will allow us to append the Hit to the {@code Entity.hits} LinkedList at a later time, after we've made some additional changes to the Hit
	 * by chaining, such as hit.pid().protection(). etc. Once this is done, we can hit.pid().submit()... which finalizes the Hit, setting built as True and
	 * either processing it instantly (if it is a PID affected hit) or adding it to the traditional hits LinkedList of the victim Entity.
	 */
	private boolean built = true;
	
	public Hit(int damage, Type type, int delay, boolean built) {
		this.damage = damage;
		this.type = type;
		this.delay = delay;
		this.built = built;
	}
	
	public int damage() {
		return damage;
	}
	
	public Type type() {
		return type;
	}
	
	public Hit type(Type type) {
		this.type = type;
		return this;
	}
	
	public int delay() {
		return delay;
	}
	
	public Hit delay(int d) {
		delay = Math.max(0, d);
		return this;
	}
	
	public Hit block(boolean b) {
		doBlock = b;
		return this;
	}
	
	public Hit origin(HitOrigin origin) {
		this.origin = origin;
		return this;
	}
	
	public CombatStyle style() {
		return style;
	}
	
	public Hit combatStyle(CombatStyle style) {
		this.style = style;
		return this;
	}
	
	public boolean fromEntity() {
		return origin instanceof Entity;
	}
	
	public boolean block() {
		return doBlock;
	}
	
	public HitOrigin origin() {
		return origin;
	}
	
	public Hit graphic(int id) {
		return graphic(new Graphic(id));
	}
	
	public Hit graphic(Graphic g) {
		graphic = g;
		return this;
	}
	
	public Graphic graphic() {
		return graphic;
	}
	
	// This method is only used be Player, when hits() are processed. It's set by default during the hits cycle.
	public Hit target(Entity entity) {
		target = entity;
		return this;
	}
	
	public boolean built() {
		return built;
	}
	
	private boolean processed;
	
	public boolean beenProcessed() {
		return processed;
	}
	
	public void processed() {
		processed = true;
	}
	
	public boolean invalid() {
		
		// Locked, and the lock isn't one that allows damage through.
		if (target.locked() && !target.isDamageOkLocked() && !target.isDelayDamageLocked())
			return true;
		
		if (origin() != null && target != null && origin instanceof Entity) {
			Entity from = ((Entity) origin());
			//System.out.printf("incoming hit on %s origin=%s state=%s%n", target, origin(), from.dead());
			
			if (origin() instanceof Player) {
				// Damage that was delt by an entity far away is disgarded, except if your position change is close, like MB stairs or KBD ladder
				// Kbd damage (npc damage) doesn't do this - it carries through. you can teleport using the KBD lever and die once you reach the other side after tping.
				Tile myWildTile = target.tile().z < 6400 ? target.tile() : target.tile.transform(0, -6400, 0);
				Tile originWildTile = from.tile().z < 6400 ? from.tile() : from.tile().transform(0, -6400, 0);
				int wildDist = originWildTile.distance(myWildTile);
				
				// wildy underground doesn't line up perfectly.. see 55 stars/kbd cage coords are 53~ diff instead of just -6400
				/*if (wildDist >= (WildernessLevelIndicator.inWilderness(from.tile()) ? 64 : 18)) {
					//System.out.print("Hit nullified: dist "+wildDist); // Debug
					return true;
				}*/
				
			} else if (origin() instanceof Npc) {
				// Damage from dead Npcs is nullified. Not from players tho, a vengeance hit from a dead player can still kill you, resulting in double death.
				if (from.dead()) {
					return true;
				}
				
				//Dist check for hits from npcs if the distance exceeds over 64.
				Tile attackerTile = ((Npc) origin()).tile();
				Tile myTile = target.tile();
				
				if (myTile.distance(attackerTile) >= 64) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int overkill() {
		return overkill;
	}
	
	public void overkill(int overkill) {
		this.overkill = overkill;
	}
	
	public enum Type {
		MISS, REGULAR, POISON, DISEASE, OGRE_DISEASE, VENOM,
		
		/**
		 * Redemption prayer, hits opponents around us on death
		 */
		PRAYER
	}
	
	/**
	 * Modifies the damage taking into account protection prayers of the target.
	 */
	public Hit applyProtection() {
		if (damage > 0 && target != null) {
			if (target.isPlayer()) {
				//final int olddam = damage;
				if (style == CombatStyle.MELEE && target.varps().varbit(Varbit.PROTECT_FROM_MELEE) == 1) {
					damage *= 0.6;
				} else if (style == CombatStyle.RANGE && target.varps().varbit(Varbit.PROTECT_FROM_MISSILES) == 1) {
					damage *= 0.6;
				} else if (style == CombatStyle.MAGIC && target.varps().varbit(Varbit.PROTECT_FROM_MAGIC) == 1) {
					damage *= 0.6;
				}
				/*if (olddam != damage) {
					System.out.println("Damage updated by prot pray: "+origin.<Entity>getClass().getSimpleName()+" vs "+target.index()+" from "+olddam+" to "+damage);
				}*/
			} else if (target.isNpc()) {
				// Damage capping for NPCs only - player damage capping requires some investigating on RS because of PID.
				if (target.hp() < damage) {
					damage = target.hp();
				}
			}
		}/* else if (target == null) {
			System.out.println("no target to apply protection too!");
		}*/
		return this;
	}

	public Hit applyDamageReduction() {
		if (target != null && origin != null) {
			if (target.isPlayer() && origin instanceof Npc) {
				Player playerTarget = (Player) target;
				// TODO: Look into this TheaterOfBloodItems thing
				/*if (damage > 0 && TheaterOfBloodItems.justiciarSet(playerTarget)) {
					int abosrbed = (int) (damage * 0.15);
					damage = damage - abosrbed;
				}*/
			}
		}

		return this;
	}
	
	public Hit adjustDmg(int dmg) {
		this.damage = dmg;
		return this;
	}
	
	public Hit setIsRecoil() {
		isRecoilDmg = true;
		return this;
	}
	
	public boolean isRecoilDamage() {
		return isRecoilDmg;
	}
	
	public boolean hasPidAdjusted;
	
	public Hit pidAdjust() {
		
		if (origin != null && target != null && origin instanceof Entity) {
			
			if (check_pid_senario()) {
				hasPidAdjusted = true;
			}

			// TODO: Look into the GameCommands thing
			// New engine change. Because the logic of hitqueue()#process is if(d==0)takehit() ELSE delay-- non-pid hits become 2t. Cycle 1: add to queue. C2: -- to 0. C3: takehit.
			/*if (target.isPlayer() && !(!GameCommands.ARENA__ZERO_TICK_PID_ON && (boolean) target.attribOr(AttributeKey.IN_STAKE, false)
					&& origin != null && origin instanceof Player && ((Entity) origin).pvpPid < target.pvpPid)) {
				delay(delay - 1); // instant yo instant but not -1 delay REEEEEEE
			}*/
			
			// No magic spells (modern, ancient) hit instantly the same way a melee weapon would when you have PID.
			// As of the engine flow update (see this commit) hits tick and handle in one cycle, so a delay of 2, then pid adjusted, becomes 1, which reduces to 0 and instas applies.
			if (style != CombatStyle.MELEE && delay < 1) {
				delay = 1;
			}
			
			/*if (GameCommands.PID_DMGCAP_ON) {
				if (damage > target.hp()) {
					damage = target.hp();
				}
			}*/
		}
		return this;
	}
	
	public boolean check_pid_senario() {
		// TODO: Look into this.
		/*if (origin != null && target != null && origin instanceof Entity && target.isPlayer() && GameCommands.ZERO_TICK_PID_ON && ((Entity) origin).pvpPid < target.pvpPid) {
			if (!GameCommands.ARENA__ZERO_TICK_PID_ON && (boolean) target.attribOr(AttributeKey.IN_STAKE, false))
				return false;
			return true;
		}*/
		return false;
	}
	
	public Hit queueAlways(boolean b) {
		queueAlways = b;
		return this;
	}
	
	
	/**
	 * Once additional changes have taken place via chaining (hit.x().y().. ) after initialization in {@code Entity.hit()}
	 * this will then place the Hit into the LinkedList of {@code Entity.hits} or, if the delay is 0 (possibly because of PID)
	 * process the hit instantly rather than later in the engine cycle traditionally in {@code Entity.cycle()}
	 */
	public Hit submit() {
		// TODO: Look into this.
		built = true; // Var won't be used beyond this point in live scenarios. Maybe in debugging.
		if (target != null && !invalid()) {
			if (delay <= 0 && hasPidAdjusted && !queueAlways) {
				//target.takeHit(this);
			} else {
				//target.getHits().add(this);
			}
		}
		return this;
	}
	
	@Override
	public String toString() {
		return "Hit[damage=" + damage + ", type=" + type + ", origin=" + origin + ", style=" + style + "]";
	}
	
	public Hit addXp(CombatStyle style) {
		// TODO: Look into this.
		if (origin != null && target != null && style != null && origin instanceof Player && damage > 0) {
            //PlayerCombat.addCombatXp((Player) origin, target, damage, style);
        }
		return this;
	}
	
	public Hit addXp() {
		return addXp(style);
	}
}
