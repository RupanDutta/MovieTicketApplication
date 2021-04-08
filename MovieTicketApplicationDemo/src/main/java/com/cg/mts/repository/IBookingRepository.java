package com.cg.mts.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Booking;
import com.cg.mts.exception.BookingNotFoundException;
import com.cg.mts.exception.SeatNotAvailableException;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {
//	public Booking addBooking(Booking booking);
//	public Booking updateBooking(Booking booking) throws BookingNotFoundException;
//	public Booking cancelBooking(int bookingid) throws BookingNotFoundException;
//	
	@Query("SELECT e FROM Booking e WHERE e.movieId=?1")
	public List<Booking> showAllBookings( int movieid);
	
	@Query("SELECT e FROM Booking e WHERE e.bookingDate=?1")
	public List<Booking> showAllBookings(LocalDate bookingdate);
	
	@Query("SELECT e FROM Booking e WHERE e.showId=?1")
	public List<Booking> showBookingList(int showid);
	
//	public double calculateTotalCost(int bookingid);
//	
}
