package com.shgonzals.reservationconfirmationsystem.api.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document
@Data
@Builder
public class Reservation {

	@Id
	private String id;
	private String email;
	private LocalDate dateReservation;
	private String restaurant;
	private String people;
	private String city;
	private LocalDateTime date;

}
