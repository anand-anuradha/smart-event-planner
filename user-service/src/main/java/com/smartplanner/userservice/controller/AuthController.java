package com.smartplanner.userservice.controller;

import com.smartplanner.userservice.dto.JwtResponse;
import com.smartplanner.userservice.dto.LoginRequest;
import com.smartplanner.userservice.dto.UserRequestDTO;
import com.smartplanner.userservice.dto.UserResponseDTO;
import com.smartplanner.userservice.entity.User;
import com.smartplanner.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) {
        JwtResponse jwtResponse = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.ok(jwtResponse);
    }

    // Register endpoint
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO userRequestDTO) {
        User savedUser = userService.register(userRequestDTO);

        // Map Entity → Response DTO
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(savedUser.getId());
        responseDTO.setFirstName(savedUser.getFirstName());
        responseDTO.setLastName(savedUser.getLastName());
        responseDTO.setEmail(savedUser.getEmail());
        responseDTO.setRole(savedUser.getRole());

        return ResponseEntity.ok(responseDTO);
    }
}
