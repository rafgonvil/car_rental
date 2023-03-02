/*
 * @autor:rgvillareal
 *
 */
package com.rent.car.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rent.car.api.repository.CarsRepository;
import com.rent.car.model.persistence.Car;

/**
 * The Class CarsServices.
 */
@Service
public class CarsServices {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarsServices.class);

    @Autowired
    private CarsRepository carRepository;

    /**
     * Gets the car from database.
     *
     * @param carId
     *     the car id
     * @return the car from database
     */
    public Car getCarFromDatabase(String carId) {
        LOGGER.info("INI  | getCarFromDatabase. carId = {} ", carId);

        return carRepository.getOne(carId);
    }
}
