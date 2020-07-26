package com.oocl.cultivation;

public class ParkingBoy {


    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public CarTicket park(Car car) {
        return null;
    }

    public Object fetch(CarTicket carTicket) {
        return "Unrecognized parking ticket.";
    }
}
