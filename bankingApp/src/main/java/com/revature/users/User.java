package com.revature.users;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5277968277661592946L;
	private String userName;
	private String password;
	
	public User(String user, String pass) {
		super();
		userName = user;
		password = pass;
	}

	public String getUserName() {
		return userName;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}