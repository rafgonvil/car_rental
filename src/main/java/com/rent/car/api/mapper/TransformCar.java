/*
 * @autor:rgvillareal
 *
 */
package com.rent.car.api.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rent.car.model.dto.CarDTO;
import com.rent.car.model.persistence.Car;

/**
 * The Class TransformCar.
 */
public class TransformCar {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransformCar.class);


    /**
     * Transform car to DTO.
     *
     * @param car
     *     the car
     * @return the car DTO
     */
    public static CarDTO transformCarToDTO(Car car) {
        LOGGER.info("INI  | transformCarToDTO. car = {} ", car);
        CarDTO carDTO = new CarDTO();

        carDTO.setCarId(car.getCarid());
        carDTO.setCarType(car.getCartype());
        carDTO.setPrice(car.getPrice());
        LOGGER.info("End  | transformCarToDTO");
        return carDTO;
    }

}
