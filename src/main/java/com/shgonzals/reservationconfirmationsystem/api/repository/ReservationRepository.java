package com.shgonzals.reservationconfirmationsystem.api.repository;

import com.shgonzals.reservationconfirmationsystem.api.document.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, String> {

}
