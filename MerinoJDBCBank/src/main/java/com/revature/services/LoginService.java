package com.revature.services;

import java.util.Scanner;

import com.revature.app.Driver;
import com.revature.users.Customer;
import com.revature.users.Employee;
import com.revature.users.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginService {

	private static final Logger logger = LogManager.getLogger(Driver.class);
	private UserService uServ = new UserService();
	private CustomerService cServ = new CustomerService();
	private EmployeeService eServ = new EmployeeService();

	public void service( Scanner sc) {
		while (true) {
			System.out.println(
					"Welcome to Luis' banking app! Please type 'login' to login to an existing account or 'create' to create an account. Type 'exit' to exit the program.");
			String response = sc.nextLine();
			if (response.equals("exit")) {
				System.out.println("Goodbye!");
				break;
			}
			switch (response) {
			case "login":
				login( sc);
				break;
			case "create":
				createUser( sc);
				break;
			default:
				System.out.println("Invalid entry.");
				continue;
			}

		}

	}

	public void login( Scanner sc) {
		while (true) {
			System.out.println("Please type your username or write 'exit' to exit this menu:");
			String userName = sc.nextLine();
			User user;
			if (userName.equals("exit")) {
				break;
			}
			user = uServ.getUser(userName);
			if (user == null) {
				System.out.println("User not found.");
				continue;
			}
			System.out.println("Please type your password.");
			String password = sc.nextLine();
			if (user.getPassword().equals(password)) {
				if (user.getUserType() == 1) {
					Customer cus = cServ.getCustomer(user.getUserID());

					cServ.service(cus, sc);
					continue;

				} else if (user.getUserType() == 2) {
					Employee emp = eServ.getEmployee(user.getUserID());

					eServ.service(emp, sc);
					continue;

				} else {
//					
//					
					continue;
				}

			} else {
				System.out.println("Incorrect username and password combination");
				continue;
			}

		}
	}

	public void createUser( Scanner sc) {
		while (true) {
			System.out.println("Please type your desired username or write 'exit' to exit this menu:");
			String user = sc.nextLine();
			if (user.equals("exit")) {
				break;
			}
			if (uServ.getUser(user) != null) {
				System.out.println("Username " + user + " is unavailable.");
				continue;
			} else {
				String pass;
				while (true) {
					System.out.println("Please type your password.");
					pass = sc.nextLine();
					System.out.println("Please type your password again.");
					String conf = sc.nextLine();
					if (pass.equals(conf) != true) {
						System.out.println("The passwords didn't match");
						continue;
					} else {
						break;
					}
				}
				System.out.println("Please provide your first name.");

				String firstName = sc.nextLine();
				System.out.println("Please provide your last name");
				String lastName = sc.nextLine();
				boolean correct;
				while (true) {
					System.out.println("Information provided: User name " + user + " for " + firstName + " " + lastName
							+ ". Is this correct? Type 'yes' or 'no'");
					String response = sc.nextLine();
					switch (response) {
					case "yes":
						correct = true;
						break;
					case "no":
						correct = false;
						break;
					default:
						System.out.println("Invalid Response");
						continue;
					}
					break;
				}
				if (!correct) {
					continue;
				} else {

					while (true) {
						System.out.println(
								"Are you a customer or an employee? Type 'customer' or 'employee', or 'exit' to leave the menu.");
						String type = sc.nextLine();
						if (type.equals("exit")) {
							break;
						}
						switch (type) {
						case "customer":
							Customer cus = new Customer(1, user, pass, firstName, lastName);
							cServ.createCustomer(user, pass, firstName, lastName);
							logger.trace("Created customer " + cus.getFirstName() + " " + cus.getLastName() + " with username " + cus.getUserName() + "." );
							System.out.println("Created this customer account.");
							break;
						case "employee":
							Employee emp = new Employee(1, user, pass, firstName, lastName, 2);
							eServ.createEmployee(user, pass, firstName, lastName);
							logger.trace("Created employee " + emp.getFirstName() + " " + emp.getLastName() + " with username " + emp.getUserName() + "." );
							System.out.println("Created this employee account.");
							break;
						default:
							System.out.println("Invalid input.");
							continue;
						}
						break;
					}
					break;
				}

			}
		}
	}

}
