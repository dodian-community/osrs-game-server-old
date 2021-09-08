package net.dodian.game.cache

import io.guthix.buffer.readString
import io.guthix.buffer.writeString
import io.netty.buffer.ByteBuf

internal fun ByteBuf.readParameters(): Map<Int, Any> {
    val parameters = mutableMapOf<Int, Any>()
    val count = readUnsignedByte().toInt()
    repeat(count) {
        val readString = readBoolean()
        val key = readUnsignedMedium()
        if (readString) {
            parameters[key] = readString()
        } else {
            parameters[key] = readInt()
        }
    }
    return parameters
}

internal fun ByteBuf.writeParameters(parameters: Map<Int, Any>) {
    writeByte(parameters.size)
    parameters.forEach { (key, value) ->
        val isString = value is String
        writeByte(if (isString) 1 else 0)
        writeMedium(key)
        if (isString) {
            writeString(value as String)
        } else {
            writeInt(value as Int)
        }
    }
}