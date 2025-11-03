package com.example.helloservice.service;

import com.example.helloservice.service.impl.InMemoryGreetingService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreetingServiceTest {

    @Test
    public void inMemoryGreeting() {
        GreetingService svc = new InMemoryGreetingService();
        String g = svc.getGreeting();
        Assertions.assertThat(g).isNotNull().contains("hello-service");
    }
}
