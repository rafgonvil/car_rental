/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.12).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.rent.car.api;

import com.rent.car.model.dto.CollectionCarsReservations;
import com.rent.car.model.dto.CollectionReservations;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-03-02T18:34:06.332+01:00")

@Api(value = "reservation", description = "the reservation API")
@RequestMapping(value = "")
public interface ReservationApi {

    Logger log = LoggerFactory.getLogger(ReservationApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Reservate a car", nickname = "reservateCar", notes = "Reservate a car", response = CollectionReservations.class, tags={ "Reservation", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = CollectionReservations.class),
        @ApiResponse(code = 201, message = "CREATED"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/reservation",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<CollectionReservations> _reservateCar(@ApiParam(value = "Reservation" ,required=true )  @Valid @RequestBody CollectionCarsReservations reservation) {
        return reservateCar(reservation);
    }

    // Override this method
    default ResponseEntity<CollectionReservations> reservateCar(CollectionCarsReservations reservation) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"items\" : [ {    \"car\" : {      \"carType\" : \"carType\",      \"price\" : 0,      \"carId\" : \"carId\"    },    \"endDate\" : \"endDate\",    \"reservationPrice\" : \"reservationPrice\",    \"penaltyPrice\" : \"penaltyPrice\",    \"finalPrice\" : \"finalPrice\",    \"startDate\" : \"startDate\",    \"customer\" : {      \"customerId\" : 6,      \"loyalty_point\" : \"loyalty_point\"    }  }, {    \"car\" : {      \"carType\" : \"carType\",      \"price\" : 0,      \"carId\" : \"carId\"    },    \"endDate\" : \"endDate\",    \"reservationPrice\" : \"reservationPrice\",    \"penaltyPrice\" : \"penaltyPrice\",    \"finalPrice\" : \"finalPrice\",    \"startDate\" : \"startDate\",    \"customer\" : {      \"customerId\" : 6,      \"loyalty_point\" : \"loyalty_point\"    }  } ]}", CollectionReservations.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ReservationApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
