package io.nozemi.runescape.content.interfaces

import io.nozemi.runescape.model.entity.Player
import io.nozemi.runescape.model.entity.player.Interfaces
import io.nozemi.runescape.model.item.Item
import io.nozemi.runescape.util.Varbit

/**
 *
 * @author Eikenboom - Clean up to Dodian source, left some spell code, needs to cleanup later.
 *
 */

object SpellSelect {
	
	@JvmStatic val MODERN_CHILDREN = intArrayOf(2, 5, 7, 9, 11, 15, 18, 21, 25, 28, 34, 39, 46, 49, 54, 57, 1, 32, 43, 44, 61, 63, 68, 70, 42)
	@JvmStatic val MODERN_LEVEL_REQS = intArrayOf(1, 5, 9, 13, 17, 23, 29, 35, 41, 47, 53, 59, 62, 65, 70, 75, 1, 50, 60, 60, 81, 85, 90, 95, 60)
	@JvmStatic val MODERN_ITEM_REQS = arrayOf(
			arrayOf(Item(556, 1), Item(558, 1)),
			arrayOf(Item(555, 1), Item(556, 1), Item(558, 1)),
			arrayOf(Item(557, 2), Item(556, 1), Item(558, 1)),
			arrayOf(Item(554, 3), Item(556, 1), Item(558, 1)),
			arrayOf(Item(556, 2), Item(562, 1)),
			arrayOf(Item(555, 2), Item(556, 2), Item(562, 1)),
			arrayOf(Item(556, 2), Item(557, 3), Item(562, 1)),
			arrayOf(Item(554, 3), Item(556, 2), Item(562, 1)),
			arrayOf(Item(556, 3), Item(560, 1)),
			arrayOf(Item(555, 3), Item(556, 3), Item(560, 1)),
			arrayOf(Item(557, 4), Item(556, 3), Item(560, 1)),
			arrayOf(Item(554, 5), Item(556, 4), Item(560, 1)),
			arrayOf(Item(556, 5), Item(565, 1)),
			arrayOf(Item(556, 5), Item(555, 7), Item(565, 1)),
			arrayOf(Item(557, 7), Item(556, 5), Item(565, 1)),
			arrayOf(Item(554, 7), Item(556, 5), Item(565, 1)), // 16th spell ([15])
			arrayOf(Item(557, 2), Item(556, 2), Item(562)), // crumble undead
			arrayOf(Item(560, 1), Item(558, 4)), // [17] magic dart
			arrayOf(Item(554), Item(556, 4), Item(565, 2)), // claws of guth
			arrayOf(Item(554, 4), Item(565, 2), Item(556)), // [19] zammy
            arrayOf(Item(556, 7), Item(21880, 1)), //Wind surge
            arrayOf(Item(555, 10), Item(556, 7), Item(21880, 1)), //Water Surge
            arrayOf(Item(557, 10), Item(556, 7), Item(21880, 1)), //Earth Surge
            arrayOf(Item(554, 10), Item(556, 7), Item(21880, 1)), //Fire Surge
            arrayOf(Item(554, 2), Item(565, 2), Item(556, 4)) //Sara strike
	)
	
	val ANCIENT_CHILDREN = intArrayOf(80, 84, 76, 72, 82, 86, 78, 74, 81, 85, 77, 73, 83, 87, 79, 75)
	val ANCIENT_LEVEL_REQS = intArrayOf(50, 52, 56, 58, 62, 64, 68, 70, 74, 76, 80, 82, 86, 88, 92, 94)
	val ANCIENT_ITEM_REQS = arrayOf(
			arrayOf(Item(562, 2), Item(560, 2), Item(556, 1), Item(554, 1)),
			arrayOf(Item(562, 2), Item(560, 2), Item(556, 1), Item(566, 1)),
			arrayOf(Item(562, 2), Item(560, 2), Item(565, 1)),
			arrayOf(Item(562, 2), Item(560, 2), Item(555, 2)),
			arrayOf(Item(562, 4), Item(560, 2), Item(554, 2), Item(556, 2)),
			arrayOf(Item(562, 4), Item(560, 2), Item(556, 2), Item(566, 2)),
			arrayOf(Item(562, 4), Item(560, 2), Item(565, 2)),
			arrayOf(Item(562, 4), Item(560, 2), Item(555, 4)),
			arrayOf(Item(560, 2), Item(565, 2), Item(554, 2), Item(556, 2)),
			arrayOf(Item(560, 2), Item(565, 2), Item(556, 2), Item(562, 2)),
			arrayOf(Item(560, 2), Item(565, 4)),
			arrayOf(Item(560, 2), Item(565, 2), Item(555, 3)),
			arrayOf(Item(560, 4), Item(565, 2), Item(554, 4), Item(556, 4)),
			arrayOf(Item(560, 4), Item(565, 2), Item(556, 4), Item(566, 3)),
			arrayOf(Item(560, 4), Item(565, 4), Item(566, 1)),
			arrayOf(Item(560, 4), Item(565, 2), Item(555, 6)))
	
	
	@JvmStatic fun reset(player: Player, resetSpell: Boolean, sendTab: Boolean) {
		if (resetSpell) {
			player.varps().varbit(Varbit.AUTOCAST_SELECTED, 0)
		}
		if (sendTab) {
			player.interfaces().sendWidgetOn(593, Interfaces.InterSwitches.COMBAT_TAB)
		}
		player.updateWeaponInterface()
	}

}
