package com.cg.mts.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.mts.repository.IMovieRepository;

@Entity
public class Theatre {

	@Id
	private int theatreId;

	@NotEmpty(message = "Please enter the theatre Name")
	private String theatreName;

	@NotEmpty(message = "Please enter the City Name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Please enter only alphabets")
	private String theatreCity;

	@ManyToMany(fetch = FetchType.EAGER)
	// @JoinTable(name = "movie_theatre_master")
	private List<Movie> listOfMovies;

	@OneToMany
	// @JoinColumn(name ="screenId")
	// @JoinTable(name = "screen_theatre_master")
	private List<Screen> listOfScreens;

	@NotEmpty(message = "Please enter the Manager Name")
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String managerName;

	@NotEmpty(message = "Please enter the Manager contact no.")
	@Pattern(regexp = "^[0-9]{10}$", message = "Please enter mobile no. in digits and is of 10")
	private String managerContact;

	public Theatre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Theatre(int theatreId, String theatreName, String theatreCity, String managerName, String managerContact) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}

	public List<Movie> getListOfMovies() {
		// TODO Auto-generated method stub
		return null;
	}



	

}
