package com.shgonzals.reservationconfirmationsystem.api.service;

import com.shgonzals.reservationconfirmationsystem.api.dto.Request;
import com.shgonzals.reservationconfirmationsystem.api.document.Reservation;
import com.shgonzals.reservationconfirmationsystem.api.repository.ReservationRepository;
import com.shgonzals.reservationconfirmationsystem.commons.dto.Confirmation;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReservationService {

	private final  KafkaTemplate<String, Confirmation> kafkaTemplate;

	private final ReservationRepository repository;

	private Confirmation confirmation;

	public void createReservation(Request request){
		var reservation = Reservation.builder()
				.email(request.getEmail())
				.dateReservation(LocalDate.now())
				.restaurant(request.getRestaurant())
				.people(request.getPeople())
				.city(request.getCity())
				.date(request.getDate())
				.build();
		repository.save(reservation);


		confirmation = Confirmation
				.builder()
				.email(request.getEmail())
				.dateReservation(LocalDate.now())
				.restaurant(request.getRestaurant())
				.people(request.getPeople())
				.city(request.getCity())
				.date(request.getDate())
				.dateReservation(LocalDate.now())
				.build();
		
		sendKafka();
	}

	private void sendKafka(){
		kafkaTemplate.send("confirmation-topic", confirmation);
	}

}
