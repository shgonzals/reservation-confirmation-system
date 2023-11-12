package com.shgonzals.reservationconfirmationsystem.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class Request {

	private String email;
	private String restaurant;
	private String people;
	private String city;
	private LocalDateTime date;

}
