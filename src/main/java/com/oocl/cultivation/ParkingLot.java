package com.oocl.cultivation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private Map<CarTicket, Car> parkedCars = new HashMap<>();

    private int capacity = 10;

    public CarTicket park(Car car) {
        if (parkedCars.size() == capacity) {
            return null;
        }
        CarTicket carTicket = new CarTicket();
        parkedCars.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        return parkedCars.remove(carTicket);
    }

    public int getEmptyPosition() {
        return this.capacity - parkedCars.size();
    }

}
