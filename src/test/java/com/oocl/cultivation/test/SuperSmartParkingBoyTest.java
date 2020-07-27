package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuperSmartParkingBoyTest {

    @Test
    void should_park_into_larger_available_parking_lot_when_park_given_car() throws NoSuchFieldException {
        // given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotOne = new ParkingLot();
        parkingLotOne.park(new Car());
        ParkingLot parkingLotTwo = new ParkingLot();
        parkingLotTwo.park(new Car());
        parkingLotTwo.park(new Car());
        parkingLots.add(parkingLotOne);
        parkingLots.add(parkingLotTwo);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        // when
        superSmartParkingBoy.park(new Car());

        // then
        assertEquals(8, parkingLotOne.getEmptyPosition());
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
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        // when
        Object parkResult = superSmartParkingBoy.park(new Car());

        // then
        assertEquals("Not enough position.", parkResult);
    }
}
