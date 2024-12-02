package com.bluemoon.service;

import com.bluemoon.model.User;

public class NotificationService {

    public void sendNotification(User user, String message) {
        // Simulate sending a notification (e.g., email, SMS)
        System.out.println("Sending notification to " + user.getUsername() + ": " + message);
    }

    // Add more methods for different types of notifications as needed
}