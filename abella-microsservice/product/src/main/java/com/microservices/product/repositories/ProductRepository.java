package com.microservices.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
 
}
