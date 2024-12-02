package com.bluemoon.ui;

import com.bluemoon.api.UtilityAPI;
import com.bluemoon.model.Utility;

import java.util.List;
import java.util.Scanner;

public class UtilityView {
    private Scanner scanner;
    private UtilityAPI utilityAPI;

    public UtilityView() {
        this.scanner = new Scanner(System.in);
        this.utilityAPI = new UtilityAPI();
    }

    public void displayUtilities() {
        List<Utility> utilities = utilityAPI.getAllUtilities();
        utilities.forEach(System.out::println);
    }

    public void addUtility() {
        System.out.println("=== Add Utility ===");
        System.out.print("Utility ID: ");
        String utilityId = scanner.nextLine();
        System.out.print("Household ID: ");
        String householdId = scanner.nextLine();
        System.out.print("Type (electricity/water/internet): ");
        String type = scanner.nextLine();
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Utility utility = new Utility(utilityId, householdId, type, amount);
        utilityAPI.addUtility(utility);
        System.out.println("Utility added successfully.");
    }

    public void updateUtility() {
        System.out.println("=== Update Utility ===");
        System.out.print("Utility ID: ");
        String utilityId = scanner.nextLine();
        System.out.print("New Household ID: ");
        String householdId = scanner.nextLine();
        System.out.print("New Type (electricity/water/internet): ");
        String type = scanner.nextLine();
        System.out.print("New Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Utility utility = new Utility(utilityId, householdId, type, amount);
        utilityAPI.updateUtility(utility);
        System.out.println("Utility updated successfully.");
    }

    public void deleteUtility() {
        System.out.println("=== Delete Utility ===");
        System.out.print("Utility ID: ");
        String utilityId = scanner.nextLine();

        utilityAPI.deleteUtility(utilityId);
        System.out.println("Utility deleted successfully.");
    }
}