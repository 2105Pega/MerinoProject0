package com.revature.users;

import java.io.Serializable;
import java.util.ArrayList;

public class UserList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -800589302506785589L;
	
	static UserList instance = null;
	private final ArrayList<User> uList;
	
	private UserList() {
		uList = new ArrayList<User>();
	}
	
	static public UserList getInstance() {
		if(instance == null) {
			instance = new UserList();
		}
		return instance;
	}
	public ArrayList<User> getUserList() {
		return uList;
	}
}
