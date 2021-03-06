package com.revature.users;

import java.io.Serializable;
import java.util.ArrayList;

public class UserList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -800589302506785589L;
	
	private static UserList instance = null;
	private final ArrayList<Customer> cusList;
	private final ArrayList<Employee> empList;
	
	private UserList() {
		cusList = new ArrayList<Customer>();
		empList = new ArrayList<Employee>();
	}
	
	static public UserList getInstance() {
		if(instance == null) {
			instance = new UserList();
		}
		return instance;
	}
	public ArrayList<Customer> getCusList() {
		return cusList;
	}

	public ArrayList<Employee> getEmpList() {
		return empList;
	}
	public void addCustomer(Customer customer) {
		cusList.add(customer);
	}
	public void addEmployee(Employee employee) {
		empList.add(employee);
	}
}
