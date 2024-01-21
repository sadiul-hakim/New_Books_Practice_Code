package com.spring_security_in_action.config;

import com.spring_security_in_action.csf.CustomCsrfTokenRepository;
import com.spring_security_in_action.security.AuthenticationFailurePoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    private final AuthenticationProvider authenticationProvider;
    private final CustomCsrfTokenRepository csrfTokenRepository;

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        return http.csrf(c -> {
                    c.csrfTokenRepository(csrfTokenRepository);
                    c.csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler());
                }).httpBasic(basic -> {
                    basic.realmName("OTHER");
                    basic.authenticationEntryPoint(new AuthenticationFailurePoint());
                })
                .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, "/ohe").hasRole("ADMIN"))
                .authorizeHttpRequests(auth -> auth.requestMatchers("/hello").hasAnyRole("MANAGER", "ADMIN"))
                .authorizeHttpRequests(auth -> auth.requestMatchers("/product/{code:^[0-9]*$}").authenticated())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .authenticationProvider(authenticationProvider)
                .build();
    }
}