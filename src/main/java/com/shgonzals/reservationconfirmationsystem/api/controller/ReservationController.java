package com.shgonzals.reservationconfirmationsystem.api.controller;

import com.shgonzals.reservationconfirmationsystem.api.dto.Request;
import com.shgonzals.reservationconfirmationsystem.api.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
@Tag(name = "Reservation API", description = "Reservation API")
public class ReservationController {

	private final static String RESERVATION_VALUE = "Reservar";
	private final static String RESERVATION_NOTES = "Realizamos una reserva";

	private final ReservationService service;

	@Operation(summary = RESERVATION_VALUE, description = RESERVATION_NOTES)
	@PostMapping("/create")
	private ResponseEntity<String> createBook(@RequestBody Request request){
		service.createReservation(request);
		return ResponseEntity.ok("");
	}
}
