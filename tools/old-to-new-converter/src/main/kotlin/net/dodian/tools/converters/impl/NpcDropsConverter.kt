package net.dodian.tools.converters.impl

import com.fasterxml.jackson.module.kotlin.readValue
import net.dodian.orm.models.game.NpcDrop
import net.dodian.tools.Application
import net.dodian.tools.converters.Converter

class NpcDropsConverter : Converter<MutableList<NpcDrop>>("dodiannet_npc_drops.json") {

    override fun convert() {
        val oldDrops: MutableList<OldNpcDrop> = Application.objectMapper.readValue(file)
        val newDrops = mutableListOf<NpcDrop>()

        oldDrops.forEach {
            newDrops.add(
                NpcDrop(
                    it.npcid,
                    it.itemid,
                    it.amount_low,
                    it.amount_max,
                    it.percent.toDouble(),
                    it.rare_shout
                )
            )
        }

        saveNew(newDrops)
    }
}

data class OldNpcDrop(
    val npcid: Int,
    val itemid: Int,
    val amount_low: Int,
    val amount_max: Int,
    val percent: Int,
    val rare_shout: Boolean
)