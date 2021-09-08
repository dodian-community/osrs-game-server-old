package net.dodian.game.core

import org.springframework.stereotype.Component

@Component
interface ServerModule<T> {
    fun get(): T
}