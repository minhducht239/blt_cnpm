package com.bluemoon.ui;

import com.bluemoon.api.*;
import com.bluemoon.model.*;

import java.util.List;
import java.util.Scanner;

public class MainView {
    private Scanner scanner;
    private HouseholdAPI householdAPI;
    private FeeAPI feeAPI;
    private PaymentAPI paymentAPI;
    private UserAPI userAPI;
    private VehicleAPI vehicleAPI;
    private UtilityAPI utilityAPI;

    public MainView() {
        this.scanner = new Scanner(System.in);
        this.householdAPI = new HouseholdAPI();
        this.feeAPI = new FeeAPI();
        this.paymentAPI = new PaymentAPI();
        this.userAPI = new UserAPI();
        this.vehicleAPI = new VehicleAPI();
        this.utilityAPI = new UtilityAPI();
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("=== BlueMoon Apartment Fee Management ===");
            System.out.println("1. Manage Households");
            System.out.println("2. Manage Fees");
            System.out.println("3. Manage Payments");
            System.out.println("4. Manage Users");
            System.out.println("5. Manage Vehicles");
            System.out.println("6. Manage Utilities");
            System.out.println("7. Generate Reports");
            System.out.println("8. Sign Out");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayHouseholdMenu();
                    break;
                case 2:
                    displayFeeMenu();
                    break;
                case 3:
                    displayPaymentMenu();
                    break;
                case 4:
                    displayUserMenu();
                    break;
                case 5:
                    displayVehicleMenu();
                    break;
                case 6:
                    displayUtilityMenu();
                    break;
                case 7:
                    displayReportMenu();
                    break;
                case 8:
                    signOut();
                    return;
                case 9:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void signOut() {
        System.out.println("Signing out...");
        LoginView loginView = new LoginView();
        User user = loginView.displayLogin();

        if (user != null) {
            displayMainMenu();
        } else {
            System.out.println("Exiting application.");
        }
    }

    private void displayHouseholdMenu() {
        System.out.println("=== Manage Households ===");
        System.out.println("1. View All Households");
        System.out.println("2. Add Household");
        System.out.println("3. Update Household");
        System.out.println("4. Delete Household");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                List<Household> households = householdAPI.getAllHouseholds();
                households.forEach(System.out::println);
                break;
            case 2:
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
                break;
            case 3:
                System.out.print("Household ID: ");
                householdId = scanner.nextLine();
                System.out.print("New Address: ");
                address = scanner.nextLine();
                System.out.print("New Area: ");
                area = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                household = new Household(householdId, address, area, null);
                householdAPI.updateHousehold(household);
                System.out.println("Household updated successfully.");
                break;
            case 4:
                System.out.print("Household ID: ");
                householdId = scanner.nextLine();
                householdAPI.deleteHousehold(householdId);
                System.out.println("Household deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void displayFeeMenu() {
        System.out.println("=== Manage Fees ===");
        System.out.println("1. View All Fees");
        System.out.println("2. Add Fee");
        System.out.println("3. Update Fee");
        System.out.println("4. Delete Fee");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                List<Fee> fees = feeAPI.getAllFees();
                fees.forEach(System.out::println);
                break;
            case 2:
                System.out.print("Fee ID: ");
                String feeId = scanner.nextLine();
                System.out.print("Fee Type: ");
                String feeType = scanner.nextLine();
                System.out.print("Amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                Fee fee = new Fee(feeId, feeType, amount);
                feeAPI.addFee(fee);
                System.out.println("Fee added successfully.");
                break;
            case 3:
                System.out.print("Fee ID: ");
                feeId = scanner.nextLine();
                System.out.print("New Fee Type: ");
                feeType = scanner.nextLine();
                System.out.print("New Amount: ");
                amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                fee = new Fee(feeId, feeType, amount);
                feeAPI.updateFee(fee);
                System.out.println("Fee updated successfully.");
                break;
            case 4:
                System.out.print("Fee ID: ");
                feeId = scanner.nextLine();
                feeAPI.deleteFee(feeId);
                System.out.println("Fee deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void displayPaymentMenu() {
        System.out.println("=== Manage Payments ===");
        System.out.println("1. View All Payments");
        System.out.println("2. Add Payment");
        System.out.println("3. Update Payment");
        System.out.println("4. Delete Payment");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                List<HouseholdFee> payments = paymentAPI.getAllPayments();
                payments.forEach(System.out::println);
                break;
            case 2:
                System.out.print("Household ID: ");
                String householdId = scanner.nextLine();
                System.out.print("Fee ID: ");
                String feeId = scanner.nextLine();
                System.out.print("Amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                HouseholdFee payment = new HouseholdFee(householdId, feeId, amount);
                paymentAPI.addPayment(payment);
                System.out.println("Payment added successfully.");
                break;
            case 3:
                System.out.print("Household ID: ");
                householdId = scanner.nextLine();
                System.out.print("Fee ID: ");
                feeId = scanner.nextLine();
                System.out.print("New Amount: ");
                amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                payment = new HouseholdFee(householdId, feeId, amount);
                paymentAPI.updatePayment(payment);
                System.out.println("Payment updated successfully.");
                break;
            case 4:
                System.out.print("Household ID: ");
                householdId = scanner.nextLine();
                System.out.print("Fee ID: ");
                feeId = scanner.nextLine();
                paymentAPI.deletePayment(householdId, feeId);
                System.out.println("Payment deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void displayUserMenu() {
        System.out.println("=== Manage Users ===");
        System.out.println("1. View All Users");
        System.out.println("2. Add User");
        System.out.println("3. Update User");
        System.out.println("4. Delete User");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                // Implement view all users
                break;
            case 2:
                System.out.print("User ID: ");
                String userId = scanner.nextLine();
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                System.out.print("Role: ");
                String role = scanner.nextLine();
                User user = new User(userId, username, password, role);
                userAPI.register(user);
                System.out.println("User added successfully.");
                break;
            case 3:
                System.out.print("User ID: ");
                userId = scanner.nextLine();
                System.out.print("New Username: ");
                username = scanner.nextLine();
                System.out.print("New Password: ");
                password = scanner.nextLine();
                System.out.print("New Role: ");
                role = scanner.nextLine();
                user = new User(userId, username, password, role);
                userAPI.updateUser(user);
                System.out.println("User updated successfully.");
                break;
            case 4:
                System.out.print("User ID: ");
                userId = scanner.nextLine();
                userAPI.deleteUser(userId);
                System.out.println("User deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void displayVehicleMenu() {
        System.out.println("=== Manage Vehicles ===");
        System.out.println("1. View All Vehicles");
        System.out.println("2. Add Vehicle");
        System.out.println("3. Update Vehicle");
        System.out.println("4. Delete Vehicle");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                List<Vehicle> vehicles = vehicleAPI.getAllVehicles();
                vehicles.forEach(System.out::println);
                break;
            case 2:
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
                break;
            case 3:
                System.out.print("Vehicle ID: ");
                vehicleId = scanner.nextLine();
                System.out.print("New Household ID: ");
                householdId = scanner.nextLine();
                System.out.print("New Type (motorbike/car): ");
                type = scanner.nextLine();
                fee = vehicleAPI.calculateVehicleFee(type);
                vehicle = new Vehicle(vehicleId, householdId, type, fee);
                vehicleAPI.updateVehicle(vehicle);
                System.out.println("Vehicle updated successfully.");
                break;
            case 4:
                System.out.print("Vehicle ID: ");
                vehicleId = scanner.nextLine();
                vehicleAPI.deleteVehicle(vehicleId);
                System.out.println("Vehicle deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void displayUtilityMenu() {
        System.out.println("=== Manage Utilities ===");
        System.out.println("1. View All Utilities");
        System.out.println("2. Add Utility");
        System.out.println("3. Update Utility");
        System.out.println("4. Delete Utility");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                List<Utility> utilities = utilityAPI.getAllUtilities();
                utilities.forEach(System.out::println);
                break;
            case 2:
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
                break;
            case 3:
                System.out.print("Utility ID: ");
                utilityId = scanner.nextLine();
                System.out.print("New Household ID: ");
                householdId = scanner.nextLine();
                System.out.print("New Type (electricity/water/internet): ");
                type = scanner.nextLine();
                System.out.print("New Amount: ");
                amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                utility = new Utility(utilityId, householdId, type, amount);
                utilityAPI.updateUtility(utility);
                System.out.println("Utility updated successfully.");
                break;
            case 4:
                System.out.print("Utility ID: ");
                utilityId = scanner.nextLine();
                utilityAPI.deleteUtility(utilityId);
                System.out.println("Utility deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void displayReportMenu() {
        System.out.println("=== Generate Reports ===");
        System.out.println("1. Generate Monthly Report");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                ReportAPI reportAPI = new ReportAPI();
                reportAPI.generateMonthlyReport();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void main(String[] args) {
        MainView mainView = new MainView();
        mainView.displayMainMenu();
    }
}