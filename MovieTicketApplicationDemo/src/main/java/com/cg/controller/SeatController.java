package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Seat;
import com.cg.mts.exception.SeatAlreadyExist;
import com.cg.mts.exception.SeatNotAvailableException;
import com.cg.mts.exception.SeatNotFoundException;
import com.cg.mts.service.ISeatService;

@RestController
@RequestMapping("/seat")
public class SeatController {
	@Autowired
	ISeatService service;
	//Book the seat(state-Booked)
	@PutMapping("/bookSeat/{seatId}")
	public ResponseEntity<Object> bookSeat(@PathVariable("seatId") int seat) throws SeatNotFoundException {
		Seat seatData = null;
		seatData = service.bookSeat(seat);
		return new ResponseEntity<Object>(seatData, HttpStatus.OK);

	}

	//Book the seat(state-Available)
	@PutMapping("/cancelSeat/{seatId}")
	public ResponseEntity<Object> cancelSeat(@PathVariable("seatId") int seatId) throws SeatNotFoundException {
		Seat seatData;
		seatData = service.cancelSeatBooking(seatId);
		return new ResponseEntity<Object>(seatData, HttpStatus.OK);

	}


	//Book the seat(state-Blocked)
	@PutMapping("/blockSeat/{seatId}")
	public ResponseEntity<Object> blockSeat(@PathVariable("seatId") int seatId) {
		Seat seatData;
		try {
			seatData = service.blockSeat(seatId);
			return new ResponseEntity<Object>(seatData, HttpStatus.OK);

		} catch (SeatNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	//adding the seats.
	@PostMapping("")
	public ResponseEntity<Object> addNewSeat(@Valid @RequestBody Seat seat) {
		Seat seatData = null;
		try {
			seatData = service.addSeat(seat);
			return new ResponseEntity<Object>(seatData, HttpStatus.OK);
		} catch (SeatAlreadyExist e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	//Getting the list of all the seats.

	@GetMapping("")
	public ResponseEntity<Object> getAllSeats() {
		List<Seat> seatList;
		try {
			seatList = service.getAll();
			return new ResponseEntity<Object>(seatList, HttpStatus.OK);
		} catch (SeatNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}