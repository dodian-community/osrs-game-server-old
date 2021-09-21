package net.dodian.runescape.services.serializers.player

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import net.dodian.orm.models.character.GameCharacter
import net.dodian.orm.models.character.updateFromCharacter
import net.dodian.runescape.model.AttributeKey
import net.dodian.runescape.model.entity.Player
import net.dodian.runescape.model.uid.providers.SimpleUIDProvider
import net.dodian.runescape.net.message.LoginRequestMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.nio.file.Path
import java.util.function.Consumer

@Component
class JsonPlayerSerializer @Autowired constructor(
    private val mapper: ObjectMapper,
    private val uidProvider: SimpleUIDProvider
) : PlayerSerializer() {

    private val characterFolder = Path.of("data/characters")

    override fun loadPlayer(
        player: Player,
        uid: Any?,
        password: String,
        fn: Consumer<PlayerLoadResult?>,
        loginRequestMessage: LoginRequestMessage
    ): Boolean {
        val characterFile = Path.of(characterFolder.toString(), "${player.username()}.json")

        if (characterFile.toFile().exists()) {
            player.updateFromCharacter(mapper.readValue(characterFile.toFile()))
        } else {
            if (!characterFolder.toFile().exists()) {
                characterFolder.toFile().mkdirs()
            }

            player.id(uidProvider.acquire(player))
            player.putattrib(AttributeKey.NEW_ACCOUNT, true)

            createCharacter(player)
            savePlayer(player, false)
        }

        fn.accept(PlayerLoadResult.OK)
        return true
    }

    override fun savePlayer(player: Player, removeOnline: Boolean) {
        val characterFile = Path.of(characterFolder.toString(), "${player.username()}.json")
        val character = GameCharacter(player)
        mapper.writeValue(characterFile.toFile(), character)
    }
}