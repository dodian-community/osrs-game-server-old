package net.dodian.runescape.content.mechanics

import net.dodian.runescape.model.entity.Player
import net.dodian.runescape.model.item.Item
import java.util.*


/**
 * Created by Bart on 12/16/2016.
 */
object ServerAnnouncements {
	
	val RARE_DROPS = setOf<Int>(
			11812, // Bandos hilt
			11832, // Bandos chestplate
			11834, // Bandos tassets
			11785, // Armadyl crossbow
			11810, // Armadyl hilt
			11826, // Armadyl helmet
			11828, // Armadyl chestplate
			11830, // Armadyl chainskirt
			11824, // Zamorakian spear
			11816, // Zamorak hilt
			11791, // Staff of the dead
			11814, // Saradomin hilt
			11838, // Saradomin sword
			12819, // Elysian sigil
			12823, // Spectral sigil
			12827, // Arcane sigil
			12922, // Tanzanite fang
			12932, // Magic fang
			12927, // Serpentine visage
			12605, // Treasonous ring
			7158, // Dragon 2h
			11920, // Dragon pickaxe
			19529, // Zenyte shard,
			19592, // Ballista limbs
			19601, // Ballista spring
			19586, // Light frame
			19589, // Heavy frame
			19610, // Monkey tail
			13576, // Dragon warhammer
			11286, // Draconic visage
			3140, // Dragon chainbody
			13231, // Primordial crystal
			13229, // Pegasian crystal
			13227, // Eternal crystal
			13233, // Smouldering stone,
			// On world 2 a lot of items drop as their raw form.
			11802, 11804, 11806, 11808,
			12817, 12821, 12825, 11283,
			22299, //Ancient medallion
			22302, //Ancient effigy
			22305, //Ancient relic
			20724, //Imbued heart
			6739,  //Dragon axe
			13652, //Dragon claws
			21015, //Dihn's Bulwark
			21003,  //Elder maul
			21000, //Twisted buckler
			22305, //Ancient relic
			22106  //Jar of decay

	)
	
	val VOWELS = charArrayOf('a', 'e', 'i', 'o', 'u')
	
	@JvmStatic fun tryBroadcastDrop(player: Player, item: Int) {
		if (item in RARE_DROPS) {
			val def = Item(item).unnote(player.world()).definition(player.world())
			val aOrAn = if (def.name.lowercase(Locale.getDefault())[0] in VOWELS) "an" else "a"
			player.world().broadcast("<col=0052cc>News: ${player.username()} has received $aOrAn ${def.name} drop!")
		}
	}
	
}