package com.cg.mts.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.mts.entities.Booking;
import com.cg.mts.exception.BookingAlreadyExistsException;
import com.cg.mts.exception.BookingNotFoundException;
import com.cg.mts.exception.MovieNotFoundException;
import com.cg.mts.exception.ShowNotFoundException;

public interface IBookingService {
	public Booking addBooking(Booking booking) throws BookingAlreadyExistsException, MovieNotFoundException, ShowNotFoundException;
	public Booking updateBooking(Booking booking) throws BookingNotFoundException, MovieNotFoundException, ShowNotFoundException;
	public Booking cancelBooking(int bookingid) throws BookingNotFoundException;
	public List<Booking> showAllBookings(int movieid) throws BookingNotFoundException;
	public List<Booking> showAllBookings(LocalDate bookingdate) throws BookingNotFoundException;
	public List<Booking> showBookingList(int showid) throws BookingNotFoundException;
	public double calculateTotalCost(int bookingid);
	public List<Booking> getBooking() throws BookingNotFoundException;
	
}
