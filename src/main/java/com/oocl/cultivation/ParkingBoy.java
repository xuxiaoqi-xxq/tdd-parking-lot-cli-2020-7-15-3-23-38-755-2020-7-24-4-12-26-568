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
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.getEmptyPosition() > 0)
                .findFirst()
                .orElse(parkingLots.get(0))
                .park(car);
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
