package net.dodian.runescape.services.serializers.player

import net.dodian.runescape.model.entity.Player
import net.dodian.runescape.net.message.LoginRequestMessage
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class SpringPlayerSerializer : PlayerSerializer() {

    override fun loadPlayer(
        player: Player,
        uid: Any?,
        password: String,
        fn: Consumer<PlayerLoadResult?>,
        loginRequestMessage: LoginRequestMessage
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun savePlayer(player: Player, removeOnline: Boolean) {
        TODO("Not yet implemented")
    }
}