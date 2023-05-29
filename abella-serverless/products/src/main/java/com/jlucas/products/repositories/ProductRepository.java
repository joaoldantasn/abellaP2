package com.jlucas.products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlucas.products.entities.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

}
