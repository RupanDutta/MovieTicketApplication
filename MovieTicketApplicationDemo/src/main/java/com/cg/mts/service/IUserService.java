package com.cg.mts.service;


import java.util.List;

import com.cg.mts.entities.Users;
import com.cg.mts.exception.UsernameAlreadyExistsException;
import com.cg.mts.exception.UsernameNotFoundException;

public interface IUserService {
	public List<Users> getAllUsers();
	public boolean deleteUserById(int userId) throws UsernameNotFoundException;
	public Users validateUser(String username, String password) throws UsernameNotFoundException;
	public Users addUser(Users user) throws UsernameAlreadyExistsException;
	public Users removeUser(Users user) throws UsernameNotFoundException;
}
