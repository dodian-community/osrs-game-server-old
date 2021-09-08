package net.dodian.tools.converters.impl

import com.fasterxml.jackson.module.kotlin.readValue
import net.dodian.tools.Application
import net.dodian.tools.converters.Converter

class NpcDropsConverter : Converter<String>("dodiannet_npc_drops.json") {

    override fun convert() {
        val oldDrops: MutableList<OldNpcDrop>  = Application.objectMapper.readValue(file)

        oldDrops.forEach {
            println("NPC ID: ${it.npcid} | Item ID: ${it.itemid}")
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
}