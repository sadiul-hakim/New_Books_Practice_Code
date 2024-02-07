package com.spring_security_in_action.controller;

import com.spring_security_in_action.pojo.Product;
import com.spring_security_in_action.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    @GetMapping("/sell")
    public ResponseEntity<?> sell(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Samsung Galaxy a20s","Hakim"));
        products.add(new Product(2,"HP EliteBook 840 G3","Hakim"));
        products.add(new Product(3,"HP M22F","Hakim"));
        products.add(new Product(4,"Mac","Ashik"));

        List<Product> sell = productService.sell(products);
        return ResponseEntity.ok(sell);
    }
    @GetMapping("/find-all/{text}")
    public ResponseEntity<?> findAll(@PathVariable String text){
        List<Product> products = productService.findAll(text);
        return ResponseEntity.ok(products);
    }
}
