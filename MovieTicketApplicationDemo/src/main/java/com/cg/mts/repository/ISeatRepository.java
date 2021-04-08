package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.mts.entities.Seat;
import com.cg.mts.exception.SeatNotAvailableException;

public interface ISeatRepository extends JpaRepository<Seat, Integer> {
//public Seat bookSeat(Seat seat) ;
//public Seat cancelSeatBooking(Seat seat);
//public Seat blockSeat(Seat seat); //not available for any booking 
//
//@Query("SELECT e FROM Seat_table e WHERE e.seatId=?1")
//public Seat findAllById(int id); 
//
//@Query("SELECT COUNT(*) FROM Seat_table e WHERE e.seatId=?1")
//public boolean existSeat(int id);
//
//@Query("SELECT e FROM Seat_table e WHERE e.seatId=?1")
//public Seat findBySeatId(int seatId);

}
