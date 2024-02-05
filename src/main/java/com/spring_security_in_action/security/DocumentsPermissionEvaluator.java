package com.spring_security_in_action.security;

import com.spring_security_in_action.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@RequiredArgsConstructor
public class DocumentsPermissionEvaluator implements PermissionEvaluator {
    private final DocumentRepository repository;
    @Override
    public boolean hasPermission(Authentication authentication, Object target, Object permissionObject) {

        return false;
    }

//    @Override
//    public boolean hasPermission(Authentication authentication, Object target, Object permissionObject) {
//
//        var document = (Document) target;
//        var permission = (String) permissionObject;
//
//        boolean admin = authentication.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals(permission));
//
//        return admin || document.owner().equals(authentication.getName());
//    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {

        var code = (String) targetId;
        var document = repository.findDocument(code);

        boolean admin = authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals(permission));

        return admin || document.owner().equals(authentication.getName());
    }
}
