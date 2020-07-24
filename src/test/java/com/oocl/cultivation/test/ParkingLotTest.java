package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_return_car_ticket_when_park_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket carTicket = parkingLot.park(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_fetch_car_when_fetch_car_given_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        CarTicket carTicket = parkingLot.park(car);

        //when
        Car fetchedCar = parkingLot.fetch(carTicket);

        //then
        assertNotNull(fetchedCar);
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_fetch_car_when_park_multiple_cars_given_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car carOne = new Car();
        Car carTwo = new Car();
        CarTicket carTicketOne = parkingLot.park(carOne);
        CarTicket carTicketTwo = parkingLot.park(carTwo);

        //when
        Car fetchedCarOne = parkingLot.fetch(carTicketOne);
        Car fetchedCarTwo = parkingLot.fetch(carTicketTwo);

        //then
        assertNotNull(fetchedCarOne);
        assertNotNull(fetchedCarTwo);
        assertNotEquals(fetchedCarOne, fetchedCarTwo);
    }

    @Test
    void should_fetch_car_when_fetch_car_given_correspond_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        CarTicket carTicket = parkingLot.park(car);

        //when
        Car fetchedCar = parkingLot.fetch(carTicket);

        //then
        assertNotNull(fetchedCar);
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_not_fetch_car_when_fetch_car_given_wrong_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        parkingLot.park(car);
        CarTicket wrongCarTicket = new CarTicket();

        //when
        Car fetchedCar = parkingLot.fetch(wrongCarTicket);

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_not_fetch_car_when_fetch_car_given_null_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        parkingLot.park(car);

        //when
        Car fetchedCar = parkingLot.fetch(null);

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_not_fetch_car_when_fetch_car_given_used_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        CarTicket carTicket = parkingLot.park(car);

        //when
        Car fetchedCar = parkingLot.fetch(carTicket);
        Car fetchedAgainCar = parkingLot.fetch(carTicket);

        //then
        assertNotNull(fetchedCar);
        assertNull(fetchedAgainCar);
    }

    @Test
    void should_return_null_car_ticket_when_have_no_capacity_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        int capacity = 10;
        for (int i = 0; i < capacity; i++) {
            parkingLot.park(new Car());
        }
        Car car = new Car();

        //when
        CarTicket carTicket = parkingLot.park(car);

        //then
        assertNull(carTicket);
    }
}
