package com.bluemoon.model;

import java.util.List;

public class Household {
    private String householdId;
    private String address;
    private double area; // Diện tích căn hộ
    private List<Resident> residents; // Danh sách cư dân trong hộ gia đình
    private List<HouseholdFee> fees; // Danh sách các khoản phí của hộ gia đình

    public Household(String householdId, String address, double area, List<Resident> residents) {
        this.householdId = householdId;
        this.address = address;
        this.area = area;
        this.residents = residents;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public List<Resident> getResidents() {
        return residents;
    }

    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }

    public List<HouseholdFee> getFees() {
        return fees;
    }

    public void setFees(List<HouseholdFee> fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Household{" +
                "householdId='" + householdId + '\'' +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", residents=" + residents +
                ", fees=" + fees +
                '}';
    }
}