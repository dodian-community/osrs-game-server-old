package io.nozemi.runescape.content.mechanics

import io.nozemi.runescape.content.clearContext
import io.nozemi.runescape.content.col
import io.nozemi.runescape.events.Script
import io.nozemi.runescape.model.*
import io.nozemi.runescape.model.entity.Npc
import io.nozemi.runescape.model.entity.Player
import io.nozemi.runescape.model.item.Item
import io.nozemi.runescape.util.Varbit
import io.nozemi.runescape.util.Varp
import java.util.*

/**
 * Created by Bart on 10/6/2015.
 */
object NpcDeath {

	@JvmField val script: Function1<Script, Unit> = s@ {
		val npc: Npc = it.getContext()
		it.clearContext()
		
		// Path reset instantly when hitsplat appears killing the npc.
		//npc.world().server().scriptExecutor().interruptFor(this)
		npc.pathQueue().clear()
		npc.lockNoDamage()
		
		val killer_id: Optional<Int> = npc.killer()
		val opt_player: Optional<Player> = if (killer_id.isPresent) npc.world().playerForId(killer_id.get()) else Optional.empty()
		// Player that did the most damage.
		val killer: Player? = if (killer_id.isPresent && opt_player.isPresent) opt_player.get() else null
		
		// Person that did the final hit, killing us.
		val killedBy: Entity? = npc.attribOr(AttributeKey.KILLER, null)
		
		// Try to do our death anim
		it.delay(1)
		
		// 1t later facing is reset. Stops npcs looking odd when they reset facing their target the tick they die.
		npc.sync().faceEntity(null)
		
		it.delay(1)
		
		var isBoss = false
		
		if (killer != null) {
			
			// Increment kill. Logging of kills only, does not act as a KC tracker!
			//killer.registerNpcKill(npc.id())
			
			//AchievementAction.processCategoryAchievement(killer, AchievementCategory.PVM, npc.id())
			
			//Remove the reanimated NPC ownership for player so they can spawn another! : )
			val isReanimatedMonster = npc.attribOr<Boolean>(AttributeKey.IS_REANIMATED_MONSTER, true)
			val hasReanimatedMonster = killer.attribOr<Boolean>(AttributeKey.HAS_REANIMATED_MONSTER, true)
			if (isReanimatedMonster) {
				if (hasReanimatedMonster)
					killer.clearattrib(AttributeKey.HAS_REANIMATED_MONSTER)
			}

			val killerOpp: Entity? = killer.attribOr<Entity>(AttributeKey.LAST_DAMAGER, null);
			if (killer.varps().varbit(Varbit.MULTIWAY_AREA) == 0 && killerOpp != null && killerOpp == npc) { // Last fighting with this dead npc.
				killer.clearattrib(AttributeKey.LAST_WAS_ATTACKED_TIME) // Allow instant aggro from other npcs/players.
			}
			
			var done = booleanArrayOf(false)
		}
		
		npc.animate(npc.combatInfo()?.animations?.death ?: -1)
		
		// Death sound!
		if (killer != null) {
			val sounds = npc.combatInfo()?.sounds?.death
			if (sounds != null && sounds.size > 0) {
				killer.sound(npc.world().random(sounds))
			}
		}
		
		it.delay(npc.combatInfo()?.deathlen ?: 5)
		
		if (killer != null) {
			if (npc.id() == 101 || npc.id() == 103) {
				when (npc.id()) {
					101 -> npc.sync().transmog(101)
					103 -> npc.sync().transmog(103)
				}
				
				npc.walkRadius(0)
			}

			// TODO: NPC Drops...
		}
		
		// Post-death scripts
		val postDeathScript = npc.combatInfo()?.scripts?.death_
		if (postDeathScript != null) {
			npc.executeScript(postDeathScript)
		}
		
		if (npc.id() == 319) { // Corp beast
			// Reset damage counter
			npc.damagers.forEach { pid ->
				npc.world().playerForId(pid.key).ifPresent { player -> player.varps().varp(Varp.CORP_BEAST_DAMAGE, 0) }
			}
		}
		deathReset(npc)
		if (npc.respawns()) {
			npc.teleport(npc.spawnTile())
			
			npc.hidden(true)
			
			if (npc.combatInfo()?.respawntime ?: 0 > 0) {
				it.delay(npc.combatInfo()?.respawntime!!)
			} else {
				it.delay(50)
			}

			respawn(npc)
		} else if (npc.id() != 6500) {
			npc.hidden(true)
			npc.world().unregisterNpc(npc)
		}
	}
	
	
	@JvmStatic fun notification(killer: Player, drop: Item) {
		val loot = drop.unnote(killer.world())

		// Enabled? Untradable buttons are only enabled if the threshold is enabled. Can't have one without the other.
		if (killer.varps().varbit(Varbit.ENABLE_UNTRADABLE_LOOT_NOTIFICATIONS_BUTTONS) != 0) {
			if (!loot.tradable(killer.world())) {
				if (killer.varps().varbit(Varbit.UNTRADABLE_LOOT_NOTIFICATIONS) == 1) {
					killer.message("Untradable drop: ${loot.amount} x ${loot.name(killer.world())}".col("cc0000"))
				}
			} else if (loot.realPrice(killer.world()) >= killer.varps().varbit(Varbit.LOOT_DROP_THRESHOLD_VALUE)) {
				killer.message("Valuable drop: ${loot.amount} x ${loot.name(killer.world())} (${loot.realPrice(killer.world()) * loot.amount} coins)".col("cc0000"))
			}
		}
	}
	
	/**
	 * If you're resetting an Npc as if it were by death but not, for example maybe kraken tentacles which go back down to
	 * the depths when the boss is killed.
	 */
	@JvmStatic fun deathReset(npc: Npc) {
		if (npc.id() != 6500) { // KQ first stage keeps damage onto stage 2!
			npc.clearDamagers() //Clear damagers
			npc.clearDamageTimes()
		}
		npc.clearattrib(AttributeKey.TARGET)
		npc.clearattrib(AttributeKey.LAST_ATTACKED_MAP)
		npc.putattrib(AttributeKey.VENOM_TICKS, 0)
		npc.putattrib(AttributeKey.POISON_TICKS, 0)
	}
	
	@JvmStatic fun respawn(npc: Npc) {
		if (npc.hidden()) { // not respawned yet. we do this check incase it was force-respawned by .. group spawning (gwd)
			deathReset(npc)
			npc.hidden(false)
			npc.hp(npc.maxHp(), 0) // Heal up to full hp
			npc.combatInfo()?.stats = npc.combatInfo()?.originalStats?.clone() // Replenish all stats on this NPC.
			npc.animate(-1) // Reset death animation
			npc.unlock()
		}
	}
}