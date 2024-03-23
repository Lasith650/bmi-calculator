package com.example.bmicalculator;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/bmi/**")
                .allowedOrigins("https://8fe4a8b1-4dab-445f-96af-89aec9819abc-dev.e1-us-cdp-2.choreoapis.dev")
                .allowedMethods("GET", "POST")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}

