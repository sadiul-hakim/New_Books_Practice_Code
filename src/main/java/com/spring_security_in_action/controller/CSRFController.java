package com.spring_security_in_action.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/csrf")
public class CSRFController {

    @GetMapping("/get-token")
    public ResponseEntity<?> getToken(HttpServletRequest request){

        var csrf = (CsrfToken) request.getAttribute("_csrf");

        return ResponseEntity.ok(Collections.singletonMap("X-CSRF-TOKEN",csrf.getToken()));
    }
}
