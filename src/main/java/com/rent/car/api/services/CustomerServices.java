/*
 * @autor:rgvillareal
 *
 */
package com.rent.car.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rent.car.api.mapper.TransformCustomerReservations;
import com.rent.car.api.repository.CustomerRepository;
import com.rent.car.model.dto.ReservationSurchargesDTO;
import com.rent.car.model.persistence.Customer;
import com.rent.car.model.persistence.Reservation;

/**
 * The Class CustomerServices.
 */
@Service
public class CustomerServices {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServices.class);

    @Autowired
    private ReservationServices reservationServices;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Gets the customer.
     *
     * @param customerId
     *     the long 1
     * @return the customer
     */
    public Customer getCustomer(Long customerId) {
        LOGGER.info("INI  | getCustomer. customerId = {} ", customerId);
        return customerRepository.getOne(customerId);
    }

    /**
     * Sets the points.
     *
     * @param customer
     *     the customer
     * @param points
     *     the points
     */
    public void setPoints(Customer customer, int points) {
        LOGGER.info("INI  | setPoints. customer = {} , points = {}", customer, points);
        customer.setPointsaccumulated(customer.getPointsaccumulated() + points);

        customerRepository.save(customer);
    }

    /**
     * Gets the customer reservations.
     *
     * @param customerId
     *     the customer id
     * @return the customer reservations
     */
    public ReservationSurchargesDTO getCustomerReservations(Long customerId) {
        LOGGER.info("INI  | getCustomerReservations. customerId = {} ", customerId);
        // Retrieving customer
        Customer customer = new Customer();

        customer = getCustomer(customerId);

        // Retrieving Customer's reservations
        for (Reservation reservation : customer.getReservations()) {
            // Calculate penaltyPrice and final price
            reservationServices.fullFilledPrice(reservation);
        }
        LOGGER.info("End  | getCustomerReservations");
        return TransformCustomerReservations.transformCustomerReservationToDTO(customer);
    }
}
