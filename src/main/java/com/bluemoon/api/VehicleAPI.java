package com.bluemoon.api;

import com.bluemoon.manager.VehicleManager;
import com.bluemoon.model.Vehicle;

import java.util.List;

public class VehicleAPI {
    private VehicleManager vehicleManager;

    public VehicleAPI() {
        this.vehicleManager = new VehicleManager();
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleManager.getAllVehicles();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleManager.addVehicle(vehicle);
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicleManager.updateVehicle(vehicle);
    }

    public void deleteVehicle(String vehicleId) {
        vehicleManager.deleteVehicle(vehicleId);
    }

    public double calculateVehicleFee(String type) {
        return vehicleManager.calculateVehicleFee(type);
    }
}