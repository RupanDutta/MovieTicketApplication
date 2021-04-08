package com.cg.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.cg.mts.entities.Movie;
import com.cg.mts.exception.MovieNotFoundException;
import com.cg.mts.service.IMovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	IMovieService service;

	// Adding the Movies
	@PostMapping("")
	public ResponseEntity<Object> addMovie(@Value(value = "") @RequestBody Movie movie) {

		Movie movieAdd = new Movie();
		try {
			movieAdd = service.addMovie(movie);
			return new ResponseEntity<Object>(movieAdd, HttpStatus.CREATED);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	// Deleting movie by id

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMovie(@PathVariable Integer id) {

		String deleteString = null;
		try {
			deleteString = service.removeMovie(id);
			return new ResponseEntity<String>(deleteString, HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	//Updating the records in database.
	@PutMapping("")
	public ResponseEntity<Object> updateMovie(@Valid @RequestBody Movie movie) {

		Movie movieUpdate = new Movie();
		try {
			movieUpdate = service.updateMovie(movie);
			return new ResponseEntity<Object>(movieUpdate, HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	//Retriving movie by id
	@GetMapping("/{id}")
	public ResponseEntity<Object> viewMovie(@PathVariable int id) {

		Movie movieView = new Movie();
		try {
			movieView = service.viewMovie(id);
			return new ResponseEntity<Object>(movieView, HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Retreive the movies present in the database.  
	@GetMapping("")
	public ResponseEntity<Object> viewMovieList() {

		List<Movie> movieList = new ArrayList<Movie>();
		try {
			movieList = service.viewMovieList();
			return new ResponseEntity<Object>(movieList, HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

//	@GetMapping("/VMByTheatreId/{id}")
//	public ResponseEntity<Object> MovieListByTheatre(@PathVariable int id) {
//
//		try {
//			List<Movie> movieListByTheatreId = service.viewMovieList(id);
//			return new ResponseEntity<Object>(movieListByTheatreId, HttpStatus.OK);
//		} catch (MovieNotFoundException e) {
//			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//	}

//	@GetMapping("/viewMovieListByDate")
//	public ResponseEntity<Object> MovieListByLocalDate(@RequestParam String date) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//		LocalDate releaseDate = LocalDate.parse(date, formatter);
//
//		try {
//
//			List<Movie> movieListByLocalDate = service.viewMovieList(releaseDate);
//			return new ResponseEntity<Object>(movieListByLocalDate, HttpStatus.OK);
//		} catch (MovieNotFoundException e) {
//			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//	}

}