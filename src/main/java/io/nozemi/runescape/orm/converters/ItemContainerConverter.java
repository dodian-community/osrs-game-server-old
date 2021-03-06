package io.nozemi.runescape.orm.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.nozemi.runescape.model.item.ItemContainer;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ItemContainerConverter implements AttributeConverter<ItemContainer, String> {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(ItemContainer attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "[]";
    }

    @Override
    public ItemContainer convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, ItemContainer.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ItemContainer();
    }
}