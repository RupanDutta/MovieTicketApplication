package com.cg.mts.entities;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.cg.mts.exception.BookingNotFoundException;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.NonNull;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	private int bookingId;
	

	private int movieId;
	private int showId;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private LocalDate bookingDate;
	//private Show showRef;
	@SequenceGenerator(name="seq", initialValue=1, allocationSize=1000)
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private int transactionId;
	private double totalCost;
	

	private BookingState bookingstatus;
	@OneToOne
//	@JoinColumn(name="ticket_Id")
	private Ticket ticket;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(@NonNull int bookingId , @NonNull int movieId, @NonNull int showId, @NonNull LocalDate bookingDate, @NonNull int transactionId ,	@NonNull Ticket ticket) {
		super();
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.showId = showId;
		this.bookingDate = bookingDate;
		
		this.transactionId = transactionId;
		
		this.ticket = ticket;
	}
	public Booking(@NotNull int movieId,@NotNull int showId,@NotNull LocalDate bookingDate,Ticket ticket) {
		super();
		this.ticket=ticket;
		this.movieId = movieId;
		this.showId = showId;
		this.bookingDate = bookingDate;
	}

	public Booking(int bookingId, int movieId, int showId, LocalDate bookingDate) {
		super();
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.showId = showId;
		this.bookingDate = bookingDate;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

//	public Show getShowRef() {
//		return showRef;
//	}
//
//	public void setShowRef(Show showRef) {
//		this.showRef = showRef;
//	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

		public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}



		

}
