package com.cg.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.repository.IAdminRepository;
import com.cg.mts.entities.Users;
import com.cg.mts.exception.UsernameAlreadyExistsException;

@Service
public class IAdminServiceImpl implements IAdminService {
	@Autowired
	private IAdminRepository adminRep;
	public void registerAdmin(String username, String password) throws UsernameAlreadyExistsException {
		adminRep.registerAdmin(username, password);
	}
}