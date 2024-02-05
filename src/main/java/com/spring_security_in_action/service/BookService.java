package com.spring_security_in_action.service;

import com.spring_security_in_action.pojo.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private static final Map<String,Employee> records = Map.of(
            "Hakim",new Employee("Hakim",List.of("accountant","reader"),List.of("Spring Security In Action")),
            "Ashik",new Employee("Ashik",List.of("researcher"),List.of("PHP"))
    );

    @PostAuthorize("returnObject.roles.contains('reader')")
    public Employee getBookDetails(String name){
        return records.get(name);
    }
}
