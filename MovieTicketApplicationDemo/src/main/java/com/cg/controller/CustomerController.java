package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Customer;
import com.cg.mts.exception.CustomerNotFoundException;
import com.cg.mts.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService service;

	//Adding Customer to database
	@PostMapping("")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) throws CustomerNotFoundException {
		Customer customerData = service.addCustomer(customer);
		return new ResponseEntity<Customer>(customerData, HttpStatus.OK);
	}

	//Deleting the records by customer id
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable("customerId") int customerId){
		try {
		     service.deleteCustomer(customerId);
			return new ResponseEntity<Object>("Customer deleted", HttpStatus.OK);
		}
		catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("Customer data not found", HttpStatus.UNAUTHORIZED);
	}

	//Retrive the records by userId
	@GetMapping("/{userId}")
	public ResponseEntity<Object> getCustomerById(@PathVariable("userId") int id) {
		Customer customerData;
		try {
			customerData = service.viewCustomer(id);
			return new ResponseEntity<Object>(customerData, HttpStatus.OK);
		} 
		catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("Customer not found", HttpStatus.UNAUTHORIZED);
	}
//	
//	@GetMapping("/getCustByMovieId/{movieId}")
//	public ResponseEntity<Object> getCustomerMovieId(@PathVariable("movieId") int id) {
//		List<Customer> customerData;
//		try {
//			customerData = service.viewAllCustomersByMovieId(id);
//			return new ResponseEntity<Object>(customerData, HttpStatus.OK);
//		} catch (CustomerNotFoundException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//		}
//		return new ResponseEntity<Object>("MovieId not found", HttpStatus.UNAUTHORIZED);
//	}
	
	
	
	//Getting list of all customer in the databases

	@GetMapping("")
	public ResponseEntity<Object>getAllCustomer(){
		List<Customer> customerList;
		try {
			customerList = service.showAll();
			return new ResponseEntity<Object>(customerList, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return new ResponseEntity<Object>("Customers not found", HttpStatus.UNAUTHORIZED);
	}

	//Updating the customer details
	@PutMapping("")
	public ResponseEntity<Object> updateCustomer(@Valid @RequestBody Customer customer) {
		Customer customerData;
		try {
			customerData = service.updateCustomer(customer);
			return new ResponseEntity<Object>(customerData, HttpStatus.OK);
		} 
		catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return new ResponseEntity<Object>("Customer not updated", HttpStatus.UNAUTHORIZED);
	}

}
