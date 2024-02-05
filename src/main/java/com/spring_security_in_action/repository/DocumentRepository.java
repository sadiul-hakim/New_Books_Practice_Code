package com.spring_security_in_action.repository;

import com.spring_security_in_action.pojo.Document;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class DocumentRepository {
    private final Map<String, Document> documents = Map.of(
            "hakim123",new Document("Hakim"),
            "ashik123",new Document("Ashik")
    );
    public Document findDocument(String code){
        return documents.get(code);
    }
}
