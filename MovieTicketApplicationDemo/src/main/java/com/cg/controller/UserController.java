package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Users;
import com.cg.mts.exception.UsernameAlreadyExistsException;
import com.cg.mts.exception.UsernameNotFoundException;
import com.cg.mts.security.StringEncrypter;
import com.cg.mts.service.IUserService;

import com.cg.mts.repository.UserRepository;

@RestController
@RequestMapping(value = "/hcr")
@CrossOrigin
public class UserController {
	@Autowired
	private IUserService userService;

	@GetMapping("/validateUser/{username}")
	public ResponseEntity<String> validateUser(@PathVariable String username, @RequestBody String password)
			throws UsernameNotFoundException {
		Users u = userService.validateUser(username, password);
		return new ResponseEntity<String>("User Exists", HttpStatus.FOUND);
	}

	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody Users user) throws UsernameAlreadyExistsException {
		// user.setPassword(encodedPassword);
		userService.addUser(user);

		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteUser")
	public ResponseEntity<String> removeUser(@RequestBody Users user) throws UsernameNotFoundException {
		userService.removeUser(user);
		return new ResponseEntity<String>("Removed", HttpStatus.OK);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<List<Users>> getAllUser() {
		List<Users> list = userService.getAllUsers();
		return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUserById/{userId}")
	public ResponseEntity<String> removeUserById(@PathVariable int userId) throws UsernameNotFoundException {
		userService.deleteUserById(userId);
		return new ResponseEntity<String>("Removed", HttpStatus.OK);
	}

}