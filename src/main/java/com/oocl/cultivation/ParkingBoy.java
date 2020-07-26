package com.oocl.cultivation;

public class ParkingBoy {


    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public CarTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Object fetch(CarTicket carTicket) {
        Car car = parkingLot.fetch(carTicket);
        if (car == null) {
            return "Unrecognized parking ticket.";
        }
        return car;
    }
}
