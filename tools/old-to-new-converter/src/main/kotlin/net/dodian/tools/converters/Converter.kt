package net.dodian.tools.converters

import net.dodian.tools.Application
import java.io.File
import java.lang.RuntimeException
import java.nio.file.Path

abstract class Converter<T>(private val fileName: String) {

    private val dataDirectory = "./tools/old-to-new-converter/data/"

    protected val file: File

    init {
        file = findFile()
    }

    abstract fun convert()

    private fun findFile(): File {
        val file = Path.of(dataDirectory, "old", fileName)
        if(file.toFile().exists()) {
            return file.toFile()
        }

        throw RuntimeException("Can't find file: ${file.toAbsolutePath()}")
    }

    protected fun saveNew(toSave: T) {
        Application.objectMapper.writeValue(Path.of(dataDirectory, "new", fileName).toFile(), toSave)
    }
}