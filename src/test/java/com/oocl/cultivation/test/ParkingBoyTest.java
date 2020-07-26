package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingBoyTest {

    @Test
    void should_return_error_msg_when_fetch_car_given_wrong_car_ticket() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(new Car());
        CarTicket wrongCarTicket = new CarTicket();

        //when
        Object fetchedResult = parkingBoy.fetch(wrongCarTicket);

        //then
        assertEquals("Unrecognized parking ticket.", fetchedResult);
    }

    @Test
    void should_return_error_msg_when_fetch_car_given_used_car_ticket() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        CarTicket carTicket = (CarTicket) parkingBoy.park(car);

        //when
        Object fetched = parkingBoy.fetch(carTicket);
        Object fetchedAgain = parkingBoy.fetch(carTicket);

        //then
        assertEquals(fetched, car);
        assertEquals("Unrecognized parking ticket.", fetchedAgain);
    }

    @Test
    void should_return_error_msg_when_fetch_car_given_null_car_ticket() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        CarTicket carTicket = (CarTicket) parkingBoy.park(car);

        //when
        Object fetchedWithCarTicket = parkingBoy.fetch(carTicket);
        Object fetchedWithoutCarTicket = parkingBoy.fetch(null);

        //then
        assertEquals(fetchedWithCarTicket, car);
        assertEquals("Please provide your parking ticket.", fetchedWithoutCarTicket);
    }

    @Test
    void should_return_error_msg_when_park_car_without_position_given_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car());
        }

        //when
        Object parkedResult = parkingBoy.park(new Car());

        // then
        assertEquals("Not enough position.", parkedResult);
    }

    @Test
    void should_park_into_second_parking_lot_when_first_full_given_car() {
        // given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car());
        }

        // when
        CarTicket carTicket = (CarTicket)parkingBoy.park(new Car());

        // then
        assertTrue(carTicket instanceof CarTicket);
    }
}
