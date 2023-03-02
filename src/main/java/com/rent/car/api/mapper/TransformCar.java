package com.rent.car.api.mapper;

import com.rent.car.model.dto.CarDTO;
import com.rent.car.model.persistence.Cars;

public class TransformCar {

    public static Cars transformToData(CarDTO carDTO) {
        Cars car = new Cars();

        car.setCarid(carDTO.getCarId());
        car.setCartype(carDTO.getCarType());
        car.setPrice(new Long(0));
        return car;
    }

    public static CarDTO transformToDTO(Cars car) {
        CarDTO carDTO = new CarDTO();

        carDTO.setCarId(car.getCarid());
        carDTO.setCarType(car.getCartype());
        carDTO.setPrice(car.getPrice());

        return carDTO;
    }

}
