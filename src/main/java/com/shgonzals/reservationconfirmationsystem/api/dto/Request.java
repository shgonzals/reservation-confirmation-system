package com.shgonzals.reservationconfirmationsystem.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Request {

	private String email;
	private String restaurant;
	private String people;
	private String city;
	private LocalDate date;

}
