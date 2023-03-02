/*
 * @autor:rgvillareal
 *
 */
package com.rent.car.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rent.car.model.persistence.Reservation;

/**
 * The Interface ReservationRepository.
 */
public interface ReservationRepository extends JpaRepository<Reservation, String> {


}
