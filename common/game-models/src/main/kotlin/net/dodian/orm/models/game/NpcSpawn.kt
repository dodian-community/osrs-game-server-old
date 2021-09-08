package net.dodian.orm.models.game

import net.dodian.models.SpawnDirection
import javax.persistence.*

@Entity
@Table(name = "npc_spawns")
class NpcSpawn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0
    var npcId = 0
    var x = 0
    var y = 0
    var level = 0
    var health = 0

    @Column(columnDefinition = "boolean default false", nullable = true)
    var isTaskRequired = false

    @Column(columnDefinition = "integer default 0", nullable = true)
    var slayerExperience = 0

    @Column(columnDefinition = "integer default 0", nullable = true)
    var slayerLevel = 0
    var respawnDelay = 0
    var combatLevel = 0
    var walkRadius = 0
    private var direction: SpawnDirection? = null

    @Column(columnDefinition = "boolean default false", nullable = true)
    val isAttackAble = false

    constructor() {}

    constructor(
        npcId: Int,
        walkRadius: Int,
        x: Int,
        y: Int,
        level: Int,
        direction: SpawnDirection
    ) {
        this.npcId = npcId
        this.x = x
        this.y = y
        this.level = level
        this.walkRadius = walkRadius
        this.direction = direction
        this.respawnDelay = 0
        this.combatLevel = 0
        this.isTaskRequired = false
        this.health = 0
    }

    fun getDirection(): SpawnDirection? {
        return direction
    }

    fun setDirection(direction: SpawnDirection?) {
        this.direction = direction
    }
}
