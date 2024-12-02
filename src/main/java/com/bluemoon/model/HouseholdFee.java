package com.bluemoon.model;

public class HouseholdFee {
    private String householdId;
    private String feeId;
    private double amount;

    public HouseholdFee(String householdId, String feeId, double amount) {
        this.householdId = householdId;
        this.feeId = feeId;
        this.amount = amount;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "HouseholdFee{" +
                "householdId='" + householdId + '\'' +
                ", feeId='" + feeId + '\'' +
                ", amount=" + amount +
                '}';
    }
}