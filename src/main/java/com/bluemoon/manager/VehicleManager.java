package com.bluemoon.manager;

import com.bluemoon.model.Vehicle;
import com.bluemoon.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VehicleManager {

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "SELECT * FROM vehicles";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle(
                        resultSet.getString("vehicleId"),
                        resultSet.getString("householdId"),
                        resultSet.getString("type"),
                        resultSet.getDouble("fee")
                );
                vehicles.add(vehicle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "INSERT INTO vehicles (vehicleId, householdId, type, fee) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, vehicle.getVehicleId());
            statement.setString(2, vehicle.getHouseholdId());
            statement.setString(3, vehicle.getType());
            statement.setDouble(4, vehicle.getFee());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateVehicle(Vehicle vehicle) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "UPDATE vehicles SET householdId = ?, type = ?, fee = ? WHERE vehicleId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, vehicle.getHouseholdId());
            statement.setString(2, vehicle.getType());
            statement.setDouble(3, vehicle.getFee());
            statement.setString(4, vehicle.getVehicleId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteVehicle(String vehicleId) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "DELETE FROM vehicles WHERE vehicleId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, vehicleId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public double calculateVehicleFee(String type) {
        double fee = 0.0;
        switch (type.toLowerCase()) {
            case "car":
                fee = 20.0;
                break;
            case "motorbike":
                fee = 10.0;
                break;
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
        return fee;
    }
    // Add more methods as needed (update, delete, etc.)
}