package com.example.myGreetingApp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreetingMessage() {
        return "{\"message\": \"Hello World\"}";
    }
}
