package com.example.be.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class ConfigFE implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
