package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartParkingBoyTest {

    @Test
    void should_park_into_more_empty_parking_lot_when_park_given_car() {
        // given
        ParkingLot parkingLotOne = new ParkingLot(1);
        ParkingLot parkingLotTwo = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLotOne, parkingLotTwo));

        // when
        smartParkingBoy.park(new Car());

        // then
        assertEquals(1, parkingLotOne.getEmptyPosition());
        assertEquals(1, parkingLotTwo.getEmptyPosition());
    }

    @Test
    void should_return_error_msg_when_all_parking_lots_full_given_car() {
        // given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(1)));
        smartParkingBoy.park(new Car());

        // when
        ParkResult parkResult = smartParkingBoy.park(new Car());

        // then
        assertEquals("Not enough position.", parkResult.getMessage());
    }
}
