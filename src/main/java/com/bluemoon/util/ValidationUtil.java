package com.bluemoon.util;

public class ValidationUtil {

    public static boolean isValidUsername(String username) {
        return username != null && username.matches("^[a-zA-Z0-9._-]{3,}$");
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    public static boolean isValidArea(double area) {
        return area > 0;
    }

    public static boolean isValidFee(double fee) {
        return fee >= 0;
    }

    // Add more validation methods as needed
}