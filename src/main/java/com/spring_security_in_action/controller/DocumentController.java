package com.spring_security_in_action.controller;

import com.spring_security_in_action.pojo.Document;
import com.spring_security_in_action.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;
    @GetMapping("/documents/{code}")
    public ResponseEntity<Document> getDocument(@PathVariable String code){
        Document document = documentService.getDocument(code);
        return ResponseEntity.ok(document);
    }
}
