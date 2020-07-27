package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    void should_return_error_msg_when_all_parking_lots_full_given_car() {
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
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        // when
        ParkResult parkResult = superSmartParkingBoy.park(new Car());

        // then
        assertEquals("Not enough position.", parkResult.getMessage());
    }
}
