/*
 * @autor:rgvillareal
 *
 */
package com.rent.car.api.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rent.car.model.dto.ReservationDTO;
import com.rent.car.model.persistence.Reservation;

/**
 * The Class TransformReservation.
 */
public class TransformReservation {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransformReservation.class);


    /**
     * Transform reservation to DTO.
     *
     * @param reservation
     *     the reservation
     * @return the reservation DTO
     */
    public static ReservationDTO transformReservationToDTO(Reservation reservation) {
        LOGGER.info("INI  | transformReservationToDTO. Reservation = {} ", reservation);

        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setCar(TransformCar.transformCarToDTO(reservation.getCar()));
        reservationDTO.setCustomer(TransformCustomer.transformCustomerToDTO(reservation.getCustomer()));
        reservationDTO.setStartDate(reservation.getStartdate().toString());
        reservationDTO.setEndDate(reservation.getEnddate().toString());
        reservationDTO.setReservationPrice(String.valueOf(reservation.getReservationprice()));

        LOGGER.info("End  | transformReservationToDTO");

        return reservationDTO;
    }

}
