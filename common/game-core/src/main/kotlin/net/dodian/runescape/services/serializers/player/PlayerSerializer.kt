package net.dodian.runescape.services.serializers.player

import net.dodian.orm.models.character.GameCharacter
import net.dodian.orm.models.character.position
import net.dodian.orm.models.character.runEnergy
import net.dodian.orm.models.character.updateFromCharacter
import net.dodian.orm.models.game.GameCharacter
import net.dodian.runescape.model.Tile
import net.dodian.runescape.model.entity.Player
import net.dodian.runescape.net.message.LoginRequestMessage
import net.dodian.runescape.services.serializers.Serializer
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
abstract class PlayerSerializer : Serializer() {

    abstract fun loadPlayer(
        player: Player,
        uid: Any?,
        password: String,
        fn: Consumer<PlayerLoadResult?>,
        loginRequestMessage: LoginRequestMessage
    ): Boolean

    abstract fun savePlayer(player: Player, removeOnline: Boolean)

    protected fun createCharacter(player: Player): GameCharacter {
        val character = GameCharacter(player)

        character.position(Tile(2606, 3102))
        character.runEnergy(100.0)

        player.updateFromCharacter(character)

        return character
    }
}