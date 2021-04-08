package com.cg.controller;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Booking;
import com.cg.mts.exception.BookingAlreadyExistsException;
import com.cg.mts.exception.BookingAlreadyExistsException;
import com.cg.mts.exception.BookingNotFoundException;
import com.cg.mts.exception.MovieNotFoundException;
import com.cg.mts.exception.ShowNotFoundException;
import com.cg.mts.service.IBookingService;

@RestController
@RequestMapping("/movieBooking")
public class BookingController {

	@Autowired
	IBookingService service;

//Add the booking
	@PostMapping("")
	public ResponseEntity<Object> addBooking(@Valid @RequestBody Booking booking)
			throws BookingAlreadyExistsException, MovieNotFoundException, ShowNotFoundException {
		Booking bookingData;
		bookingData = service.addBooking(booking);
		return new ResponseEntity<Object>(bookingData, HttpStatus.OK);
	}
//	 return new ResponseEntity<Object>("Bookings Cannot done as either show or
//	 Movie is not available",HttpStatus.BAD_REQUEST); }

//update the booking
	@PutMapping()
	public ResponseEntity<Object> updateBooking(@Valid @RequestBody Booking booking) {
		Booking bookingData = null;
		try {
			bookingData = service.updateBooking(booking);
			return new ResponseEntity<Object>(bookingData, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return new ResponseEntity<Object>("No Bookings found in DataBase with given ID", HttpStatus.UNAUTHORIZED);
	}

	//Delete the booking by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> cancelBooking(@PathVariable("id") int bookingId) throws BookingNotFoundException {
		Booking bookingData;
		bookingData = service.cancelBooking(bookingId);
		return new ResponseEntity<Object>(bookingData, HttpStatus.OK);

		// return new ResponseEntity<Object>("No Bookings found in DataBase with given
		// ID", HttpStatus.UNAUTHORIZED);
	}
	
	//retriving the bookings by movie id
	@GetMapping("/showByMovieId/{movieId}")
	public ResponseEntity<Object> showAllBooking(@PathVariable int movieId) {

		List<Booking> bookingList;
		try {
			bookingList = service.showAllBookings(movieId);
			return new ResponseEntity<Object>(bookingList, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("No Bookings found in DataBase with given ID", HttpStatus.UNAUTHORIZED);
	}
//
//	@GetMapping("/showByShowId/{showId}")
//	public ResponseEntity<Object> showBookingList(@PathVariable("showId") int showId) {
//		List<Booking> bookingList;
//		try {
//			bookingList = service.showBookingList(showId);
//			return new ResponseEntity<Object>(bookingList, HttpStatus.OK);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Object>("No Bookings found in DataBase with given ID", HttpStatus.UNAUTHORIZED);
//	}

	@GetMapping("/bill/{id}")
	public ResponseEntity<Object> calculateTotalCost(@PathVariable("id") int bookingId) {
		Double bookingData;
		try {
			bookingData = service.calculateTotalCost(bookingId);
			return new ResponseEntity<Object>(bookingData, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return new ResponseEntity<Object>("No Bookings found in DataBase with given ID", HttpStatus.UNAUTHORIZED);

	}

	//Getting list of all bookings
	@GetMapping("")
	public ResponseEntity<Object> selectAllBooking() {

		List<Booking> bookingList;
		try {
			bookingList = service.getBooking();
			return new ResponseEntity<Object>(bookingList, HttpStatus.OK);
		} catch (BookingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("No Bookings found in DataBase", HttpStatus.NO_CONTENT);
	}
//
//	@GetMapping("/getBookingByBookingDate")
//	public ResponseEntity<Object> getBookingByLocalDate(@RequestBody String date) {
//
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//		LocalDate bookingDate;
//		List<Booking> getBookingByLocalDate = null;
//		List<Booking> bookingData;
//		try {
//			bookingDate = LocalDate.parse(date, formatter);
//			bookingData = service.showAllBookings(bookingDate);
//			return new ResponseEntity<Object>(bookingData, HttpStatus.OK);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//
//		}
//		return new ResponseEntity<Object>("No Bookings found in DataBase with given date", HttpStatus.UNAUTHORIZED);
//
	}

