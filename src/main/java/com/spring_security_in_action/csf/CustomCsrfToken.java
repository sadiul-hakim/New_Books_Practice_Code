package com.spring_security_in_action.csf;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "csrf_token")
public class CustomCsrfToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String identifier;
    private String token;
}
