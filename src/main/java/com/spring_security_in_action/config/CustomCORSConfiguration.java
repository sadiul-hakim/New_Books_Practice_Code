package com.spring_security_in_action.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class CustomCORSConfiguration {
    @Bean
    public CorsConfigurationSource corsConfiguration(){
        return request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(List.of("http://localhost:8080"));
            config.setAllowedMethods(List.of("GET","POST","DELETE"));
            config.setAllowedHeaders(List.of("*"));
            return config;
        };
    }
}
