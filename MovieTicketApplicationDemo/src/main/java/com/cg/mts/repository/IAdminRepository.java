package com.cg.mts.repository;

import com.cg.mts.entities.Users;
import com.cg.mts.exception.UsernameAlreadyExistsException;
import com.cg.mts.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository {
	public static final IUserRepository userRep = new IUserRepository();
	default void registerAdmin(String username, String password) throws UsernameAlreadyExistsException {
		Users user=new Users();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole("Admin");
		userRep.addUsers(user);
	}
}
