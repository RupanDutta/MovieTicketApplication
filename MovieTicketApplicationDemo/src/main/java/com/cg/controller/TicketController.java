package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Seat;
import com.cg.mts.entities.Show;
import com.cg.mts.entities.Ticket;
import com.cg.mts.exception.SeatAlreadyExist;
import com.cg.mts.exception.ShowNotFoundException;
import com.cg.mts.exception.TicketAlreadyExistsException;
import com.cg.mts.service.ITicketServiceImpl;

@RestController
@RequestMapping("/Ticket")
public class TicketController {
	@Autowired
	ITicketServiceImpl service;
	
	//Getting list of all the tickets
	@GetMapping()
	public ResponseEntity<Object> showAllTickets() throws TicketAlreadyExistsException {
		List<Ticket> ticketData = null;
		ticketData = service.showTickets();
		return new ResponseEntity<Object>(ticketData, HttpStatus.OK);
	}

	//Adding new tickets to database
	@PostMapping()
	public ResponseEntity<Object> addNewTicket(@Valid @RequestBody Ticket ticket) throws TicketAlreadyExistsException {
		Ticket ticketData = null;
		ticketData = service.addTicket(ticket);
		return new ResponseEntity<Object>(ticketData, HttpStatus.OK);
	}
	
	//Updating the records
	@PutMapping()
	public ResponseEntity<Object> updateTicket(@RequestBody Ticket ticket) throws TicketAlreadyExistsException{
		Ticket ticketData;
		ticketData = service.updateTicket(ticket);
		return new ResponseEntity<Object>(ticketData, HttpStatus.OK);
	}
}
