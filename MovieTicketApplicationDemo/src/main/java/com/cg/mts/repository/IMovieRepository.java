package com.cg.mts.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Movie;
import com.cg.mts.exception.MovieNotFoundException;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

//	public Movie addMovie(Movie movie);
//
//	public Movie removeMovie(int movieid) throws MovieNotFoundException;
//
//	public Movie updateMovie(Movie movie) throws MovieNotFoundException;
//
//	public Movie viewMovie(int movieid) throws MovieNotFoundException;
//
//	public List<Movie> viewMovieList();
//
//	public List<Movie> viewMovieList(int theatreid);
//
//	public List<Movie> viewMovieList(LocalDate date);
//
	
	@Query("SELECT e FROM Movie e WHERE e.movieReleaseDate=?1")
	public List<Movie> findByMovieReleaseDate(LocalDate movieReleaseDate) throws MovieNotFoundException;

	@Query("SELECT e FROM Movie e WHERE e.movieId=?1")
	public Movie findByMovieId(int movieId) throws MovieNotFoundException;
}
