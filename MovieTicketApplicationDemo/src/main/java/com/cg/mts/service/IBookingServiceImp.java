package com.cg.mts.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Booking;
import com.cg.mts.entities.Seat;
import com.cg.mts.entities.Ticket;
import com.cg.mts.exception.BookingAlreadyExistsException;
import com.cg.mts.exception.BookingNotFoundException;
import com.cg.mts.exception.MovieNotFoundException;
import com.cg.mts.exception.ShowNotFoundException;
import com.cg.mts.repository.IBookingRepository;
import com.cg.mts.repository.IMovieRepository;
import com.cg.mts.repository.IShowRepository;

@Service
public class IBookingServiceImp implements IBookingService {

	@Autowired
	IBookingRepository repository;
	@Autowired
	IShowRepository showrepository;
	@Autowired
	IMovieRepository movierepository;

	@Override
	public Booking addBooking(Booking booking)
			throws BookingAlreadyExistsException, MovieNotFoundException, ShowNotFoundException {

		if (repository.existsById(booking.getBookingId())) {
			throw new BookingAlreadyExistsException();
		} else {
			if (!movierepository.existsById(booking.getMovieId())) {
				throw new MovieNotFoundException("Movie is not present with id" + booking.getMovieId());
			}
//			else {
//				if (!showrepository.existsById(booking.getShowId())) {
//					throw new ShowNotFoundException("Show not found with id:" + booking.getShowId());
//				}
		}
		repository.save(booking);
		return booking;
	}

	@Override
	public Booking updateBooking(Booking booking)
			throws BookingNotFoundException, MovieNotFoundException, ShowNotFoundException {
		if (!(repository.existsById(booking.getBookingId()))) {
			throw new BookingNotFoundException("Booking not found");
		} else {
			if (!movierepository.existsById(booking.getMovieId())) {
				throw new MovieNotFoundException("Movie is not present with id:" + booking.getMovieId());
			} else {
				if (!showrepository.existsById(booking.getShowId())) {
					throw new ShowNotFoundException("Show not found with id:" + booking.getShowId());
				}

			}
			repository.save(booking);
			return booking;
		}
	}

	@Override
	public Booking cancelBooking(int bookingid) throws BookingNotFoundException {
		if (!(repository.existsById(bookingid))) {
			throw new BookingNotFoundException("Booking not found");
		}
		Booking b = repository.getOne(bookingid);
		repository.deleteById(bookingid);
		return b;
	}

	@Override
	public List<Booking> showAllBookings(int movieid) throws BookingNotFoundException {
		List<Booking> booklist = repository.showAllBookings(movieid);
		if (booklist.isEmpty()) {
			throw new BookingNotFoundException("Booking not found");
		}
		return booklist;
	}

	@Override
	public List<Booking> showAllBookings(LocalDate bookingdate) throws BookingNotFoundException {
		List<Booking> booklist = repository.showAllBookings(bookingdate);
		if (booklist.isEmpty()) {
			throw new BookingNotFoundException("Booking not found");
		}
		return booklist;

	}

	@Override
	public List<Booking> showBookingList(int showid) throws BookingNotFoundException {
		List<Booking> booklist = repository.showBookingList(showid);
		if (booklist.isEmpty()) {
			throw new BookingNotFoundException("Booking not found");
		}
		return booklist;
	}

	@Override
	public double calculateTotalCost(int bookingid) {
		Booking book = repository.getOne(bookingid);
		Ticket ticket = book.getTicket();
		int numseat = ticket.getNoOfSeats();
		List<Seat> slist = ticket.getSeatNumber();
		Seat seat = slist.get(0);
		double total = seat.getPrice() * numseat;
		return total;
	}

	@Override
	public List<Booking> getBooking() throws BookingNotFoundException {
		List<Booking> bookingList = repository.findAll();
		if (bookingList.isEmpty()) {
			throw new BookingNotFoundException("Booking Database is empty");
		} else
			return bookingList;
	}

}
