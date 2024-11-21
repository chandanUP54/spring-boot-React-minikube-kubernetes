package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.entity.User;
import com.example.test.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String hello( ) {
		return "Hello World! How are you?";
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		try {
			User user2 = userRepository.save(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user2);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@GetMapping("/all")
	public List<User> allUser() {
		return userRepository.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable long id) {

		userRepository.deleteById(id);

	}

	@PutMapping("/update/{id}")
	public User updateUser(@RequestBody User user, @PathVariable long id) {

		User user2 = userRepository.findById(id).get();

		user2.setEmail(user.getEmail());
		user2.setName(user.getName());

		userRepository.save(user2);

		return user2;
	}
}
