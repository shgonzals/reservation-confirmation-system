package com.shgonzals.reservationconfirmationsystem.config.kafka.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.shgonzals.reservationconfirmationsystem.commons.dto.Confirmation;
import org.apache.commons.lang3.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;

public class ConfirmationSerializer implements Serializer<Confirmation> {
	private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

	@Override
	public byte[] serialize(String topic, Confirmation confirmation) {
		try{
			if (confirmation == null) {
				return null;
			}

			System.out.println("Serializing...");
			return objectMapper.writeValueAsBytes(confirmation);
		} catch (Exception e) {
			throw new SerializationException("Error when serializing Confirmation to byte[]");
		}
	}
}