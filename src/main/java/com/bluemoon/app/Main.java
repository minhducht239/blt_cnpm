package com.bluemoon.app;

import com.bluemoon.ui.LoginView;
import com.bluemoon.ui.MainView;
import com.bluemoon.model.User;

public class Main {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        User user = loginView.displayLogin();

        if (user != null) {
            MainView mainView = new MainView();
            mainView.displayMainMenu();
        } else {
            System.out.println("Exiting application.");
        }
    }
}