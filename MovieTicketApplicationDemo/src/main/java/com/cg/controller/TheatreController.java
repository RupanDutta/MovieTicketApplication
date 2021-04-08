package com.cg.controller;

import java.util.List;

//import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.cg.mts.entities.Theatre;
import com.cg.mts.exception.TheatreAlreadyExistsException;
import com.cg.mts.repository.ITheatreRepository;
import com.cg.mts.service.ITheatreService;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

	@Autowired
	ITheatreService service;
	
	@Autowired
	ITheatreRepository repository;
	
	
	
	//IMPLEMENTED TO VERIFY THE MOVIELISTBYTHEATREID METHOD IN IMOVIESERVICE LAYER
	//Adding theatres to theatre databases.
	@PostMapping("")
	public ResponseEntity<Theatre> addTheatre(@Valid @RequestBody Theatre theatre) throws TheatreAlreadyExistsException{
		Theatre theatreAdd=null;
		theatreAdd = service.addTheatre(theatreAdd);
		return new ResponseEntity<Theatre>(theatreAdd, HttpStatus.OK);
	}
	
	//IMPLEMENTED TO VERIFY THE MOVIELISTBYTHEATREID METHOD IN IMOVIESERVICE LAYER
	
	//Getting list of all theatres from the database.
	@GetMapping("")
	public ResponseEntity<List<Theatre>> viewTheatreList(){
		List<Theatre> theatreList = repository.findAll();
		return new ResponseEntity<List<Theatre>>(theatreList, HttpStatus.OK);
		}

	
}
