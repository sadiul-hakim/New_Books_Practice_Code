package com.spring_security_in_action.repo;

import com.spring_security_in_action.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostFilter;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findProductByOwner(String owner);
}
