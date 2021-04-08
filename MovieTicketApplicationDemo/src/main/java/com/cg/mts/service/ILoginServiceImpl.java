package com.cg.mts.service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.repository.IUserRepository;
import com.cg.mts.repository.UserRepository;

import ch.qos.logback.classic.PatternLayout;

import com.cg.mts.exception.InvalidUsernameException;
import com.cg.mts.entities.Users;

@Service
public class ILoginServiceImpl implements ILoginService {

	static private PatternLayout patternLayout;
	
	static {
		patternLayout = new PatternLayout();

	}

	@Autowired
	private IUserRepository loginRepository;

	@Override
	public Users login(Users user) throws InvalidUsernameException {
		Users username = loginRepository.validateUsers(user.getUsername(), user.getPassword());

		if (username == null) {

			throw new InvalidUsernameException(
					"The username or password that you've entered doesn't match to any account");

		}

		return username;
	}

	@Override
	public Users logout(Users user) throws InvalidUsernameException {

		Users username = loginRepository.validateUsers(user.getUsername(), user.getPassword());

		if (username == null) {

			throw new InvalidUsernameException(
					"The username or password that you've entered doesn't match to any account");

		}

		return username;
	}
}
