package com.smartplanner.userservice.controller;

import com.smartplanner.userservice.entity.User;
import com.smartplanner.userservice.security.JwtTokenProvider;
import com.smartplanner.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // Register new user
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    // Login user
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User existingUser = userService.login(user.getEmail(), user.getPassword());
        if (existingUser == null) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
        String token = jwtTokenProvider.generateToken(existingUser.getEmail());
        return ResponseEntity.ok(token);
    }
}
