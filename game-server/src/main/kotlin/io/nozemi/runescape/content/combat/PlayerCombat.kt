package io.nozemi.runescape.content.combat

import io.nozemi.runescape.content.get
import io.nozemi.runescape.content.mechanics.MultiwayCombat
import io.nozemi.runescape.content.set
import io.nozemi.runescape.events.ScriptMain
import io.nozemi.runescape.events.ScriptRepository
import io.nozemi.runescape.model.AttributeKey
import io.nozemi.runescape.model.Entity
import io.nozemi.runescape.model.entity.CombatStyle
import io.nozemi.runescape.model.entity.Npc
import io.nozemi.runescape.model.entity.Player
import io.nozemi.runescape.model.entity.player.Privilege
import io.nozemi.runescape.model.entity.player.Skills
import io.nozemi.runescape.model.instance.InstancedMapIdentifier
import io.nozemi.runescape.script.TimerKey
import io.nozemi.runescape.util.AttackMode
import io.nozemi.runescape.util.EquipmentInfo
import io.nozemi.runescape.util.Varbit
import io.nozemi.runescape.util.Varp

object PlayerCombat {

    @JvmStatic
    @ScriptMain
    fun register(repo: ScriptRepository) {
        //Autocasting
        repo.onButton(593, 3) { it.player().varps()[43] = 0; resetCb(it.player()) }
        repo.onButton(593, 7) { it.player().varps()[43] = 1; resetCb(it.player()) }
        repo.onButton(593, 11) { it.player().varps()[43] = 2; resetCb(it.player()) }
        repo.onButton(593, 15) { it.player().varps()[43] = 3; resetCb(it.player()) }

        // Autoretaliate
        repo.onButton(593, 27) {
            it.player().varps()[Varp.AUTO_RETALIATE_DISABLED] =
                if (it.player().varps()[Varp.AUTO_RETALIATE_DISABLED] == 1) 0 else 1
        }

        repo.onTimer(TimerKey.COMBAT_IMMUNITY) {
            it.message("Your combat immunity has worn off.")
        }

        repo.onTimer(TimerKey.TELEBLOCK) {
            it.player().timers().cancel(TimerKey.BLOCK_SPEC_AND_TELE)
            // No message for fading; only when leaving the wilderness do you get the fade message.
        }
    }

    private fun resetCb(player: Player) { // Just the spell
        //SpellSelect.reset(player, true, true)
    }

    @JvmStatic
    fun canAttack(entity: Entity, other: Entity): Boolean {
        return canAttack(entity, other, true)
    }

