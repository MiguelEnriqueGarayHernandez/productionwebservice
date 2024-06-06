package com.example.productionwebservice.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Converter(autoApply = true)
public class HierarchyIdConverter implements AttributeConverter<String, byte[]> {

    @Override
    public byte[] convertToDatabaseColumn(String attribute) {
        if (attribute == null) {
            return null;
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            baos.write(attribute.getBytes());
            return baos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to convert string to byte array", e);
        }
    }

    @Override
    public String convertToEntityAttribute(byte[] dbData) {
        if (dbData == null) {
            return null;
        }
        try (ByteArrayInputStream bais = new ByteArrayInputStream(dbData)) {
            byte[] buffer = new byte[dbData.length];
            int bytesRead = bais.read(buffer);
            return new String(buffer, 0, bytesRead);
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to convert byte array to string", e);
        }
    }
}
