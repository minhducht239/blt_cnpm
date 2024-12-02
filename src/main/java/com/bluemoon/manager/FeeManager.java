package com.bluemoon.manager;

import com.bluemoon.model.Fee;
import com.bluemoon.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FeeManager {

    public List<Fee> getAllFees() {
        List<Fee> fees = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "SELECT * FROM fees";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Fee fee = new Fee(
                        resultSet.getString("feeId"),
                        resultSet.getString("feeType"),
                        resultSet.getDouble("amount")
                );
                fees.add(fee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fees;
    }

    public void addFee(Fee fee) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "INSERT INTO fees (feeId, feeType, amount) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, fee.getFeeId());
            statement.setString(2, fee.getFeeType());
            statement.setDouble(3, fee.getAmount());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateFee(Fee fee) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "UPDATE fees SET feeType = ?, amount = ? WHERE feeId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, fee.getFeeType());
            statement.setDouble(2, fee.getAmount());
            statement.setString(3, fee.getFeeId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteFee(String feeId) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "DELETE FROM fees WHERE feeId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, feeId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public double calculateServiceFee(double area, double rate) {
        return area * rate;
    }
    public double calculateManagementFee(double area) {
        double managementRate = 1.5; // Example rate, you can change it as needed
        return area * managementRate;
    }
    // Add more methods as needed (update, delete, etc.)
}