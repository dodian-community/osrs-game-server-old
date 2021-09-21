package net.dodian.orm.models.game

import net.dodian.runescape.orm.converters.IntArrayConverter
import javax.persistence.*

@Entity
@Table(name = "npc_configs")
class NpcConfig(
    @Id var id: Int,
    var name: String,
    @Column(columnDefinition = "integer default 3") var combatLevel: Int,
    @Column(columnDefinition = "integer default 20") var health: Int,
    @Column(columnDefinition = "boolean default true") var isRetaliating: Boolean,
    @Column(columnDefinition = "boolean default false") var isUnstacked: Boolean,
    @Column(columnDefinition = "integer default 60") var respawnTime: Int,
    @Column(columnDefinition = "integer default 0") var respawnTimeRandomOffset: Int,
    @Column(columnDefinition = "boolean default false") var isAttackAble: Boolean,
    @Column(columnDefinition = "boolean default false") var isBoss: Boolean,
    @Column(columnDefinition = "integer default 1") var dropRolls: Int,
    @Column(columnDefinition = "boolean default false") var isSlayerRequired: Boolean,
    @Column(columnDefinition = "integer default 0") var slayerLevel: Int,
    @Column(columnDefinition = "integer default 0") var slayerExperience: Int,
    @Column(columnDefinition = "boolean default false") var isAggressive: Boolean,
    @Column(columnDefinition = "integer default 0") var aggroRadius: Int,
    @Column(columnDefinition = "integer default 4") var attackSpeed: Int,
    @Column(columnDefinition = "integer default 2") var maxHit: Int,
    @Convert(converter = IntArrayConverter::class) var attackSound: Array<Int>,
    @Convert(converter = IntArrayConverter::class) var blockSound: Array<Int>,
    @Convert(converter = IntArrayConverter::class) var deathSound: Array<Int>,
    @Column(columnDefinition = "integer default -1") var attackAnimation: Int,
    @Column(columnDefinition = "integer default -1") var blockAnimation: Int,
    @Column(columnDefinition = "integer default -1") var deathAnimation: Int,
    @Column(columnDefinition = "integer default 0") var attackBonus: Int,
    @Column(columnDefinition = "integer default 0") var magicBonus: Int,
    @Column(columnDefinition = "integer default 0") var rangedBonus: Int,
    @Column(columnDefinition = "integer default 0") var strengthBonus: Int,
    @Column(columnDefinition = "integer default 0") var stabDefenceBonus: Int,
    @Column(columnDefinition = "integer default 0") var slashDefenceBonus: Int,
    @Column(columnDefinition = "integer default 0") var crushDefenceBonus: Int,
    @Column(columnDefinition = "integer default 0") var rangedDefenceBonus: Int,
    @Column(columnDefinition = "integer default 0") var magicDefenceBonus: Int,
    @Column(columnDefinition = "integer default 1") var attackLevel: Int,
    @Column(columnDefinition = "integer default 1") var strengthLevel: Int,
    @Column(columnDefinition = "integer default 1") var defenceLevel: Int,
    @Column(columnDefinition = "integer default 1") var rangedLevel: Int,
    @Column(columnDefinition = "integer default 1") var magicLevel: Int,
    var hitScript: String?,
    var combatScript: String?,
    var dropTableScript: String?,
    var deathScript: String?,
    var aggressionScript: String?
) {

    fun setRetaliates(retaliates: Boolean) {
        isRetaliating = retaliates
    }
}
