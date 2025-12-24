package com.stub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@SpringBootApplication
@RestController
public class StubApplication {

    public static void main(String[] args) {
        SpringApplication.run(StubApplication.class, args);
    }

    @GetMapping("/actuator/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    @GetMapping("/api/info")
    public Map<String, String> info() {
        return Map.of(
                "service", System.getenv().getOrDefault("SERVICE_NAME", "unknown"),
                "status", "running",
                "mode", "stub"
        );
    }
}
