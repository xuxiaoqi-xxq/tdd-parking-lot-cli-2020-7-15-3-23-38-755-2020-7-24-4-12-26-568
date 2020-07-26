package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends SmartParkingBoy{

    private final List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public Object park(Car car) {
        ParkingLot maxPositionParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot: parkingLots) {
            double availableRate = parkingLot.getEmptyPosition() / parkingLot.getCapacity();
            double maxAvailableRate = maxPositionParkingLot.getEmptyPosition() / maxPositionParkingLot.getCapacity();
            if (Double.compare(availableRate, maxAvailableRate) > 0) {
                maxPositionParkingLot = parkingLot;
            }
        }
        CarTicket carTicket = maxPositionParkingLot.park(car);
        return carTicket == null ? "Not enough position." : carTicket;
    }
}
