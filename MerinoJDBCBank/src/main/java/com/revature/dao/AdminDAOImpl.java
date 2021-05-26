package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.postgresql.util.PSQLException;


import com.revature.users.Admin;

import com.revature.users.User;
import com.revature.util.ConnectionUtils;

public class AdminDAOImpl implements AdminDAO {
	

	@Override
	public boolean createAdmin(String user, String password, String fName, String lName) {
		// TODO Auto-generated method stub
		try  (Connection conn = ConnectionUtils.getConnection()){
			String sql = "insert into user_table (user_name, user_pass, user_f_name, user_l_name, user_type) values (?, ?, ?, ?, 3)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user);
			statement.setString(2, password);
			statement.setString(3, fName);
			statement.setString(4, lName);
			statement.execute();
			return true;
		
		} catch(PSQLException e1) {
			return false;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean updatePassword(User user, String newPassword) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "update user_table set user_pass = ? where user_id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newPassword);
			statement.setInt(2, user.getUserID());
			statement.execute();
			return true;
					
					
		}catch(PSQLException e1) {
			
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateName(User user, String fName, String lName) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "update user_table set user_f_name = ?, user_l_name = ? where user_id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, fName);
			statement.setString(2, lName);
			statement.setInt(3, user.getUserID());
			statement.execute();
			return true;
					
					
		}catch(PSQLException e1) {
			
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int userID) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtils.getConnection()){
			String sql = "delete from user_table where user_id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, userID);
			statement.execute();
			return true;
		} catch(PSQLException e1) {
			
			return false;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public Admin getAdmin(int userID) {
		// TODO Auto-generated method stub
		Admin adm = null;
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "SELECT user_table.user_id AS userID, user_table.user_name AS username, user_table.user_pass as password,	 user_table.user_f_name as fName , user_table.user_l_name as lName FROM user_table  where user_table.user_id = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, userID);
			ResultSet result = statement.executeQuery();
			result.next();
			adm = new Admin(result.getInt("userID"), result.getString("username"), result.getString("password"),
					result.getString("fName"), result.getString("lName")

			);
			return adm;

		} catch (PSQLException e1) {
			
			return null;
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		return null;
	}
	

}
