/*
 * @autor:rgvillareal
 *
 */
package com.rent.car.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rent.car.model.persistence.Car;

/**
 * The Interface CarsRepository.
 */
public interface CarsRepository extends JpaRepository<Car, String> {


}
