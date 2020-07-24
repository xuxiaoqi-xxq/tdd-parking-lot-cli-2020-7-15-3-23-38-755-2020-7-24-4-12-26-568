package com.oocl.cultivation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private Map<CarTicket, Car> parkedCars = new HashMap<>();

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        parkedCars.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        return parkedCars.get(carTicket);
    }

    public List<CarTicket> parkMultiple(List<Car> cars) {
        return null;
    }
}
