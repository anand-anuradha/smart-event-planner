package com.smartplanner.userservice.service;

import com.smartplanner.userservice.dto.JwtResponse;
import com.smartplanner.userservice.dto.UserRequestDTO;
import com.smartplanner.userservice.entity.User;
import com.smartplanner.userservice.repository.UserRepository;
import com.smartplanner.userservice.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

        // Generate JWT using email only
        String jwtToken = jwtService.generateToken(user.getEmail());

        return new JwtResponse(jwtToken);
    }

    @Override
    public User register(UserRequestDTO userRequestDTO) {
        // Map DTO → Entity
        User user = new User();
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        user.setRole(userRequestDTO.getRole());
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));

        return userRepository.save(user);
    }
}
