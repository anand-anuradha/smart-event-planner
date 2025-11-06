package com.smartplanner.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // Public endpoint
    @GetMapping("/api/test/public")
    public String publicEndpoint() {
        return "This is a PUBLIC endpoint.";
    }

    // Protected endpoint
    @GetMapping("/api/test/protected")
    public String protectedEndpoint() {
        return "This is a PROTECTED endpoint. You have a valid JWT!";
    }
}
