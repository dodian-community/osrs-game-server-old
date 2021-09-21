package net.dodian.tools.converters.impl

import com.fasterxml.jackson.module.kotlin.readValue
import net.dodian.orm.models.game.NpcConfig
import net.dodian.tools.Application
import net.dodian.tools.converters.Converter

class NpcConfigConverter : Converter<MutableList<NpcConfig>>("dodiannet_npc_data.json") {

    override fun convert() {
        val oldNpcConfigs: MutableList<OldNpcConfig> = Application.objectMapper.readValue(file)
        val newNpcConfigs = mutableListOf<NpcConfig>()

        oldNpcConfigs.forEach {
            newNpcConfigs.add(NpcConfig(
                id = it.id,
                name = it.name,
                combatLevel = it.combat_level,
                health = it.health,
                isRetaliating = true,
                isUnstacked = true,
                respawnTime = it.respawn_time,
                respawnTimeRandomOffset = 0,
                isAttackAble = it.health != -1,
                isBoss = false,
                dropRolls = 1,
                isSlayerRequired = false,
                slayerLevel = 1,
                slayerExperience = 0,
                isAggressive = false,
                aggroRadius = 0,
                attackSpeed = it.attack_speed,
                maxHit = 0,
                attackSound = arrayOf(),
                blockSound = arrayOf(),
                deathSound = arrayOf(),
                attackAnimation = it.attack_emote,
                blockAnimation = -1,
                deathAnimation = it.death_emote,
                attackBonus = it.melee_attack_bonus,
                magicBonus = it.magic_attack_bonus,
                rangedBonus = it.range_attack_bonus,
                strengthBonus = it.melee_strength_bonus,
                stabDefenceBonus = 0,
                slashDefenceBonus = 0,
                crushDefenceBonus = 0,
                rangedDefenceBonus = it.range_defence_bonus,
                magicDefenceBonus = it.magic_defence_bonus,
                attackLevel = it.melee_attack,
                strengthLevel = it.melee_strength,
                defenceLevel = it.defence_level,
                rangedLevel = it.range_level,
                magicLevel = it.magic_level,
                hitScript = null,
                combatScript = null,
                dropTableScript = null,
                deathScript = null,
                aggressionScript = null
            ))
        }

        saveNew(newNpcConfigs)
    }
}

data class OldNpcConfig(
    val id: Int,
    val name: String,
    val health: Int,
    val attack_emote: Int,
    val death_emote: Int,
    val respawn_time: Int,
    val combat_level: Int,
    val attack_speed: Int,
    val melee_attack: Int,
    val melee_strength: Int,
    val melee_strength_bonus: Int,
    val melee_attack_bonus: Int,
    val melee_defence_bonus: Int,
    val range_level: Int,
    val range_strength: Int,
    val range_attack_bonus: Int,
    val range_defence_bonus: Int,
    val magic_level: Int,
    val magic_strength: Int,
    val magic_attack_bonus: Int,
    val magic_defence_bonus: Int,
    val defence_level: Int
)