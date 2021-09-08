package net.dodian.runescape.content.npcs

import net.dodian.runescape.events.Script
import net.dodian.runescape.model.AttributeKey
import net.dodian.runescape.model.Entity

/**
 * Created by Jak on 26/08/2017
 * When you chat to an Npc, they will face you once the npcChat dialogue pops up (with the npc chathead)
 * after 8 seconds since their last interaction, if they're still facing you (and not somebody else) the face flag
 * will be reset.
 */
class NpcFacingPlayerPolicy(val facing: Entity) : Function1<Script, Unit> {
	override fun invoke(it: Script) {
		val npc = it.npc()
		
		it.delay(9) // 8.3 ticks = 5s
		
		// Are we still facing this target 5 seconds later? If someone else spoke to the npc it would be facing someone else now.
		if (npc.attribOr<Int>(AttributeKey.LAST_FACE_ENTITY_IDX, -1) == if (facing.isNpc) facing.index() else  facing.index() + 32768) {
			npc.face(null)
//			npc.faceTile(facing.tile()) // Face the last active tile.
		}
	}
}