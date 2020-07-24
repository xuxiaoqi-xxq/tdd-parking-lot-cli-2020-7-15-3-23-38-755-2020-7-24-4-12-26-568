package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

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
    void should_return_car_tickets_when_park_multiple_cars_given_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car carOne = new Car();
        Car carTwo = new Car();

        //when
        CarTicket carTicketOne = parkingLot.park(carOne);
        CarTicket carTicketTwo = parkingLot.park(carTwo);

        //then
        assertNotNull(carTicketOne);
        assertNotNull(carTicketOne);
        assertNotEquals(carTicketOne, carTicketTwo);
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
}
