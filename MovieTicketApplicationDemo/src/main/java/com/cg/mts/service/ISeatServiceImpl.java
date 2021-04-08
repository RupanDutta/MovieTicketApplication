package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.entities.BookingState;
import com.cg.mts.entities.Seat;
import com.cg.mts.exception.SeatAlreadyExist;
import com.cg.mts.exception.SeatNotFoundException;
import com.cg.mts.repository.ISeatRepository;

@Service
@Transactional
public class ISeatServiceImpl implements ISeatService {

	@Autowired
	ISeatRepository repository;
	
	@Override
	public Seat bookSeat(int seatId) throws SeatNotFoundException {
		Optional<Seat> optNewSeat = repository.findById(seatId);
		if(!optNewSeat.isPresent()) {
			throw new SeatNotFoundException("Invalid Seat Id");
		}
		else {
			optNewSeat.get().setState(BookingState.Booked);
			return optNewSeat.get();
		}
		
	}

	@Override
	public Seat cancelSeatBooking(int seatId) throws SeatNotFoundException {
		Optional<Seat> optNewSeat = repository.findById(seatId);
		if(optNewSeat == null) {
			throw new SeatNotFoundException("Invalid Seat Id");
		}
		else {
			optNewSeat.get().setState(BookingState.Available);
			return optNewSeat.get();
		}
	}

	@Override
	public Seat blockSeat(int seatId) throws SeatNotFoundException {
		Optional<Seat> optNewSeat = repository.findById(seatId);
		if(optNewSeat == null){
			throw new SeatNotFoundException("Invalid Seat Id");
		}
		else {
			optNewSeat.get().setState(BookingState.Blocked);
			return optNewSeat.get();
		}
	}
	
	@Override
	public List<Seat> getAll() throws SeatNotFoundException {
		List<Seat> seatList = repository.findAll();
		if(seatList.isEmpty()){
			throw new SeatNotFoundException("Seat Database is empty");
		}
		else
			return seatList;
	}

	@Override
	public Seat addSeat(Seat seat) throws SeatAlreadyExist {
		if(repository.existsById(seat.getSeatId())) {
			throw new SeatAlreadyExist("Seat Id already exists");
		}
		Seat newSeat = repository.save(seat);
		return newSeat;
	}
	
}
