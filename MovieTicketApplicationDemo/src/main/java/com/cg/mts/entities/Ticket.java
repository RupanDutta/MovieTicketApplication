package com.cg.mts.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Ticket {
	@Id
	private int ticketId;
	private int noOfSeats;
	@OneToOne
	//@JoinColumn(name = "booking_id")
	private Booking bookingRef;
	//private boolean ticketStatus;
	private String screenName;
	@OneToMany
	//@JoinColumn(name = "ticket_id")
	private List<Seat> seats;

	public Ticket(int ticketId, int noOfSeats, List<Seat> seatNumber, Booking bookingRef, //boolean ticketStatus,
			String screenName) {
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.seats = seatNumber;
		this.bookingRef = bookingRef;
	//	this.ticketStatus = ticketStatus;
		this.screenName = screenName;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public List<Seat> getSeatNumber() {
		return seats;
	}

	public void setSeatNumber(List<Seat> seatNumber) {
		this.seats = seatNumber;
	}

	public Booking getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(Booking bookingRef) {
		this.bookingRef = bookingRef;
	}

//	public boolean isTicketStatus() {
//		return ticketStatus;
//	}
//
//	public void setTicketStatus(boolean ticketStatus) {
//		this.ticketStatus = ticketStatus;
//	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

}
