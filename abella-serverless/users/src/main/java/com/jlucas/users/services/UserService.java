package com.jlucas.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jlucas.users.entities.Users;
import com.jlucas.users.repositories.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public boolean existe(Long id) {
		return repository.existsById(id);
	}
	
	//GETALL
	public List<Users> listarUsuarios(){
		return repository.findAll();
	}
	
	//GETBYID
	public ResponseEntity<Users> getUserById(Long id){
		Optional<Users> user = repository.findById(id);
        if(user.isPresent())
            return new ResponseEntity<Users>(user.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	//POST
	public Users addUsuario(Users user) {
		return repository.save(user);
	}
	
	//DELETE
	public void deleteUsuario(Long id) {
		repository.deleteById(id);
	}
}
