package com.bluemoon.manager;

import com.bluemoon.model.Household;
import com.bluemoon.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HouseholdManager {

    public List<Household> getAllHouseholds() {
        List<Household> households = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "SELECT * FROM households";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Household household = new Household(
                        resultSet.getString("householdId"),
                        resultSet.getString("address"),
                        resultSet.getDouble("area"),
                        null // You can add logic to fetch residents here
                );
                households.add(household);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return households;
    }

    public void addHousehold(Household household) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "INSERT INTO households (householdId, address, area) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, household.getHouseholdId());
            statement.setString(2, household.getAddress());
            statement.setDouble(3, household.getArea());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateHousehold(Household household) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "UPDATE households SET address = ?, area = ? WHERE householdId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, household.getAddress());
            statement.setDouble(2, household.getArea());
            statement.setString(3, household.getHouseholdId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteHousehold(String householdId) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "DELETE FROM households WHERE householdId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, householdId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Add more methods as needed (update, delete, etc.)
}