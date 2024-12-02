package com.bluemoon.model;

public class Resident {
    private String residentId;
    private String name;
    private int age;
    private String gender;
    private String householdId; // Mã hộ gia đình mà cư dân thuộc về

    public Resident(String residentId, String name, int age, String gender, String householdId) {
        this.residentId = residentId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.householdId = householdId;
    }

    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "residentId='" + residentId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", householdId='" + householdId + '\'' +
                '}';
    }
}