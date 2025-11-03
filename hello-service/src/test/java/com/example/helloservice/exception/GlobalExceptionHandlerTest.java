package com.example.helloservice.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mvc;

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
