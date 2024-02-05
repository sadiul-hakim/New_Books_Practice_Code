package com.spring_security_in_action.config;

import com.spring_security_in_action.security.DocumentsPermissionEvaluator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@RequiredArgsConstructor
public class ProjectConfig {
    private final DocumentsPermissionEvaluator documentsPermissionEvaluator;
    @Bean
    public MethodSecurityExpressionHandler createExpressionHandler(){
        var expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(documentsPermissionEvaluator);
        return expressionHandler;
    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails hakim = User.withUsername("Hakim")
                .password(passwordEncoder().encode("hakim@123"))
                .authorities("ROLE_ADMIN")
                .build();
        UserDetails ashik = User.withUsername("Ashik")
                .password(passwordEncoder().encode("hakim@123"))
                .authorities("ROLE_MANAGER")
                .build();

        return new InMemoryUserDetailsManager(hakim,ashik);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}
