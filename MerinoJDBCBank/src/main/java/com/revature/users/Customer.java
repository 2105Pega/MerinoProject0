package com.revature.users;

import java.util.ArrayList;

import com.revature.accounts.Account;

public class Customer extends User {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -5125388050983655948L;
	
	private String address;
	private String phone;
	private ArrayList<Account> accountList;
	private int numberOfAccounts;
	
	public Customer(String user, String pass, String firstName, String lastName) {
		super(user, pass, firstName, lastName);
		accountList = new ArrayList<Account>();
		numberOfAccounts = 0;
	}
	public Customer(String user, String pass, String firstName, String lastName, String address) {
		super(user, pass, firstName, lastName);
		this.address = address;
		accountList = new ArrayList<Account>();
		numberOfAccounts = 0;
	}
	public Customer(String user, String pass, String firstName, String lastName, String address, String phone) {
		super(user, pass, firstName, lastName);
		this.address = address;
		this.phone = phone;
		accountList = new ArrayList<Account>();
		numberOfAccounts = 0;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void addAccount(Account newAccount) {
		this.accountList.add(newAccount);
		numberOfAccounts++;
		
		/*
		 * Debugging code commented out
		System.out.println("Added " + newAccount + ". The current list of accounts for user "+ this.getUserName() +  " is:");
		for(int i = 0; i < accountList.size(); i++) {
			int j = i + 1;
			System.out.println(j + ". The " + accountList.get(i));
		}
		*/
	}
	public Account getAccount(int index) {
		return this.accountList.get(index);
	}
	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	

}
