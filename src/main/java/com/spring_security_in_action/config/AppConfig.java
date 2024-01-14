package com.spring_security_in_action.config;

import com.spring_security_in_action.security.CustomAuthenticationFailureHandler;
import com.spring_security_in_action.security.CustomAuthenticationSuccessHandler;
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
    private final CustomAuthenticationSuccessHandler authenticationSuccessHandler;
    private final CustomAuthenticationFailureHandler authenticationFailureHandler;


    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        return http.formLogin(form->{
                    form.defaultSuccessUrl("/home",true);
                    form.successHandler(authenticationSuccessHandler);
                    form.failureHandler(authenticationFailureHandler);
                })
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .authenticationProvider(authenticationProvider)
                .build();
    }
}
