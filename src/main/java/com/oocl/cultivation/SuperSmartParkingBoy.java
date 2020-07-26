package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends SmartParkingBoy{
  private final List<ParkingLot> parkingLots;

  public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }
}