    // Does not stop combat, only sends a message if an entity is unable to attack another entity. Reasons include slayer level, invisibility, and single-combat restrictions.
    @JvmStatic
    fun canAttack(entity: Entity, other: Entity, message: Boolean = true): Boolean {
        if (entity.index() == -1 || other.index() == -1) { // Target logged off.
            return false
        }

        if (entity.stunned()) {
            // Calling stun interrupts combat, but this will force stop it too.
            return false
        }

        if (other.tile().level != entity.tile().level) {
            return false
        }

        if (other.isNpc()) {
            val npc = other as Npc
            if (npc.hidden() || (entity.isPlayer && npc.id() == 7707) || npc.locked() && npc.id() != 5886 && npc.id() != 2668)
                return false
            if (npc.id() == 2668) // you can always attack combat dummies
                return true
        }

        var wep = -1
        if (entity.isPlayer) {
            wep = (entity as Player).equipment()[3]?.id ?: -1
        }
        if (other.isPlayer) {
            // TODO: Implement player
        } else if (other.isNpc) {
            if ((other as Npc).combatInfo() == null) {
                if (message)
                    entity.message("Without combat attributes this monster is unattackable.")

                return false
            } else if (other.combatInfo().unAttackAble) {
                if (message)
                    entity.message("You cannot attack this monster.")

                return false
            }
        }

        val targetLastVictim = other.attribOr<Entity>(AttributeKey.LAST_TARGET, null)

        // The last time our target was attacked
        val targetLastAttackedTime = System.currentTimeMillis() - other.attribOr<Long>(AttributeKey.LAST_WAS_ATTACKED_TIME, 0.toLong())

        // Last person to hit our target.
        val targetLastAttacker = other.attrib<Entity>(AttributeKey.LAST_DAMAGER)

        // Last time we were attacked
        val myLastAttackedTime = System.currentTimeMillis() - entity.attribOr<Long>(AttributeKey.LAST_WAS_ATTACKED_TIME, 0.toLong())

        // Last person to hit us.
        val myLastAttacker = entity.attrib<Entity>(AttributeKey.LAST_DAMAGER)

        // Last time our target attacked something.
        val targetLastAttackTime = System.currentTimeMillis() - other.attribOr<Long>(AttributeKey.LAST_ATTACK_TIME, 0.toLong())

        var edge_or_canifis_pvp: Boolean = false
        var instance_key: InstancedMapIdentifier? = null
        entity.world().allocator().active(entity.tile()).ifPresent { map -> map.identifier.ifPresent { id -> instance_key = id } }

        if (instance_key == InstancedMapIdentifier.CANIFIS_PVP || instance_key == InstancedMapIdentifier.EDGE_PVP)
            edge_or_canifis_pvp = true

        if(entity.isPlayer && other.isPlayer) {
            // TODO: Player vs Player
        }

        //If the NPC isn't visible we should no longer be attacking them.
        if (entity.isNpc) {
            val npc = entity as Npc
            if (npc.hidden()) {
                return false
            }
            if (other.isPlayer) {
                if ((other as Player).interfaces().activeMain() == 155) {
                    // When viewing the barrows loot interface, NPCs are not aggressive. Interesting eh.
                    return false
                }
            }
        }

        if (other.isPlayer && entity.isPlayer) {
            // TODO: Player vs Player
        }

        if (other.timers().has(TimerKey.COMBAT_IMMUNITY)) {
            if (entity.isPlayer) {
                //if (!(entity as Player).privilege().eligibleTo(Privilege.ADMIN)) { // Used as a mechanic in GE PVP instance
                if (message)
                    entity.message("That player is temporarily <col=FF0000>immune</col> to attacks.")
                return false
                //}
            } else {
                return false
            }
        }

        if (entity.timers().has(TimerKey.COMBAT_IMMUNITY) && entity.isPlayer && !(entity as Player).privilege().eligibleTo(
                Privilege.ADMIN)) {
            if (message)
                entity.message("You're temporarily <col=FF0000>immune</col> to combat - during this period you can't fight. To cancel this, type ::modpk")
            return false
        }

        if (other.isPlayer) {
            if (other.varps().varbit(Varbit.MULTIWAY_AREA) == 1 && MultiwayCombat.includes(other)) {
                if (!(other.tile().region() == 12190 && other.tile().level == 3)) // Height 3 in wildy gwd is single-way combat.
                    return true
            }
        } else if (MultiwayCombat.includes(other)) {
            return true
        }

        return true
    }

    @JvmStatic fun addCombatXp(player: Player, target: Entity, hit: Int, style: CombatStyle) {
        addCombatXp(player, target, hit, style, EquipmentInfo.xpModeFor(player))
    }

