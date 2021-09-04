package io.nozemi.runescape.content.mechanics

import io.nozemi.runescape.events.ScriptMain
import io.nozemi.runescape.events.ScriptRepository
import io.nozemi.runescape.model.Area
import io.nozemi.runescape.model.Entity
import io.nozemi.runescape.model.Tile
import io.nozemi.runescape.model.entity.Player
import io.nozemi.runescape.util.Varbit
import io.nozemi.runescape.util.Varp

/**
 * Created by Bart on 11/30/2015.
 */

object MultiwayCombat {
	
	val REGIONS = intArrayOf(
			/** Safe: **/
			11827, 11828, 11829, //Falador
			12341, //Barbarian Village
			8253, 8252, 8508, 8509, 8254, //Lunar Isle:
			9273, 9017, //Piscatoris Fishing Colony
			9532, 9276, //Fremennik Isles
			10809, 10810, 10554, //Relleka
			10549, //Ranging Guild
			10034, //Battlefield
			10029, //Feldip hills
			11318, //White wolf mountain
			11575, //Burthope
			11577, 11578, //Trollheim
			11050, 11051, 10794, 10795, //Apeatoll
			12590, //Bandit camp
			13105, //Al Kharid
			12337, //Wizards tower
			12338, //Draynor Village
			11602, 11603, 11346, 11347, //Godwars Dungeon
			13131, 13387, //FFA clan wars, top half
			11844, //Corporeal beast
			11589, //Dagannoths
			5690, 5689, //Zeah lizanman pit
			9116, //Kraken cave
			9619, 9363, //new thermo room
			8023, //Gnome Stronghold crash site (monkey madness)
			13972, // Kalphite queen lair
			
			
			/** Wildy: (uses 8x8 chunks for some sections as well as chunks) **/
			12599, 12600, //Wilderness Ditch
			12855, 12856, //Mammoths (lvl 9)
			13111, 13112, 13113, 13114, 13115, 13116, 13117, //Varrock -> GDZ
			12857, 12858, 12859, 12860, 12861, //East graveyard (lvl 17)
			13372, 13373, //East of Callisto (lvl 41)
			12604, //Black chins (lvl 33)
			12348, //Wildy GWD & Center wildy north of lava maze
			12088, 12089, //North of dark warriors (lvl 17)
			12961, //Scorpia pit
			9033, // KBD zone
			12363, 12362, 12106, 11851, 11850, // Abyssal Sire
			14938, 14939, // Smokedevil room in Nieve's cave + kalphite hive room
			12701, 12702, 12703, 12957, 12958, 12959, // Revenants! Not 100% accurate but.. Yeah
			9886, 10142 // waterbirth dungeon / dagannoth cave
	)
	
	val CHUNKS = intArrayOf(
			// Chaos temple - Crazy Arch 44s
			24117724, 24117725, 24117726,
			24183260, 24183261, 24183262,
			
			//Black chins
			25756120, 25756121, 25756122, 25756123, 25756124, 25756125, 25756126, 25756127,
			25821656, 25821657, 25821658, 25821659, 25821660, 25821661, 25821662, 25821663,
			25887192, 25887193, 25887194, 25887195, 25887196, 25887197, 25887198, 25887199,
			25952728, 25952729, 25952730, 25952731, 25952732, 25952733, 25952734, 25952735,
			26018264, 26018265, 26018266, 26018267, 26018268, 26018269, 26018270, 26018271,
			26083800, 26083801, 26083802, 26083803, 26083804, 26083805, 26083806, 26083807,
			26149336, 26149337, 26149338, 26149339, 26149340, 26149341, 26149342, 26149343,
			
			
			//KBD Cage
			24642018, 24642019, 24642020, 24642021, 24642022, 24642023,
			24707554, 24707555, 24707556, 24707557, 24707558, 24707559,
			24773090, 24773091, 24773092, 24773093, 24773094, 24773095,
			24838626, 24838627, 24838628, 24838629, 24838630, 24838631,
			24904162, 24904163, 24904164, 24904165, 24904166, 24904167,
			
			//Rune rocks north of KBD cage
			24969699, 24969700, 24969702, 24969703, 25035238, 25035239,
			25100774, 25100775,
			
			// Wilderness agility course at 55 wilderness
			24445417, 24510953, 24576489,
			24445418, 24510954, 24576490,
			24445419
			
			// TODO wildy gwd dungeon needs to be chunks not region because same region (12190) upstairs height 3 is single

	)

