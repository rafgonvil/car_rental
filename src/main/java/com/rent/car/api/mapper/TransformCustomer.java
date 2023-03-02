/*
 * @autor:rgvillareal
 *
 */
package com.rent.car.api.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rent.car.model.dto.CustomerDTO;
import com.rent.car.model.persistence.Customer;

public class TransformCustomer {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(TransformCustomer.class);


    /**
     * Transform customer to DTO.
     *
     * @param customer
     *     the customer
     * @return the customer DTO
     */
    public static CustomerDTO transformCustomerToDTO(Customer customer) {
        LOGGER.info("INI  | transformCustomerToDTO. customer = {} ", customer);
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCustomerId(customer.getCustomerid());
        customerDTO.setLoyaltyPoint(String.valueOf(customer.getPointsaccumulated()));

        LOGGER.info("End  | transformCustomerToDTO");
        return customerDTO;
    }

}
