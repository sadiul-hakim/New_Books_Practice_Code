package com.spring_security_in_action.service;

import com.spring_security_in_action.pojo.Product;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @PreFilter("filterObject.owner().equals(authentication.name)")
    public List<Product> sell(List<Product> products){
        products.forEach(System.out::println);
        return products;
    }

    @PostFilter("filterObject.owner().equals(authentication.name)")
    public List<Product> findAll(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("Samsung Galaxy a20s","Hakim"));
        products.add(new Product("HP EliteBook 840 G3","Hakim"));
        products.add(new Product("HP M22F","Hakim"));
        products.add(new Product("Mac","Ashik"));
        return products;
    }
}
