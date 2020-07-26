package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public Object park(Car car) {
        ParkingLot maxPositionParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot: parkingLots) {
            if (parkingLot.getEmptyPosition() > maxPositionParkingLot.getEmptyPosition()) {
                maxPositionParkingLot = parkingLot;
            }
        }
        CarTicket carTicket = maxPositionParkingLot.park(car);
        return carTicket == null ? "Not enough position." : carTicket;
    }
}
