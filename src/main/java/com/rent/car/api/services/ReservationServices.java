/*
 * @autor:rgvillareal
 *
 */
package com.rent.car.api.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rent.car.api.repository.ReservationRepository;
import com.rent.car.api.utils.Constants;
import com.rent.car.model.persistence.Car;
import com.rent.car.model.persistence.Customer;
import com.rent.car.model.persistence.Reservation;

/**
 * The Class ReservationServices.
 */
@Service
public class ReservationServices {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServices.class);

    @Autowired
    private CustomerServices customerServices;

    @Autowired
    private CarsServices carsServices;

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * Save reservation.
     *
     * @param carId
     *     the car id
     * @param customerId
     *     the long 1
     * @param endDate
     *     the end date
     * @return the reservation
     */
    public Reservation saveReservation(String carId, Long customerId, String endDate) {
        LOGGER.info("INI  | saveReservation. car = {}, customerId = {}, endDate = {} ", carId, customerId, endDate);
        Reservation reservationData = new Reservation();
        // Retrieving customer
        try {
            Customer customer = customerServices.getCustomer(customerId);

            // Retrieving car
            Car car = carsServices.getCarFromDatabase(carId);

            // Set reservation params
            reservationData.setCar(car);
            reservationData.setCustomer(customer);
            reservationData.setStartdate(new Date());
            reservationData.setEnddate(new SimpleDateFormat("dd/MM/yyyy").parse(endDate));

            // Calculate reservation Price
            reservationData
                .setReservationprice(
                    calculateReservationPrice(
                        car,
                        customer,
                        TimeUnit.MILLISECONDS
                            .toDays(reservationData.getEnddate().getTime() - reservationData.getStartdate().getTime()) +
                            1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LOGGER.info("End  | saveReservation");
        return reservationRepository.save(reservationData);
    }

    /**
     * Calculate reservation price.
     *
     * @param car
     *     the car
     * @param customer
     *     the customer
     * @param days
     *     the days
     * @return the double
     */
    private Double calculateReservationPrice(Car car, Customer customer, long days) {
        LOGGER.info("INI  | calculateReservationPrice. car = {}, customer = {}, endDate = {} ", car, customer, days);
        Double result = 0.0;
        switch (car.getCartype()) {
            case Constants.CAR_TYPE_PREMIUM:
                result = getPremiumPrice(days, car.getPrice());
                customerServices.setPoints(customer, 5);
                break;
            case Constants.CAR_TYPE_SUV:
                result = getSuvPrice(days, car.getPrice());
                customerServices.setPoints(customer, 3);
                break;
            case Constants.CAR_TYPE_SMALL:
                result = getSmallPrice(days, car.getPrice());
                customerServices.setPoints(customer, 1);
                break;
            default:
                break;
        }
        LOGGER.info("End  | calculateReservationPrice");
        return result;
    }

    /**
     * Gets the premium price.
     *
     * @param days
     *     the days
     * @param price
     *     the price
     * @return the premium price
     */
    private Double getPremiumPrice(long days, long price) {
        LOGGER.info("INI  | getPremiumPrice. days = {}, price = {}", days, price);
        return Double.valueOf(days * price);
    }

    /**
     * Gets the suv price.
     *
     * @param days
     *     the days
     * @param price
     *     the price
     * @return the suv price
     */
    private Double getSuvPrice(long days, long price) {
        LOGGER.info("INI  | getSuvPrice. days = {}, price = {}", days, price);
        Double reservationPrice;
        if (days <= 7) {
            reservationPrice = Double.valueOf(days * price);
        } else if (days >= 7 && days <= 30) {
            reservationPrice = Double.valueOf(7 * price) + ((price * 0.8) * (days - 7));
        } else {
            reservationPrice = Double.valueOf(7 * price) + ((price * 0.8) * 23) + ((price * 0.5) * (days - 30));
        }
        LOGGER.info("End  | getSuvPrice");
        return reservationPrice;
    }

    /**
     * Gets the small price.
     *
     * @param days
     *     the days
     * @param price
     *     the price
     * @return the small price
     */
    private Double getSmallPrice(long days, long price) {
        LOGGER.info("INI  | getSmallPrice. days = {}, price = {}", days, price);
        Double reservationPrice;
        if (days <= 7) {
            reservationPrice = Double.valueOf(days * price);
        } else {
            reservationPrice = Double.valueOf(7 * price) + ((price * 0.6) * (days - 7));
        }
        LOGGER.info("End  | getSmallPrice");
        return reservationPrice;
    }

    /**
     * Full filled price.
     *
     * @param reservation
     *     the reservation
     */
    public void fullFilledPrice(Reservation reservation) {
        LOGGER.info("INI  | fullFilledPrice. Reservation = {}", reservation);
        switch (reservation.getCar().getCartype()) {
            case Constants.CAR_TYPE_PREMIUM:

                getPremiumPriceWithSurcharges(
                    reservation,
                    TimeUnit.MILLISECONDS.toDays(new Date().getTime() - reservation.getEnddate().getTime()));
                break;
            case Constants.CAR_TYPE_SUV:
                getSUVPriceWithSurcharges(
                    reservation,
                    TimeUnit.MILLISECONDS.toDays(new Date().getTime() - reservation.getEnddate().getTime()));
                break;
            case Constants.CAR_TYPE_SMALL:
                getSmallPriceWithSurcharges(
                    reservation,
                    TimeUnit.MILLISECONDS.toDays(new Date().getTime() - reservation.getEnddate().getTime()));
                break;
            default:
                break;

        }
        LOGGER.info("End  | fullFilledPrice");
    }

    /**
     * Gets the premium price with surcharges.
     *
     * @param reservation
     *     the reservation
     * @param extraDays
     *     the extra days
     * @return the premium price with surcharges
     */
    private void getPremiumPriceWithSurcharges(Reservation reservation, long extraDays) {
        LOGGER
            .info(
                "INI  | getPremiumPriceWithSurcharges. reservation = {}, extraDays = {}, endDate = {} ",
                reservation,
                extraDays);
        if (extraDays > 0) {
            Double penaltyPrice = (reservation.getCar().getPrice() * 1.2) * extraDays;

            // Calculate penalty Price
            reservation.setPenaltyprice(penaltyPrice);
            reservation.setFinalprice(reservation.getReservationprice() + penaltyPrice);
        } else {
            reservation.setPenaltyprice(0.0);
            reservation.setFinalprice(reservation.getReservationprice());
        }
        LOGGER.info("End  | getPremiumPriceWithSurcharges");
    }

    /**
     * Gets the SUV price with surcharges.
     *
     * @param reservation
     *     the reservation
     * @param extraDays
     *     the extra days
     * @return the SUV price with surcharges
     */
    private void getSUVPriceWithSurcharges(Reservation reservation, long extraDays) {
        LOGGER.info("INI  | getSUVPriceWithSurcharges. reseervation = {}, extraDays = {} ", reservation, extraDays);
        if (extraDays > 0) {
            Double penaltyPrice = (reservation.getCar().getPrice() + (Constants.CAR_PRICE_SMALL * 0.6)) * extraDays;

            // Calculate penalty Price
            reservation.setPenaltyprice(penaltyPrice);
            reservation.setFinalprice(reservation.getReservationprice() + penaltyPrice);
        } else {
            reservation.setPenaltyprice(0.0);
            reservation.setFinalprice(reservation.getReservationprice());
        }
        LOGGER.info("End  | getSUVPriceWithSurcharges");
    }

    /**
     * Gets the small price with surcharges.
     *
     * @param reservation
     *     the reservation
     * @param extraDays
     *     the extra days
     * @return the small price with surcharges
     */
    private void getSmallPriceWithSurcharges(Reservation reservation, long extraDays) {
        LOGGER.info("INI  | getSmallPriceWithSurcharges. reservation = {}, extraDays = {}", reservation, extraDays);
        Double penaltyPrice = (reservation.getCar().getPrice() * 1.3) * extraDays;
        if (extraDays > 0) {
            // Calculate penalty Price
            reservation.setPenaltyprice(penaltyPrice);
            reservation.setFinalprice(reservation.getReservationprice() + penaltyPrice);
        } else {
            reservation.setPenaltyprice(0.0);
            reservation.setFinalprice(reservation.getReservationprice());
        }
        LOGGER.info("End  | getSmallPriceWithSurcharges");
    }
}
