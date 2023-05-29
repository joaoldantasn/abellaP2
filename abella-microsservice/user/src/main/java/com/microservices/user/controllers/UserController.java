package com.microservices.user.controllers;

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

import com.microservices.user.entities.Users;
import com.microservices.user.services.UsersService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UsersService service;
	
	@PostMapping
	public Users adicionarUsuario(@RequestBody Users user) {
		return service.addUsuario(user);
	}
	
	
	@GetMapping
	public List<Users>listarUsuarios(){
		return service.listarUsuarios();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> UserById(@PathVariable Long id){
		return service.getUserById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeUsuario(@PathVariable Long id){
		if(!service.existe(id)) {
			return ResponseEntity.notFound().build();
		}
		service.deleteUsuario(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Users> atualizarUsuario(@PathVariable Long id, @RequestBody Users user){
		if(service.existe(id)) {
			return ResponseEntity.notFound().build();
		}
		user.setId(id);
		user = service.addUsuario(user);
		return ResponseEntity.ok(user);
	}
}
