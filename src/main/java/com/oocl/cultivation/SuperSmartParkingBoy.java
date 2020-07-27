package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends SmartParkingBoy {

    private final List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkResult park(Car car) {
        ParkingLot maxPositionParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            double availableRate = (double) parkingLot.getEmptyPosition() / parkingLot.getCapacity();
            double maxAvailableRate = (double) maxPositionParkingLot.getEmptyPosition() / maxPositionParkingLot.getCapacity();
            if (Double.compare(availableRate, maxAvailableRate) > 0) {
                maxPositionParkingLot = parkingLot;
            }
        }
        ParkResult parkResult = maxPositionParkingLot.park(car);
        return parkResult;
    }
}
