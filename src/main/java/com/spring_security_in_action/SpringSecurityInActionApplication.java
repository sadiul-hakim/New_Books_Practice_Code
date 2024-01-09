package com.spring_security_in_action;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringSecurityInActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityInActionApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
