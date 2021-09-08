package net.dodian.game.cache.type.item

import io.guthix.buffer.readString
import io.netty.buffer.ByteBuf
import net.dodian.game.cache.GameCache
import net.dodian.game.cache.readParameters
import net.dodian.game.cache.type.CacheTypeLoader
import org.springframework.stereotype.Component
import java.lang.RuntimeException

private const val ITEM_ARCHIVE = 2
private const val ITEM_GROUP = 10

class ItemTypeLoader constructor(
    private val cache: GameCache,
    private val types: ItemTypeList
) : CacheTypeLoader {

    override fun load() {
        val files = cache.groups(ITEM_ARCHIVE, ITEM_GROUP)
        files.forEach { (file, data) ->
            val type = data.readType(file)
            types.add(type)
        }
    }

    private fun ByteBuf.readType(id: Int): ItemType {
        val builder = ItemTypeBuilder().apply { this.id = id }
        while (isReadable) {
            val opcode = readUnsignedByte().toInt()
            if (opcode == 0) {
                break
            }
            builder.readBuffer(opcode, this)
        }
        return builder.build()
    }

    private fun ItemTypeBuilder.readBuffer(opcode: Int, buffer: ByteBuf) {
        when (opcode) {
            1 -> model = buffer.readUnsignedShort()
            2 -> name = buffer.readString()
            4 -> zoom2d = buffer.readUnsignedShort()
            5 -> xan2d = buffer.readUnsignedShort()
            6 -> yan2d = buffer.readUnsignedShort()
            7 -> {
                xOff2d = buffer.readUnsignedShort()
                if (xOff2d > 0x7FFF) {
                    xOff2d -= 0x10000
                }
            }
            8 -> {
                yOff2d = buffer.readUnsignedShort()
                if (yOff2d > 0x7FFF) {
                    yOff2d -= 0x10000
                }
            }
            11 -> stacks = true
            12 -> cost = buffer.readInt()
            16 -> members = true
            23 -> {
                maleModel0 = buffer.readUnsignedShort()
                maleModelOffset = buffer.readByte().toInt()
            }
            24 -> maleModel1 = buffer.readUnsignedShort()
            25 -> {
                femaleModel0 = buffer.readUnsignedShort()
                femaleModelOffset = buffer.readByte().toInt()
            }
            26 -> femaleModel1 = buffer.readUnsignedShort()
            in 30 until 35 -> {
                groundOptions[opcode - 30] = buffer.readString()
                if (groundOptions[opcode - 30].equals("null", ignoreCase = true)) {
                    groundOptions[opcode - 30] = null
                }
            }
            in 35 until 40 -> inventoryOptions[opcode - 35] = buffer.readString()
            40, 41 -> {
                val count = buffer.readUnsignedByte().toInt()
                val src = IntArray(count)
                val dest = IntArray(count)
                repeat(count) {
                    src[it] = buffer.readUnsignedShort()
                    dest[it] = buffer.readUnsignedShort()
                }

                if (opcode == 40) {
                    recolorSrc = src
                    recolorDest = dest
                } else {
                    retextureSrc = src
                    retextureDest = dest
                }
            }
            42 -> dropOptionIndex = buffer.readByte().toInt()
            65 -> exchangeable = true
            78 -> maleModel2 = buffer.readUnsignedShort()
            79 -> femaleModel2 = buffer.readUnsignedShort()
            90 -> maleHeadModel0 = buffer.readUnsignedShort()
            91 -> femaleHeadModel0 = buffer.readUnsignedShort()
            92 -> maleHeadModel1 = buffer.readUnsignedShort()
            93 -> femaleHeadModel1 = buffer.readUnsignedShort()
            95 -> zan2d = buffer.readUnsignedShort()
            96 -> buffer.readByte()
            97 -> noteLink = buffer.readUnsignedShort()
            98 -> noteValue = buffer.readUnsignedShort()
            in 100 until 110 -> {
                if (countItem.isEmpty()) {
                    countItem = IntArray(10)
                    countCo = IntArray(10)
                }
                val index = opcode - 100
                countItem[index] = buffer.readUnsignedShort()
                countCo[index] = buffer.readUnsignedShort()
            }
            110 -> resizeX = buffer.readUnsignedShort()
            111 -> resizeY = buffer.readUnsignedShort()
            112 -> resizeZ = buffer.readUnsignedShort()
            113 -> ambient = buffer.readByte().toInt()
            114 -> contrast = buffer.readByte() * 5
            115 -> teamCape = buffer.readUnsignedByte().toInt()
            139 -> boughtLink = buffer.readShort().toInt()
            140 -> boughtValue = buffer.readShort().toInt()
            148 -> placeholderLink = buffer.readUnsignedShort()
            149 -> placeholderValue = buffer.readUnsignedShort()
            249 -> parameters = buffer.readParameters()
            else -> throw RuntimeException("cannot parse item definition, missing config code: $opcode")
        }
    }
}