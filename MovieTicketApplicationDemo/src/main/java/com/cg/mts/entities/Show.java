package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

@Entity
@Table(name="Showtable")
public class Show {

	@Id
	private int showId;
	@JsonFormat(pattern = "HH:mm:ss", shape = JsonFormat.Shape.STRING)
	private LocalTime showStartTime;
	@JsonFormat(pattern = "HH:mm:ss", shape = JsonFormat.Shape.STRING)
	private LocalTime showEndTime;
	private String showName;
	@OneToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "movie_Id")
	private Movie movie;
	private int screenId;
	private int theatreId;

	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Show(int showId, LocalTime showStartTime, LocalTime showEndTime, String showName, Movie movie, int screenId,
			int theatreId) {
		super();
		this.showId = showId;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.showName = showName;
		this.movie = movie;
		this.screenId = screenId;
		this.theatreId = theatreId;
	}

	public Show(int showId, String showName, int screenId, int theatreId) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.screenId = screenId;
		this.theatreId = theatreId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalTime getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(LocalTime showStartTime) {
		this.showStartTime = showStartTime;
	}

	public LocalTime getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(LocalTime showEndTime) {
		this.showEndTime = showEndTime;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime
				+ ", showName=" + showName + ", movie=" + movie + ", screenId=" + screenId + ", theatreId=" + theatreId
				+ "]";
	}

}