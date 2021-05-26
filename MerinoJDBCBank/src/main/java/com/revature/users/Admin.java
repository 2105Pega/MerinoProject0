package com.revature.users;

public class Admin extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1609667111233476691L;


	public Admin (int userID, String user, String password, String fName, String lName) {
		super(userID, user, password, fName, lName, 3);
		
	}
}
