package com.spring_security_in_action.service;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @PreAuthorize("#name == authentication.name")
//    @RolesAllowed("ROLE_ADMIN") // todo: less powerful than PreAuthorize and PostAuthorize
//    @Secured("ROLE_ADMIN") // todo: less powerful than PreAuthorize and PostAuthorize
    public String greeting(String name){
        return STR."Hello \{name}";
    }
}
