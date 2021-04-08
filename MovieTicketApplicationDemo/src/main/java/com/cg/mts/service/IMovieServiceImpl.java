package com.cg.mts.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Movie;
import com.cg.mts.entities.Theatre;
import com.cg.mts.exception.MovieNotFoundException;
import com.cg.mts.repository.IMovieRepository;
import com.cg.mts.repository.ITheatreRepository;

@Service

public class IMovieServiceImpl implements IMovieService {

	@Autowired
	IMovieRepository repository;
	@Autowired
	ITheatreRepository theatrerepository;

	@Override
	public Movie addMovie(Movie movie) throws MovieNotFoundException {
		if (!repository.existsById(movie.getMovieId())) {
			Movie movieAdd = repository.save(movie);
			return movieAdd;
		} else {
			throw new MovieNotFoundException(
					"Movie cannot be added as id " + movie.getMovieId() + " already exists in Database.");
		}
		// TODO Auto-generated method stub

	}

	@Override
	public String removeMovie(int movieid) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		if (repository.existsById(movieid)) {
			Movie movieDelete = repository.getOne(movieid);
			repository.delete(movieDelete);
			return "Movie Deleted";
		} else {

			throw new MovieNotFoundException("Movie with Id " + movieid + " cannot be deleted. Not Found in DB.");
		}

	}

	@Override
	public Movie updateMovie(Movie movie) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		if (repository.existsById(movie.getMovieId())) {
			Movie movieUpdate = repository.save(movie);
			return movieUpdate;
		} else {

			throw new MovieNotFoundException(
					"Movie with Id " + movie.getMovieId() + " cannot be updated as it does not exist in DB");
		}

	}

	@Override
	public Movie viewMovie(int movieid) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> movieView = repository.findById(movieid);
		if (movieView.isPresent()) {
			return movieView.get();
		} else {

			throw new MovieNotFoundException("Movie with " + movieid + " does not exist.");
		}

	}

	@Override
	public List<Movie> viewMovieList() throws MovieNotFoundException {

		List<Movie> movieList = repository.findAll();

		if (!movieList.isEmpty()) {
			return movieList;
		} else {

			throw new MovieNotFoundException("Movie List does not exist.");
		}
	}

	@Override
	public List<Movie> viewMovieList(int theatreid) throws MovieNotFoundException {

		Theatre theatre = theatrerepository.getOne(theatreid);
		if (!theatrerepository.existsById(theatreid)) {
			throw new MovieNotFoundException("TheatreId " + theatreid + " not found");
		}

		List<Movie> movieListByTheatreId = theatre.getListOfMovies();

		if (!movieListByTheatreId.isEmpty()) {
			return movieListByTheatreId;
		} else {

			throw new MovieNotFoundException("Movie List does not exist for the theatre Id " + theatreid);
		}
	}

	@Override
	public List<Movie> viewMovieList(LocalDate date) throws MovieNotFoundException {

		List<Movie> movieListbyReleaseDate = repository.findByMovieReleaseDate(date);
		if (!movieListbyReleaseDate.isEmpty()) {
			return movieListbyReleaseDate;
		} else {

			throw new MovieNotFoundException("No Movie Available for the following Release Date " + date);
		}

	}

}
