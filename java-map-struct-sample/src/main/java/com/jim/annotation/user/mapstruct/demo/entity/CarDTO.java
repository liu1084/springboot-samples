package com.jim.annotation.user.mapstruct.demo.entity;
public class CarDTO {
    private String make;
    private int seatCount;
    private String type;

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "make='" + make + '\'' +
                ", seatCount=" + seatCount +
                ", type='" + type + '\'' +
                '}';
    }
}
