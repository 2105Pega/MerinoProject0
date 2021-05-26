package com.revature.services;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.revature.app.Driver;
import com.revature.dao.AdminDAO;
import com.revature.dao.AdminDAOImpl;

import com.revature.users.Admin;
import com.revature.users.Customer;
import com.revature.users.Employee;
import com.revature.users.User;

public class AdminService {

	private static final Logger logger = LogManager.getLogger(Driver.class);
	private UserService uServ = new UserService();
	private CustomerService cServ = new CustomerService();
	private EmployeeService eServ = new EmployeeService();
	private AdminDAO admDao = new AdminDAOImpl();

	public void service(Admin admin, Scanner sc) {
		System.out.println("Welcome " + admin.getFirstName() + " " + admin.getLastName() + ".");

		while (true) {

			System.out.println(
					"To view existing users type 'view', to create a new user type 'create', to update an existing user type 'update', to delete a user type 'delete', and to logout type 'logout'.");
			String response;
			try {
				response = sc.nextLine();
			} catch (NoSuchElementException e) {
				e.printStackTrace();
				throw new NoSuchElementException("Ctrl-z stops the program. Good bye.");
			}
			if (response.equals("logout")) {
				break;
			}
			switch (response) {
			case "view":
				displayUsers();
				break;
			case "create":
				createUser(sc);
				break;
			case "update":
				update(sc);
				break;
			case "delete":
				deleteUserService(sc, admin);
				break;
			default:
				System.out.println("Invalid selection.");
				continue;
			}

		}
		System.out.println("Good bye " + admin.getFirstName() + " " + admin.getLastName() + ".");
	}

	public void displayUsers() {
		int list = 1;
		for (String user : uServ.getUserList()) {
			User u = uServ.getUser(user);
			String print = list + ". User ID " + u.getUserID() + " is assigned to " + u.getFirstName() + " "
					+ u.getLastName() + " and is a user of type ";
			switch (u.getUserType()) {
			case 3:
				print += "administrator.";
				break;
			case 2:
				print += "employee.";
				break;
			default:
				print += "customer.";
				break;
			}
			System.out.println(print);
			list++;
		}

	}

