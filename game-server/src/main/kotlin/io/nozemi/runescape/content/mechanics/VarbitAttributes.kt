package io.nozemi.runescape.content.mechanics

import io.nozemi.runescape.model.AttributeKey
import io.nozemi.runescape.model.Entity
import io.nozemi.runescape.model.entity.player.Varps
import io.nozemi.runescape.net.message.game.command.UpdateStateCustom

/**
 * Created by Jak on 24/06/2016.
 */
object VarbitAttributes {
	
	/**
	 * Note - if varbits ever need to expand, you'll have to depreciate that varbitid since expansion will clash and overflow into bits sharing the rest of the variable.
	 * Bart: Sometimes I legit question if you come from this planet, or from a completely different one.
	 */
	enum class VarbitInfo(val varbitid: Int, val bitsize: Int, val shift: Int, val key: AttributeKey) {
		INFHP(1, 1, 0, AttributeKey.GENERAL_VARBIT1),
		INFPRAY(2, 1, 1, AttributeKey.GENERAL_VARBIT1),
		INFSPEC(3, 1, 2, AttributeKey.GENERAL_VARBIT1),
		INFRUN(4, 1, 3, AttributeKey.GENERAL_VARBIT1),
		XPLOCKED(5, 1, 4, AttributeKey.GENERAL_VARBIT1),
		XP_X1(6, 1, 5, AttributeKey.GENERAL_VARBIT1),
		// Interestingly, there are not real varbits (tested on osbot)
		PUBLIC_CHAT_STATUS(7, 7, 6, AttributeKey.GENERAL_VARBIT1),
		PM_STATUS(8, 3, 10, AttributeKey.GENERAL_VARBIT1),
		TRADE_STATUS(9, 3, 13, AttributeKey.GENERAL_VARBIT1),
		KS_SKULLS_HIDDEN(10, 1, 16, AttributeKey.GENERAL_VARBIT1),
		MAXCAPE_ROL_ON(11, 1, 17, AttributeKey.GENERAL_VARBIT1),
		HIDE_BOSS_KC(12, 1, 18, AttributeKey.GENERAL_VARBIT1),
		HIDE_KS_BROADCASTS(13, 1, 19, AttributeKey.GENERAL_VARBIT1),
		HIDE_LEVELUP_RARES_BROADCASTS(14, 1, 20, AttributeKey.GENERAL_VARBIT1),
		DEADMAN_DANGERZONE(15, 3, 22, AttributeKey.GENERAL_VARBIT1),
		RING_OF_SUFFERING_RECOIL_DISABLED(16, 1, 24, AttributeKey.GENERAL_VARBIT1),
		ROW_COIN_COLLECTION_OFF(17, 1, 25, AttributeKey.GENERAL_VARBIT1),
		BLOCK_RUSHING(18, 1, 26, AttributeKey.GENERAL_VARBIT1),
		BLOCK_SPEC_AND_TELE(19, 1, 27, AttributeKey.GENERAL_VARBIT1),
		USE_OLD_PRAYER_POS(20, 1, 28, AttributeKey.GENERAL_VARBIT1),
		;
		
		companion object {
			fun forid(id: Int): VarbitInfo? {
				for (varbit in VarbitInfo.values()) {
					if (varbit.varbitid == id) {
						return varbit
					}
				}
				return null
			}
		}
		
	}
	
	@JvmStatic fun varbit(entity: Entity, id: Int): Int {
		val vb = VarbitInfo.forid(id)!!
		return entity.attribOr<Int>(vb.key, 0).shr(vb.shift).and(vb.bitsize)
	}
	
	@JvmStatic fun varbiton(entity: Entity, id: Int): Boolean {
		return varbit(entity, id) == 1
	}
	
	@JvmStatic fun set(entity: Entity, id: Int, value: Int) {
		val vb = VarbitInfo.forid(id)!!
		entity.putattrib(vb.key, Varps.updateValue(entity.attribOr(vb.key, 0), vb.bitsize, value, vb.shift))
		if (id == 10 && entity.isPlayer) {
			UpdateStateCustom.skullToggle(value == 0)
		}
	}
	
	@JvmStatic fun toggle(entity: Entity, id: Int) {
		set(entity, id, varbit(entity, id).inv())
	}
}