package net.dodian.tools.converters.impl

import com.fasterxml.jackson.module.kotlin.readValue
import net.dodian.models.SpawnDirection
import net.dodian.orm.models.game.NpcSpawn
import net.dodian.tools.Application
import net.dodian.tools.converters.Converter

class NpcSpawnsConverter : Converter<MutableList<NpcSpawn>>("dodiannet_npc_spawns.json") {

    override fun convert() {
        val oldSpawns: MutableList<OldNpcSpawn> = Application.objectMapper.readValue(file)
        val newSpawns = mutableListOf<NpcSpawn>()

        oldSpawns.forEach {
            newSpawns.add(NpcSpawn(
                it.id,
                0,
                it.posX,
                it.posY,
                it.height,
                SpawnDirection.SOUTH
            ))
        }

        saveNew(newSpawns)
    }
}

data class OldNpcSpawn(
    val id: Int,
    val health: Int,
    val posX: Int,
    val posY: Int,
    val height: Int
)