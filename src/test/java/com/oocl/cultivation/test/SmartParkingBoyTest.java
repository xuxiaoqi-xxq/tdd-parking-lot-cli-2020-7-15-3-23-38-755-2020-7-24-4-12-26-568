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
}
