package com.oocl.cultivation;

public class FetchResult {
    private String message;
    private Car car;

    public FetchResult(Car car,String message) {
        this.car = car;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public Car getCar() {
        return this.car;
    }
}
