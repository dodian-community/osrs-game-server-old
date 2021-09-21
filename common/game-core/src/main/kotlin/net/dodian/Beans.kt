package net.dodian

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import net.dodian.runescape.model.uid.providers.SimpleUIDProvider
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class Beans {

    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper()
            .findAndRegisterModules()
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
            .enable(SerializationFeature.INDENT_OUTPUT)
    }

    @Bean
    fun simpleUidProvider(): SimpleUIDProvider {
        return SimpleUIDProvider()
    }
}