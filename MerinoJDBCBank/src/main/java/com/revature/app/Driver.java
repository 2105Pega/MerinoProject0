package com.revature.app;

//import com.revature.accounts.Account;
//import com.revature.exceptions.InvalidActionException;
//import com.revature.services.AccountService;
//import com.revature.services.AdminService;
//import com.revature.services.CustomerService;
//import com.revature.services.EmployeeService;
//
//import com.revature.services.UserListService;
//import com.revature.services.UserService;
//import com.revature.services.tServices;
//import com.revature.users.*;

import java.util.NoSuchElementException;
import java.util.Scanner;
import com.revature.services.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver {

	private static final Logger logger = LogManager.getLogger(Driver.class);

	public static void main(String[] args) {
		
		
		//Code obsoleted by implementation of database
//		UserList ul = UserListService.readUL();
		

		
		
		Scanner sc = new Scanner(System.in);
//		
		LoginService lServ = new LoginService();
		try {
			lServ.service(sc);
		} catch (NoSuchElementException e) {

			System.out.println("Force exiting the application.");
			logger.fatal("User exited the application forcefully using a shortcut.");
		} catch (Exception e) {

			System.out.println("Caught unexpected exception. Closing the application.");
			logger.fatal("Unexpected RuntimeException: " + e.getMessage());
		}


		
		
		//Code obsoleted by implementation of database
//		UserListService.writeUL(ul);
//		sc.close();
//		logger.trace("Exited the application correctly after writing the state of our UserList.");
//		
//		

		
		
		
		//Manual unit tests for program features.
		
		// Testing get Account
//		AccountService accServ = new AccountService();
//		Account a = accServ.getAccount(8);
//		System.out.println(a);
//		
		// Testing withdraw
//		tServices tServ = new tServices();
//		System.out.println(tServ.withdraw(500, 4));
//		
//		//Testing Deposit
//		tServices tServ = new tServices();
//		System.out.println(tServ.deposit(500, 1));

		// Testing Transfer
//		tServices tServ = new tServices();
//		System.out.println(tServ.transfer(2000, 4, 5));

		// Testing getUser
//		UserService uServ = new UserService();
//		System.out.println(uServ.getUser("test"));

//		Testing getCustomer
//		CustomerService cServ = new CustomerService();
//		System.out.println(cServ.getCustomer(1));

		// Testing createAccount
//		AccountService accServ = new AccountService();
//		Account a = accServ.getAccount(8);
//		System.out.println(accServ.createAccount(a));

		// Testing deleteAccount
//		AccountService accServ = new AccountService();
//		System.out.println(accServ.deleteAccount(9));

		// Testing setApproved
//		AccountService accServ = new AccountService();
//		System.out.println(accServ.setApproved(2, "Cancelled"));

		// Testing listAccounts
//		CustomerService cServ = new CustomerService();
//		cServ.listAccounts(cServ.getCustomer(1));

		// testing Customer updatePassword
//		CustomerService cServ = new CustomerService();
//		Customer c = cServ.getCustomer(1);
//		cServ.updatePassword(c, sc);

		// testing Customer accounts
//		CustomerService cServ = new CustomerService();
//		Customer c = cServ.getCustomer(1);
//		cServ.accounts(c, sc);

		// testing Customer openAccount
//		CustomerService cServ = new CustomerService();
//		Customer c = cServ.getCustomer(1);
//		cServ.openAccount(c, sc);

		// testing customer update
//		CustomerService cServ = new CustomerService();
//		Customer c = cServ.getCustomer(1);
//		cServ.update(c, sc);

		// testing Customer service
//		CustomerService cServ = new CustomerService();
//		Customer c = cServ.getCustomer(1);
//		cServ.service(c, sc);

		// testing employee approveAccount
//		EmployeeService eServ = new EmployeeService();
//		Employee e = new Employee(1, "morejonpa", "pass", "Pablo", "Morejon", 2);
//		System.out.println(eServ.approveAccount(e, 10));

		// testing employee cancelAccount
//		EmployeeService eServ = new EmployeeService();
//		Employee e = new Employee(1, "morejonpa", "pass", "Pablo", "Morejon", 2);
//		System.out.println(eServ.cancelAccount(e, 2));

		// testing employee rejectAccount
//		EmployeeService eServ = new EmployeeService();
//		Employee e = new Employee(1, "morejonpa", "pass", "Pablo", "Morejon", 2);
//		System.out.println(eServ.rejectAccount(e, 8));

		// Testing employee displayCustomers
//		EmployeeService eServ = new EmployeeService();
//		eServ.displayCustomers();

		// testing employee pendingService
//		EmployeeService eServ = new EmployeeService();
//		Employee e = new Employee(1, "morejonpa", "pass", "Pablo", "Morejon", 2);
//		eServ.pendingService(e, sc);

		// Testing employee cancelService
//		EmployeeService eServ = new EmployeeService();
//		Employee e = new Employee(1, "morejonpa", "pass", "Pablo", "Morejon", 2);
//		eServ.cancelService(e, sc);

		// testing employee withdrawService
//		EmployeeService eServ = new EmployeeService();
//		Employee e = new Employee(1, "morejonpa", "pass", "Pablo", "Morejon", 2);
//		eServ.withdrawService(e, sc);

		// testing employee depositService
//		EmployeeService eServ = new EmployeeService();
//		Employee e = new Employee(1, "morejonpa", "pass", "Pablo", "Morejon", 2);
//		eServ.depositService(e, sc);

		// testing employee transferService
//		EmployeeService eServ = new EmployeeService();
//		Employee e = new Employee(1, "morejonpa", "pass", "Pablo", "Morejon", 2);
//		eServ.transferService(e, sc);
//		
		// testing employee transferService
//		EmployeeService eServ = new EmployeeService();
//		Employee e = new Employee(1, "morejonpa", "pass", "Pablo", "Morejon", 2);
//		eServ.transactionService(e, sc);

		// testing employee customerDisplayService
//		EmployeeService eServ = new EmployeeService();
//		Employee e = new Employee(1, "morejonpa", "pass", "Pablo", "Morejon", 2);
//		eServ.customerDisplayService(e, sc);

		// testing employee service
//		EmployeeService eServ = new EmployeeService();
//		Employee e = new Employee(1, "morejonpa", "pass", "Pablo", "Morejon", 2);
//		eServ.service(e, sc);

		// testing employeeDao getEmployee
//		EmployeeService eServ = new EmployeeService();
//		System.out.println(eServ.getEmployee(2));

		// testing CustomerDao createCustomer
//		CustomerService cServ = new CustomerService();
//		System.out.println(cServ.createCustomer("castellanoIs", "pass", "Isabel", "Castellano"));
//		
		// testing EmployeeDao createEmployee
//		EmployeeService eServ = new EmployeeService();
//		System.out.println(eServ.createEmployee("morejonis", "pass", "Isabel", "Morejon"));

		//testing User getUserList
//		UserService uServ = new UserService();
//		System.out.println(uServ.getUserList());
		
		//testing admin displayUser
//		AdminService admServ = new AdminService(); 
//		admServ.displayUsers();
//		
//		//testing admin createAdmin
//		AdminService admServ = new AdminService();
//		System.out.println(admServ.createAdmin("revature", "securePassword", "Luis", "Merino"));
		
		//testing admin createUser
//		AdminService admServ = new AdminService();
//		admServ.createUser(sc);
		
		//testing admin updatePassword
//		AdminService admServ = new AdminService();
//		UserService uServ = new UserService();
//		System.out.println(admServ.updatePassword(uServ.getUser("merinolu"), "pass"));
		
		//testing admin updatePasswordService
//		AdminService admServ = new AdminService();
//		UserService uServ = new UserService();
//		admServ.updatePasswordService(uServ.getUser("merinolu"), sc);

		//testing admin updateName
//		AdminService admServ = new AdminService();
//		UserService uServ = new UserService();
//		System.out.println(admServ.updateName(uServ.getUser("merinolu"), "Luis Pablo", "Merino Morejon"));
//		
		//testing admin updateNameService
//		AdminService admServ = new AdminService();
//		UserService uServ = new UserService();
//		admServ.updateNameService(uServ.getUser("merinolu"), sc);
		
		//testing user getUser(id)
//		UserService uServ = new UserService();
//		System.out.println(uServ.getUser(1));
		
		//testing admin update
//		AdminService admServ = new AdminService();
//		admServ.update( sc);
		
		//testing customer deleteCustomer
//		CustomerService cServ= new CustomerService();
//		System.out.println(cServ.deleteCustomer(17));
		
//		//testing admin deleteUser
//		AdminService admServ = new AdminService();
//		System.out.println(admServ.deleteUser(11));
		
		//testing admin getAdmin
//		AdminService admServ = new AdminService();
//		System.out.println(admServ.getAdmin(12));
		
		//testing admin deleteUserService
//		AdminService admServ = new AdminService();
//		Admin adm = admServ.getAdmin(12);
//		admServ.deleteUserService(sc, adm);
		
		//testing admin service
//		AdminService admServ = new AdminService();
//		Admin adm = admServ.getAdmin(12);
//		admServ.service(adm, sc);
		
		//testing custom exception
//		try {
//			throw new InvalidActionException("Such and such");
//		} catch(InvalidActionException e) {
//			System.out.println(e.getMessage());
//		}
		
		
		sc.close();
		
		
	}

}
