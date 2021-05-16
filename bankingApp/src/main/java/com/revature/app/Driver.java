package com.revature.app;
import com.revature.accounts.*;
import com.revature.services.CustomerService;
import com.revature.services.UserListService;
import com.revature.users.*;
import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Testing CustomerService
		System.out.println("Lets try CustomerService");
		UserList ul = UserListService.readUL();
		Customer cus = new Customer("merinolu", "pass", "Luis", "Merino");
		ul.addCustomer(cus);
		Account a = new Account(ul, 20, "checking", cus);
		Account b = new Account(ul, 20, "checking", cus);
		Account c = new Account(ul, 20, "checking", cus);
		a.setApproved("Approved");
		b.setApproved("Approved");
		c.setApproved("Cancelled");
		CustomerService.service(cus, ul, sc);
		//end of testing CustomerService
		
		
		
		
	}
	
	
	
	
}
