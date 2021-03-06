package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy() {
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkResult park(Car car) {
        ParkingLot maxPositionParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot: parkingLots) {
            if (parkingLot.getEmptyPosition() > maxPositionParkingLot.getEmptyPosition()) {
                maxPositionParkingLot = parkingLot;
            }
        }
        return maxPositionParkingLot.park(car);
    }
}
