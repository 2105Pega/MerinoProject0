package com.revature.accounts;
import com.revature.services.AccountService;
import com.revature.users.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -921326158968652254L;
	private final Integer accountNumber;
	private final String accountType;
	private double balance;
	private String approved;
	private ArrayList<Customer> customerList;
	
	
	
	public Account(UserList ul, double balance, String type, Customer ...customers ) {
		this.balance = balance;
		while (true) {
		Random rand = new Random();
		Integer generated = rand.nextInt(900000000) + 100000000;
		if (AccountService.checkAvailable(generated, ul)) {
			accountNumber = generated;
			break;
		}
		
		}
		
		approved = "Pending";
		if (type.equals("Checking")  || type.equals("checking") ) {
			this.accountType = "Checking";
		} else {
			this.accountType ="Savings";
		}
		this.customerList = new ArrayList<Customer>();
		for (Customer customer: customers) {
			customerList.add(customer);
			customer.addAccount(this);
			
		}
		
		
	}
	public String getAccountType() {
		return this.accountType;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	public Customer getCustomer(int i) {
		return customerList.get(i);
	}

	@Override
	public String toString() {
		switch (this.getApproved()) {
		case "Pending":
			return this.getAccountType() + " account [" + this.getAccountNumber() + "] is pending and has a balance of: " + this.getBalance() + ".";
		case "Approved":
			return this.getAccountType() + " account [" + this.getAccountNumber() + "] has a balance of: " + this.getBalance() + ".";
		default:
			return this.getAccountType() + " account [" + this.getAccountNumber() + "] has been canceled.";
		}
	}
	
	
	
	
}
