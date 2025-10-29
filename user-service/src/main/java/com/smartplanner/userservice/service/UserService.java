package com.smartplanner.userservice.service;

import com.smartplanner.userservice.entity.User;

public interface UserService {

    // Register a new user
    User register(User user);

    // Login user with email and password
    User login(String email, String password);
}
