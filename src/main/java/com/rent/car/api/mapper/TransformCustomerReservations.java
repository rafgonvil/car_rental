package com.rent.car.api.mapper;

import java.util.ArrayList;
import java.util.List;
import com.rent.car.model.dto.ReservationCalcualtedDTO;
import com.rent.car.model.dto.ReservationSurchargesDTO;
import com.rent.car.model.persistence.Customer;
import com.rent.car.model.persistence.Reservation;

public class TransformCustomerReservations {

    public static ReservationSurchargesDTO transformToDTO(Customer customer) {

        ReservationSurchargesDTO reservationSurchargesDTO = new ReservationSurchargesDTO();

        reservationSurchargesDTO.setCustomer(TransformCustomer.transformToDTO(customer));

        List<ReservationCalcualtedDTO> reservationsDTO = new ArrayList<>();

        for (Reservation reservation : customer.getReservations()) {
            ReservationCalcualtedDTO reservationCalcualtedDTO = new ReservationCalcualtedDTO();

            reservationCalcualtedDTO.setCar(TransformCar.transformToDTO(reservation.getCars()));
            reservationCalcualtedDTO.setStartDate(reservation.getStartdate().toString());
            reservationCalcualtedDTO.setEndDate(reservation.getEnddate().toString());
            reservationCalcualtedDTO.setReservationPrice(String.valueOf(reservation.getReservationprice()));
            reservationCalcualtedDTO.setPenaltyPrice(reservation.getPenaltyprice().toString());
            reservationCalcualtedDTO.setFinalPrice(reservation.getFinalprice().toString());

            reservationsDTO.add(reservationCalcualtedDTO);
        }

        reservationSurchargesDTO.setReservations(reservationsDTO);

        return reservationSurchargesDTO;
    }

}
