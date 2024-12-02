package com.bluemoon.ui;

import com.bluemoon.api.PaymentAPI;
import com.bluemoon.model.HouseholdFee;

import java.util.List;
import java.util.Scanner;

public class PaymentView {
    private Scanner scanner;
    private PaymentAPI paymentAPI;

    public PaymentView() {
        this.scanner = new Scanner(System.in);
        this.paymentAPI = new PaymentAPI();
    }

    public void displayPayments() {
        List<HouseholdFee> payments = paymentAPI.getAllPayments();
        payments.forEach(System.out::println);
    }

    public void addPayment() {
        System.out.println("=== Add Payment ===");
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
    }

    public void updatePayment() {
        System.out.println("=== Update Payment ===");
        System.out.print("Household ID: ");
        String householdId = scanner.nextLine();
        System.out.print("Fee ID: ");
        String feeId = scanner.nextLine();
        System.out.print("New Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        HouseholdFee payment = new HouseholdFee(householdId, feeId, amount);
        paymentAPI.updatePayment(payment);
        System.out.println("Payment updated successfully.");
    }

    public void deletePayment() {
        System.out.println("=== Delete Payment ===");
        System.out.print("Household ID: ");
        String householdId = scanner.nextLine();
        System.out.print("Fee ID: ");
        String feeId = scanner.nextLine();

        paymentAPI.deletePayment(householdId, feeId);
        System.out.println("Payment deleted successfully.");
    }
}