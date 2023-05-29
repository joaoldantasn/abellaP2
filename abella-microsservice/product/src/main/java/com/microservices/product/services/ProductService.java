package com.microservices.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.product.entities.Product;
import com.microservices.product.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public boolean existe(Long id) {
		return repository.existsById(id);
	}
	
	//POST
	public Product addProduct(Product product) {
		return repository.save(product);
	}
	
	//GETALL
	public List<Product> listarProdutos(){
		return repository.findAll();
	}
	
	//GETBYID
	public ResponseEntity<Product> getProductById(Long id){
		Optional<Product> product = repository.findById(id);
        if(product.isPresent())
            return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	//DELETE
	public void deleteProduct(Long id) {
		repository.deleteById(id);
	}
}
