package com.revature.services;

import com.revature.accounts.*;

import com.revature.dao.TDAO;
import com.revature.dao.TDAOImpl;

public class tServices {
	private TDAO tDao = new TDAOImpl();
	private AccountService accServ = new AccountService();

	public String withdraw(double amount, int accNumber) {
		Account account = accServ.getAccount(accNumber);
		if(account == null) {
			return "Account not found for withdrawl";
		}
		if (account.getApproved() == "Pending") {
			return "The account is pending approval. No withdrawals allowed until the account is approved.";
		} else if (account.getApproved() == "Cancelled") {
			return "This account has been cancelled. Please talk to a local teller.";
		}
		if (account.getBalance() > amount) {
			if (amount > 0) {

				if (tDao.withdraw(accNumber, amount)) {
					double oldBalance = account.getBalance();
					account = accServ.getAccount(accNumber);

					return "Account [" + account.getAccountNumber() + "] had an account balance of " + oldBalance
							+ " and a withdrawal of " + amount + " was made. The new balance is: "
							+ account.getBalance() + ".";
				} else {
					return "The withdrawl was unsuccessful";
				}
			} else {
				return "You should withdraw an amount bigger than 0.";
			}
		} else {
			return "Insuficient funds to make this withdrawal. Transaction canceled.";
		}
	}

	public String deposit(double amount, int accNumber) {
		Account account = accServ.getAccount(accNumber);
		if(account == null) {
			return "Account not found for deposit";
		}
		if (account.getApproved().equals("Pending")) {
			return "The account is pending approval. No deposits allowed until the account is approved.";
		} else if (account.getApproved().equals("Cancelled") ) {
			return "This account has been cancelled. Please talk to a local teller.";
		}
		if (amount > 0) {
			if (tDao.deposit(accNumber, amount)) {
				double oldBalance = account.getBalance();
				account = accServ.getAccount(accNumber);

				return "Account [" + account.getAccountNumber() + "] had an account balance of " + oldBalance
						+ " and a deposit of " + amount + " was made. The new balance is: "
						+ account.getBalance() + ".";
			} else {
				return "The deposit was unsuccessful";
			}
		} else {
			return "You should deposit an amount bigger than 0.";
		}
	}

	public String transfer(double amount, int senderNumber, int receiverNumber) {
		Account sender = accServ.getAccount(senderNumber);
		Account receiver = accServ.getAccount(receiverNumber);
		if(sender == null) {
			return "Account not found for withdrawl portion. Transfer cancelled.";
		}
		if(receiver == null) {
			return "Account not found for deposit portion. Transfer cancelled.";
		}
		if (amount <= 0) {
			return "The transfer amount should be bigger than 0.";
		} else if (senderNumber == receiverNumber) {
			return "You cannot transfer funds between the same account. Please choose to withdraw or deposit as necessary.";
		} else {
			if (sender.getBalance() < amount) {
				return "Insufficient funds to carry the transaction";
			} else if (sender.getApproved().equals("Pending")) {
				return "The account is pending approval. No transfers allowed until the account is approved.";
			} else if (sender.getApproved().equals("Cancelled")) {
				return "This account has been cancelled. Please talk to a local teller.";
			} else if (receiver.getApproved().equals("Pending") || receiver.getApproved().equals("Cancelled")) {
				return "The recepient account is unable to receive transfers at the moment. Please speak to your recepient.";
			}
			if (sender.getApproved().equals("Approved") && receiver.getApproved().equals("Approved")) {
				if(tDao.transfer(amount, senderNumber, receiverNumber)) {
				
				return "Account [" + sender.getAccountNumber() + "] had an account balance of " + sender.getBalance()
						+ " and a withdrawal of " + amount + " was made. The new balance is: "
						+ accServ.getAccount(senderNumber).getBalance() + "." + " The withdrawn amount was transferred to account [" + receiver.getAccountNumber()
						+ "] and should be available immediately.";
				} else {
					return "Transfer was unsuccessful.";
				}
			}
			return "Unknown account status. Unable to transfer";
		}
	}
}
