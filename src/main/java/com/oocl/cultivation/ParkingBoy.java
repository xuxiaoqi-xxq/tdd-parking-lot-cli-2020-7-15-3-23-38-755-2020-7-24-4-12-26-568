package com.oocl.cultivation;

public class ParkingBoy {


    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Object park(Car car) {
        CarTicket carTicket = parkingLot.park(car);
        return carTicket == null ? "Not enough position." : carTicket;
    }

    public Object fetch(CarTicket carTicket) {
        if(carTicket == null) {
            return "Please provide your parking ticket.";
        }
        Car car = parkingLot.fetch(carTicket);
        return car == null ? "Unrecognized parking ticket." : car;
    }
}
