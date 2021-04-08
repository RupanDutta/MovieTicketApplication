package com.cg.mts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Theatre;
import com.cg.mts.exception.TheatreAlreadyExistsException;
import com.cg.mts.repository.ITheatreRepository;

@Service
public class ITheatreSeviceImpl implements ITheatreService {

	@Autowired
	ITheatreRepository service;
	
	@Override
	public Theatre addTheatre(Theatre theatre) throws TheatreAlreadyExistsException {
		if(service.existsById(theatre.getTheatreId())) {
			throw new TheatreAlreadyExistsException("Theatre already Exists.");
		}
		return theatre;
	}

	@Override
	public List<Theatre> viewTheatreList() {
		// TODO Auto-generated method stub
		return null;
	}

}