	val exclusions = arrayOf(
			// Rev cave enter holes
        Area(3236, 10229, 3248, 10236),
        Area(3193, 10051, 3207, 10061)
	)

	private fun exclusion(tile: Tile): Boolean {
		return exclusions.any { a -> a.contains(tile) }
	}
	
	@JvmStatic fun includes(entity: Entity): Boolean {
		// Every instance a man can think of is multicombat. Zulrah, minigames, tzhaar... anything.
		val instance = entity.world().allocator().active(entity.tile())
		if (instance.isPresent && instance.get().isMulti()) {
			return true
		}
		
		return includes(entity.tile())
	}
	
	@JvmStatic fun includes(tile: Tile): Boolean {
		return !exclusion(tile) && (REGIONS.any { id -> id == tile.region() } || CHUNKS.any { id -> tile.chunk() == id || tile == Tile(
            3021,
            3855
        ) || tile == Tile(3022, 3855)
        })
	}
	
	private fun region_includes(tile: Tile): Boolean {
		return !exclusion(tile) && REGIONS.any { id -> id == tile.region() }
	}

	private fun chunk_includes(tile: Tile): Boolean {
		return !exclusion(tile) && CHUNKS.any { id -> tile.chunk() == id }
	}

	val tileChangeListenChunks = arrayOf(
			// bottom of caves
			26215657, 26281193,
			// top of caves
			26543359, 26543358, 26477822
			)

	/**
	 * Always something hey? Single lines in rev caves DO NOT follow region OR chunk border lol. So check tile changes
	 * when in these dirty chunks for exact changes.
	 */
	@JvmStatic fun tileChanged(player: Player) {
		if (tileChangeListenChunks.any { c -> c == player.tile().chunk() }) {
			val state = if (includes(player.tile())) 1 else 0
			//player.message("state $state")
			if (player.varps().varbit(Varbit.MULTIWAY_AREA) != state)
				player.varps().varbit(Varbit.MULTIWAY_AREA, state)
		}
	}
	
	@JvmStatic @ScriptMain
	fun register(r: ScriptRepository) {
		REGIONS.forEach { region ->
			r.onRegionEnter(region) {
				//it.message("enter hook for region %d", region)
				// If new region is multi
				if (region_includes(it.player().tile())) {
					it.player().varps().varbit(Varbit.MULTIWAY_AREA, 1)
				}
			}
			// If you dont check, when you exit a chunk in a multi region it gets removed.
			r.onRegionExit(region) {
				//it.message("exit hook for region %d", region)
				// If new region isn't multi, set not.
				if (!includes(it.player().tile())) {
					it.player().varps().varbit(Varbit.MULTIWAY_AREA, 0)
				}
				if (region == 11844) { // Corp beast region, included here because multiple hooks per region not yet supported
					it.player().interfaces().closeById(13)
					it.player().varps().varp(Varp.CORP_BEAST_DAMAGE, 0)
				}
			}
		}
		CHUNKS.forEach { chunk_id ->
			r.onChunkEnter(chunk_id) {
				if (chunk_includes(it.player().tile())) {
					it.player().varps().varbit(Varbit.MULTIWAY_AREA, 1)
				}
			}
			r.onChunkExit(chunk_id) {
				// If new chunk isn't multi. actually checks fucking regions too instead of JUST CHUNKS
				if (!includes(it.player().tile())) {
					it.player().varps().varbit(Varbit.MULTIWAY_AREA, 0)
				}
			}
		}
		r.onRegionExit(12190) {
			// Leaving wildy gwd. Has to be hardcoded because in the same region, it is partly single.
			if (!includes(it.player().tile())) {
				it.player().varps().varbit(Varbit.MULTIWAY_AREA, 0)
			}
		}
	}
	
}