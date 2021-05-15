package com.revature.accounts;
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
	private double balance;
	private String approved;
	private ArrayList<Customer> customerList;
	
	
	public Account(double balance, Customer ...customers ) {
		this.balance = balance;
		Random rand = new Random();
		Integer generated = rand.nextInt(900000000) + 100000000;
		accountNumber = generated;
		approved = "Pending";
		this.customerList = new ArrayList<Customer>();
		for (Customer customer: customers) {
			customerList.add(customer);
			customer.addAccount(this);
			
		}
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
			return "account [" + this.getAccountNumber() + "] is pending and has a balance of: " + this.getBalance() + ".";
		case "Approved":
			return "account [" + this.getAccountNumber() + "] has a balance of: " + this.getBalance() + ".";
		default:
			return "account [" + this.getAccountNumber() + "] has been canceled.";
		}
	}
	
	
	
	
}