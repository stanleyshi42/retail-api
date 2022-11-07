package com.cognixia.jump.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	@Autowired
	PasswordEncoder encoder;

	// CRUD operations
	public User createUser(User user) {
		user.setId(null);
		user.setRole(User.Role.ROLE_USER);
		User created = repo.insert(user);
		return created;
	}

	public List<User> findAllUsers() {
		return repo.findAll();
	}

	public User findUserById(String id) throws ResourceNotFoundException {
		Optional<User> found = repo.findById(id);
		if (found.isPresent()) {
			return found.get();
		}
		throw new ResourceNotFoundException("User", id);
	}

	public User updateUser(User user) throws ResourceNotFoundException {
		if (repo.existsById(user.getId())) {
			user.setPassword(encoder.encode(user.getPassword()));
			User updated = repo.save(user);
			return updated;
		}

		throw new ResourceNotFoundException("User", user.getId());
	}

	public User deleteUser(String id) throws ResourceNotFoundException {
		User toDelete = findUserById(id);
		repo.deleteById(id);
		return toDelete;
	}

}
