package com.revature.users;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5277968277661592946L;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private int userID;
	
	public User(int userID, String user, String pass, String firstName, String lastName) {
		super();
		this.userID = userID;
		userName = user;
		password = pass;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
