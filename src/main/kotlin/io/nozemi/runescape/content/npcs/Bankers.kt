package io.nozemi.runescape.content.npcs

import io.nozemi.runescape.events.ScriptMain
import io.nozemi.runescape.events.ScriptRepository
import io.nozemi.runescape.model.entity.Npc
import java.util.*


/**
 * Created by Jak on 20/12/2015.
 */

object Bankers {
	
	@JvmStatic val bankerNpcIds = intArrayOf(394, 395, 2897, 2898, 400, 396, 7677, 5453, 5454, 5455, 5456, 6510, 7057, 6528)
	
	//@JvmStatic @ScriptMain
	/*fun register(r: ScriptRepository) {
		bankerNpcIds.forEach { banker ->
			r.onNpcOption3(banker) @Suspendable { it.player().grandExchange().openCollectionBox() }
			r.onNpcOption2(banker) @Suspendable { Bank.open(it.player(), it) }
			r.onNpcOption1(banker) @Suspendable {
				it.chatNpc("Good day, how may I help you?", banker)
				when (it.options("I'd like to access my bank account, please.", "I'd like to check my PIN settings.", "Never mind")) {
					1 -> Bank.open(it.player(), it)
					2 -> it.chatNpc("Bank PINs were removed on May 4th. Use ::2fa to secure your account. If you get hacked, no 2FA no refund.", banker)
				}
			}
			
			r.onItemOnNpc(banker, s@ @Suspendable {
				val player = it.player()
				val itemID: Int = player.attrib(AttributeKey.ITEM_ID)
				val slot: Int = player.attrib(AttributeKey.ITEM_SLOT)
				val def: ItemDefinition = player.world().definitions().get(ItemDefinition::class.java, itemID) ?: return@s
				
				bankobjects.noteLogic(it, itemID, slot, def)
			})
		}
	}*/

	@JvmStatic
	fun isBanker(npc: Npc): Boolean {
		return npc.id() in bankerNpcIds
				|| npc.def()!!.name!!.lowercase(Locale.getDefault()).contains("banker")
				|| npc.def()!!.name!!.lowercase(Locale.getDefault()).contains("clerk")
	}
}