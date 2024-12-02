package com.bluemoon.manager;

import com.bluemoon.model.Utility;
import com.bluemoon.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UtilityManager {

    public List<Utility> getAllUtilities() {
        List<Utility> utilities = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "SELECT * FROM utilities";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Utility utility = new Utility(
                        resultSet.getString("utilityId"),
                        resultSet.getString("householdId"),
                        resultSet.getString("type"),
                        resultSet.getDouble("amount")
                );
                utilities.add(utility);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return utilities;
    }

    public void addUtility(Utility utility) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "INSERT INTO utilities (utilityId, householdId, type, amount) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, utility.getUtilityId());
            statement.setString(2, utility.getHouseholdId());
            statement.setString(3, utility.getType());
            statement.setDouble(4, utility.getAmount());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateUtility(Utility utility) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "UPDATE utilities SET householdId = ?, type = ?, amount = ? WHERE utilityId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, utility.getHouseholdId());
            statement.setString(2, utility.getType());
            statement.setDouble(3, utility.getAmount());
            statement.setString(4, utility.getUtilityId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteUtility(String utilityId) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "DELETE FROM utilities WHERE utilityId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, utilityId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Add more methods as needed (update, delete, etc.)
}