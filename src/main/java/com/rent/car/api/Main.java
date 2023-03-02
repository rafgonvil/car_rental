/*
 * @autor:rgvillareal
 *
 */
package com.rent.car.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Class Main.
 */
@EnableJpaRepositories("com.rent.car.api.repository")
@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "com.rent.car.model.persistence")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
