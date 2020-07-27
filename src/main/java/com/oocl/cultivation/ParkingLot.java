package com.oocl.cultivation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private Map<CarTicket, Car> parkedCars = new HashMap<>();

    private int capacity;

    public ParkingLot() {
        this.capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkResult park(Car car) {
        if (parkedCars.size() == capacity) {
            return new ParkResult(null, null);
        }
        CarTicket carTicket = new CarTicket();
        parkedCars.put(carTicket, car);
        return new ParkResult(carTicket, null);
    }

    public Car fetch(CarTicket carTicket) {
        return parkedCars.remove(carTicket);
    }

    public int getEmptyPosition() {
        return this.capacity - parkedCars.size();
    }

    public int getCapacity() {
        return this.capacity;
    }

}
