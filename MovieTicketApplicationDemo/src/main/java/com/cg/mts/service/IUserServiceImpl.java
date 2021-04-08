package com.cg.mts.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.repository.IUserRepository;
import com.cg.mts.repository.UserRepository;
import com.cg.mts.exception.UsernameAlreadyExistsException;
import com.cg.mts.exception.UsernameNotFoundException;
import com.cg.mts.entities.Users;
import com.cg.mts.security.StringEncrypter;

import ch.qos.logback.classic.PatternLayout;

@Service
public class IUserServiceImpl implements IUserService {

	static private PatternLayout patternLayout;

	static {
		patternLayout = new PatternLayout();
	}

	@Autowired
	private IUserRepository userRep;

	// Validate if a user exists
	@Override
	public Users validateUser(String username, String password) throws UsernameNotFoundException {

		Users user = userRep.validateUsers(username, password);
		if (user == null) {

			throw new UsernameNotFoundException("User Not Found");
		}

		return user;
	}

	// Add a new user
	@Override
	public Users addUser(Users user) throws UsernameAlreadyExistsException {
		Users u = userRep.addUsers(user);

		return u;
	}

	// Remove a User
	@Override
	public Users removeUser(Users user) throws UsernameNotFoundException {
		Users u = userRep.removeUsers(user);

		return user;
	}

	@Override
	public List<Users> getAllUsers() {
		return userRep.getAllUsers();
	}

	@Override
	public boolean deleteUserById(int userId) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRep.removeUserById(userId);
	}

}
