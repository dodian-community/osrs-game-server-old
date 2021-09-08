package net.dodian.tools.converters

import net.dodian.tools.Converter
import java.io.File
import java.lang.RuntimeException
import java.nio.file.Path

/**
 * Converts <PREFIX>items.json
 */
class ItemConfigConverter : Converter {

    private var fileToConvert: File? = null

    init {
        findFile()
        convert()
    }

    override fun convert() {
        TODO("Not yet implemented")
    }

    override fun findFile() {
        val file = Path.of("./data/old/dodiannet_items.json")
        fileToConvert = file.toFile() ?: throw RuntimeException("Couldn't find file: $file")
    }
}