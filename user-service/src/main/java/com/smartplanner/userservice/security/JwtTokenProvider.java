package com.smartplanner.userservice.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationMs}")
    private long jwtExpirationMs;

    // Generate JWT Token
    public String generateToken(String email) {
        return JWT.create()
                .withSubject(email)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .sign(Algorithm.HMAC256(jwtSecret));
    }

    // Validate JWT Token
    public boolean validateToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(jwtSecret)).build().verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extract email from token
    public String getEmailFromToken(String token) {
        return JWT.require(Algorithm.HMAC256(jwtSecret))
                .build()
                .verify(token)
                .getSubject();
    }
}
