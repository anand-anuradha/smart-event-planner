package com.smartplanner.userservice.dto;

public class JwtResponse {

    private String token;

    // Constructor accepting token
    public JwtResponse(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }

    // Setter (optional)
    public void setToken(String token) {
        this.token = token;
    }
}
