package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;
import com.cognixia.jump.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService service;

	@Autowired
	UserRepository repo;

	@Autowired
	PasswordEncoder encoder;

	// CRUD operations
	@PostMapping("/user")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		user.setId(null);
		user.setPassword(encoder.encode(user.getPassword()));
		User created = service.createUser(user);

		return ResponseEntity.status(201).body(created);
	}

	@GetMapping("/user")
	public List<User> findAllUsers() {
		return service.findAllUsers();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> findUserById(@PathVariable String id) throws ResourceNotFoundException {
		User found = service.findUserById(id);
		return ResponseEntity.status(200).body(found);
	}

	@PutMapping("/user")
	public ResponseEntity<?> updateUser(@RequestBody User user) throws ResourceNotFoundException {
		User updated = service.updateUser(user);
		return ResponseEntity.status(200).body(updated);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable String id) throws ResourceNotFoundException {
		User deleted = service.deleteUser(id);
		return ResponseEntity.status(200).body(deleted);
	}

}
