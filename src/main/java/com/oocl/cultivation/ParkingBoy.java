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
        if(carTicket == null) {
            return "Please provide your parking ticket.";
        }
        Car car = parkingLot.fetch(carTicket);
        return car == null ? "Unrecognized parking ticket." : car;
    }
}
