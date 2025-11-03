package com.example.helloservice.exception;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebMvcTest(controllers = GlobalExceptionHandlerTest.ThrowerController.class)
public class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mvc;
    
//    @MockBean
//    private GreetingService greetingService;

    @RestController
    static class ThrowerController {
        @GetMapping("/boom")
        public String boom() {
            throw new RuntimeException("boom!");
        }
    }

    @Test
    public void testExceptionHandling() throws Exception {
        mvc.perform(get("/boom"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.error").value("RuntimeException"))
                .andExpect(jsonPath("$.message").value("boom!"));
    }
}
