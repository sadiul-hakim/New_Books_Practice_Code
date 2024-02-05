package com.spring_security_in_action.controller;

import com.spring_security_in_action.pojo.Employee;
import com.spring_security_in_action.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping("/book/details/{name}")
    public ResponseEntity<Employee> getDetails(@PathVariable String name){
        Employee employee = bookService.getBookDetails(name);
        return ResponseEntity.ok(employee);
    }
}
