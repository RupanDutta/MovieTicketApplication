package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Users {
	@Id
	@GeneratedValue
	// Primary Key for Users
	private int usersId;
	// Property of Users

	private String username;
	// Property of Users

	private String password;
	// Property of Users

	private String role;

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int usersId, String username, String password, String role) {
		super();
		this.usersId = usersId;
		this.username = username;
		this.password = password;
		this.role = role;
	}

}