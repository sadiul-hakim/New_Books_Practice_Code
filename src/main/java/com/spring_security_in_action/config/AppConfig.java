package com.spring_security_in_action.config;

import com.spring_security_in_action.security.AuthenticationFailurePoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        return http.httpBasic(basic -> {
                    basic.realmName("OTHER");
                    basic.authenticationEntryPoint(new AuthenticationFailurePoint());
                })
                .authorizeHttpRequests(auth -> auth.anyRequest().hasAuthority("WRITE"))
                .authenticationProvider(authenticationProvider)
                .build();
    }
}