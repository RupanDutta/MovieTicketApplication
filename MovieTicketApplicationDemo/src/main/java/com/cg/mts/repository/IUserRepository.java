package com.cg.mts.repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

import com.cg.mts.exception.UsernameAlreadyExistsException;
import com.cg.mts.exception.UsernameNotFoundException;
import com.cg.mts.entities.Users;
import com.cg.mts.security.StringEncrypter;

@Repository
public class IUserRepository{
	@Autowired
	private UserRepository usersRepo;

	public Users validateUsers(String Usersname, String password) {
		StringEncrypter encrypt = new StringEncrypter();
		List<Users> list = usersRepo.findAll();
		for (Users u : list) {
			if (u.getUsername().equals(Usersname)) {
				String dcypPassword = encrypt.decrypt(u.getPassword());

				if (dcypPassword.equals(password)) {

					return u;
				}
			}
		}
		return null;
	}

	public Users addUsers(Users user) throws UsernameAlreadyExistsException {
		StringEncrypter encrypt = new StringEncrypter();
		String encPass = encrypt.encrypt(user.getPassword());
		user.setPassword(encPass);
		List<Users> userList = usersRepo.findAll();
		for (Users list : userList) {
			if (list.getUsername().equals(user.getUsername())) {
				throw new UsernameAlreadyExistsException("This is username is already used");
			}
		}
		Users u = usersRepo.save(user);
		return user;
	}

	public boolean removeUserById(int userId) throws UsernameNotFoundException {
		Optional<Users> u = usersRepo.findById(userId);
		Users user = null;
		try {
			user = u.get();
		} catch (NoSuchElementException e) {
			throw new UsernameNotFoundException("User Not Found");
		}
		usersRepo.deleteById(userId);
		return true;
	}

	public Users removeUsers(Users users) throws UsernameNotFoundException {
		StringEncrypter encrypt = new StringEncrypter();
		users.setPassword(encrypt.encrypt(users.getPassword()));
		Optional<Users> u = usersRepo.findByUsername(users.getUsername());
		Users user = null;
		try {
			user = u.get();
		} catch (NoSuchElementException e) {
			throw new UsernameNotFoundException("User Not Found");
		}

		usersRepo.delete(user);
		return user;
	}

	public List<Users> getAllUsers() {
		return usersRepo.findAll();
	}
}
