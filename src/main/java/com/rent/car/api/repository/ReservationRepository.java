package com.rent.car.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rent.car.model.persistence.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {


}
