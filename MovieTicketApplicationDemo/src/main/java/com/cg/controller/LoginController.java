package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Users;
import com.cg.mts.exception.InvalidUsernameException;
import com.cg.mts.service.ILoginService;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
	@Autowired
	private ILoginService loginService;
	private boolean loginStatus = false;

	@PostMapping(value = "/loginuser")
	public ResponseEntity<String> validateLogin(@RequestBody Users user) throws InvalidUsernameException {
		if (loginStatus) {
			return new ResponseEntity<String>("Already Logged In", HttpStatus.CONFLICT);
		}
		Users user1 = loginService.login(user);

		if (user1 != null) {
			loginStatus = true;
			return new ResponseEntity<String>("Login Success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Login Failed, Please Try Again", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/logout")
	public ResponseEntity<String> logout() {
		//Users u = loginService.logout(user);
		if (loginStatus) {
			loginStatus = false;
			return new ResponseEntity<String>("Logged Out User ", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Please Login First", HttpStatus.OK);
	}

}
