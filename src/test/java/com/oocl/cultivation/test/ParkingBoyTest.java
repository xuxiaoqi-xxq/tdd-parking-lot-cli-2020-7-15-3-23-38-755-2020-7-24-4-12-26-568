package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        FetchResult fetchedResult = parkingBoy.fetch(wrongCarTicket);

        //then
        assertEquals("Unrecognized parking ticket.", fetchedResult.getMessage());
    }

    @Test
    void should_return_error_msg_when_fetch_car_given_used_car_ticket() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        ParkResult parkResult = parkingBoy.park(car);

        //when
        FetchResult fetched = parkingBoy.fetch(parkResult.getCarTicket());
        FetchResult fetchedAgain = parkingBoy.fetch(parkResult.getCarTicket());

        //then
        assertEquals(fetched.getCar(), car);
        assertEquals("Unrecognized parking ticket.", fetchedAgain.getMessage());
    }

    @Test
    void should_return_error_msg_when_fetch_car_given_null_car_ticket() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        ParkResult parkResult = parkingBoy.park(car);

        //when
        FetchResult fetchedWithCarTicket = parkingBoy.fetch(parkResult.getCarTicket());
        FetchResult fetchedWithoutCarTicket = parkingBoy.fetch(null);

        //then
        assertEquals(fetchedWithCarTicket.getCar(), car);
        assertEquals("Please provide your parking ticket.", fetchedWithoutCarTicket.getMessage());
    }

    @Test
    void should_return_error_msg_when_park_car_without_position_given_car() {
        //given

        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(1)));
        parkingBoy.park(new Car());


        //when
        ParkResult parkedResult = parkingBoy.park(new Car());

        // then
        assertEquals("Not enough position.", parkedResult.getMessage());
    }

    @Test
    void should_park_into_second_parking_lot_when_first_full_given_car() {
        // given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(new Car());

        // when
        ParkResult parkResult = parkingBoy.park(new Car());

        // then
        assertNotNull(parkResult.getCarTicket());
    }
}
