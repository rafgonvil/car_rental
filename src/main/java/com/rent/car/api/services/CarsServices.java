package com.rent.car.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rent.car.api.repository.CarsRepository;
import com.rent.car.model.persistence.Cars;

@Service
public class CarsServices {

    @Autowired
    private CarsRepository carRepository;

    public Cars getCarFromDatabase(String carId) {


        return carRepository.getOne(carId);
    }
}
