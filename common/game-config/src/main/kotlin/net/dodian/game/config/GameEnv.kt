package net.dodian.game.config

sealed class GameEnv {

    object Testing : GameEnv()
    object Development : GameEnv()
    object Production : GameEnv()

    override fun toString(): String {
        return javaClass.simpleName
    }
}