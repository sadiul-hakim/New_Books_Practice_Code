package com.spring_security_in_action.service;

import com.spring_security_in_action.pojo.Document;
import com.spring_security_in_action.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;
    @PreAuthorize("hasPermission(#code,'document','ROLE_ADMIN')")
//    @PostAuthorize("hasPermission(returnObject,'ROLE_ADMIN')")
    public Document getDocument(String code){
         return documentRepository.findDocument(code);
    }
}
