package com.shgonzals.reservationconfirmationsystem.commons.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Confirmation {
	private String email;
	private String restaurant;
	private String people;
	private String city;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime date;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateReservation;
}
