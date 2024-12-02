package com.bluemoon.model;

public class Fee {
    private String feeId;
    private String feeType;
    private double amount;

    public Fee(String feeId, String feeType, double amount) {
        this.feeId = feeId;
        this.feeType = feeType;
        this.amount = amount;
    }

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "feeId='" + feeId + '\'' +
                ", feeType='" + feeType + '\'' +
                ", amount=" + amount +
                '}';
    }
}