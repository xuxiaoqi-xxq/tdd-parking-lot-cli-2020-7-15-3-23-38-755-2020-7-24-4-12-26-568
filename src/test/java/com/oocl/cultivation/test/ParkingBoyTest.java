package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyTest {

    @Test
    void should_return_error_msg_when_fetch_car_given_wrong_car_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);

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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);

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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car());
        }

        //when
        Object parkedResult = parkingBoy.park(new Car());

        // then
        assertEquals("Not enough position.", parkedResult);
    }
}
