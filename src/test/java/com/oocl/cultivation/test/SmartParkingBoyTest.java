package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartParkingBoyTest {

    @Test
    void should_park_into_more_empty_parking_lot_when_park_given_car() throws NoSuchFieldException {
        // given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotOne = new ParkingLot();
        parkingLotOne.park(new Car());
        ParkingLot parkingLotTwo = new ParkingLot();
        parkingLotTwo.park(new Car());
        parkingLotTwo.park(new Car());
        parkingLots.add(parkingLotOne);
        parkingLots.add(parkingLotTwo);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        // when
        CarTicket carTicket = (CarTicket)smartParkingBoy.park(new Car());

        // then
        assertTrue(carTicket instanceof CarTicket);
    }

    @Test
    void should_return_error_msg_when_all_parking_lots_full_given_car() throws NoSuchFieldException {
        // given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotOne = new ParkingLot();
        for (int i = 0; i < 10; i++) {
            parkingLotOne.park(new Car());
        }
        ParkingLot parkingLotTwo = new ParkingLot();
        for (int i = 0; i < 10; i++) {
            parkingLotTwo.park(new Car());
        }
        parkingLots.add(parkingLotOne);
        parkingLots.add(parkingLotTwo);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        // when
        Object parkResult = smartParkingBoy.park(new Car());

        // then
        assertEquals("Not enough position.", parkResult);
    }
}
