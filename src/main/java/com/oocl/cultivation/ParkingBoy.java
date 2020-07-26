package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {


    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Object park(Car car) {
        CarTicket carTicket = null;
        for (ParkingLot parkingLot: parkingLots) {
            if ((carTicket = parkingLot.park(car)) != null) {
                break;
            }
        }
        return carTicket == null ? "Not enough position." : carTicket;
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
