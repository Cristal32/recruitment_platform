package com.recruitment.backend.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.backend.model.User;
import com.recruitment.backend.service.UserService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private final UserService userService;
	
	//constructeur
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// ================================= GET Mapping =================================
	
	@GetMapping("/getAll")
//	@PreAuthorize("hasAuthority('GET_USERS')")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/getId/{id}")
	// @PreAuthorize("hasAuthority('GET_USERS')")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id){
		User user = userService.findUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	// ================================= POST Mapping =================================
	
	@PostMapping("/add")
	// @PreAuthorize("hasAuthority('MANAGE_USERS')")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User newUser = userService.addUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED); 
	}
	
	// ================================= PUT Mapping =================================
	
	@PutMapping("/update")
	// @PreAuthorize("hasAuthority('MANAGE_USERS')")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User updateUser = userService.updateUser(user);
		return new ResponseEntity<>(updateUser, HttpStatus.OK); 
	}
	
	// ================================= DELETE Mapping =================================
	@Transactional
	@DeleteMapping("/delete/{id}")
	// @PreAuthorize("hasAuthority('MANAGE_USERS')")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id){
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}
