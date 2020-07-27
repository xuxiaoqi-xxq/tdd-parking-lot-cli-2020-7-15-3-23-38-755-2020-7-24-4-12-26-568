package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLots;

    public ParkingBoy() {
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkResult park(Car car) {
        ParkResult parkResult = null;
        for (ParkingLot parkingLot: parkingLots) {
            if ((parkResult = parkingLot.park(car)) != null) {
                break;
            }
        }
        return parkResult;
    }

    public Object fetch(CarTicket carTicket) {
        if (carTicket == null) {
            return "Please provide your parking ticket.";
        }
        Car car = null;
        for (ParkingLot parkingLot: parkingLots) {
            if((car = parkingLot.fetch(carTicket)) != null) {
                break;
            }
        }
        return car == null ? "Unrecognized parking ticket." : car;
    }
}
