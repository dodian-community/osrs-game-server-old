package io.nozemi.runescape.orm.converters;

import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.stream.Collectors;

@Converter
public class IntArrayConverter implements AttributeConverter<Integer[], String> {

    @Override
    public String convertToDatabaseColumn(Integer[] attribute) {
        if(attribute.length <= 0) {
            return "";
        }

        return StringUtils.arrayToDelimitedString(attribute, ", ");
    }

    @Override
    public Integer[] convertToEntityAttribute(String dbData) {
        if(dbData == null || dbData.isEmpty()) {
            return new Integer[]{-1};
        }

        if(!dbData.contains(",")) {
            return new Integer[]{Integer.parseInt(dbData)};
        }

        return Arrays.stream(dbData.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .toArray(new Integer[3]);
    }
}
