package com.example.myGreetingApp.service;

import com.example.myGreetingApp.model.Greeting;
import com.example.myGreetingApp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    public String getGreetingMessage() {
        return "{\"message\": \"Hello World\"}";
    }

    // UC4: Saving messages in the repository
    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting getGreetingMessage(String firstName, String lastName) {
        String message;

        if (firstName != null && lastName != null) {
            message = String.format("Hello, %s %s!", firstName, lastName);
        } else if (firstName != null) {
            message = String.format("Hello, %s!", firstName);
        } else if (lastName != null) {
            message = String.format("Hello, %s!", lastName);
        } else {
            message = "Hello World!";
        }

        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    // UC5 Finding Messages using ID
    public Greeting findGreetingById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with id: " + id));
    }

    // UC6: Finding list of all messages
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // UC7: Updating messages using ID
    public Greeting updateGreeting(Long id, String newMessage) {
        // Try to find the greeting by ID
        Greeting greeting = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with id: " + id));

        // Update the message
        greeting.setMessage(newMessage);

        // Save the updated greeting and return it
        return greetingRepository.save(greeting);
    }
}
