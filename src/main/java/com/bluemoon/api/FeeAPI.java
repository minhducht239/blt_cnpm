package com.bluemoon.api;

import com.bluemoon.manager.FeeManager;
import com.bluemoon.model.Fee;

import java.util.List;

public class FeeAPI {
    private FeeManager feeManager;

    public FeeAPI() {
        this.feeManager = new FeeManager();
    }

    public List<Fee> getAllFees() {
        return feeManager.getAllFees();
    }

    public void addFee(Fee fee) {
        feeManager.addFee(fee);
    }

    public void updateFee(Fee fee) {
        feeManager.updateFee(fee);
    }

    public void deleteFee(String feeId) {
        feeManager.deleteFee(feeId);
    }

    public double calculateServiceFee(double area, double rate) {
        return feeManager.calculateServiceFee(area, rate);
    }

    public double calculateManagementFee(double area) {
        return feeManager.calculateManagementFee(area);
    }
}