package com.cg.mts.service;

import com.cg.mts.exception.UsernameAlreadyExistsException;

public interface IAdminService {
	public void registerAdmin(String username, String password) throws UsernameAlreadyExistsException;
}
