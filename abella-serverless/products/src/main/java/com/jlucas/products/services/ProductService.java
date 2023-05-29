package com.jlucas.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jlucas.products.entities.Products;
import com.jlucas.products.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public boolean existe(Long id) {
		return repository.existsById(id);
	}
	
	//POST
	public Products addProduct(Products product) {
		return repository.save(product);
	}
	
	//GETALL
	public List<Products> listarProdutos(){
		return repository.findAll();
	}
	
	//GETBYID
	public ResponseEntity<Products> getProductById(Long id){
		Optional<Products> product = repository.findById(id);
        if(product.isPresent())
            return new ResponseEntity<Products>(product.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	//DELETE
	public void deleteProduct(Long id) {
		repository.deleteById(id);
	}
}