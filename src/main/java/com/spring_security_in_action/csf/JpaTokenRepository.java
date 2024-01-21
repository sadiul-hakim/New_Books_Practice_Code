package com.spring_security_in_action.csf;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaTokenRepository extends JpaRepository<CustomCsrfToken,Long> {
    Optional<CustomCsrfToken> findByIdentifier(String identifier);
}
