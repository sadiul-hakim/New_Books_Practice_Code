package com.spring_security_in_action.config;

import com.spring_security_in_action.interceptors.CustomAuthenticationFilter;
import com.spring_security_in_action.interceptors.RequestInterceptor;
import com.spring_security_in_action.interceptors.RequestLoggingFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
//    private final UserDetailsService userDetailsService;
    private final CustomAuthenticationFilter authenticationFilter;
    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
//                .userDetailsService(userDetailsService)
                .addFilterBefore(new RequestInterceptor(), BasicAuthenticationFilter.class)
                .addFilterAt(authenticationFilter, BasicAuthenticationFilter.class)
                .addFilterAfter(new RequestLoggingFilter(), BasicAuthenticationFilter.class)
                .build();
    }
}
