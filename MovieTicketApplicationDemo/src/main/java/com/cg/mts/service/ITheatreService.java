package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Theatre;
import com.cg.mts.exception.TheatreAlreadyExistsException;

public interface ITheatreService {
	public Theatre addTheatre(Theatre theatre) throws TheatreAlreadyExistsException;
	public List<Theatre> viewTheatreList();
	

}
