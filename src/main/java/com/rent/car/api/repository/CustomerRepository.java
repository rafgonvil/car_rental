package com.rent.car.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rent.car.model.persistence.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Object> {


}
