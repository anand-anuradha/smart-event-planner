package com.smartplanner.userservice.service;

import com.smartplanner.userservice.dto.JwtResponse;
import com.smartplanner.userservice.dto.UserRequestDTO;
import com.smartplanner.userservice.entity.User;

public interface UserService {

    // Login with email and password, return JWT
    JwtResponse login(String email, String password);

    // Register new user from DTO and return saved User entity
    User register(UserRequestDTO userRequestDTO);
}
