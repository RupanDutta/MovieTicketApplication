package com.cg.mts.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Booking;
import com.cg.mts.entities.Ticket;
import com.cg.mts.exception.TicketAlreadyExistsException;
import com.cg.mts.repository.ITicketRepository;

@Service
public class ITicketServiceImpl implements ITicketService {

	@Autowired
	ITicketRepository repository;
	
	
	@Override
	public Ticket addTicket(Ticket ticket) {
		Ticket ticketData = repository.save(ticket);
		return ticketData;
	}


	public Ticket updateTicket(Ticket ticket) throws TicketAlreadyExistsException {
		if(!repository.existsById(ticket.getTicketId())) {
			throw new TicketAlreadyExistsException("Ticket not found");
		}
		Ticket t=repository.getOne(ticket.getTicketId());
		repository.save(ticket);
		return t;
	}
	
	public List<Ticket> showTickets() throws TicketAlreadyExistsException {
		
		List<Ticket> tickets =repository.findAll();
		if(tickets.isEmpty()) {
			throw new TicketAlreadyExistsException("No tickets to show");
		}
		return tickets;
		
	}
	
}
