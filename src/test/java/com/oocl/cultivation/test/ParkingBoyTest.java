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
        Object fetched = parkingBoy.fetch(wrongCarTicket);

        //then
        assertEquals("Unrecognized parking ticket.", fetched);
    }
}
