/*
 * @autor:rgvillareal
 *
 */
package com.rent.car.api.mapper;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rent.car.model.dto.ReservationCalcualtedDTO;
import com.rent.car.model.dto.ReservationSurchargesDTO;
import com.rent.car.model.persistence.Customer;
import com.rent.car.model.persistence.Reservation;

/**
 * The Class TransformCustomerReservations.
 */
public class TransformCustomerReservations {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransformCar.class);


    /**
     * Transform customer reservation to DTO.
     *
     * @param customer
     *     the customer
     * @return the reservation surcharges DTO
     */
    public static ReservationSurchargesDTO transformCustomerReservationToDTO(Customer customer) {
        LOGGER.info("INI  | transformCustomerReservationToDTO. Customer = {} ", customer);

        ReservationSurchargesDTO reservationSurchargesDTO = new ReservationSurchargesDTO();

        reservationSurchargesDTO.setCustomer(TransformCustomer.transformCustomerToDTO(customer));

        List<ReservationCalcualtedDTO> reservationsDTO = new ArrayList<>();

        for (Reservation reservation : customer.getReservations()) {
            ReservationCalcualtedDTO reservationCalcualtedDTO = new ReservationCalcualtedDTO();

            reservationCalcualtedDTO.setCar(TransformCar.transformCarToDTO(reservation.getCar()));
            reservationCalcualtedDTO.setStartDate(reservation.getStartdate().toString());
            reservationCalcualtedDTO.setEndDate(reservation.getEnddate().toString());
            reservationCalcualtedDTO.setReservationPrice(String.valueOf(reservation.getReservationprice()));
            reservationCalcualtedDTO.setPenaltyPrice(reservation.getPenaltyprice().toString());
            reservationCalcualtedDTO.setFinalPrice(reservation.getFinalprice().toString());

            reservationsDTO.add(reservationCalcualtedDTO);
        }

        reservationSurchargesDTO.setReservations(reservationsDTO);
        LOGGER.info("End  | transformCustomerReservationToDTO");
        return reservationSurchargesDTO;
    }

}
