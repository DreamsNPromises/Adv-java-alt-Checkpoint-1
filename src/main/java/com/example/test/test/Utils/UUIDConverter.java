package com.example.test.test.Utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.UUID;

@Converter(autoApply = true)
public class UUIDConverter implements AttributeConverter<UUID, String> {

    @Override
    public String convertToDatabaseColumn(UUID uuid) {
        return uuid.toString().replace("-", "");
    }

    @Override
    public UUID convertToEntityAttribute(String string) {
        return UUID.fromString(string);
    }

}

