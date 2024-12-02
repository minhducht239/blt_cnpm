package com.bluemoon.service;

import com.bluemoon.manager.PaymentManager;
import com.bluemoon.model.HouseholdFee;

import java.util.List;

public class ReportService {
    private PaymentManager paymentManager;

    public ReportService() {
        this.paymentManager = new PaymentManager();
    }

    public void generateMonthlyReport() {
        List<HouseholdFee> payments = paymentManager.getAllPayments();
        double totalAmount = payments.stream().mapToDouble(HouseholdFee::getAmount).sum();
        System.out.println("Monthly Report:");
        System.out.println("Total Amount Collected: " + totalAmount);
        payments.forEach(payment -> System.out.println(payment));
    }

    // Add more methods for different types of reports as needed
}