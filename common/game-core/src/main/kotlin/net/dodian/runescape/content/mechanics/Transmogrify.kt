package net.dodian.runescape.content.mechanics

import net.dodian.runescape.fs.NpcDefinition
import net.dodian.runescape.model.entity.Player
import java.util.*

/**
 * Created by Mack on 10/23/2017.
 */
object Transmogrify {

	private const val ENABLED = false

	enum class TransmogItems(id: Int, transmogId: Int, walkable: Boolean) {
		NONE(-1, -1, true),
		BEDSHEET(4285, 3009, true),
		
		;//end
		
		private val item = id
		private val toId = transmogId
		private val mobile = walkable
		
		fun id(): Int {
			return item
		}
		
		fun transmogId(): Int {
			return toId
		}
		
		fun mobile(): Boolean {
			return mobile
		}
	}
	
	/**
	 * A flag to check if the player is currently transmog'd.
	 */
	@JvmStatic fun isTransmogrified(player: Player): Boolean {
		return (player.looks().trans() > -1)
	}
	
	/**
	 * Preconditions to be met prior to allowing the player to transmogrify.
	 */
	@JvmStatic fun canTransmogrify(player: Player): Boolean {
        if (!ENABLED) {
            return false
        }
		
		return true
	}
	
	/**
	 * The main function to transmogrifying the player.
	 */
	fun transmog(player: Player, data: TransmogItems) {
        if (!ENABLED) {
            return
        }
		if (!data.mobile()) {
			player.stopActions(true)
		}
		
		player.looks().transmog(data.transmogId())
		player.looks().renderData(player.world().definitions().get(NpcDefinition::class.java, data.transmogId()).renderpairs())
	}
	
	/**
	 * Hard resets the player's render under certain circumstance such as being morphed in a area
	 * they shouldn't or dying whilst morphed.
	 */
	@JvmStatic fun hardReset(player: Player) {
		val transmogType: Optional<TransmogItems> = Arrays.stream(TransmogItems.values()).filter({ type -> player.equipment().has(type.id())}).findAny()
		
		if (transmogType.isPresent) {
			untransmog(player, transmogType.get())
		}
	}
	
	/**
	 * The main function to untransmogrifying the player.
	 */
	fun untransmog(player: Player, data: TransmogItems?) {
		val transmog = data ?: TransmogItems.NONE
		
		if (transmog.mobile()) {
			player.unlock()
		}
		
		player.looks().transmog(-1)
		player.looks().resetRender()
		player.message("You return to your human-like state.")
	}
}