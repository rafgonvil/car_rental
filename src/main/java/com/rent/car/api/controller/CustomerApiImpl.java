/*
 * @autor:rgvillareal
 *
 */
package com.rent.car.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.rent.car.api.CustomerApi;
import com.rent.car.api.services.CustomerServices;
import com.rent.car.model.dto.ReservationSurchargesDTO;
import io.swagger.annotations.Api;

/**
 * The Class CustomerApiImpl.
 */
@Api(tags = "Customer")
@Controller
public class CustomerApiImpl implements CustomerApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerApiImpl.class);

    @Autowired
    private CustomerServices customerServices = new CustomerServices();

    /**
     * Gets the customer reservation.
     *
     * @param customerId
     *     the customer id
     * @return the customer reservation
     */
    @Override
    public ResponseEntity<ReservationSurchargesDTO> getCustomerReservation(Long customerId) {

        LOGGER.info("INI  | getCustomerReservation. body = {} ", customerId);

        ReservationSurchargesDTO reservationSurchargesDTO = new ReservationSurchargesDTO();

        try {
            reservationSurchargesDTO = customerServices.getCustomerReservations(customerId);
        } catch (Exception e) {

        }

        LOGGER.info("End  | getCustomerReservation");
        return new ResponseEntity<>(reservationSurchargesDTO, HttpStatus.OK);
    }


}
