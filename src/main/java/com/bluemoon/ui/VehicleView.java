package com.bluemoon.ui;

import com.bluemoon.api.VehicleAPI;
import com.bluemoon.model.Vehicle;

import java.util.List;
import java.util.Scanner;

public class VehicleView {
    private Scanner scanner;
    private VehicleAPI vehicleAPI;

    public VehicleView() {
        this.scanner = new Scanner(System.in);
        this.vehicleAPI = new VehicleAPI();
    }

    public void displayVehicles() {
        List<Vehicle> vehicles = vehicleAPI.getAllVehicles();
        vehicles.forEach(System.out::println);
    }

    public void addVehicle() {
        System.out.println("=== Add Vehicle ===");
        System.out.print("Vehicle ID: ");
        String vehicleId = scanner.nextLine();
        System.out.print("Household ID: ");
        String householdId = scanner.nextLine();
        System.out.print("Type (motorbike/car): ");
        String type = scanner.nextLine();
        double fee = vehicleAPI.calculateVehicleFee(type);

        Vehicle vehicle = new Vehicle(vehicleId, householdId, type, fee);
        vehicleAPI.addVehicle(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    public void updateVehicle() {
        System.out.println("=== Update Vehicle ===");
        System.out.print("Vehicle ID: ");
        String vehicleId = scanner.nextLine();
        System.out.print("New Household ID: ");
        String householdId = scanner.nextLine();
        System.out.print("New Type (motorbike/car): ");
        String type = scanner.nextLine();
        double fee = vehicleAPI.calculateVehicleFee(type);

        Vehicle vehicle = new Vehicle(vehicleId, householdId, type, fee);
        vehicleAPI.updateVehicle(vehicle);
        System.out.println("Vehicle updated successfully.");
    }

    public void deleteVehicle() {
        System.out.println("=== Delete Vehicle ===");
        System.out.print("Vehicle ID: ");
        String vehicleId = scanner.nextLine();

        vehicleAPI.deleteVehicle(vehicleId);
        System.out.println("Vehicle deleted successfully.");
    }
}