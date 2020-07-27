package com.oocl.cultivation;

public class ParkResult {

    private CarTicket carTicket;

    private String message;

    public ParkResult(CarTicket carTicket, String message) {
        this.carTicket = carTicket;
        this.message = message;
    }

    public CarTicket getCarTicket() {
        return carTicket;
    }

    public String getMessage() {
        return message;
    }
}
