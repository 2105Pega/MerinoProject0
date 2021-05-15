package com.revature.services;
import com.revature.accounts.*;

public class tServices {
	
	public static String withdraw(double amount, Account account) {
		if (account.getBalance() > amount) {
			if (amount > 0) {
				double oldBalance = account.getBalance();
				double newBalance = oldBalance - amount;
				account.setBalance(newBalance);
				return "Account [" + account.getAccountNumber() + "] had an account balance of " + oldBalance + " and a withdrawal of " + amount + " was made. The new balance is: " + account.getBalance() + ".";
			} else {
				return "You should withdraw an amount bigger than 0.";
			}
		} else {
			return "Insuficient funds to make this withdrawal. Transaction canceled.";
		}
	}
	
	public static String deposit(double amount, Account account) {
		return "";
	}
}
