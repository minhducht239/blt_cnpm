package com.bluemoon.model;

public class Utility {
    private String utilityId;
    private String householdId;
    private String type; // "electricity", "water", "internet"
    private double amount;

    public Utility(String utilityId, String householdId, String type, double amount) {
        this.utilityId = utilityId;
        this.householdId = householdId;
        this.type = type;
        this.amount = amount;
    }

    public String getUtilityId() {
        return utilityId;
    }

    public void setUtilityId(String utilityId) {
        this.utilityId = utilityId;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Utility{" +
                "utilityId='" + utilityId + '\'' +
                ", householdId='" + householdId + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}