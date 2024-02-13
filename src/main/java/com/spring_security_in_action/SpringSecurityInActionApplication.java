package com.spring_security_in_action;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
@RestController
public class SpringSecurityInActionApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SpringApplication.run(SpringSecurityInActionApplication.class, args);

        // code_verifier
        SecureRandom secureRandom = new SecureRandom();
        byte[] code = new byte[32];
        secureRandom.nextBytes(code);
        String verifier = Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(code);
        System.out.println(STR."\{verifier} => verifier");

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] digested = messageDigest.digest(verifier.getBytes());
        String challenge = Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(digested);
        System.out.println(STR."\{challenge} => challenge");
    }
}
