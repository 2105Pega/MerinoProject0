package com.revature.services;

import com.revature.users.Customer;
import com.revature.users.Employee;
import com.revature.users.UserList;

public class UserService {
	
	public static Customer findCustomer(UserList ul, String userName) {
		for(Customer cus: ul.getCusList()) {
			if(cus.getUserName().equals(userName)) {
				return cus;
			}
		}
		return null;
	}
	public static Employee findEmployee(UserList ul, String userName) {
		for(Employee emp: ul.getEmpList()) {
			if(emp.getUserName().equals(userName)) {
				return emp;
			}
		}
		return null;
	}
}
