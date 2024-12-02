package com.bluemoon.model;

public class Vehicle {
    private String vehicleId;
    private String householdId;
    private String type; // "motorbike" or "car"
    private double fee;

    public Vehicle(String vehicleId, String householdId, String type, double fee) {
        this.vehicleId = vehicleId;
        this.householdId = householdId;
        this.type = type;
        this.fee = fee;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", householdId='" + householdId + '\'' +
                ", type='" + type + '\'' +
                ", fee=" + fee +
                '}';
    }
}