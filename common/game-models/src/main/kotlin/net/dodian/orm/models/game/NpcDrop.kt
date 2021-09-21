package net.dodian.orm.models.game

data class NpcDrop(
    val npcId: Int,
    val itemId: Int,
    val minAmount: Int,
    val maxAmount: Int,
    val dropChance: Double,
    val broadcast: Boolean
)