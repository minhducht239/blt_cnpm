package com.bluemoon.api;

import com.bluemoon.manager.PaymentManager;
import com.bluemoon.model.HouseholdFee;

import java.util.List;

public class PaymentAPI {
    private PaymentManager paymentManager;

    public PaymentAPI() {
        this.paymentManager = new PaymentManager();
    }

    public List<HouseholdFee> getAllPayments() {
        return paymentManager.getAllPayments();
    }

    public void addPayment(HouseholdFee payment) {
        paymentManager.addPayment(payment);
    }

    public void updatePayment(HouseholdFee payment) {
        paymentManager.updatePayment(payment);
    }

    public void deletePayment(String householdId, String feeId) {
        paymentManager.deletePayment(householdId, feeId);
    }
}