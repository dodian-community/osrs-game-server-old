package net.dodian.tools

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import net.dodian.tools.converters.impl.NpcConfigConverter
import net.dodian.tools.converters.impl.NpcDropsConverter
import net.dodian.tools.converters.impl.NpcSpawnsConverter

object Application {

    val objectMapper: ObjectMapper = ObjectMapper()
        .findAndRegisterModules()
        .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
        .enable(SerializationFeature.INDENT_OUTPUT)

    @JvmStatic
    fun main(args: Array<String>) {
        NpcSpawnsConverter().convert()
        NpcDropsConverter().convert()
        NpcConfigConverter().convert()
    }
}