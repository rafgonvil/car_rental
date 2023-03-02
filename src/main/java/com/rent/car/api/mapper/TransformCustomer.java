package com.rent.car.api.mapper;

import com.rent.car.model.dto.CustomerDTO;
import com.rent.car.model.persistence.Customer;

public class TransformCustomer {

    public static CustomerDTO transformToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCustomerId(customer.getCustomerid());
        customerDTO.setLoyaltyPoint(String.valueOf(customer.getPointsaccumulated()));
        // customerDTO.setReservationId(customer.getReservations());

        return customerDTO;
    }

}
