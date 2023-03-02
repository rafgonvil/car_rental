package com.rent.car.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rent.car.model.persistence.Cars;

public interface CarsRepository extends JpaRepository<Cars, String> {


}
