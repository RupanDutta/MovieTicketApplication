package com.cg.mts.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.entities.Show;
import com.cg.mts.exception.MovieNotFoundException;
import com.cg.mts.exception.ShowExistsException;
import com.cg.mts.exception.ShowNotFoundException;
import com.cg.mts.exception.TheatreNotFoundException;
import com.cg.mts.repository.IMovieRepository;
import com.cg.mts.repository.IShowRepository;
import com.cg.mts.repository.ITheatreRepository;

@Service
@Transactional
public class IShowServiceImpl implements IShowService {

	@Autowired
	IShowRepository repository;
	
	@Autowired
	ITheatreRepository theatre;

	@Override
	public Show addShow(Show show) throws ShowExistsException, MovieNotFoundException, TheatreNotFoundException {

		if (repository.existsById(show.getShowId()))
			throw new ShowExistsException("Cannot add show, Show Id already exists");
		else {
			if(theatre.existsById(show.getTheatreId())) {
				throw new TheatreNotFoundException("Theatre not found");
			}
		}
		
		Show showData = repository.save(show);
		return showData;
	}

	@Override
	public Show updateShow(Show show) throws ShowNotFoundException {

		if (repository.existsById(show.getShowId())) {
			Show showData = repository.save(show);
			return showData;
		} else
			throw new ShowNotFoundException("Show not found");

	}

	@Override
	public Show removeShow(int showId) throws ShowNotFoundException {

		if (repository.existsById(showId)) {
			repository.deleteById(showId);
		} else
			throw new ShowNotFoundException("Invalid showid, cannot delete show");
		return null;

	}

	@Override
	public Show viewShow(int showid) throws ShowNotFoundException {
		Optional<Show> s=repository.findById(showid);
		if (s.isPresent()) {
			return s.get();
		} else {
			throw new ShowNotFoundException("Invalid Show Id, no shows found");
		}
	}

	@Override
	public List<Show> viewAllShows() throws ShowNotFoundException {

		List<Show> showList = repository.findAll();
		if (showList.isEmpty()) {
			throw new ShowNotFoundException("No Show in Database");
		} else
			return showList;

	}

	@Override
	public List<Show> viewShowList(int theatreid) throws ShowNotFoundException {
		// TODO Auto-generated method stub

		List<Show> showData = repository.findByTheatreId(theatreid);
		if (showData.isEmpty()) {

			throw new ShowNotFoundException("No show found");
		} else
			return showData;
	}

//	@Override
//	public List<Show> viewShowList(String date) throws ShowNotFoundException {
//
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
//		List<Show> showList = repository.findByShowStartTime(dateTime);
//		if (showList.isEmpty()) {
//			throw new ShowNotFoundException("No show found");
//		} else
//			return showList;
//
//	}

//	@Override
//	public List<Show> viewShowList(LocalDate date) throws ShowNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}