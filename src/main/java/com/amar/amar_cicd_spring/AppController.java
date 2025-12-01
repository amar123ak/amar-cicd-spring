package com.amar.amar_cicd_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {

    @GetMapping("/")
    public String home() {
        return "🚀 Amar CI/CD Spring Boot Demo is running!";
    }

    @GetMapping("/api/build-info")
    public Map<String, Object> buildInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("app", "Amar CI/CD Spring Demo");
        info.put("version", "1.0.0");
        info.put("builtBy", "Amarendra");
        return info;
    }
}
