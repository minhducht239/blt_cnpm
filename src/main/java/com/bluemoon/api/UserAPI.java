package com.bluemoon.api;

import com.bluemoon.manager.AuthenticationManager;
import com.bluemoon.model.User;

public class UserAPI {
    private AuthenticationManager authenticationManager;

    public UserAPI() {
        this.authenticationManager = new AuthenticationManager();
    }

    public User authenticate(String username, String password) {
        return authenticationManager.authenticate(username, password);
    }

    public void register(User user) {
        authenticationManager.register(user);
    }

    public void updateUser(User user) {
        authenticationManager.update(user);
    }

    public void deleteUser(String userId) {
        authenticationManager.delete(userId);
    }
}