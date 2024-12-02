package com.bluemoon.ui;

import com.bluemoon.api.HouseholdAPI;
import com.bluemoon.model.Household;

import java.util.List;
import java.util.Scanner;

public class HouseholdView {
    private Scanner scanner;
    private HouseholdAPI householdAPI;

    public HouseholdView() {
        this.scanner = new Scanner(System.in);
        this.householdAPI = new HouseholdAPI();
    }

    public void displayHouseholds() {
        List<Household> households = householdAPI.getAllHouseholds();
        households.forEach(System.out::println);
    }

    public void addHousehold() {
        System.out.println("=== Add Household ===");
        System.out.print("Household ID: ");
        String householdId = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Area: ");
        double area = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Household household = new Household(householdId, address, area, null);
        householdAPI.addHousehold(household);
        System.out.println("Household added successfully.");
    }

    public void updateHousehold() {
        System.out.println("=== Update Household ===");
        System.out.print("Household ID: ");
        String householdId = scanner.nextLine();
        System.out.print("New Address: ");
        String address = scanner.nextLine();
        System.out.print("New Area: ");
        double area = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Household household = new Household(householdId, address, area, null);
        householdAPI.updateHousehold(household);
        System.out.println("Household updated successfully.");
    }

    public void deleteHousehold() {
        System.out.println("=== Delete Household ===");
        System.out.print("Household ID: ");
        String householdId = scanner.nextLine();

        householdAPI.deleteHousehold(householdId);
        System.out.println("Household deleted successfully.");
    }
}