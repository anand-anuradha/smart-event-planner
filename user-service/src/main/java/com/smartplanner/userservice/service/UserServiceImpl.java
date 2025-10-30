package com.smartplanner.userservice.service;

import com.smartplanner.userservice.entity.User;
import com.smartplanner.userservice.repository.UserRepository;
import com.smartplanner.userservice.security.JwtService;
import com.smartplanner.userservice.dto.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Override
    public JwtResponse login(String email, String password) {
        // Find user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // Verify password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        // Generate JWT using email (not the User object)
        String jwtToken = jwtService.generateToken(user.getEmail());

        return new JwtResponse(jwtToken);
    }

    @Override
    public User register(User user) {
        // Hash password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
