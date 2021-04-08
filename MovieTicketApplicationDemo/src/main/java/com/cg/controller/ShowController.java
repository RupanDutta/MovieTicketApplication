package com.cg.controller;

import java.util.List;

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

import com.cg.mts.entities.Show;
import com.cg.mts.exception.MovieNotFoundException;
import com.cg.mts.exception.ShowExistsException;
import com.cg.mts.exception.ShowNotFoundException;
import com.cg.mts.exception.TheatreNotFoundException;
import com.cg.mts.service.IShowService;

@RestController
@RequestMapping("/showDetails")
public class ShowController {

	@Autowired
	IShowService service;

	// Adding shows by body

	@PostMapping("")
	public ResponseEntity<Object> addShow(@RequestBody Show show) throws MovieNotFoundException, TheatreNotFoundException {

		Show showData;
		try {
			showData = service.addShow(show);
			return new ResponseEntity<Object>(showData, HttpStatus.OK);

		} catch (ShowExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("Cannot add show, Show Id exists", HttpStatus.BAD_REQUEST);
	}

	// Getting list of all the movies in the database.
	@GetMapping("")
	public ResponseEntity<Object> getAllShows() {

		List<Show> showList;
		try {
			showList = service.viewAllShows();
			return new ResponseEntity<Object>(showList, HttpStatus.OK);
		} catch (ShowNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("No show in database", HttpStatus.BAD_REQUEST);
	}

	// Deleting the by show_id
	@DeleteMapping("/{showid}")
	public ResponseEntity<String> deleteShow(@PathVariable("showid") int showId) {

		try {
			service.removeShow(showId);
			return new ResponseEntity<String>("Show deleted", HttpStatus.OK);
		} catch (ShowNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Show Id not found, cannot delete show", HttpStatus.BAD_REQUEST);
	}

	// Retriving records by show id
	@GetMapping("/{showId}")
	public ResponseEntity<Object> getShowByShowId(@PathVariable("showId") int id) {

		Show showData;
		try {
			showData = service.viewShow(id);
			return new ResponseEntity<Object>(showData, HttpStatus.OK);
		} catch (ShowNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("No show found, Invalid showId", HttpStatus.BAD_REQUEST);
	}

	// Retriving records by showid
	@GetMapping("/getByTheatreId/{theatreId}")
	public ResponseEntity<Object> getShowsByTheatreId(@PathVariable("theatreId") int id) {

		List<Show> showList;
		try {
			showList = service.viewShowList(id);
			return new ResponseEntity<Object>(showList, HttpStatus.OK);

		} catch (ShowNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("No show found with given Theatre Id: " + id, HttpStatus.BAD_REQUEST);
	}

//
//	@GetMapping("/getShowByStartTime")
//	public ResponseEntity<Object> getShowsByStartTime(@RequestParam int date){
//		
//		List<Show> showList;
//		try {
//			showList = service.viewShowList(date);
//			return new ResponseEntity<Object>(showList, HttpStatus.OK);
//
//		} catch (ShowNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Object>("No show found", HttpStatus.BAD_REQUEST);
//	}

	// updating the Show
	@PutMapping("")
	public ResponseEntity<Object> updateShow(@RequestBody Show show) {
		Show showData;
		try {
			showData = service.updateShow(show);
			return new ResponseEntity<Object>(showData, HttpStatus.OK);
		} catch (ShowNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("Cannot update show, Showid invalid", HttpStatus.BAD_REQUEST);
	}
}