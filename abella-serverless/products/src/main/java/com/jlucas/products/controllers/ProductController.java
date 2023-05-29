package com.jlucas.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlucas.products.entities.Products;
import com.jlucas.products.services.ProductService;



@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping
	public Products adicionarProdutos(@RequestBody Products product) {
		return service.addProduct(product);
	}
	
	@GetMapping
	public List<Products>listarProdutos(){
		return service.listarProdutos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Products> ProductById(@PathVariable Long id){
		return service.getProductById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeProduto(@PathVariable Long id){
		if(!service.existe(id)) {
			return ResponseEntity.notFound().build();
		}
		service.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Products> atualizarProduto(@PathVariable Long id, @RequestBody Products product){
		if(service.existe(id)) {
			return ResponseEntity.notFound().build();
		}
		product.setId(id);
		product = service.addProduct(product);
		return ResponseEntity.ok(product);
	}
}