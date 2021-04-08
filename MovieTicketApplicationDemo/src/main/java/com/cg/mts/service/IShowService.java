package com.cg.mts.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.mts.entities.Show;
import com.cg.mts.exception.MovieNotFoundException;
import com.cg.mts.exception.ShowExistsException;
import com.cg.mts.exception.ShowNotFoundException;
import com.cg.mts.exception.TheatreNotFoundException;

public interface IShowService {

	public Show addShow(Show show) throws ShowExistsException, MovieNotFoundException, TheatreNotFoundException;

	public Show updateShow(Show show) throws ShowNotFoundException;

	public Show removeShow(int showid) throws ShowNotFoundException;

	public Show viewShow(int showid) throws ShowNotFoundException;

	public List<Show> viewAllShows() throws ShowNotFoundException;

	public List<Show> viewShowList(int theatreid) throws ShowNotFoundException;

//	public List<Show> viewShowList(LocalDate date) throws ShowNotFoundException;
//
//	List<Show> viewShowList(String date) throws ShowNotFoundException;
}
