package com.rent.car.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.rent.car.api.ReservationApi;
import com.rent.car.api.mapper.TransformReservation;
import com.rent.car.api.services.ReservationServices;
import com.rent.car.model.dto.CollectionCarsReservations;
import com.rent.car.model.dto.CollectionReservations;
import com.rent.car.model.dto.ReservationDTO;
import com.rent.car.model.persistence.Reservation;
import io.swagger.annotations.Api;

@Api(tags = "Reservation")
@Controller
public class ReservationApiImpl implements ReservationApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationApiImpl.class);

    @Autowired
    private ReservationServices reservationServices = new ReservationServices();


    @Override
    public ResponseEntity<CollectionReservations> reservateCar(CollectionCarsReservations collectionCarsReservations) {
        LOGGER.info("INI  | reservateCar. body = {} ", collectionCarsReservations);
        CollectionReservations collectionReservations = new CollectionReservations();

        for (String carId : collectionCarsReservations.getCars()) {

            try {
                Reservation reservationSaved =
                    reservationServices
                        .saveReservation(
                            carId,
                            collectionCarsReservations.getCustomerId(),
                            collectionCarsReservations.getEndDate());
                ReservationDTO reservationDTOSaved = TransformReservation.transformToDTO(reservationSaved);
                collectionReservations.addItemsItem(reservationDTOSaved);
            } catch (Exception e) {

            }
        }
        HttpStatus httpStatus = HttpStatus.OK;

        LOGGER.info("End  | reservateCar");
        return new ResponseEntity<>(collectionReservations, httpStatus);
    }
}