    fun addCombatXp(player: Player, target: Entity, hitDamage: Int, style: CombatStyle, mode: AttackMode) {
        var hit = hitDamage
        // Rather than putting hooks into every style of attacking a target, centralize it and stop giving XP
        // when certain styles can't damage an opponent.

        if (target.isNpc) {
            val ntarg = target as Npc
            val id = ntarg.id()
            if (id == 5534) hit = 0 // Can't damage tentacles much
            if (id == 496) {
                if (ntarg.sync().transmog() != 494) // Whirlpool as kraken
                    hit = 0
                else if (style != CombatStyle.MAGIC)
                    hit = 0
            }
            if (id == 319) { // Corp beast
                player.varps().varp(
                    Varp.CORP_BEAST_DAMAGE, player.varps().varp(
                        Varp.CORP_BEAST_DAMAGE) + hitDamage)
            }
        }

        when (style) {
            CombatStyle.MELEE -> {
                when (mode) {
                    AttackMode.ATTACK -> {
                        player.skills().__addXp(Skills.HITPOINTS, (hit + (hit / 3)).toDouble(), target !is Player)
                        player.skills().__addXp(Skills.ATTACK, (hit * 4).toDouble(), target !is Player)
                    }
                    AttackMode.STRENGTH -> {
                        player.skills().__addXp(Skills.HITPOINTS, (hit + (hit / 3)).toDouble(), target !is Player)
                        player.skills().__addXp(Skills.STRENGTH, (hit * 4).toDouble(), target !is Player)
                    }
                    AttackMode.DEFENCE -> {
                        player.skills().__addXp(Skills.HITPOINTS, (hit + (hit / 3)).toDouble(), target !is Player)
                        player.skills().__addXp(Skills.DEFENCE, (hit * 4).toDouble(), target !is Player)
                    }
                    AttackMode.SHARED -> {
                        val xp: Double = (hit * 4).toDouble()
                        player.skills().__addXp(Skills.HITPOINTS, (hit + (hit / 3)).toDouble(), target !is Player)
                        player.skills().__addXp(Skills.ATTACK, xp / 3, target !is Player)
                        player.skills().__addXp(Skills.STRENGTH, xp / 3, target !is Player)
                        player.skills().__addXp(Skills.DEFENCE, xp / 3, target !is Player)
                    }
                }
            }

            CombatStyle.RANGE -> {
                when (mode) {
                    AttackMode.RANGED -> {
                        player.skills().__addXp(Skills.HITPOINTS, (hit + (hit / 3)).toDouble(), target !is Player)
                        player.skills().__addXp(Skills.RANGED, (hit * 4).toDouble(), target !is Player)
                    }
                    AttackMode.SHARED -> {
                        player.skills().__addXp(Skills.HITPOINTS, (hit + (hit / 3)).toDouble(), target !is Player)
                        player.skills().__addXp(Skills.RANGED, (hit * 2).toDouble(), target !is Player)
                        player.skills().__addXp(Skills.DEFENCE, (hit * 2).toDouble(), target !is Player)
                    }
                }
            }

            CombatStyle.MAGIC -> {
                when (mode) {
                    AttackMode.MAGIC -> {
                        if (player.varps().varbit(2668) == 0 || player.varps().varbit(Varbit.AUTOCAST_SELECTED) == 0) {
                            // Accurate? Or normal autocast? aka non defensive
                            player.skills().__addXp(Skills.HITPOINTS, (hit + (hit / 3)).toDouble(), target !is Player)
                            player.skills().__addXp(Skills.MAGIC, (hit * 2).toDouble(), target !is Player)
                        } else {
                            // Defensive autocast...
                            player.skills().__addXp(Skills.HITPOINTS, (hit + (hit / 3)).toDouble(), target !is Player)
                            player.skills().__addXp(Skills.MAGIC, (hit + (hit / 3)).toDouble(), target !is Player)
                            player.skills().__addXp(Skills.DEFENCE, hit.toDouble(), target !is Player)
                        }
                    }
                    AttackMode.SHARED -> {
                        player.skills().__addXp(Skills.HITPOINTS, (hit + (hit / 3)).toDouble(), target !is Player)
                        player.skills().__addXp(Skills.MAGIC, (hit * 2).toDouble(), target !is Player)
                        player.skills().__addXp(Skills.DEFENCE, (hit * 2).toDouble(), target !is Player)
                    }
                }
            }
        }
    }
}