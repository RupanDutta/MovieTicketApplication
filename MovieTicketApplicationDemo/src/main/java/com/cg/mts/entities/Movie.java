package com.cg.mts.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Movie {

	@Id
	private int movieId;
	
	@NotEmpty(message = "Movie Name cannot be empty")
	private String movieName;
	
	@NotEmpty(message = "Movie Genre cannot be empty")
	@Pattern(regexp ="^[a-zA-Z]+$", message="Please enter only alphabets")
	@Size(max = 30, message ="Movie Genre cannot exceed 30 characters")
	private String movieGenre;
	
	@NotEmpty(message = "Movie Hours cannot be empty")
	@Pattern(regexp ="^[0-9]{2} hours [0-9]{2} mins$", message="Please enter movie hours in hh hours mm mins") 
	private String movieHours;

	@NotEmpty(message = "Movie Language cannot be empty")
	@Pattern(regexp ="^[a-zA-Z]+$", message="Please enter only alphabets")
	private String movieLanguage;
	
	@NotEmpty(message ="Movie Description cannot be empty")
	@Size(max = 150, message="Description cannot exceed 150 characters")
	private String movieDescription;
	
	private LocalDate movieReleaseDate;
	
	public Movie(int movieId, String movieName, String movieGenre, String movieHours, String movieLanguage,
			String movieDescription) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieHours = movieHours;
		this.movieLanguage = movieLanguage;
		this.movieDescription = movieDescription;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieHours() {
		return movieHours;
	}

	public void setMovieHours(String movieHours) {
		this.movieHours = movieHours;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre + ", movieHours="
				+ movieHours + ", movieLanguage=" + movieLanguage + ", movieDescription=" + movieDescription + "]";
	}

}