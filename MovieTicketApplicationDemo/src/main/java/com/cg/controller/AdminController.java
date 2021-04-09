package com.cg.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Users;
import com.cg.mts.exception.UsernameAlreadyExistsException;
import com.cg.mts.service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminService adminService;
	
	@PostMapping("/registerAdmin/{username}")
	public ResponseEntity<String> registerAdmin(@PathVariable String username,@RequestBody String password) throws UsernameAlreadyExistsException{
		adminService.registerAdmin(username, password);
		return new ResponseEntity<String>("Admin Registered",HttpStatus.CREATED);
	}
}
