-- Tabla Customer
INSERT INTO car_rental.customer (customerid, pointsAccumulated) VALUES(1, 0);

-- Tabla Cars
INSERT INTO car_rental.cars (carId, carType, price, loyaltyPoint) VALUES('BMW 7','Premium', 300, 5);
INSERT INTO car_rental.cars (carId, carType, price, loyaltyPoint) VALUES('Kia Sorendo','SUV', 150, 3);
INSERT INTO car_rental.cars (carId, carType, price, loyaltyPoint) VALUES('Nissan Juke','SUV', 150, 3);
INSERT INTO car_rental.cars (carId, carType, price, loyaltyPoint) VALUES('Seat Ibiza', 'small', 50, 3);

-- Tabla Reservation
INSERT INTO car_rental.reservation (reservationid,carId, customerId, startDate, endDate, reservationPrice) VALUES(1,'Kia Sorendo', 1, '20/02/2023','22/02/2023', '100');
