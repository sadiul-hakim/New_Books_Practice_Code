package com.spring_security_in_action.service;

import com.spring_security_in_action.pojo.Product;
import com.spring_security_in_action.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    @PreFilter("filterObject.owner().equals(authentication.name)")
    public List<Product> sell(List<Product> products){
        products.forEach(System.out::println);
        return products;
    }

    public List<Product> findAll(String owner){
        return productRepository.findProductByOwner(owner);
    }
}
