package net.dodian.tools.converters.impl

import com.fasterxml.jackson.module.kotlin.readValue
import net.dodian.orm.models.game.ItemConfig
import net.dodian.tools.Application
import net.dodian.tools.converters.Converter

/**
 * Converts <PREFIX>items.json
 */
class ItemConfigConverter : Converter<String>("dodiannet_uber3_items.json") {

    override fun convert() {
        val oldItemConfigs: MutableList<OldItemConfig> = Application.objectMapper.readValue(file)
        val newItemConfigs = mutableListOf<ItemConfig>()
    }
}

data class OldItemConfig(
    val id: Int,
    val name: String,
    val description: String,
    val slot: Int,
    val stackable: Boolean,
    val tradeable: Boolean,
    val noteable: Boolean,
    val shopSellValue: Int,
    val shopBuyValue: Int,
    val Alchemy: Int,
    val standAnim: Int,
    val walkAnim: Int,
    val runAnim: Int,
    val attackAnim: Int,
    val premium: Boolean,
    val twohanded: Boolean,
    val full: Boolean,
    val interfaceid: Int,
    val bonus1: Int,
    val bonus2: Int,
    val bonus3: Int,
    val bonus4: Int,
    val bonus5: Int,
    val bonus6: Int,
    val bonus7: Int,
    val bonus8: Int,
    val bonus9: Int,
    val bonus10: Int,
    val bonus11: Int,
    val bonus12: Int,
)