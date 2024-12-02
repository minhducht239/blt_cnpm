package com.bluemoon.ui;

import com.bluemoon.api.UserAPI;
import com.bluemoon.model.User;

import java.util.Scanner;

public class LoginView {
    private Scanner scanner;
    private UserAPI userAPI;

    public LoginView() {
        this.scanner = new Scanner(System.in);
        this.userAPI = new UserAPI();
    }

    public User displayLogin() {
        while (true) {
            System.out.println("=== Login ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    return login();
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return null;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private User login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = userAPI.authenticate(username, password);
        if (user != null) {
            System.out.println("Login successful!");
            return user;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return null;
        }
    }

    private void register() {
        System.out.println("=== Register ===");
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Role: ");
        String role = scanner.nextLine();

        User user = new User(userId, username, password, role);
        userAPI.register(user);
        System.out.println("User registered successfully.");
    }
}