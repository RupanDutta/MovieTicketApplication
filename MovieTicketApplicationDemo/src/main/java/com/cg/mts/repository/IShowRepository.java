package com.cg.mts.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Show;
import com.cg.mts.exception.ShowNotFoundException;

@Repository
public interface IShowRepository extends JpaRepository<Show, Integer> {

//	public Show addShow(Show show);
//
//	public Show updateShow(Show show) throws ShowNotFoundException;
//
//	public Show removeShow(int showid) throws ShowNotFoundException;
//
//	public Show viewShow(int showid) throws ShowNotFoundException;
//
//	public List<Show> viewAllShows();

	@Query("SELECT e FROM Show e WHERE e.theatreId=?1")
	public List<Show> viewShowList(int theatreid) throws ShowNotFoundException;

	
	@Query("SELECT e FROM Show e WHERE e.theatreId=?1")
	public List<Show> findByTheatreId(int theatreid);
//
//	@Query("SELECT e FROM Show e WHERE e.theatreId=?1")
//	public List<Show> findByShowStartTime(LocalDateTime dateTime);
}