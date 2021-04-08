package com.cg.mts.service;
import com.cg.mts.entities.Users;
import com.cg.mts.exception.InvalidUsernameException;


public interface ILoginService {
	public Users login(Users user) throws InvalidUsernameException;
	public Users logout(Users user) throws InvalidUsernameException;
}