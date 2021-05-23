package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.postgresql.util.PSQLException;

import com.revature.accounts.Account;
import com.revature.util.ConnectionUtils;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public Account getAccount(Integer accNumber) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "SELECT account_table.bank_account_id AS accNumber, account_table.account_approved AS approved, account_table.account_balance as balance,	 account_table.account_type , user_account_table.user_id FROM account_table inner join user_account_table on account_table.bank_account_id = user_account_table.bank_account_id where user_account_table.bank_account_id ="
					+ accNumber;

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			result.next();
			Account a = new Account(result.getInt("accNumber"), result.getString("account_type"),
					result.getDouble("balance"), result.getString("approved")

			);
			a.addCustomer(result.getInt("user_id"));
			while (result.next()) {
				a.addCustomer(result.getInt("user_id"));
			}
			return a;

		}  catch(PSQLException e1) {
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

}
