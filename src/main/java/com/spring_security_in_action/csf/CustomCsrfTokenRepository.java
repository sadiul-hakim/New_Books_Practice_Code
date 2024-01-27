package com.spring_security_in_action.csf;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CustomCsrfTokenRepository implements CsrfTokenRepository {
    private final JpaTokenRepository tokenRepository;
    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        var token = UUID.randomUUID().toString();
        return new DefaultCsrfToken("X-CSRF-TOKEN","_csrf",token);
    }

    @Override
    public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {

        String identifier = request.getHeader("X-IDENTIFIER");
        if(identifier.isEmpty()) return;
        Optional<CustomCsrfToken> existingToken = tokenRepository.findByIdentifier(identifier);

        if(existingToken.isPresent()){
            CustomCsrfToken actualToken = existingToken.get();
            actualToken.setToken(token.getToken());
        }else{
            CustomCsrfToken customCsrfToken = new CustomCsrfToken();
            customCsrfToken.setIdentifier(identifier);
            customCsrfToken.setToken(token.getToken());
            tokenRepository.save(customCsrfToken);
        }
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        String identifier = request.getHeader("X-IDENTIFIER");
        if(identifier.isEmpty()) return null;
        Optional<CustomCsrfToken> existingToken = tokenRepository.findByIdentifier(identifier);
        return existingToken.map(customCsrfToken -> new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf",
                customCsrfToken.getToken())).orElse(null);
    }
}