	public void createUser(Scanner sc) {
		while (true) {
			System.out.println("Please type the desired username or write 'exit' to exit this menu:");
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
					System.out.println("Please type the password.");
					pass = sc.nextLine();
					System.out.println("Please type the password again.");
					String conf = sc.nextLine();
					if (pass.equals(conf) != true) {
						System.out.println("The passwords didn't match");
						continue;
					} else {
						break;
					}
				}
				System.out.println("Please provide the first name for this user.");

				String firstName = sc.nextLine();
				System.out.println("Please provide the last name for this user.");
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
								"Are you creating a customer, an employee, or an administrator account? Type 'customer' or 'employee' or 'administrator', or 'exit' to leave the menu.");
						String type = sc.nextLine();
						if (type.equals("exit")) {
							break;
						}
						switch (type) {
						case "customer":
							Customer cus = new Customer(1, user, pass, firstName, lastName);
							if (cServ.createCustomer(user, pass, firstName, lastName)) {
								logger.trace("Created customer " + cus.getFirstName() + " " + cus.getLastName()
										+ " with username " + cus.getUserName() + ".");
								System.out.println("Created this customer account.");
								break;
							} else {
								System.out.println("Error creating customer account.");
								break;
							}

						case "employee":
							Employee emp = new Employee(1, user, pass, firstName, lastName, 2);
							if (eServ.createEmployee(user, pass, firstName, lastName)) {
								logger.trace("Created employee " + emp.getFirstName() + " " + emp.getLastName()
										+ " with username " + emp.getUserName() + ".");
								System.out.println("Created this employee account.");
								break;
							} else {
								System.out.println("Error creating employee account.");
								break;
							}

						case "administrator":
							Admin adm = new Admin(1, user, pass, firstName, lastName);
							if (createAdmin(user, pass, firstName, lastName)) {
								logger.trace("Created administrator " + adm.getFirstName() + " " + adm.getLastName()
										+ " with username " + adm.getUserName() + ".");
								System.out.println("Created this administrator account.");
								break;
							} else {
								System.out.println("Error creating administrator account.");
								break;
							}
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

	public boolean createAdmin(String user, String password, String fName, String lName) {
		return admDao.createAdmin(user, password, fName, lName);
	}

	public void updatePasswordService(User user, Scanner sc) {
		while (true) {
			System.out.println("Please type your new password.");
			String pass = sc.nextLine();
			System.out.println("Please type your new password again.");
			String conf = sc.nextLine();
			if (pass.equals(conf)) {
				user.setPassword(pass);
				if (updatePassword(user, pass)) {
					logger.trace("Changed password for user " + user.getUserName());
					System.out.println("Changed password for user " + user.getUserName());
					break;
				} else {
					System.out.println("Unable to update the password. Please try again.");
					continue;
				}

			} else {
				System.out.println("The passwords didn't match");
			}
		}
	}

	public boolean updatePassword(User user, String newPassword) {
		return admDao.updatePassword(user, newPassword);
	}

	public void updateNameService(User user, Scanner sc) {
		while (true) {
			System.out.println("Please type the new first name or write 'exit' to exit this menu:.");
			String fName = sc.nextLine();
			if (fName.equals("exit")) {
				break;
			}
			System.out.println("Please type the new last name.");
			String lName = sc.nextLine();
			boolean correct;
			while (true) {
				System.out.println("Information provided: First name " + fName + ", last name " + lName
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

				if (updateName(user, fName, lName)) {
					user.setFirstName(fName);
					user.setLastName(lName);
					logger.trace("Changed name for user " + user.getUserID() + "to " + user.getFirstName() + " "
							+ user.getLastName() + ".");
					System.out.println("Changed name for user " + user.getUserID() + " to " + user.getFirstName() + " "
							+ user.getLastName() + ".");
					break;
				} else {
					System.out.println("Unable to update the name. Please try again.");
					continue;
				}

			}
		}
	}

	public boolean updateName(User user, String fName, String lName) {
		return admDao.updateName(user, fName, lName);
	}

	public void update(Scanner sc) {
		while (true) {
			System.out.println(
					"Please type 'password' to update a password, 'name' to update a name, or 'exit' to exit this menu.");
			String response = sc.nextLine();
			if (response.equals("exit")) {
				break;
			}
			int userID;
			User user;
			String answer;
			switch (response) {
			case "password":
				System.out.println("Please type the user ID for the user you are updating");

				try {
					answer = sc.nextLine();
				} catch (NoSuchElementException e) {
					e.printStackTrace();
					throw new NoSuchElementException("Ctrl-z stops the program. Good bye.");

				}

				try {

					userID = Integer.valueOf(answer);
					user = uServ.getUser(userID);
					if (user == null) {
						System.out.println("User could not be found.");
						continue;
					}
				} catch (NumberFormatException e) {
					System.out.println("Please type a user ID.");
					continue;
				} catch (NullPointerException e) {
					System.out.println("User could not be found.");
					continue;

				}

				updatePasswordService(user, sc);
				continue;
			case "name":
				System.out.println("Please type the user ID for the user you are updating");

				try {
					answer = sc.nextLine();
				} catch (NoSuchElementException e) {
					e.printStackTrace();
					throw new NoSuchElementException("Ctrl-z stops the program. Good bye.");

				}

				try {

					userID = Integer.valueOf(answer);
					user = uServ.getUser(userID);
					if (user == null) {
						System.out.println("User could not be found.");
						continue;
					}
				} catch (NumberFormatException e) {
					System.out.println("Please type a user ID.");
					continue;
				} catch (NullPointerException e) {
					System.out.println("User could not be found.");
					continue;

				}

				updateNameService(user, sc);
				continue;
			default:
				System.out.println("Invalid entry.");
				continue;
			}
		}

	}

	public boolean deleteUser(int userID) {
		return admDao.deleteUser(userID);
	}

	public void deleteUserService(Scanner sc, Admin admin) {
		while (true) {

			System.out.println("Type the User ID for the user you wish to delete, or 'exit' to exit this menu.");
			String response = sc.nextLine();
			if (response.equals("exit")) {
				break;
			}
			int index;
			try {
				index = Integer.valueOf(response);
				if (index < 0) {
					System.out.println("Your number should be bigger than 0");

					continue;
				}

			} catch (NumberFormatException e) {
				System.out.println("Invalid entry.");

				continue;
			}

			User user = uServ.getUser(index);
			if (user == null) {
				System.out.println("User could not be found.");
				continue;
			} else if (user.getUserType() == 1) {
				if (cServ.deleteCustomer(user.getUserID())) {

					System.out.println("Customer [" + user.getUserID() + "] was successfully deleted.");
					logger.trace("Customer [" + user.getUserID() + "] was successfully deleted by administrator "
							+ admin.getUserID() + ".");
					continue;

				} else {
					System.out.println("User deletion was not successfull");
					logger.debug("User [" + user.getUserID() + "] was not successfully deleted by administrator "
							+ admin.getUserID() + ".");
					continue;
				}
			} else {
				if (deleteUser(user.getUserID())) {
					if (user.getUserType() == 2) {
						System.out.println("Employee [" + user.getUserID() + "] was successfully deleted.");
						logger.trace("Employee [" + user.getUserID() + "] was successfully deleted by administrator "
								+ admin.getUserID() + ".");
						continue;
					} else {
						System.out.println("Administrator [" + user.getUserID() + "] was successfully deleted.");
						logger.trace("Administrator [" + user.getUserID()
								+ "] was successfully deleted by administrator " + admin.getUserID() + ".");
						continue;
					}

				} else {
					System.out.println("User deletion was not successfull");
					logger.debug("User [" + user.getUserID() + "] was not successfully deleted by administrator "
							+ admin.getUserID() + ".");
					continue;
				}

			}
		}

	}

	public Admin getAdmin(int userID) {
		return admDao.getAdmin(userID);
	}
}
