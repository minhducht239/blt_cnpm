package com.bluemoon.ui;

import com.bluemoon.api.FeeAPI;
import com.bluemoon.model.Fee;

import java.util.List;
import java.util.Scanner;

public class FeeView {
    private Scanner scanner;
    private FeeAPI feeAPI;

    public FeeView() {
        this.scanner = new Scanner(System.in);
        this.feeAPI = new FeeAPI();
    }

    public void displayFees() {
        List<Fee> fees = feeAPI.getAllFees();
        fees.forEach(System.out::println);
    }

    public void addFee() {
        System.out.println("=== Add Fee ===");
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
    }

    public void updateFee() {
        System.out.println("=== Update Fee ===");
        System.out.print("Fee ID: ");
        String feeId = scanner.nextLine();
        System.out.print("New Fee Type: ");
        String feeType = scanner.nextLine();
        System.out.print("New Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Fee fee = new Fee(feeId, feeType, amount);
        feeAPI.updateFee(fee);
        System.out.println("Fee updated successfully.");
    }

    public void deleteFee() {
        System.out.println("=== Delete Fee ===");
        System.out.print("Fee ID: ");
        String feeId = scanner.nextLine();

        feeAPI.deleteFee(feeId);
        System.out.println("Fee deleted successfully.");
    }
}