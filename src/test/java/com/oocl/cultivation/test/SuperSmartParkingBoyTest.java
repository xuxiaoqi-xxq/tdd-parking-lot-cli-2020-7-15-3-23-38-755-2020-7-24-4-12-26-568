package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {

    @Test
    void should_park_into_larger_available_parking_lot_when_park_given_car() {
        // given
        ParkingLot parkingLotOne = new ParkingLot(2);
        ParkingLot parkingLotTwo = new ParkingLot(3);
        parkingLotOne.park(new Car());
        parkingLotTwo.park(new Car());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(parkingLotOne, parkingLotTwo));

        // when
        superSmartParkingBoy.park(new Car());

        // then
        assertEquals(1, parkingLotOne.getEmptyPosition());
        assertEquals(1, parkingLotTwo.getEmptyPosition());
    }
}
