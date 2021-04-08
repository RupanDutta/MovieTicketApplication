package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Seat {

	@Id
	private int seatId;
//	private String type;
	private double price;
	private BookingState state;
	@NotEmpty
	@Pattern(regexp = "^[A-Z][0-9]{2}$", message = "Enter proper seatnumber")
	private String seatNumber;

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Seat(int seatId, String seatNumber,  double price) {
		super();
		this.seatId = seatId;
		this.seatNumber = seatNumber;
	//	this.type = type;
		this.price = price;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public BookingState getState() {
		return state;
	}

	public void setState(BookingState state) {
		this.state = state;
	}
}
