package com.example.helloservice.service.impl;

import com.example.helloservice.service.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class InMemoryGreetingService implements GreetingService {

    @Override
    public String getGreeting() {
        return "Hello from hello-service!";
    }
}
