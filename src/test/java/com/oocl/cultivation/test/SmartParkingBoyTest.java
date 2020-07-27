package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartParkingBoyTest {

    @Test
    void should_park_into_more_empty_parking_lot_when_park_given_car() {
        // given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotOne = new ParkingLot(10);
        parkingLotOne.park(new Car());
        ParkingLot parkingLotTwo = new ParkingLot(10);
        parkingLotTwo.park(new Car());
        parkingLotTwo.park(new Car());
        parkingLots.add(parkingLotOne);
        parkingLots.add(parkingLotTwo);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        // when
        smartParkingBoy.park(new Car());

        // then
        assertEquals(8, parkingLotOne.getEmptyPosition());
    }

    @Test
    void should_return_error_msg_when_all_parking_lots_full_given_car() {
        // given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotOne = new ParkingLot(1);
        parkingLotOne.park(new Car());
        parkingLots.add(parkingLotOne);
        ParkingLot parkingLotTwo = new ParkingLot(1);
        parkingLotTwo.park(new Car());
        parkingLots.add(parkingLotTwo);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        // when
        Object parkResult = smartParkingBoy.park(new Car());

        // then
        assertEquals("Not enough position.", parkResult);
    }
}
