/* Drop Tables */
DROP TABLE IF EXISTS car_rental.reservation;
DROP TABLE IF EXISTS car_rental.customer;
DROP TABLE IF EXISTS car_rental.cars;


/* Create Tables */
CREATE TABLE car_rental.reservation (
	reservationId bigint NOT NULL,
	carId text NOT NULL,
	customerId bigint NOT NULL,
	startDate date NOT NULL,
	endDate date DEFAULT NULL,
	reservationPrice decimal	 NOT NULL,
	finalPrice decimal	 DEFAULT NULL,
	penaltyPrice decimal	
	
)
;

CREATE TABLE car_rental.customer (
	customerId bigint NOT NULL,
	pointsAccumulated bigint NOT NULL
	
)
;

CREATE TABLE car_rental.cars (
	carId text NOT NULL,
	carType text NOT NULL,
	price bigint NOT NULL,
	loyaltyPoint bigint NOT NULL
)
;

-- Primary key
ALTER TABLE car_rental.reservation ADD CONSTRAINT pk_reservation PRIMARY KEY (reservationId);
ALTER TABLE car_rental.customer ADD CONSTRAINT pk_customer PRIMARY KEY (customerId);
ALTER TABLE car_rental.cars ADD CONSTRAINT pk_car PRIMARY KEY (carId);

-- Foreign keys
ALTER TABLE car_rental.reservation ADD CONSTRAINT fk_car FOREIGN KEY (carId) REFERENCES car_rental.cars(carId) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE car_rental.reservation ADD CONSTRAINT fk_customer FOREIGN KEY (customerId) REFERENCES car_rental.customer(customerId) ON DELETE CASCADE ON UPDATE CASCADE;

-- Drop Sequences
DROP SEQUENCE IF EXISTS car_rental.CUSTOMER_ID_SEQ;
DROP SEQUENCE IF EXISTS car_rental.RESERVATION_ID_SEQ;


CREATE SEQUENCE car_rental.CUSTOMER_ID_SEQ INCREMENT 1 START 2;
ALTER TABLE car_rental.customer ALTER COLUMN customerId SET DEFAULT NEXTVAL('car_rental.CUSTOMER_ID_SEQ');

CREATE SEQUENCE reservation_id_seq INCREMENT BY 1 START WITH 2 NO MAXVALUE NO CYCLE;
ALTER TABLE car_rental.reservation ALTER COLUMN reservationId SET DEFAULT NEXTVAL('reservation_id_seq');

-- Uniques
ALTER TABLE car_rental.cars ADD CONSTRAINT const_car_key UNIQUE (carId);
ALTER TABLE car_rental.customer ADD CONSTRAINT const_customer_key UNIQUE (customerId);
ALTER TABLE car_rental.reservation ADD CONSTRAINT const_reservation_key UNIQUE (reservationId);

