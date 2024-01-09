package com.spring_security_in_action.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails hakim = User.withUsername("Hakim")
                .password(passwordEncoder().encode("hakim@123"))
                .authorities("READ")
                .build();

        return new InMemoryUserDetailsManager(hakim);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}
