package com.shgonzals.reservationconfirmationsystem.config.kafka.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.shgonzals.reservationconfirmationsystem.commons.dto.Confirmation;
import org.apache.commons.lang3.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class ConfirmationDeserializer implements Deserializer<Confirmation> {
	private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

	@Override
	public Confirmation deserialize(String topic, byte[] data) {
		try {
			if (data == null){
				System.out.println("Null received at deserializing");
				return null;
			}
			System.out.println("Deserializing...");

			return objectMapper.readValue(new String(data, StandardCharsets.UTF_8), Confirmation.class);
		} catch (Exception e) {
			throw new SerializationException("Error when deserializing byte[] to Confirmation");
		}
	}
}