package com.bluemoon.manager;

import com.bluemoon.model.HouseholdFee;
import com.bluemoon.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentManager {

    public List<HouseholdFee> getAllPayments() {
        List<HouseholdFee> payments = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "SELECT * FROM household_fees";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HouseholdFee payment = new HouseholdFee(
                        resultSet.getString("householdId"),
                        resultSet.getString("feeId"),
                        resultSet.getDouble("amount")
                );
                payments.add(payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payments;
    }

    public void addPayment(HouseholdFee payment) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "INSERT INTO household_fees (householdId, feeId, amount) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, payment.getHouseholdId());
            statement.setString(2, payment.getFeeId());
            statement.setDouble(3, payment.getAmount());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updatePayment(HouseholdFee payment) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "UPDATE household_fees SET amount = ? WHERE householdId = ? AND feeId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, payment.getAmount());
            statement.setString(2, payment.getHouseholdId());
            statement.setString(3, payment.getFeeId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deletePayment(String householdId, String feeId) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "DELETE FROM household_fees WHERE householdId = ? AND feeId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, householdId);
            statement.setString(2, feeId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Add more methods as needed (update, delete, etc.)
}