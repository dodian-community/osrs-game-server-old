package net.dodian.runescape.services

import org.springframework.stereotype.Component

@Component
interface Service {
    fun setup()
    fun start(): Boolean
    fun stop(): Boolean
    fun isAlive(): Boolean
}