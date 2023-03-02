package com.rent.car.api.mapper;

import com.rent.car.model.dto.ReservationDTO;
import com.rent.car.model.persistence.Reservation;

public class TransformReservation {

    public static Reservation transformToData(ReservationDTO reservationDTO) {

        Reservation reservation = new Reservation();

        reservation.setEnddate(null);


        return reservation;
    }

    public static ReservationDTO transformToDTO(Reservation reservation) {

        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setCar(TransformCar.transformToDTO(reservation.getCars()));
        reservationDTO.setCustomer(TransformCustomer.transformToDTO(reservation.getCustomer()));
        reservationDTO.setStartDate(reservation.getStartdate().toString());
        reservationDTO.setEndDate(reservation.getEnddate().toString());
        reservationDTO.setReservationPrice(String.valueOf(reservation.getReservationprice()));

        return reservationDTO;
    }

}
