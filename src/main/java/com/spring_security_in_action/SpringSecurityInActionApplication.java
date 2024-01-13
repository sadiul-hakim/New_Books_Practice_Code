package com.spring_security_in_action;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
@RestController
public class SpringSecurityInActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityInActionApplication.class, args);
    }
}
