package net.dodian.runescape.services.serializers

import net.dodian.runescape.services.Service

abstract class Serializer : Service {

    override fun setup() {

    }

    override fun start(): Boolean {
        return true
    }

    override fun stop(): Boolean {
        return true
    }

    override fun isAlive(): Boolean {
        return true
    }
}