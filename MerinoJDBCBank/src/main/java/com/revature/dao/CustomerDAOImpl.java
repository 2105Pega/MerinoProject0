package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.postgresql.util.PSQLException;

import com.revature.users.Customer;
import com.revature.users.User;
import com.revature.util.ConnectionUtils;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Customer c = null;
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "SELECT user_table.user_id AS userID, user_table.user_name AS username, user_table.user_pass as password,	 user_table.user_f_name as fName , user_table.user_l_name as lName, personal_information_table.phone_number as phone, personal_information_table.address  FROM user_table inner join personal_information_table on personal_information_table.user_id = user_table.user_id where user_table.user_id = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			result.next();
			c = new Customer(result.getInt("userID"), result.getString("username"), result.getString("password"),
					result.getString("fName"), result.getString("lName"), result.getString("address"),
					result.getString("phone")

			);
			

		} catch (PSQLException e1) {
			return null;
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "select user_account_table.bank_account_id as bankID from user_account_table where user_account_table.user_id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				c.addAccount(result.getInt("bankID"));
			}
			
			return c;
		} catch (PSQLException e1) {
			return c;
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

}
