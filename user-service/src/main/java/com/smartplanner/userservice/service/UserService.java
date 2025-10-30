package com.smartplanner.userservice.service;

import com.smartplanner.userservice.dto.JwtResponse;
import com.smartplanner.userservice.entity.User;

public interface UserService {

    // Login with email and password, return JWT response
    JwtResponse login(String email, String password);

    // Register new user
    User register(User user);
}
