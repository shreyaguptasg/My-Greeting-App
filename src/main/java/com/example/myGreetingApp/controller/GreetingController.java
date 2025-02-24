package com.example.myGreetingApp.controller;

import com.example.myGreetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public String getGreeting() {
        return greetingService.getGreetingMessage();
    }

    @GetMapping
    public String getGreeting(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName) {
        return greetingService.getGreetingMessage(firstName, lastName);
    }

    @PostMapping
    public String postGreeting() {
        return "{\"message\": \"Hello, this is a POST request!\"}";
    }

    @PutMapping
    public String putGreeting() {
        return "{\"message\": \"Hello, this is a PUT request!\"}";
    }

    @DeleteMapping
    public String deleteGreeting() {
        return "{\"message\": \"Hello, this is a DELETE request!\"}";
    }
}
