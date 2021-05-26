package com.revature.dao;

import com.revature.users.Admin;
import com.revature.users.User;

public interface AdminDAO {
	public boolean createAdmin(String user, String password, String fName, String lName);
	public boolean updatePassword(User user, String newPassword);
	public boolean updateName(User user, String fName, String lName);
	public boolean deleteUser(int userID);
	public Admin getAdmin(int userID);
}
